package service;

import client.StoreClient;
import pojo.Order;

public class StoreService extends StoreClient {

    public Order createAOrder(Order order) {
        return  postOrder(order)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .as(Order.class);
    }
}
