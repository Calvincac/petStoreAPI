package client;

import io.restassured.response.Response;
import pojo.Order;
import resources.PetStoreResources;
import resources.Utils;

import static io.restassured.RestAssured.given;

public class StoreClient {
    Utils utils = new Utils();

    public Response postOrder(Order order) {
        return  given()
                .spec(utils.requestSpecification())
                .body(order)
                .when()
                .log()
                .all()
                .post(PetStoreResources.ORDER.getResource());
    }
}
