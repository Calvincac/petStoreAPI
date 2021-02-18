package tests.pets;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Pet;
import service.BaseTest;

import static asserters.PetAsserters.assertPet;

public class AddPetTests extends BaseTest {
    private Pet expectedPet;

    @BeforeMethod
    public void beforeMethod() {
        expectedPet = dataBuilder.getPetAllFields();
    }

    @Test
    public void canCreateAPetAllFields() {
        Pet petResponse = petService.addPet(expectedPet);
        assertPet(expectedPet, petResponse);
    }

    @Test
    public void canCreateAPetWithoutCategory() {
        expectedPet.setCategory(null);
        Pet petResponse = petService.addPet(expectedPet);
        assertPet(expectedPet, petResponse);
    }

    @Test
    public void canCreateAPetWithoutName() {
        expectedPet.setName(null);
        Pet petResponse = petService.addPet(expectedPet);
        assertPet(expectedPet, petResponse);
    }

    @Test
    public void canCreateAPetWithoutTags() {
        expectedPet.setTags(null);
        Pet petResponse = petService.addPet(expectedPet);
        assertPet(expectedPet, petResponse);
    }

    @Test
    public void canCreateAPetWithoutStatus() {
        expectedPet.setStatus(null);
        Pet petResponse = petService.addPet(expectedPet);
        assertPet(expectedPet, petResponse);
    }

    @Test
    public void canCreateAPetWithoutPhotoUrls() {
        expectedPet.setPhotoUrls(null);
        Pet petResponse = petService.addPet(expectedPet);
        assertPet(expectedPet, petResponse);
    }

    @Test
    public void canAdd50PetsOneAfterAnother() {
        for (int i = 0; i < 50; i++) {
            Pet pet = dataBuilder.getPetAllFields();
            Pet petResponse = petService.addPet(pet);
            assertPet(pet, petResponse);
        }
    }
}
