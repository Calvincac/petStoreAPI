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

    public User retrieveUserByUserName(String username) {
        return  getUserByUserName(username)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .as(User.class);
    }

    public Response retrieveUserByUserNameNotFound(String username) {
        return  getUserByUserName(username)
                .then()
                .log()
                .all()
                .statusCode(404)
                .extract()
                .response();
    }

    public Response retrieveUserByUserNameError(String username) {
        return  getUserByUserName(username)
                .then()
                .log()
                .all()
                .statusCode(405)
                .extract()
                .response();
    }

    public Response deleteUserByUsername(String username) {
        return  deleteUserByUserName(username)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .response();
    }

    public Response deleteUserByUsernameNotFound(String username) {
        return  deleteUserByUserName(username)
                .then()
                .log()
                .all()
                .statusCode(404)
                .extract()
                .response();
    }

    public Response deleteUserByUsernameError(String username) {
        return  deleteUserByUserName(username)
                .then()
                .log()
                .all()
                .statusCode(405)
                .extract()
                .response();
    }

    public Response updateUser(Object user, String username) {
        return  putUser(user, username)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .response();
    }
}
