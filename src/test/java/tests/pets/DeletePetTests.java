package tests.pets;

import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Pet;
import service.BaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static resources.Utils.getJsonPath;


public class DeletePetTests extends BaseTest {
    private Pet expectedPet, petResponse;

    @BeforeMethod
    public void beforeMethod() {
        expectedPet = dataBuilder.getPetAllFields();
        petResponse = petService.addPet(expectedPet);
    }

    @Test
    public void canDeleteAPet() {
        Response response = petService.deleteAPet(petResponse.getId());
        assertThat(getJsonPath(response, "message"), equalTo(petResponse.getId().toString()));
    }

    @Test
    public void canDelete10PetsOneAfterAnother() {
        for(int i=0; i<10; i++){
            Pet pet = dataBuilder.getPetAllFields();
            Pet petResponse = petService.addPet(pet);
            Response response = petService.deleteAPet(petResponse.getId());
            assertThat(getJsonPath(response, "message"), equalTo(petResponse.getId().toString()));
        }
    }

    @Test
    public void cannotDeleteAPetWithoutId() {
        petService.deleteAPetNotFound(null);
    }

    @Test
    public void cannotDeleteAPetWithInvalidId() {
        petService.deleteAPetNotFound(0L);
    }
}
