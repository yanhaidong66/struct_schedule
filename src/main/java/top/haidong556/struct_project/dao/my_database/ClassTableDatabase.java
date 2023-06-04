package top.haidong556.struct_project.dao.my_database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import top.haidong556.struct_project.pojo.action_object.Action;
import top.haidong556.struct_project.pojo.action_object.ClassTable;
import top.haidong556.struct_project.struct_list.MyList;

import java.io.*;
/**
 * 单例模式
 */
public class ClassTableDatabase {

    private static final String FILE_PATH="src/main/resources/database/class_table_database/";
    private static ClassTableDatabase instance;

    static {
        instance=new ClassTableDatabase();
    }
    private ClassTableDatabase(){}
    public static ClassTableDatabase getInstance(){
        return instance;
    }
    /**
     * 传入学生id，返回这个学生的课表，如果不存在，就新建一个，并初始化
     */
    public static ClassTable getClassTable(int student_id){
        ClassTable r=new ClassTable(student_id);
        BufferedReader bufferedReader;
        String line=new String();

        String filepath=FILE_PATH+"id_";
        filepath+=student_id;
        filepath+=".txt";
        File file=new File(filepath);


        if(!file.exists()){
            saveClassTable(r);
            return r;
        }

        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            bufferedReader=new BufferedReader(inputStreamReader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

            try {
                line=bufferedReader.readLine();

                while ( (line=bufferedReader.readLine())!=null) {
                    Action a=Action.toAction(line,Action.class);
                    r.addAction(a);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return r;

    }

    /**
     * 保存课程表，如果不存在，就创建一个，并初始化
     */
    public static boolean saveClassTable(ClassTable classTable){
        String filepath=FILE_PATH+"id_";;
        filepath+=classTable.getId();
        filepath+=".txt";
        File file=new File(filepath);
        if(!file.exists()){
            try {
                file.createNewFile();
                System.out.println("classTable creation correctly.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
            bufferedWriter.write("student_id:"+classTable.getId());
            bufferedWriter.write(classTable.toJson());
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return true;
    }

//    public static void main(String[] args) {
//        ClassTable classTable=new ClassTable();
//        classTable=getClassTable(0);
//        System.out.println(classTable.toString());
//    }

}
