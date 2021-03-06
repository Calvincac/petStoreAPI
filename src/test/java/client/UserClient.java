package client;

import io.restassured.response.Response;
import pojo.User;
import resources.PetStoreResources;

import java.util.List;

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

    public Response postUsersInAList(List<User> users) {
        return  given()
                .spec(utils.requestSpecification())
                .body(users)
                .when()
                .log()
                .all()
                .post(PetStoreResources.USER_LIST.getResource());
    }

    public Response getUserByUserName(String username) {
        return  given()
                .spec(utils.requestSpecification())
                .when()
                .log()
                .all()
                .get(PetStoreResources.USER.getResource() + username);
    }

    public Response deleteUserByUserName(String username) {
        return  given()
                .spec(utils.requestSpecification())
                .when()
                .log()
                .all()
                .delete(PetStoreResources.USER.getResource() + username);
    }
}
