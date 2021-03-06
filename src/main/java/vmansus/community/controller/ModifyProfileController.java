package vmansus.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import vmansus.community.mapper.UserMapper;
import vmansus.community.model.User;
import vmansus.community.provider.OssClientAuthorization;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class ModifyProfileController {
    @Autowired
    private OssClientAuthorization ossClientAuthorization;

    @Autowired
    private UserMapper userMapper;
    @GetMapping("/modifyProfile")
    public String showProfile(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "profile_info";
    }

    @PostMapping("/modifyProfile")
    public String modifyProfile(HttpServletRequest request, Model model) throws IOException {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("head_portrait");
        String uploadImageUrl = ossClientAuthorization.upload(file.getInputStream(), file.getOriginalFilename());
        User user = (User) request.getSession().getAttribute("user");
        user.setAvatarUrl(uploadImageUrl);
        userMapper.updateByPrimaryKey(user);
        model.addAttribute("user", user);
        return "profile_info";
    }
}
