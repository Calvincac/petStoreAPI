package resources;

import com.github.javafaker.Faker;
import data.DataBuilder;
import service.PetService;
import service.StoreService;
import service.UserService;

public class BaseTest {
    public PetService petService = new PetService();
    public StoreService storeService = new StoreService();
    public UserService userService = new UserService();
    public DataBuilder dataBuilder = new DataBuilder();
    public Faker faker = new Faker();
}
