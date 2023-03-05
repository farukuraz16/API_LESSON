package pojoDatas;

import java.util.List;

public class Homework12_inAreaPojo {
    /*
      {
                    "type":"Point",
                    "coordinates":[
                                    53,
                                    37
                                   ]
                }
     */
    private String type;
    private List<Integer> coordinates;

    @Override
    public String toString() {
        return "{" +
                "type='" + type + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Integer> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Integer> coordinates) {
        this.coordinates = coordinates;
    }

    public Homework12_inAreaPojo(String type, List<Integer> coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    public Homework12_inAreaPojo() {
    }
}
