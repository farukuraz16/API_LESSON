package pojoDatas;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DummyRestApiExpextedPojo {
    /*
     {
    "status": "success",
    "data": {
        "name": "Drake F.",
        "salary": "40000",
        "age": "27",
        "id": 4545
    },
    "message": "Successfully! Record has been added."
}
     */

    private String status;
    private DummyRestApiRequestPojo data;
    private String message;


    public DummyRestApiExpextedPojo() {
    }

    public DummyRestApiExpextedPojo(String status, DummyRestApiRequestPojo dummyRestApiRequestPojo, String message) {
        this.status = status;
        this.data = dummyRestApiRequestPojo;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DummyRestApiRequestPojo getData() {
        return data;
    }

    public void setData(DummyRestApiRequestPojo data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DummyRestApiReqPojo{" +
                "status='" + status + '\'' +
                ", dummyRestApiPojo=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
