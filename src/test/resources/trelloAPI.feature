@trelloApi
Feature: Kullanıcı Trello API üzerinde ceşitli işlemler yapabilmelidir

  Background: Kullanıcı Base URL'i setler
    Given Kullanıcı Trello için Base URL set eder "https://api.trello.com"

    # Bu scen. de board create edeceğiz.
    # ayrıca taskımızda diğer işlemleri gerçekleştirebilmek için board id'ye ihtiyacımız var.
    # Board ID yi de bu scen. den alacağız. ve Board'un create edildiğini assert edeceğiz. ---> class seviyesinde tanımla...
  Scenario: Kullanıcı Board create edebilmeli
    When Kullanıcı board create edebilmek için ilgili URL e POST metodu ve ilgili end pointler ile request atar "idPath","1","boardspath","board"
    And Kullanıcı board id yi alır
    Then Kullanıcı Board un basarılı bir şekilde create edildiğini doğrular

