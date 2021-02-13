package resources;

import configuration.Configuration;
import configuration.ConfigurationManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {

    public static RequestSpecification req;
    ConfigurationManager configuration = new ConfigurationManager();

    public RequestSpecification requestSpecification() {

        if( req == null ) {
            req = new RequestSpecBuilder()
                    .setBaseUri(configuration.getConfiguration().host())
                    .setContentType(ContentType.JSON).build();
            return req;
        }
        return req;
    }

    public static String getGlobalValue(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis =new FileInputStream("src/test/java/resources/global.properties");
        prop.load(fis);
        return prop.getProperty(key);
    }

    public String getJsonPath(Response response, String key) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }

    public String getJsonObject(Response response, String key) {
        JSONObject jsonObject = new JSONObject().put(key, getJsonPath(response, key));
        return jsonObject.toString();
    }
}
