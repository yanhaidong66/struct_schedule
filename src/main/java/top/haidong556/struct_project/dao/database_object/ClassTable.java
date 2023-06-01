package top.haidong556.struct_project.dao.database_object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import top.haidong556.struct_project.pojo.action_object.Action;
@Repository
public class ClassTable {

    JdbcTemplate jdbcTemplate;
    private int id;
    private String name;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Action[][] actions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Action[][] getActions() {
        return actions;
    }

    public void setActions(Action[][] actions) {
        this.actions = actions;
    }
}
