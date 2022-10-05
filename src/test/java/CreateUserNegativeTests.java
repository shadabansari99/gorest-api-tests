import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;
import users.create.response.CreateUserResponse;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class CreateUserNegativeTests {
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass()
    {
        usersClient = new UsersClient();
    }

    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail()
    {
        //Arrange

        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().email("shadabgmail.com").build();
        //Act
        CreateUserErrorResponse errorResponse = usersClient.createUserExpectingError(requestBody);

        //Assert
        assertEquals(errorResponse.getStatuscode(),422);
        errorResponse.assertHasError("email","is invalid");

    }
    @Test
    public void shouldNotAllowToCreateUserWithBlankGenderAndStatus()
    {
        //Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().gender("").status("").build();
        //Act
        CreateUserErrorResponse errorResponse = usersClient.createUserExpectingError(requestBody);

        //Assert
        assertEquals(errorResponse.getStatuscode(),422);
        errorResponse.assertHasError("gender","can't be blank, can be male of female");
        errorResponse.assertHasError("status","can't be blank");


    }
}
