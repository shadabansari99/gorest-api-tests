import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.UsersService;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserResponse;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class CreateUserTests {

    private UsersService usersService;

    @BeforeClass
    public void beforeClass()
    {
        usersService = new UsersService();
    }

    @Test
    public void shouldCreateMaleUser()
    {
        //Arrange
//        String email = String.format("%s@gmail.com", UUID.randomUUID());
//
//        //CreateUserRequestBody requestBody = new CreateUserRequestBody(name,gender,email,status);
//        CreateUserRequestBody requestBody =  CreateUserRequestBody.builder()
//                .name("Shadab Ansari")
//                .gender("male")
//                .email(email)
//                .status("active")
//                .build();

        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().gender("male").build();

        //Act
        CreateUserResponse createUserResponse = new UsersService().createUser(requestBody);
        //Assert
        createUserResponse.assertUser(requestBody);




    }


    @Test
    public void shouldCreateFemaleUser()
    {
        //Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().gender("female").build();
        //Act
        CreateUserResponse createUserResponse = new UsersService().createUser(requestBody);

        //Assert
        createUserResponse.assertUser(requestBody);

    }





}
