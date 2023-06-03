package top.haidong556.struct_project.dao.database_object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import top.haidong556.struct_project.pojo.action_object.Action;
import top.haidong556.struct_project.pojo.action_object.ClassTable;
import top.haidong556.struct_project.struct_list.MyList;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ClassTableDatabase {
    private MyList<ClassTable> classTables;
    private JdbcTemplate jdbcTemplateate;
    @Autowired
    public void setJdbcTemplateate(JdbcTemplate jdbcTemplateate) {
        this.jdbcTemplateate = jdbcTemplateate;
    }
    public boolean read_from_file(){
        String sql="select * from course_table;";
        ClassDatabase.ActionRowMapper actionRowMapper= ClassTableRowMapper();
        classTables= (MyList<ClassTable>) jdbcTemplate.query(sql,actionRowMapper);
        return true;
    }

    public class ClassTableRowMapper implements RowMapper<ClassTable> {


        @Override
        public ClassTable mapRow(ResultSet rs, int rowNum) throws SQLException {
            ClassTable classTable=new ClassTable();

            return ;
        }
    }

}
