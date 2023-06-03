package top.haidong556.struct_project.pojo.action_object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Course extends Action{

    public Course() {
    }
    @Autowired(required = false)
    public Course(String name, int startTime, int endTime, int duration, int dayOfWeek) {
        super(name, startTime, endTime, duration, dayOfWeek);
    }
}
