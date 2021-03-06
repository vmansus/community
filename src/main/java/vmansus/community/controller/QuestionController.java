package vmansus.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vmansus.community.dto.CommentDTO;
import vmansus.community.dto.QuestionDTO;
import vmansus.community.enums.CommentTypeEnum;
import vmansus.community.model.Question;
import vmansus.community.service.CommentService;
import vmansus.community.service.QuestionHistoryService;
import vmansus.community.service.QuestionService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private QuestionHistoryService questionHistoryService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id, Model model,
                           HttpServletRequest request, HttpServletResponse response) {
        QuestionDTO questionDTO = questionService.getById(id);
        List<QuestionDTO> relatedQuestions=questionService.selectRelated(questionDTO);
        List<CommentDTO> comments = commentService.listByTargetId(id, CommentTypeEnum.QUESTION);
        String history = questionHistoryService.createHistory(id.toString(),request);
        ArrayList<Question> questionHistory = questionHistoryService.showHistory(history);
        Cookie cookie = new Cookie("history",history);
        cookie.setMaxAge(24*60*60);
        cookie.setPath("/");
        response.addCookie(cookie);
        //累加阅读数
        //questionService.incView(id);
        model.addAttribute("question", questionDTO);
        model.addAttribute("comments", comments);
        model.addAttribute("relatedQuestions", relatedQuestions);
        model.addAttribute("questionHistory", questionHistory);
        return "question";
    }
}
