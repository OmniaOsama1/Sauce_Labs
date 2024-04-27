package placeOrder;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.io.IOException;

public class PlaceOrderData {
    private WebDriver driver;
    private String firstName;
    private String lastName;
    private String postalCode;
    public PlaceOrderData(WebDriver driver){
        this.driver=driver;
    }
    public void placeOrderData() throws IOException, ParseException {
        JSONParser jsonParser=new JSONParser();
        FileReader reader =new FileReader("src/test/testData/placeOrderData.json");
        Object obj = jsonParser.parse(reader);
        JSONObject jsonObj=(JSONObject)obj;
        firstName=(String)jsonObj.get("First Name");
        lastName=(String)jsonObj.get("Last Name");
        postalCode=(String)jsonObj.get("Zip/Postal Code");
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getPostalCode(){
        return postalCode;
    }
}
