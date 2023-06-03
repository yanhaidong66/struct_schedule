package top.haidong556.struct_project.dao.database_object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import top.haidong556.struct_project.pojo.people_object.Student;
import top.haidong556.struct_project.struct_list.MyList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDatabase {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDatabase(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public MyList<Student> getAllStudents() {
        String query = "SELECT * FROM student";
        return (MyList<Student>) jdbcTemplate.query(query, new StudentMapper());
    }

    private static class StudentMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String password = rs.getString("password");
            int classTableId=rs.getInt("class_table");
            return new Student(id, name, password);
        }

    }

}
