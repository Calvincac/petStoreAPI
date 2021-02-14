package tests.store;

import data.DataBuilder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Order;
import pojo.Pet;
import service.BaseTest;

import static asserters.OrderAsserters.assertOrder;

public class AddOrderTests extends BaseTest {
    private DataBuilder data = new DataBuilder();
    private Order order;
    private Pet pet, petResponse;


    @BeforeMethod
    public void beforeMethod() {
        order = data.getOrderAllFields();
        pet = data.getPetAllFields();
        petResponse = petService.addPet(pet);
    }

    @Test
    public void canCreateAnOrderWithAllFields() {
        order.setPetId(petResponse.getId());
        Order createdOrder = storeService.createAOrder(order);
        assertOrder(order, createdOrder);
    }
}
