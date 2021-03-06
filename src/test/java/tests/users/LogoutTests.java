package tests.users;

import org.testng.annotations.Test;
import pojo.User;
import resources.BaseTest;

public class LogoutTests extends BaseTest {
    private User user;

    @Test
    public void canLogout() {
        user = dataBuilder.getUserAllFields();
        userService.addAnUser(user);
        userService.login(user.getUsername(), user.getPassword());
        userService.userLogout();
    }
}
