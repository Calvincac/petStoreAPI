package service;

import client.UserClient;
import io.restassured.response.Response;
import pojo.User;

import java.util.List;

public class UserService extends UserClient {

    public Response addAnUser(Object user) {
        return  postUser(user)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .response();
    }

    public Response addAnUserInternalServerError(Object user) {
        return  postUser(user)
                .then()
                .log()
                .all()
                .statusCode(500)
                .extract()
                .response();
    }

    public Response addUsersInAList(List<User> users) {
        return  postUsersInAList(users)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .response();
    }
}
