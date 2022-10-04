import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserResponse;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class CreateUserTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass()
    {
        usersClient = new UsersClient();
    }

    @Test
    public void shouldCreateMaleUser()
    {
        //Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());

        //CreateUserRequestBody requestBody = new CreateUserRequestBody(name,gender,email,status);
        CreateUserRequestBody requestBody =  CreateUserRequestBody.builder()
                .name("Shadab Ansari")
                .gender("male")
                .email(email)
                .status("active")
                .build();
        //Act
        CreateUserResponse createUserResponse = new UsersClient().createUser(requestBody);
        //Assert
        createUserResponse.assertUser(requestBody);




    }


    @Test
    public void shouldCreateFemaleUser()
    {
        //Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());

        CreateUserRequestBody requestBody =  CreateUserRequestBody.builder()
                .name("Aditi Rao")
                .gender("female")
                .email(email)
                .status("active")
                .build();
        //Act
        CreateUserResponse createUserResponse = new UsersClient().createUser(requestBody);

        //Assert
        createUserResponse.assertUser(requestBody);

    }





}
