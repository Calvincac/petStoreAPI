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
}
