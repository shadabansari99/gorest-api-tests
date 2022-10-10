package integrationTests;

import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.UsersService;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserResponse;

import java.util.UUID;

public class UserTests {

    private UsersService usersService;

    @BeforeClass
    public void beforeClass()
    {
        usersService = new UsersService();
    }

    @Test
    public void shouldCreateAndGetUser()
    {
        //Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().build();
        //Act
        int id = usersService.createUser(requestBody).getData().getId();
        //Assert
       usersService.getUser(id).assertUser(requestBody);
    }
    @Test
    public void shouldDeleteUser() {
        //Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().build();
        //Act
        int id = usersService.createUser(requestBody).getData().getId();
        int statusCode = usersService.deleteUser(id);
        //Assert
        Assert.assertEquals(statusCode, 204);
        usersService.getUserExpectingError(id).assertError(404, "Resource not found");
    }



}
