package service;

import client.UserClient;
import io.restassured.response.Response;
import pojo.User;

public class UserService extends UserClient {

    public Response addAnUser(User user) {
        return  postUser(user)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .response();
    }
}
