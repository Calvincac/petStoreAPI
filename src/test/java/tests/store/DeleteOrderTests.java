package tests.store;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Order;
import pojo.Pet;
import resources.BaseTest;

public class DeleteOrderTests extends BaseTest {
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
    public void canDeleteAnOrder() {
        storeService.deleteOrder(createdOrder.getId().toString());
    }

    @Test
    public void cannotDeleteInvalidOrder() {
        storeService.deleteOrderNotFound(pet.getId().toString());
    }

    @Test
    public void cannotDeleteOrderWithNullId() {
        storeService.deleteOrderNotFound(null);
    }
}
