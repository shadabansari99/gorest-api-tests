package integrationTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserResponse;

import java.util.UUID;

public class UserTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass()
    {
        usersClient = new UsersClient();
    }

    @Test
    public void shouldCreateAndGetUser()
    {
        //Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().build();
        //Act
        int id = usersClient.createUser(requestBody).getData().getId();
        //Assert
        usersClient.getUser(id).assertUser(requestBody);




    }






}
