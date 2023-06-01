package top.haidong556.struct_project.pojo.people_object;

import org.springframework.stereotype.Component;
import top.haidong556.struct_project.dao.database_object.ClassTable;
@Component
public class People {
    private int id=0;
    private String name;
    private String password;
    private ClassTable classTable;//课程表

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
}
