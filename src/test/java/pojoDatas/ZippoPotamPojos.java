package pojoDatas;

public class ZippoPotamPojos {
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
    diğer pojo class'ımızda places için var. oluşturduk. bu classımızda places haricindeki kısım için oluşturacağız.
    ancak bu pojo classa places pojoyu da eklememiz lazım..
     1) Fieldlar ----> Variable...   PRIVATE varia.--->> Her bir json için
    2) Parametresiz Constructor
    3) Parametreli Constructor
    4) Getter and Setter
    5) toString()
     */


    //Step 1: Private Var.. create et

    private String postCode;
    private String country;
    private String countryAbbreviation;
    private ZippoPotamPlaces  zippoPotamPlaces;

    //Step 2: parametresiz constructor

    public ZippoPotamPojos() {
    }

    //Step 3: Paremetreli const create et

    public ZippoPotamPojos(String postCode, String country, String countryAbbreviation, ZippoPotamPlaces zippoPotamPlaces) {
        this.postCode = postCode;
        this.country = country;
        this.countryAbbreviation = countryAbbreviation;
        this.zippoPotamPlaces = zippoPotamPlaces;
    }


    //Step 4: Getter-Setter


    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    public void setCountryAbbreviation(String countryAbbreviation) {
        this.countryAbbreviation = countryAbbreviation;
    }

    public ZippoPotamPlaces getZippoPotamPlaces() {
        return zippoPotamPlaces;
    }

    public void setZippoPotamPlaces(ZippoPotamPlaces zippoPotamPlaces) {
        this.zippoPotamPlaces = zippoPotamPlaces;
    }

    //Step 5: toString


    @Override
    public String toString() {
        return "{" +
                "postCode='" + postCode + '\'' +
                ", country='" + country + '\'' +
                ", countryAbbreviation='" + countryAbbreviation + '\'' +
                ", zippoPotamPlaces=" + zippoPotamPlaces +
                '}';
    }
}
