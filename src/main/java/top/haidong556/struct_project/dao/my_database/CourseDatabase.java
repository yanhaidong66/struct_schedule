package top.haidong556.struct_project.dao.my_database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.haidong556.struct_project.pojo.action_object.Action;
import top.haidong556.struct_project.pojo.action_object.Course;
import top.haidong556.struct_project.struct_list.MyList;

import java.io.*;

/**
 * 单例模式
 */
@Repository
public class CourseDatabase {
    private static final String FILE_PATH="src/main/resources/database/course_database/course.txt";
    private static MyList<Action> courses;

    private static int countOfCourse=0;

    private static CourseDatabase instance;

    static {
        courses=new MyList<Action>();
        instance=new CourseDatabase();
        instance.readFromFile();
    }
    private CourseDatabase(){}

    public static CourseDatabase getInstance(){
        return instance;
    }
    @Autowired
    public void setCourses(MyList<Action> courses) {
        this.courses = courses;
    }
    /**
     * 存在课程返回false，添加成功返回true
     */
    public boolean addCourse(Course course){
        if(courses.contains(course)){
           return false;
        }
        countOfCourse++;
        return courses.add(course);

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

    public static boolean writeIntoFile(){
        File file=new File(FILE_PATH);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            FileWriter fileWriter=new FileWriter(file);
            fileWriter.write(courses.toString());
            fileWriter.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
/**
 * 如果没有文件，创建文件，并返回false
 */
    public static boolean readFromFile(){
        String s=new String();
        File file=new File(FILE_PATH);
        BufferedReader bufferedReader;
        if(!file.exists()){
            try {
                file.createNewFile();
                return false;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            bufferedReader=new BufferedReader(inputStreamReader);
            while ((s=bufferedReader.readLine())!=null){
                courses.add((Action) Course.toAction(s,Action.class));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return true;

    }

    public String toString(){
        return courses.toString();
    }
    public static void main(String[] args) {
        CourseDatabase courseDatabase=CourseDatabase.getInstance();
        courseDatabase.addCourse(new Course("yuwen", 8, 9, 1, 1));
        courseDatabase.addCourse(new Course("yuwen", 8, 9, 1, 1));
        courseDatabase.addCourse(new Course("yuwe6n", 8, 9, 1, 1));
        CourseDatabase.writeIntoFile();
    }


}
