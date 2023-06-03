package top.haidong556.struct_project.pojo.action_object;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Action {

    private int id;
    private static int countOfAction=0;
    private String name;

    public static void setCountOfAction(int countOfAction) {
        Action.countOfAction = countOfAction;
    }

    private int startTime;
    private int endTime;
    private int duration;
    private int dayOfWeek;


    public Action(){}
    @Autowired(required = false)
    public Action(String name, int startTime, int endTime, int duration, int dayOfWeek) {
        this.name = name;
        try {
            if (startTime < 8 || startTime > 17 || endTime <= startTime || endTime > 18 || dayOfWeek > 7 || dayOfWeek < 1) {
                throw new IllegalArgumentException("Action创建的参数错误.action_id:"+countOfAction+1);
            }
        }catch (IllegalArgumentException i){
            System.out.println(i.getMessage());
        }
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.dayOfWeek = dayOfWeek;
        this.id=++countOfAction;
    }

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

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    @Override
    public String toString() {
        if (this==null) return "";
        try {
            Gson gson = new Gson();
            return gson.toJson(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public  String toJson() {
        if (this==null) return "";
        try {
            Gson gson = new Gson();
            return gson.toJson(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static <T> T toAction(String json, Class<T> cls) {
        Gson gson = new Gson();
        if (Objects.isNull(json)) return null;
        T obj = gson.fromJson(json, cls);
        if (Objects.isNull(obj)) {
            return null;
        } else {
            return obj;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Action action = (Action) o;
        return startTime == action.startTime && endTime == action.endTime && duration == action.duration && dayOfWeek == action.dayOfWeek && Objects.equals(name, action.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startTime, endTime, duration, dayOfWeek);
    }
}
