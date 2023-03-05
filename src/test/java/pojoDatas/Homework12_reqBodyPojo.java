package pojoDatas;

import java.util.HashMap;
import java.util.List;

public class Homework12_reqBodyPojo {

    private Homework12_timePeriodPojo time_period;
    private List<Object> conditions;
    private List<Object> area;

    @Override
    public String toString() {
        return "{" +
                "time_period=" + time_period +
                ", conditions=" + conditions +
                ", area=" + area +
                '}';
    }

    public Homework12_timePeriodPojo getTime_period() {
        return time_period;
    }

    public void setTime_period(Homework12_timePeriodPojo time_period) {
        this.time_period = time_period;
    }

    public List<Object> getConditions() {
        return conditions;
    }

    public void setConditions(List<Object> conditions) {
        this.conditions = conditions;
    }

    public List<Object> getArea() {
        return area;
    }

    public void setArea(List<Object> area) {
        this.area = area;
    }

    public Homework12_reqBodyPojo(Homework12_timePeriodPojo time_period, List<Object> conditions, List<Object> area) {
        this.time_period = time_period;
        this.conditions = conditions;
        this.area = area;
    }

    public Homework12_reqBodyPojo() {
    }
}
