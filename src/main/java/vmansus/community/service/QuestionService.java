package vmansus.community.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vmansus.community.dto.PaginationDTO;
import vmansus.community.dto.QuestionDTO;
import vmansus.community.dto.QuestionQueryDTO;
import vmansus.community.enums.SortEnum;
import vmansus.community.exception.CustomizeErrorCode;
import vmansus.community.exception.CustomizeException;
import vmansus.community.mapper.QuestionExtMapper;
import vmansus.community.mapper.QuestionMapper;
import vmansus.community.mapper.UserMapper;
import vmansus.community.model.Question;
import vmansus.community.model.QuestionExample;
import vmansus.community.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionExtMapper questionExtMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    public PaginationDTO list(String search, String tag, Integer page, Integer size, String sort) {

        if (StringUtils.isNotBlank(search)) {
            String[] tags = StringUtils.split(search, " ");
            search = Arrays
                    .stream(tags)
                    .filter(StringUtils::isNotBlank)
                    .map(t -> t.replace("+", "").replace("*", "").replace("?", ""))
                    .filter(StringUtils::isNotBlank)
                    .collect(Collectors.joining("|"));
        }

        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalPage;
        QuestionQueryDTO questionQueryDTO = new QuestionQueryDTO();
        questionQueryDTO.setSearch(search);
        questionQueryDTO.setTag(tag);
        for (SortEnum sortEnum : SortEnum.values()) {
            if (sortEnum.name().toLowerCase().equals(sort)) {
                questionQueryDTO.setSort(sort);

                if (sortEnum == SortEnum.HOT7) {
                    questionQueryDTO.setTime(System.currentTimeMillis() - 1000L * 60 * 60 * 24 * 7);
                }
                if (sortEnum == SortEnum.HOT30) {
                    questionQueryDTO.setTime(System.currentTimeMillis() - 1000L * 60 * 60 * 24 * 30);
                }
                break;
            }
        }
        Integer totalCount = questionExtMapper.countBySearch( questionQueryDTO);

        if(totalCount%size==0){
            totalPage=totalCount/size;
        }else{
            totalPage=totalCount/size+1;
        }


        if(page<1){
            page=1;
        }
        if(page>totalPage){
            page=totalPage;
        }
        paginationDTO.setPagination(totalPage,page);
        Integer offset=page<1?0:size*(page-1);
        questionQueryDTO.setSize(size);
        questionQueryDTO.setPage(offset);
        List<Question> questions = questionExtMapper.selectBySearch(questionQueryDTO);
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setData(questionDTOList);

        return paginationDTO;
    }

    public PaginationDTO list(Long userId, Integer page, Integer size) {

        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalPage;
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria()
                .andCreatorEqualTo(userId);
        Integer totalCount = (int)questionMapper.countByExample(questionExample);

        if(totalCount%size==0){
            totalPage=totalCount/size;
        }else{
            totalPage=totalCount/size+1;
        }


        if(page<1){
            page=1;
        }
        if(page>totalPage){
            page=totalPage;
        }

        paginationDTO.setPagination(totalPage,page);

        Integer offset=size*(page-1);
        QuestionExample example = new QuestionExample();
        example.createCriteria()
                .andCreatorEqualTo(userId);
        example.setOrderByClause("gmt_create desc");
        List<Question> questions = questionMapper.selectByExampleWithRowbounds(example, new RowBounds(offset, size));
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setData(questionDTOList);

        return paginationDTO;
    }

    public QuestionDTO getById(Long id) {
        //先进行计数,如果question已经查询完毕,再计数无法及时刷新数据
        questionService.incView(id);
        Question question=questionMapper.selectByPrimaryKey(id);
        if(question==null){
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);
        User user = userMapper.selectByPrimaryKey(question.getCreator());
        questionDTO.setUser(user);
        questionDTO.setViewCount(question.getViewCount());
        return questionDTO;
    }

    public void createOrUpdate(Question question) {
        if(question.getId()==null){
            //创建
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            question.setViewCount(0);
            question.setLikeCount(0);
            question.setCommentCount(0);
            questionMapper.insert(question);
        }else{
            //更新
            Question updateQuestion = new Question();
            updateQuestion.setGmtModified(System.currentTimeMillis());
            updateQuestion.setTitle(question.getTitle());
            updateQuestion.setDescription(question.getDescription());
            updateQuestion.setTag(question.getTag());
            QuestionExample example= new QuestionExample();
            example.createCriteria()
                    .andIdEqualTo(question.getId());
            int updated= questionMapper.updateByExampleSelective(updateQuestion, example);
            if(updated!=1){
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
        }
    }

    public void incView(Long id) {
        Question question = new Question();
        question.setId(id);
        question.setViewCount(1);
        questionExtMapper.incView(question);
    }

    public List<QuestionDTO> selectRelated(QuestionDTO queryDTO) {
        if (StringUtils.isBlank(queryDTO.getTag())){
            return new ArrayList<>();
        }
        String[] tags = StringUtils.split(queryDTO.getTag(), ",");
        String regexpTag = Arrays.stream(tags).collect(Collectors.joining("|"));
        Question question = new Question();
        question.setId(queryDTO.getId());
        question.setTag(regexpTag);

        List<Question> questions = questionExtMapper.selectRelated(question);
        List<QuestionDTO> questionDTOS = questions.stream().map(q -> {
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(q,questionDTO);
            return questionDTO;
        }).collect(Collectors.toList());

        return questionDTOS;
    }
}
