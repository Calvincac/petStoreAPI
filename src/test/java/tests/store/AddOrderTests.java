package tests.store;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import incorrect.IncorrectOrder;
import pojo.Order;
import pojo.Pet;
import service.BaseTest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static asserters.OrderAsserters.assertOrder;

public class AddOrderTests extends BaseTest {
    private Order order;
    private Pet pet, petResponse;

    @BeforeMethod
    public void beforeMethod() {
        order = dataBuilder.getOrderAllFields();
        pet = dataBuilder.getPetAllFields();
        petResponse = petService.addPet(pet);
    }

    @Test
    public void canCreateAnOrderWithAllFields() {
        order.setPetId(petResponse.getId());
        Order createdOrder = storeService.createAnOrder(order);
        assertOrder(order, createdOrder);
    }

    @Test
    public void canCreateAnOrderWithApprovedStatus() {
        order.setPetId(petResponse.getId());
        order.setStatus("approved");
        Order createdOrder = storeService.createAnOrder(order);
        assertOrder(order, createdOrder);
    }

    @Test
    public void canCreateAnOrderWithDeliveredStatus() {
        order.setPetId(petResponse.getId());
        order.setStatus("delivered");
        Order createdOrder = storeService.createAnOrder(order);
        assertOrder(order, createdOrder);
    }

    @Test
    public void canCreateAnOrderWithDateInTheFuture() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime timePoint = LocalDateTime.now();
        String formattedDate = timePoint.plusDays(14).format(formatter);

        order.setPetId(petResponse.getId());
        order.setShipDate(formattedDate);
        Order createdOrder = storeService.createAnOrder(order);
        assertOrder(order, createdOrder);
    }

    @Test
    public void canCreateAnOrderWithDateInThePast() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime timePoint = LocalDateTime.now();
        String formattedDate = timePoint.minusDays(14).format(formatter);

        order.setPetId(petResponse.getId());
        order.setShipDate(formattedDate);
        Order createdOrder = storeService.createAnOrder(order);
        assertOrder(order, createdOrder);
    }

    @Test
    public void canCreateAnOrderWithoutQuantity() {
        order.setPetId(petResponse.getId());
        order.setQuantity(0);
        Order createdOrder = storeService.createAnOrder(order);
        assertOrder(order, createdOrder);
    }

    @Test
    public void cannotCreateAnOrderWithDateInTheWrongFormat() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime timePoint = LocalDateTime.now();
        String formattedDate = timePoint.minusDays(14).format(formatter);

        order.setPetId(petResponse.getId());
        order.setShipDate(formattedDate);
        storeService.createAnOrderInternalServerError(order);
    }

    @Test
    public void cannotCreateAnOrderWithWrongPayload() {
        IncorrectOrder incorrectOrder = new IncorrectOrder();
        List<String> list = new ArrayList();
        list.add(order.getStatus());
        incorrectOrder.setQuantity(list);
        storeService.createAnOrderInternalServerError(incorrectOrder);
    }

    @Test
    public void cannotCreateAnOrderWithInvalidComplete() {
        IncorrectOrder incorrectOrder = new IncorrectOrder();
        incorrectOrder.setComplete(order.getQuantity().toString());
        storeService.createAnOrderInternalServerError(incorrectOrder);
    }
}
