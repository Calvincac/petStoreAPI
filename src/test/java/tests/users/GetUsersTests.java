package tests.users;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.User;
import resources.BaseTest;

import static asserters.UserAsserters.assertUser;

public class GetUsersTests extends BaseTest {
    private User user;

    @Test
    public void canRetrieveUserByUserName() {
        user = dataBuilder.getUserAllFields();
        userService.addAnUser(user);
        User retrievedUser = userService.retrieveUserByUserName(user.getUsername());
        assertUser(user, retrievedUser);
    }

    @Test
    public void cannotRetrieveUserWithEmptyUserName() {
        userService.retrieveUserByUserNameError("");
    }

    @Test
    public void cannotRetrieveAnUserWithNullUserName() {
        userService.retrieveUserByUserNameNotFound(null);
    }

    @Test
    public void cannotRetrieveAnUserWithInvalidUserName() {
        userService.retrieveUserByUserNameNotFound(faker.lorem().characters());
    }
}
