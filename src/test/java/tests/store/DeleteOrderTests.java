package tests.store;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Order;
import pojo.Pet;
import resources.BaseTest;

public class DeleteOrderTests extends BaseTest {
    private Order order, createdOrder;
    private Pet pet, petResponse;

    @Test
    public void canDeleteAnOrder() {
        order = dataBuilder.getOrderAllFields();
        pet = dataBuilder.getPetAllFields();
        petResponse = petService.addPet(pet);
        order.setPetId(petResponse.getId());
        createdOrder = storeService.createAnOrder(order);
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
