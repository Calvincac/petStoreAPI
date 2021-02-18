package service;

import client.StoreClient;
import io.restassured.response.Response;
import pojo.Order;

public class StoreService extends StoreClient {

    public Order createAnOrder(Object order) {
        return  postOrder(order)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .as(Order.class);
    }

    public Response createAnOrderInternalServerError(Object order) {
        return  postOrder(order)
                .then()
                .log()
                .all()
                .statusCode(500)
                .extract()
                .response();
    }

    public Order retrieveAnOrder(String orderId) {
        return  getAnOrder(orderId)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .as(Order.class);
    }

    public Response retrieveAnOrderNotFound(String orderId) {
        return  getAnOrder(orderId)
                .then()
                .log()
                .all()
                .statusCode(404)
                .extract()
                .response();
    }

    public Response retrieveAnOrderError(String orderId) {
        return  getAnOrder(orderId)
                .then()
                .log()
                .all()
                .statusCode(405)
                .extract()
                .response();
    }

    public Response deleteOrder(String orderId) {
        return  deleteAnOrder(orderId)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .response();
    }

    public Response deleteOrderNotFound(String orderId) {
        return  deleteAnOrder(orderId)
                .then()
                .log()
                .all()
                .statusCode(404)
                .extract()
                .response();
    }
}
