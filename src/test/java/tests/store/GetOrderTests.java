package tests.store;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Order;
import pojo.Pet;
import resources.BaseTest;

import static asserters.OrderAsserters.assertOrder;

public class GetOrderTests extends BaseTest {

    private Order order, createdOrder;
    private Pet pet, petResponse;

    @BeforeMethod
    public void beforeMethod() {
        order = dataBuilder.getOrderAllFields();
        pet = dataBuilder.getPetAllFields();
        petResponse = petService.addPet(pet);
        order.setPetId(petResponse.getId());
        createdOrder = storeService.createAnOrder(order);
    }

    @Test
    public void canRetrieveAnOrderById() {
        Order retrievedOrder = storeService.retrieveAnOrder(createdOrder.getId().toString());
        assertOrder(order, retrievedOrder);
    }

    @Test
    public void cannotRetrieveAnOrderNullId() {
        storeService.retrieveAnOrderNotFound(null);
    }

    @Test
    public void cannotRetrieveAnOrderWithWrongId() {
        storeService.retrieveAnOrderNotFound(pet.getId().toString());
    }

    @Test
    public void cannotRetrieveAnOrderWithoutId() {
        storeService.retrieveAnOrderError("");
    }
}
