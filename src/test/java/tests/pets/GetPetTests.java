package tests.pets;

import data.PetStoreTestData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Pet;
import pojo.Status;
import service.BaseTest;

import static asserters.PetAsserters.assertStatus;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

import static asserters.PetAsserters.assertPet;

public class GetPetTests extends BaseTest {

    private Pet expectedPet;

    @BeforeMethod
    public void beforeMethod() {
        expectedPet = dataBuilder.getPetAllFields();
    }

    @Test
    public void canRetrieveAPet() {
        Pet petResponse = petService.addPet(expectedPet);
        Pet retrievedPet = petService.getPetById(petResponse.getId());
        assertPet(expectedPet, retrievedPet);
    }

    @Test
    public void cannotRetrieveAPetWithNullId() {
        petService.getPetByIdNotFound(null);
    }

    @Test
    public void cannotRetrieveAPetThatDoesNotExist() {
        petService.getPetByIdNotFound(0L);
    }

    @Test
    public void canRetrieveAPetByAvailableStatus() {
        petService.addPet(expectedPet);
        List<Pet> pets = petService.retrievePetByStatus(PetStoreTestData.AVAILABLE_STATUS.toString());
        assertThat(pets.isEmpty(), is(false));
        assertStatus(pets, Status.AVAILABLE);
    }

    @Test
    public void canRetrieveAPetByPendingStatus() {
        expectedPet.setStatus(Status.PENDING);
        petService.addPet(expectedPet);
        List<Pet> pets = petService.retrievePetByStatus(PetStoreTestData.PENDING_STATUS.toString());
        assertThat(pets.isEmpty(), is(false));
        assertStatus(pets, Status.PENDING);
    }

    @Test
    public void canRetrieveAPetBySoldStatus() {
        expectedPet.setStatus(Status.SOLD);
        petService.addPet(expectedPet);
        List<Pet> pets = petService.retrievePetByStatus(PetStoreTestData.SOLD_STATUS.toString());
        assertThat(pets.isEmpty(), is(false));
        assertStatus(pets, Status.SOLD);
    }

    @Test
    public void cannotRetrieveAPetByUnknownStatus() {
        List<Pet> pets = petService.retrievePetByStatus(PetStoreTestData.UNKNOWN_STATUS.toString());
        assertThat(pets.isEmpty(), is(true));
    }

    @Test
    public void cannotRetrieveAPetByNullStatus() {
        List<Pet> pets = petService.retrievePetByStatus(null);
        assertThat(pets.isEmpty(), is(true));
    }
}
