package tests.users;

import org.testng.annotations.Test;
import resources.BaseTest;

import java.util.List;

public class AddUserWithListTests extends BaseTest {

    @Test
    public void canCreateABatchOf10Users() {
        userService.addUsersInAList(dataBuilder.getListOfUsers(10));
    }

    @Test
    public void canCreateABatchOf1000Users() {
        userService.addUsersInAList(dataBuilder.getListOfUsers(1000));
    }

    @Test
    public void canSendAEmptyList() {
        userService.addUsersInAList(List.of());
    }


}
