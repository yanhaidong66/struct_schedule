package top.haidong556.struct_project.pojo.people_object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student extends People{

    /**
     * 在database中创建这个学生id对应的课表
     */

    public Student(@Value("${people.name}") String name, @Value("${people.password}") String password) {
        super(name, password);
    }

    public static void main(String[] args) {
        Student student=new Student("haidong","112");
        Student student1=new Student("dd","233");

        System.out.println(student);;
        System.out.println(student1);

    }

}
