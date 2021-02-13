package tests.pets;

import data.DataBuilder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Pet;
import service.PetService;

import static asserters.PetAsserters.assertPet;

public class AddPetTests extends PetService {
    private DataBuilder data = new DataBuilder();
    private Pet expectedPet;

    @BeforeMethod
    public void beforeMethod() {
        expectedPet = data.getPetAllFields();
    }

    @Test
    public void canCreateAPetAllFields() {
        Pet petResponse = addPet(expectedPet);
        assertPet(expectedPet, petResponse);
    }

    @Test
    public void canCreateAPetWithoutCategory() {
        expectedPet.setCategory(null);
        Pet petResponse = addPet(expectedPet);
        assertPet(expectedPet, petResponse);
    }

    @Test
    public void canCreateAPetWithoutName() {
        expectedPet.setName(null);
        Pet petResponse = addPet(expectedPet);
        assertPet(expectedPet, petResponse);
    }

    @Test
    public void canCreateAPetWithoutTags() {
        expectedPet.setTags(null);
        Pet petResponse = addPet(expectedPet);
        assertPet(expectedPet, petResponse);
    }

    @Test
    public void canCreateAPetWithoutStatus() {
        expectedPet.setStatus(null);
        Pet petResponse = addPet(expectedPet);
        assertPet(expectedPet, petResponse);
    }

    @Test
    public void canCreateAPetWithoutPhotoUrls() {
        expectedPet.setPhotoUrls(null);
        Pet petResponse = addPet(expectedPet);
        assertPet(expectedPet, petResponse);
    }
}
