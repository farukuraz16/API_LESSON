package trelloAPI;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testData.TrelloApiTestData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class StepDefinitions {
    //API Key = da65cb6978348bf6345c0833c19abdc8
    //token = ATATT3xFfGF0yvxZ-0DsTByVeM77r08rTKh2VeFPBhWtSFuF9JpT-bDZkc-Xay5p_93NP3sdViXAfCXGUAjhWD6hdvFi9i_8djPlOKzzSOwsZPbYEpudqxlk2Miahf8TOP5icRaE2WCLIyIXzItGarFmkahZtZaAtkd5H7IaTuQS2ZqMF3jrZKo=87D1C8C2

    public RequestSpecification specification;
    TrelloApiTestData trelloApiTestData = new TrelloApiTestData();
    public static Response response;
    public static String boardID;
    public static JsonPath jsonPath;
    public static String listID;
    public static List<String> cardsID = new ArrayList<>();


    //---->>> Create Board
    @Given("Kullanıcı Trello için Base URL set eder {string}")
    public void kullanıcı_Trello_için_Base_URL_set_eder(String baseURL) {

        specification = new RequestSpecBuilder().
                setBaseUri(baseURL).
                build();
    }

    @When("Kullanıcı board create edebilmek için ilgili URL e POST metodu ve ilgili end pointler ile request atar {string},{string},{string},{string}")
    public void kullanıcı_board_create_edebilmek_için_ilgili_URL_e_POST_metodu_ve_ilgili_end_pointler_ile_request_atar(String idPath, String id, String boardsPath, String boards) {

        /*
       curl --request POST \
       --url 'https://api.trello.com/1/boards/ ? name={name} & key=APIKey & token=APIToken'
                specification      .pathParams. ? . queryParams
        */
        specification.
                pathParams(idPath, id, boardsPath, boards).
                queryParams("name", trelloApiTestData.getBoardName(),
                        "key", trelloApiTestData.getKey(),
                        "token", trelloApiTestData.getToken());

        //String ifadem var.. idPath, boardsPath
        //bu ifadelerimizi formatlayalım
        String idPathFormat = String.format("{%s}", idPath); //{idPath}
        String boardsPathFormat = String.format("{%s}", boardsPath);//{boardsPath}

        response = given().
                spec(specification).
                contentType(ContentType.JSON).
                when().
                post("/" + idPathFormat + "/" + boardsPathFormat + "/");

        //post("/{idPath}/{boardsPath}")

        System.out.println("RESPONSE Board Creation: ");
        response.prettyPrint();
    }

    @When("Kullanıcı board id yi alır")
    public void kullanıcı_board_id_yi_alır() {
        jsonPath = response.jsonPath();
        boardID = jsonPath.getString("id");

        System.out.println("boardID = " + boardID);

    }

    @Then("Kullanıcı Board un basarılı bir şekilde create edildiğini verify eder")
    public void kullanıcı_Board_un_basarılı_bir_şekilde_create_edildiğini_verify_eder() {

        response.then().assertThat().statusCode(200);
    }


    //---->>> Create Lists
    @When("Kullanıcı list create edeilmek için ilgili URL'e POST metodu ile request atar {string},{string},{string},{string}")
    public void kullanıcı_list_create_edeilmek_için_ilgili_URL_e_POST_metodu_ile_request_atar(String idPath, String id, String listsPath, String lists) {
// curl --request POST \
//  --url 'https://api.trello.com/1/lists ? name={name} & idBoard=5abbe4b7ddc1b351ef961414 & key=APIKey & token=APIToken'
        specification.pathParams(idPath, id, listsPath, lists)
                .queryParams("name", trelloApiTestData.getListName(),
                        "idBoard", boardID,
                        "key", trelloApiTestData.getKey(),
                        "token", trelloApiTestData.getToken());


        String idPathFormat = String.format("{%s}", idPath); //{idPath}
        String listsPathFormat = String.format("{%s}", listsPath);//{listsPath}

        response = given().
                spec(specification).
                contentType(ContentType.JSON).
                when().
                post("/" + idPathFormat + "/" + listsPathFormat);

        System.out.println("RESPONSE Body: ");
        response.prettyPrint();

    }


    @When("Kullanıcı list id yi alır")
    public void kullanıcı_list_id_yi_alır() {

        jsonPath = response.jsonPath();
        listID = jsonPath.getString("id");
        System.out.println("listID = " + listID);

    }

    @Then("Kullanıcı list'in başarılı bir şekilde create edildiğini verify eder")
    public void kullanıcı_list_in_başarılı_bir_şekilde_create_edildiğini_verify_eder() {
        response.then().assertThat().statusCode(200);
    }


    //--->> Create Card
    @When("Kullanıcı card edebilmek için ilgili URL'e POST metodu ile request atar {string},{string},{string},{string}")
    public void kullanıcı_card_edebilmek_için_ilgili_URL_e_POST_metodu_ile_request_atar(String idPath, String id, String cardsPath, String cards) {
        //        # URL= https://api.trello.com/1/cards ? idList=5abbe4b7ddc1b351ef961414 & key=APIKey & token=APIToken
        specification.pathParams(idPath, id, cardsPath, cards).
                queryParams(
                        "idList", listID,
                        "name", "Uraz Card",
                        "key", trelloApiTestData.getKey(),
                        "token", trelloApiTestData.getToken()
                );
        String idPathFormat = String.format("{%s}", idPath); //{idPath}
        String cardsPathFormat = String.format("{%s}", cardsPath);//{cardsPath}

        response = given().
                spec(specification).
                contentType(ContentType.JSON).
                when().
                post("/" + idPathFormat + "/" + cardsPathFormat);
        System.out.println("REPONSE cards: ");
        response.prettyPrint();

    }


    @When("Kullanıcı card ID yi alır")
    public void kullanıcı_card_ID_yi_alır() {


        jsonPath = response.jsonPath();
        cardsID.add(jsonPath.getString("id"));
        System.out.println("cardsID = " + cardsID);

    }

    @Then("Kullanıcı car create edildiğini verify eder")
    public void kullanıcı_car_create_edildiğini_verify_eder() {
        response.then().assertThat().statusCode(200);

    }


    //---->> update Card

    @When("Kullanıcı update işlemi için ilgili URLe PUT metodu ile request atar {string},{string},{string},{string}")
    public void kullanıcı_update_işlemi_için_ilgili_URLe_PUT_metodu_ile_request_atar(String idPath, String id, String cardsPath, String cards) {
        //    #   URL = https://api.trello.com/1/cards/ {id} ? key=APIKey & token=APIToken

        Random random = new Random();
        int numberOfRandom = random.nextInt(cardsID.size());//o ile verilen deeğer arasında random bir sayı seçer

        specification.pathParams(idPath, id,
                        cardsPath, cards,
                        "cardsIdPath", cardsID.get(numberOfRandom)).
                queryParams("idList", listID,
                        "name", "Uraz Card Updated",
                        "key", trelloApiTestData.getKey(),
                        "token", trelloApiTestData.getToken());

        String idPathFormat = String.format("{%s}", idPath); //{idPath}
        String cardsPathFormat = String.format("{%s}", cardsPath);//{cardsPath}

        response = given().
                spec(specification).
                contentType(ContentType.JSON).
                when().
                put("/" + idPathFormat + "/" + cardsPathFormat + "/{cardsIdPath}");

    }


    @Then("Kullanıcı update edildiğini verify eder")
    public void kullanıcı_update_edildiğini_verify_eder() {
        response.then().assertThat().statusCode(200);
    }


    //---->> delete Card
    @When("Kullanıcı delete işlemi için ilgili URLe delete metodu ile request atar {string},{string},{string},{string},{int}")
    public void kullanıcı_delete_işlemi_için_ilgili_URLe_delete_metodu_ile_request_atar(String idPath, String id, String cardsPath, String cards, Integer cardsIdGet) throws InterruptedException {

        //    #             URL = "https://api.trello.com/1/cards/ {id}?key=APIKey&token=APIToken"  (DELETE)

        specification.pathParams(idPath, id,
                        cardsPath, cards,
                        "cardIdPath", cardsID.get(cardsIdGet)).
                queryParams("key", trelloApiTestData.getKey(),
                        "token", trelloApiTestData.getToken());

        String idPathFormat = String.format("{%s}", idPath); //{idPath}
        String cardsPathFormat = String.format("{%s}", cardsPath);//{cardsPath}

        Thread.sleep(5000);

        response = given().
                spec(specification).
                contentType(ContentType.JSON).
                when().
                delete("/" + idPathFormat +
                        "/" + cardsPathFormat +
                         "/{cardIdPath}");
        System.out.println("RESPONSE delete: ");
        response.prettyPrint();
    }


    @Then("Kullanıcı delete edildiğini verify eder")
    public void kullanıcı_delete_edildiğini_verify_eder() {
        response.then().assertThat().statusCode(200);

    }


    //----> delete Board
    @When("Kullanıcı delete işlemi için ilgili URLe delete metodu ile request atar {string},{string},{string},{string}")
    public void kullanıcı_delete_işlemi_için_ilgili_URLe_delete_metodu_ile_request_atar(String idPath, String id, String boardsPath, String boards) {
      //    #             URL = "https://api.trello.com/1/boards/{id}?key=APIKey&token=APIToken"   (DELETE)

        specification.pathParams(idPath,id,boardsPath,boards,"boardID",boardID).
                queryParams("key",trelloApiTestData.getKey(),
                        "token",trelloApiTestData.getToken());

        String idPathFormat = String.format("{%s}", idPath); //{idPath}
        String boardsPathFormat = String.format("{%s}", boardsPath);//{cardsPath}

        response = given().spec(specification).contentType(ContentType.JSON).when().
                delete("/"+idPathFormat+"/"+boardsPathFormat+"/{boardID}");

        System.out.println("Response delete: ");
        response.prettyPrint();

    }


    @Then("Kullanıcı boardun delete edildiğini verify eder")
    public void kullanıcı_boardun_delete_edildiğini_verify_eder() {
        response.then().assertThat().statusCode(200);

    }

}
