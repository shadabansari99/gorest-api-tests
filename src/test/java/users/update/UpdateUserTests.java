package users.update;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersService;
import users.update.response.UpdateUserResponse;

public class UpdateUserTests {
    private UsersService usersService;

    @BeforeClass
    public void beforeClass() {
        usersService = new UsersService();
    }

    @Test
    public void shouldUpdateUser() {
        UpdateUserRequestBody updateUserRequestBody = new UpdateUserRequestBody.Builder().email("tv1@gmail.com").status("inactive").build();
        int id = 2688;
        UpdateUserResponse updateUserResponse = usersService.UpdateUser(updateUserRequestBody,id);
        updateUserResponse.assertUser(updateUserRequestBody);
    }
}
