package top.haidong556.struct_project.dao.my_database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.haidong556.struct_project.pojo.action_object.Action;
import top.haidong556.struct_project.pojo.action_object.Course;
import top.haidong556.struct_project.struct_list.MyList;
/**
 * 单例模式
 */
@Repository
public class CourseDatabase {
    private MyList<Course> courses;

    private static int countOfCourse=0;

    private static CourseDatabase instance;

    static {
        instance=new CourseDatabase();
    }
    private CourseDatabase(){}

    public static CourseDatabase getInstance(){
        return instance;
    }
    @Autowired
    public void setCourses(MyList<Course> courses) {
        this.courses = courses;
    }
    /**
     * 存在课程返回false，添加成功返回true
     */
    public boolean addCourse(Course course){
        if(courses.contains(course)){
           return false;
        }
        courses.add(course);
        return true;
    }
    /**
     * 删除成功返回true，失败返回false
     */
    public boolean deletCourse(int id){
        for(Action a:courses){
            if(a.getId()==id){
                courses.remove(a);
                return true;
            }
        }
        return false;
    }


}
