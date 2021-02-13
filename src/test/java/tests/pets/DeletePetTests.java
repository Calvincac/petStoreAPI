package tests.pets;

import data.DataBuilder;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Pet;
import service.PetService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static resources.Utils.getJsonPath;


public class DeletePetTests extends PetService {
    private DataBuilder data = new DataBuilder();
    private Pet expectedPet, petResponse;

    @BeforeMethod
    public void beforeMethod() {
        expectedPet = data.getPetAllFields();
        petResponse = addPet(expectedPet);
    }

    @Test
    public void canDeleteAPet() {
        Response response = deleteAPet(petResponse.getId());
        assertThat(getJsonPath(response, "message"), equalTo(petResponse.getId().toString()));
    }

    @Test
    public void canDelete10PetsOneAfterAnother() {
        for(int i=0; i<10; i++){
            Pet pet = data.getPetAllFields();
            Pet petResponse = addPet(pet);
            Response response = deleteAPet(petResponse.getId());
            assertThat(getJsonPath(response, "message"), equalTo(petResponse.getId().toString()));
        }
    }

    @Test
    public void cannotDeleteAPetWithoutId() {
        deleteAPetNotFound(null);
    }

    @Test
    public void cannotDeleteAPetWithInvalidId() {
        deleteAPetNotFound(0);
    }
}
