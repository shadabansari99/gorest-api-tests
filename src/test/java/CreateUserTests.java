import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

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

        String body = String.format("{\"name\":\"Shadab Ansari\",\n" +
                " \"gender\":\"male\",\n" +
                "  \"email\":\"%s\",\n" +
                "   \"status\":\"active\"}",email);
        //Act
        new UsersClient().createUser(body)
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

        String body = String.format("{\"name\":\"Aditi Rao\",\n" +
                " \"gender\":\"female\",\n" +
                "  \"email\":\"%s\",\n" +
                "   \"status\":\"active\"}",email);
        //Act
        new UsersClient().createUser(body)
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
