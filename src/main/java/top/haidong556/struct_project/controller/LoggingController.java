package top.haidong556.struct_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import top.haidong556.struct_project.dao.my_database.StudentDatabase;

@Controller
@RequestMapping("/logging")
public class LoggingController {
    @GetMapping
    public String logging(){
        return "logging";
    }
    @PostMapping
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model,
                               RedirectAttributes redirectAttributes) {
        StudentDatabase sd=StudentDatabase.getInstance();
        int id;
        // 在这里进行账号密码验证逻辑
        if ((id=sd.searchStudent(username,password))!=-1) {
            redirectAttributes.addFlashAttribute("studentId",id);
            return "redirect:/schedule"; // 验证成功，跳转到成功页面

        } else {
            model.addAttribute("loginError", true); // 设置登录错误变量的值为true
            return "logging"; // 验证失败，返回到登录页面显示错误消息
        }
    }
}
