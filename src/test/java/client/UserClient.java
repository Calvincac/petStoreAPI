package client;

import io.restassured.response.Response;
import resources.PetStoreResources;

import static io.restassured.RestAssured.given;

public class UserClient extends BaseClient{

    public Response postUser(Object user) {
        return  given()
                .spec(utils.requestSpecification())
                .body(user)
                .when()
                .log()
                .all()
                .post(PetStoreResources.USER.getResource());
    }
}
