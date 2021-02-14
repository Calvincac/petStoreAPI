package asserters;

import pojo.Order;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class OrderAsserters {

    public static void assertOrder(Order expectedOrder, Order actualOrder) {
        assertThat(expectedOrder.getId(), equalTo(actualOrder.getId()));
        assertThat(expectedOrder.getComplete(), equalTo(actualOrder.getComplete()));
        assertThat(expectedOrder.getQuantity(), equalTo(actualOrder.getQuantity()));
        assertThat(expectedOrder.getShipDate(), equalTo(actualOrder.getShipDate()));
        assertThat(expectedOrder.getPetId(), equalTo(actualOrder.getPetId()));
        assertThat(expectedOrder.getStatus(), equalTo(actualOrder.getStatus()));
    }
}
