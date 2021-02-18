package client;

import io.restassured.response.Response;
import resources.PetStoreResources;
import resources.Utils;

import static io.restassured.RestAssured.given;

public class StoreClient {
    Utils utils = new Utils();

    public Response postOrder(Object order) {
        return  given()
                .spec(utils.requestSpecification())
                .body(order)
                .when()
                .log()
                .all()
                .post(PetStoreResources.ORDER.getResource());
    }

    public Response getAnOrder(String orderId) {
        return  given()
                .spec(utils.requestSpecification())
                .when()
                .log()
                .all()
                .get(PetStoreResources.ORDER.getResource() + orderId);
    }

    public Response deleteAnOrder(String orderId) {
        return  given()
                .spec(utils.requestSpecification())
                .when()
                .log()
                .all()
                .delete(PetStoreResources.ORDER.getResource() + orderId);
    }
}
