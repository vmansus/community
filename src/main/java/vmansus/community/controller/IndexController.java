package vmansus.community.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import vmansus.community.dto.PaginationDTO;
import vmansus.community.dto.QuestionDTO;
import vmansus.community.mapper.QuestionMapper;
import vmansus.community.mapper.UserMapper;
import vmansus.community.model.Question;
import vmansus.community.model.User;
import vmansus.community.service.QuestionSevice;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 */

@Controller
public class IndexController {

    @Autowired(required=false)
    private UserMapper userMapper;
    @Autowired
    private QuestionSevice questionSevice;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name ="page",defaultValue = "1") Integer page,
                        @RequestParam(name ="size",defaultValue = "5") Integer size

    ) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0)
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }

            }

        PaginationDTO pagination = questionSevice.list(page,size);
        model.addAttribute("pagination", pagination);
        return "index";
    }
    }

