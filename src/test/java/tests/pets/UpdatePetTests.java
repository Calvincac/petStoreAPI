package tests.pets;

import com.github.javafaker.Faker;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Pet;
import pojo.Status;
import service.BaseTest;

import java.util.List;

import static asserters.PetAsserters.assertPet;

public class UpdatePetTests extends BaseTest {

    private Pet pet;
    private Faker faker = new Faker();

    @BeforeMethod
    public void beforeMethod() {
        pet = dataBuilder.getPetAllFields();
    }

    @Test
    public void canUpdateAPetName() {
        String newName = faker.name().lastName();
        Pet createdPet = petService.addPet(pet);
        createdPet.setName(newName);
        Pet updatedPet = petService.updateAPet(createdPet);
        assertPet(updatedPet, createdPet);
    }

    @Test
    public void canUpdateAPetCategory() {
        String newCategoryName = faker.name().firstName();
        Pet createdPet = petService.addPet(pet);
        createdPet.getCategory().setName(newCategoryName);
        Pet updatedPet = petService.updateAPet(createdPet);
        assertPet(updatedPet, createdPet);
    }

    @Test
    public void canUpdateAPetPhotoUrl() {
        String newPhotoUrl = faker.company().url();
        Pet createdPet = petService.addPet(pet);
        createdPet.setPhotoUrls(List.of(newPhotoUrl));
        Pet updatedPet = petService.updateAPet(createdPet);
        assertPet(updatedPet, createdPet);
    }

    @Test
    public void canUpdateAPetTagName() {
        String newTagName = faker.funnyName().name();
        Pet createdPet = petService.addPet(pet);
        createdPet.getTags().forEach(tag -> {tag.setName(newTagName);});
        Pet updatedPet = petService.updateAPet(createdPet);
        assertPet(updatedPet, createdPet);
    }

    @Test
    public void canUpdateAPetStatusFromAvailableToSold() {
        Pet createdPet = petService.addPet(pet);
        createdPet.setStatus(Status.SOLD);
        Pet updatedPet = petService.updateAPet(createdPet);
        assertPet(updatedPet, createdPet);
    }

    @Test
    public void canUpdateAPetStatusFromPendingToAvailable() {
        pet.setStatus(Status.PENDING);
        Pet createdPet = petService.addPet(pet);
        createdPet.setStatus(Status.AVAILABLE);
        Pet updatedPet = petService.updateAPet(createdPet);
        assertPet(updatedPet, createdPet);
    }

    @Test
    public void canUpdateAPetStatusFromPendingToSold() {
        pet.setStatus(Status.PENDING);
        Pet createdPet = petService.addPet(pet);
        createdPet.setStatus(Status.SOLD);
        Pet updatedPet = petService.updateAPet(createdPet);
        assertPet(updatedPet, createdPet);
    }
}
