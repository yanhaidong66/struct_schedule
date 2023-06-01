package top.haidong556.struct_project.dao.database_object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import top.haidong556.struct_project.pojo.action_object.Action;
import top.haidong556.struct_project.struct_list.MyList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClassDatabase {
    @Value("0")
    private static int amountOfClass;
    private MyList<Action> actions;

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean read_from_file(){
        String sql="select * from course_table;";
        ActionRowMapper actionRowMapper=new ActionRowMapper();
        actions= (MyList<Action>) jdbcTemplate.query(sql,actionRowMapper);
        return true;
    }

    public class ActionRowMapper implements RowMapper<Action> {


        @Override
        public Action mapRow(ResultSet rs, int rowNum) throws SQLException {
            Action a=new Action();
            a.setId(amountOfClass);
            a.setName(rs.getString("name"));
            a.setDuration(rs.getInt("last_time"));
            a.setStartTime(rs.getInt("start_time"));
            a.setEndTime(rs.getInt("end_time"));
            a.setDayOfWeek(rs.getInt("day_in_week"));
            return a;
        }
    }
    public boolean addClass(String name,int start_time,int end_time,int duration,int day_in_week){
        Action action=new Action();
        action.setName(name);
        action.setId(amountOfClass);
        action.setDuration(duration);
        action.setStartTime(start_time);
        action.setEndTime(end_time);
        action.setDayOfWeek(day_in_week);
        actions.add(action);
        return true;
    }

    public boolean deletClass(String name){
        for(int i=0;i<amountOfClass;i++){
            if(actions.get(i).getName().equals(name)==true){
                actions.remove(i);
                return true;
            }
        }
        return false;
    }

}
