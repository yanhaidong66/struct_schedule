package top.haidong556.struct_project.pojo.action_object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import top.haidong556.struct_project.pojo.action_object.Action;

import java.util.Arrays;

@Component
public class ClassTable {
    private int id;
    private Action[][] actions=new Action[7][10];




    public ClassTable(@Value("0") int studentId){
        id=studentId;
        Action.setCountOfAction(0);
        for(int i=1;i<=7;i++){
            for(int j=8;j<18;j++){
                Action action=new Action("空",j,j+1,1,i);
                this.addAction(action);
            }
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Action[][] getActions() {
        return actions;
    }

    public void setActions(Action[][] actions) {
        this.actions = actions;
    }

    //超出范围，返回false
    public boolean addAction(Action action){
        if(action==null)
            return false;
        actions[action.getDayOfWeek()-1][action.getStartTime()-8]=action;
        return true;
    }

    public boolean deletAction(Action action){
        Action action1=new Action("空",action.getStartTime(),action.getEndTime(),action.getDuration(),action.getDayOfWeek());
        actions[action.getDayOfWeek()-1][action.getStartTime()-8]=action1;
        return true;
    }


    public String toJson(){
        String s="";
        try {

            for(int i=0;i<7;i++){
                s+="\n";
                for(Action a:actions[i]){
                    s+=a.toJson()+"\n";
                }
            }

        }catch (NullPointerException n){
            System.out.println(n);
        }
        return s;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < actions.length; i++) {
            for (int j = 0; j < actions[i].length; j++) {
                sb.append(actions[i][j]).append("\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


}
