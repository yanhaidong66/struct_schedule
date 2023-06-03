package top.haidong556.struct_project.pojo.people_object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Admin extends People{
    @Autowired(required = false)
    public Admin(String name, String password) {
        super( name, password);
    }
}
