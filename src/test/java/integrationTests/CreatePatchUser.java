package integrationTests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersService;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserResponse;
import users.update.UpdateUserRequestBody;
import users.update.response.UpdateUserResponse;

public class CreatePatchUser {

    private UsersService usersService;

    @BeforeClass
    public void beforeClass()
    {
        usersService = new UsersService();
    }

    @Test
    public void shouldCreateAndUpdateUser(){

        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().build();
        CreateUserResponse createUserResponse = usersService.createUser(requestBody);
          int id = createUserResponse.getData().getId();

        UpdateUserRequestBody updateUserRequestBody = new UpdateUserRequestBody.Builder().gender("female").status("inactive").build();
        UpdateUserResponse updateUserResponse = usersService.UpdateUser(updateUserRequestBody,id);
        updateUserResponse.assertUser(updateUserRequestBody);


    }
}
