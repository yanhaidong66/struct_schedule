package top.haidong556.struct_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import top.haidong556.struct_project.dao.my_database.StudentDatabase;
import top.haidong556.struct_project.pojo.action_object.Action;
import top.haidong556.struct_project.pojo.people_object.People;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
    static private int studentId=0;
    @GetMapping
    public String showSchedule(Model model){
        StudentDatabase studentDatabase=StudentDatabase.getInstance();
        studentId=(int)model.getAttribute("studentId");
        People student=studentDatabase.getStudent(studentId);
        Action[][] action=student.getClassTable().getActions();
        model.addAttribute("student",student);
        model.addAttribute("day1",action[0]);
        model.addAttribute("day2",action[1]);
        model.addAttribute("day3",action[2]);
        model.addAttribute("day4",action[3]);
        model.addAttribute("day5",action[4]);
        model.addAttribute("day6",action[5]);
        model.addAttribute("day7",action[6]);

        return "schedule";

    }
}
