package top.haidong556.struct_project.dao.my_database;

import org.springframework.stereotype.Repository;
import top.haidong556.struct_project.pojo.people_object.People;
import top.haidong556.struct_project.pojo.people_object.Student;
import top.haidong556.struct_project.struct_list.MyList;

import java.io.*;

@Repository
public class StudentDatabase {
    public static final String FILE_PATH="src/main/resources/database/student_database/student.txt";

    private static MyList<People> students=new MyList<People>();

    private static int amountOfStudent=0;

    private static StudentDatabase instance;
    static {
        instance=new StudentDatabase();
        //readFromFile();
    }

    private StudentDatabase(){}

    public static StudentDatabase getInstance(){
        return instance;
    }

    public static boolean readFromFile(){
        File file=new File(FILE_PATH);
        FileReader fileReader;
        try {
            fileReader=new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        return true;

    }

    public static boolean writeToFile(){
        File file=new File(FILE_PATH);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        FileWriter fileWriter;
        try {
            fileWriter=new FileWriter(file);
            for(People s:students){
                fileWriter.write(s.toString()+"\n");
            }
            fileWriter.flush();
            fileWriter.close();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean addStudent(People p){
        if(students.contains(p)){
            return false;
        }
        students.add(p);
        return true;

    }



    public static void main(String[] args) {
        StudentDatabase studentDatabase=StudentDatabase.getInstance();
        studentDatabase.addStudent(new Student("hiadong","2332"));
        studentDatabase.addStudent(new Student("hiadong","23332"));
        studentDatabase.writeToFile();

    }
}
