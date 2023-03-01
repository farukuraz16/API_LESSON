package pojoDatas;

public class ZippoPotamPlaces {
    /*
     {
    "post code": "34010",
    "country": "Turkey",
    "country abbreviation": "TR",
    "places": [
        {
            "place name": "Maltepe Mah.",
            "longitude": "32.3609",
            "state": "İstanbul",
            "state abbreviation": "34",
            "latitude": "40.1589"
        }
     */

    /*
    POJO: Plain Old Java Project
    Java'da POJO, "Plain Old Java Object" kısaltmasıyla bilinen, temel bir Java sınıfıdır.
    Bu sınıflar, verileri ve onların işlemlerini tutmak için kullanılır ve
    genellikle bir veritabanı veya bir dosya gibi dış kaynaklardan veri almak veya onlara veri yazmak için kullanılır.
    POJO'lar, sadece getter ve setter metodları ile erişilen özelliklere sahip basit bir veri nesnesi olabilirler.
    POJO'lar, genellikle diğer nesneler veya bileşenlerle işbirliği yapmak için kullanılırlar
    ve bu nedenle veri aktarım nesneleri (DTO) olarak da adlandırılabilirler.
    Expected data ve actual dataları depolamak için yani tutmak için kullanıyoruz.

    1) Fieldlar ----> Variable...   PRIVATE varia.--->> Her bir json için
    2) Parametresiz Constructor
    3) Parametreli Constructor
    4) Getter and Setter
    5) toString()
    */


      //  1) Fieldlar ----> Variable...   PRIVATE varia.--->> Her bir json için

    //sadece places kısmını ele alacağız. içi içe List->Map olduğu için...
    private String placeName;
    private String longitude;
    private String state;
    private String stateAbbreviation;
    private String latitude;



    // 2) Parametresiz Constructor create ediyoruz..
    public ZippoPotamPlaces() {
    }


    // 3) Parametreli Constructor create ediyoruz.

    public ZippoPotamPlaces(String placeName, String longitude, String state, String stateAbbreviation, String latitude) {
        this.placeName = placeName;
        this.longitude = longitude;
        this.state = state;
        this.stateAbbreviation = stateAbbreviation;
        this.latitude = latitude;
    }


    // 4) Getter and Setter,,

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }


    // 5) toString()


    @Override
    public String toString() {
        return "{" +
                "placeName='" + placeName + '\'' +
                ", longitude='" + longitude + '\'' +
                ", state='" + state + '\'' +
                ", stateAbbreviation='" + stateAbbreviation + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}

