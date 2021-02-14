package tests.pets;

import data.DataBuilder;
import data.PetStoreTestData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Pet;
import pojo.Status;
import service.PetService;

import static asserters.PetAsserters.assertStatus;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

import static asserters.PetAsserters.assertPet;

public class GetPetTests extends PetService {

    private DataBuilder data = new DataBuilder();
    private Pet expectedPet;

    @BeforeMethod
    public void beforeMethod() {
        expectedPet = data.getPetAllFields();
    }

    @Test
    public void canRetrieveAPet() {
        Pet petResponse = addPet(expectedPet);
        Pet retrievedPet = getPetById(petResponse.getId());
        assertPet(expectedPet, retrievedPet);
    }

    @Test
    public void cannotRetrieveAPetWithNullId() {
        getPetByIdNotFound(null);
    }

    @Test
    public void cannotRetrieveAPetThatDoesNotExist() {
        getPetByIdNotFound(0L);
    }

    @Test
    public void canRetrieveAPetByAvailableStatus() {
        addPet(expectedPet);
        List<Pet> pets = retrievePetByStatus(PetStoreTestData.AVAILABLE_STATUS.toString());
        assertThat(pets.isEmpty(), is(false));
        assertStatus(pets, Status.AVAILABLE);
    }

    @Test
    public void canRetrieveAPetByPendingStatus() {
        expectedPet.setStatus(Status.PENDING);
        addPet(expectedPet);
        List<Pet> pets = retrievePetByStatus(PetStoreTestData.PENDING_STATUS.toString());
        assertThat(pets.isEmpty(), is(false));
        assertStatus(pets, Status.PENDING);
    }

    @Test
    public void canRetrieveAPetBySoldStatus() {
        expectedPet.setStatus(Status.SOLD);
        addPet(expectedPet);
        List<Pet> pets = retrievePetByStatus(PetStoreTestData.SOLD_STATUS.toString());
        assertThat(pets.isEmpty(), is(false));
        assertStatus(pets, Status.SOLD);
    }

    @Test
    public void cannotRetrieveAPetByUnknownStatus() {
        List<Pet> pets = retrievePetByStatus(PetStoreTestData.UNKNOWN_STATUS.toString());
        assertThat(pets.isEmpty(), is(true));
    }

    @Test
    public void cannotRetrieveAPetByNullStatus() {
        List<Pet> pets = retrievePetByStatus(null);
        assertThat(pets.isEmpty(), is(true));
    }
}
