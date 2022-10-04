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

        CreateUserRequestBody requestBody =  CreateUserRequestBody.builder()
                .name("Aditi Rao")
                .gender("female")
                .email("aditirao121gmail.com")
                .status("active")
                .build();
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

        CreateUserRequestBody requestBody =  CreateUserRequestBody.builder()
                .name("Aditi Rao")
                .gender("")
                .email("aditirao12ewew1@gmail.com")
                .status("")
                .build();
        //Act
        CreateUserErrorResponse errorResponse = usersClient.createUserExpectingError(requestBody);

        //Assert
        assertEquals(errorResponse.getStatuscode(),422);
        errorResponse.assertHasError("gender","can't be blank, can be male of female");
        errorResponse.assertHasError("status","can't be blank");


    }
}
