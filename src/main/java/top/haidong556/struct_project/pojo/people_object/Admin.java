package top.haidong556.struct_project.pojo.people_object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Admin extends People{

    public Admin(@Value("") String name,@Value("") String password) {
        super( name, password);
    }
}
