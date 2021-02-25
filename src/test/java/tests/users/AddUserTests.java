package tests.users;

import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.User;
import resources.BaseTest;

public class AddUserTests extends BaseTest {

    private User expectedUser;

    @BeforeMethod
    public void beforeMethod() {
        expectedUser = dataBuilder.getUserAllFields();
    }

    @Test
    public void canCreateAnUserAllFields() {
        Response userResponse = userService.addAnUser(expectedUser);
    }
}
