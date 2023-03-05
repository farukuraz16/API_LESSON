package pojoDatas;

public class Homework12_timePeriodPojo {
    /*
     "time_period":{
                   "start": {
                            "expression":"after",
                            "amount":132000000
                            },
                    "end":{
                            "expression":"after",
                            "amount":432000000
                           }
                   },
     */

   private Homework12_startAndEndPojo start;
   private Homework12_startAndEndPojo end;

    @Override
    public String toString() {
        return "{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public Homework12_startAndEndPojo getStart() {
        return start;
    }

    public void setStart(Homework12_startAndEndPojo start) {
        this.start = start;
    }

    public Homework12_startAndEndPojo getEnd() {
        return end;
    }

    public void setEnd(Homework12_startAndEndPojo end) {
        this.end = end;
    }

    public Homework12_timePeriodPojo(Homework12_startAndEndPojo start, Homework12_startAndEndPojo end) {
        this.start = start;
        this.end = end;
    }

    public Homework12_timePeriodPojo() {
    }
}
