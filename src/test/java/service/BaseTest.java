package service;

import data.DataBuilder;
import data.PetStoreTestData;
import org.testng.annotations.AfterTest;
import pojo.Pet;

import java.util.List;

public class BaseTest {
    public PetService petService = new PetService();
    public StoreService storeService = new StoreService();
    public UserService userService = new UserService();
    public DataBuilder dataBuilder = new DataBuilder();

    @AfterTest
    public void cleanUp() {
        List<Pet> availablePets = petService.retrievePetByStatus(PetStoreTestData.AVAILABLE_STATUS.toString());
        availablePets.forEach(pet -> {petService.deleteAPet(pet.getId());});
        List<Pet> pendingPets = petService.retrievePetByStatus(PetStoreTestData.PENDING_STATUS.toString());
        pendingPets.forEach(pet -> {petService.deleteAPet(pet.getId());});
        List<Pet> soldPets = petService.retrievePetByStatus(PetStoreTestData.SOLD_STATUS.toString());
        soldPets.forEach(pet -> {petService.deleteAPet(pet.getId());});
    }
}
