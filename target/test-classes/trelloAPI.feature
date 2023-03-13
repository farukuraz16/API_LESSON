@trelloAPI
Feature: Kullanıcı Trello API üzerinde ceşitli işlemler yapabilmelidir

  Background: Kullanıcı Base URL'i setler
    Given Kullanıcı Trello için Base URL set eder "https://api.trello.com"

    # Bu scen. de board create edeceğiz.
    # ayrıca taskımızda diğer işlemleri gerçekleştirebilmek için board id'ye ihtiyacımız var.
    # Board ID yi de bu scen. den alacağız. ve Board'un create edildiğini assert edeceğiz. ---> Board ID'yi class seviyesinde tanımla...

    # URL = 'https://api.trello.com/1/boards/?name={name}&key=APIKey&token=APIToken'   (POST)

  @createBoard
  Scenario: Kullanıcı Board create edebilmeli
    When Kullanıcı board create edebilmek için ilgili URL e POST metodu ve ilgili end pointler ile request atar "idPath","1","boardsPath","boards"
    And Kullanıcı board id yi alır
    Then Kullanıcı Board un basarılı bir şekilde create edildiğini verify eder



    # 'https://api.trello.com/1/lists ? name={name} & idBoard=5abbe4b7ddc1b351ef961414 & key=APIKey & token=APIToken'
    # Card create edebilmek için önce List create etmemizi istiyor. list için de aşağıdaki gibi end point girerirz
  @createList
  Scenario: Kullanıcı card create edebilmek için list create edebilmeli
    When Kullanıcı list create edeilmek için ilgili URL'e POST metodu ile request atar "idPath","1","listsPath","lists"
    And Kullanıcı list id yi alır
    Then Kullanıcı list'in başarılı bir şekilde create edildiğini verify eder


        # URL= https://api.trello.com/1/cards?idList=5abbe4b7ddc1b351ef961414&key=APIKey&token=APIToken
  @createCard
  Scenario Outline: Kullanıcı card create edebilmeli
    When Kullanıcı card edebilmek için ilgili URL'e POST metodu ile request atar "idPath","1","cardsPath","<cards>"
    And Kullanıcı card ID yi alır
    Then Kullanıcı car create edildiğini verify eder
    Examples:
      | cards |
      | cards |
      | cards |


    #   URL = https://api.trello.com/1/cards/ {id} ? key=APIKey & token=APIToken
  @updateCard
  Scenario: Kullanıcı oluşturduğu kartlardan herhangi birini update eder
    When Kullanıcı update işlemi için ilgili URLe PUT metodu ile request atar "idPath","1","cardsPath","cards"
    Then Kullanıcı update edildiğini verify eder



    #             URL = "https://api.trello.com/1/cards/ {id}?key=APIKey&token=APIToken"  (DELETE)
  @deleteCard
  Scenario Outline: Kullanıcı oluşturduğu cardları delete eder
    When Kullanıcı delete işlemi için ilgili URLe delete metodu ile request atar "idPath","1","cardsPath","cards",<cardsID>
    Then Kullanıcı delete edildiğini verify eder

    Examples:
    |cardsID|
    |0|
    |1|


    #             URL = "https://api.trello.com/1/boards/{id}?key=APIKey&token=APIToken"   (DELETE)
    @deleteBoard
    Scenario: Kullanıcı board'u silebilmeli
      When Kullanıcı delete işlemi için ilgili URLe delete metodu ile request atar "idPath","1","boardsPath","boards"
      Then Kullanıcı boardun delete edildiğini verify eder