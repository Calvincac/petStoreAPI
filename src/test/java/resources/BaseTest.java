package resources;

import data.DataBuilder;
import data.PetStoreTestData;
import org.testng.annotations.AfterTest;
import pojo.Pet;
import service.PetService;
import service.StoreService;
import service.UserService;

import java.util.List;

public class BaseTest {
    public PetService petService = new PetService();
    public StoreService storeService = new StoreService();
    public UserService userService = new UserService();
    public DataBuilder dataBuilder = new DataBuilder();
}
