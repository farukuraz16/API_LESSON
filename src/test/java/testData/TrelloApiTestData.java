package testData;

public class TrelloApiTestData {

    // key ---> String
    // token ---> String
    // name ---> String

    //token = ATTA6116293e2b6e1710a0769c4197ffbd2c7a7f23c95d476741e0255626dd2f37967CEC20DC
    //apikey = 7852a988d8215fe699b78a92c8aa400b

    //faruk API Key = da65cb6978348bf6345c0833c19abdc8
    //faruk token = ATATT3xFfGF02OiAOdwtQptvT1yYLLfoykQ0dySyT_fQx-HqTrJjPLZtOWDh95mRZsu02P7M2hfAgUbOseCW_ytm5ztHqALWGbX6cHEjlO-BH5frZeRmqXxpgy7Gh3_DTEr9P2zR1BdCowYAY21NpEsToJ7XPNl2UZLTYQ8k3HVSmSOrzqnmvMg=40DAED04
// ATTAbb7ccad13b433e0940c6a70a9c0548486c077c5a90ee69dfbafe0eb4d7e7a051AA87B10C
    private String key="da65cb6978348bf6345c0833c19abdc8";
    private String token="ATTAbb7ccad13b433e0940c6a70a9c0548486c077c5a90ee69dfbafe0eb4d7e7a051AA87B10C";
    private String boardName="Uraz Board";
    private String listName="Uraz List";

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}
