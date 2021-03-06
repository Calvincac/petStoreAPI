package tests.users;

import org.testng.annotations.Test;
import pojo.User;
import resources.BaseTest;

public class DeleteUsersTests extends BaseTest {
    private User user;

    @Test
    public void canDeleteUserByUserName() {
        user = dataBuilder.getUserAllFields();
        userService.addAnUser(user);
        userService.deleteUserByUsername(user.getUsername());
    }

    @Test
    public void cannotDeleteUserByInvalidUserName() {
        userService.deleteUserByUsernameNotFound(faker.ancient().primordial());
    }

    @Test
    public void cannotDeleteUserByNullUserName() {
        userService.deleteUserByUsernameNotFound(null);
    }

    @Test
    public void cannotDeleteUserByEmptyUserName() {
        userService.deleteUserByUsernameError("");
    }

}
