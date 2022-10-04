import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class CreateUserTests {

    private UsersClient userClient;

    @BeforeClass
    public void beforeClass()
    {
        userClient = new UsersClient();
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
        new UsersClient().createUser(requestBody)
                .then()
                .log().body()
        //Assert
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo(email))
                .body("name",Matchers.equalTo("Shadab Ansari"))
        ;
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
        new UsersClient().createUser(requestBody)
                .then()
                .log().body()
        //Assert
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo(email))
                .body("name",Matchers.equalTo("Aditi Rao"))
        ;
    }





}
