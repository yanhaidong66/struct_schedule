package top.haidong556.struct_project.pojo.people_object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.haidong556.struct_project.dao.my_database.ClassTableDatabase;
import top.haidong556.struct_project.pojo.action_object.ClassTable;
@Component
public class People {
    private static int countOfPeople=0;
    private int id=0;
    private String name;
    private String password;
    private ClassTable classTable;//课程表
    /**
     * id从0开始自增，会自己创建一个课程表
     */
    @Autowired(required = false)
    public People( String name, String password) {
        this.id = countOfPeople++;
        this.name = name;
        this.password = password;
        this.classTable= ClassTableDatabase.getClassTable(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setClassTable(ClassTable classTable) {
        this.classTable = classTable;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public ClassTable getClassTable() {
        return classTable;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\n' +
                "classTable=" + classTable +
                '}';
    }
}
