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
          String email = createUserResponse.getData().getEmail();
          String name = createUserResponse.getData().getName();
          String gender = createUserResponse.getData().getGender();
          String status = createUserResponse.getData().getStatus();

        UpdateUserRequestBody updateUserRequestBody = new UpdateUserRequestBody.Builder().name(name).email(email).gender(gender).status("inactive").build();
        UpdateUserResponse updateUserResponse = usersService.UpdateUser(updateUserRequestBody,id);
        updateUserResponse.assertUser(updateUserRequestBody);


    }
}
