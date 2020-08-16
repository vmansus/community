package vmansus.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import vmansus.community.dto.PaginationDTO;
import vmansus.community.mapper.QuestionMapper;
import vmansus.community.model.User;
import vmansus.community.service.QuestionService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DeleteController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionMapper questionMapper;

    @GetMapping("/profile/questions/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id,
                         HttpServletRequest request,
                         Model model,
                         @RequestParam(name = "page", defaultValue = "1") Integer page,
                         @RequestParam(name = "size", defaultValue = "7") Integer size) {
        User user = (User) request.getSession().getAttribute("user");
//        if (user == null) {
//            return "redirect:/";
//        }

        model.addAttribute("section", "questions");
        model.addAttribute("sectionName", "My Questions");
        questionMapper.deleteByPrimaryKey(id);
        PaginationDTO paginationDTO = questionService.list(user.getId(), page, size);
        model.addAttribute("pagination", paginationDTO);
        return "profile";
    }
}
