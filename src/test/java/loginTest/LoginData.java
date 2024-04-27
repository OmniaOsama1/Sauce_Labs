package loginTest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.io.IOException;

public class LoginData {

    private WebDriver driver;
    public LoginData(WebDriver driver){
            this.driver=driver;
    }
    private String userName;
    private String password;
    public void loginDataProvider() throws IOException, ParseException {
           JSONParser jsonParser=new JSONParser();
           FileReader reader=new FileReader("src/test/testData/loginData.json");
           Object obj=jsonParser.parse(reader);
           JSONObject jsonObject=(JSONObject) obj;
           userName = (String)jsonObject.get("UserName");
           password = (String)jsonObject.get("Password");
    }
    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }

}
