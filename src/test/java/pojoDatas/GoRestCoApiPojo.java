package pojoDatas;

public class GoRestCoApiPojo {
    /*
    diğer pojo class'ımızda places için var. oluşturduk. bu classımızda places haricindeki kısım için oluşturacağız.
    ancak bu pojo classa places pojoyu da eklememiz lazım..
    1) Fieldlar ----> Variable...   PRIVATE varia.--->> Her bir json için
    2) Parametresiz Constructor
    3) Parametreli Constructor
    4) Getter and Setter
    5) toString()
     */
/*
    {
      "id": 480339,
      "name": "Bhupen Deshpande PhD",
      "email": "bhupen_phd_deshpande@prosacco.biz",
      "gender": "male",
      "status": "active"
    }
*/
//Step 1
    private Integer id;
    private String name;
    private String email;
    private String gender;
    private String status;


    //Step 2
    public GoRestCoApiPojo() {
    }

    //Step 3

    public GoRestCoApiPojo(Integer id, String name, String email, String gender, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }


    //Step 4

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    //Step 5


    @Override
    public String toString() {
        return "GoRestPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
