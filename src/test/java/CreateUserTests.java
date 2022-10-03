import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;

import static io.restassured.RestAssured.given;

public class CreateUserTests {
    @Test
    public void shouldCreateMaleUser()
    {
        //Arrange
        String body = "{\"name\":\"Shadab Ansari\",\n" +
                " \"gender\":\"male\",\n" +
                "  \"email\":\"shadabzt15t12@gmail.com\",\n" +
                "   \"status\":\"active\"}";
        //Act
        new UsersClient().createUser(body)
                .then()
                .log().body()
        //Assert
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo("shadabzt15t12@gmail.com"))
                .body("name",Matchers.equalTo("Shadab Ansari"))
        ;
    }


    @Test
    public void shouldCreateFemaleUser()
    {
        //Arrange
        String body = "{\"name\":\"Aditi Rao\",\n" +
                " \"gender\":\"female\",\n" +
                "  \"email\":\"aditirao1t5412@gmail.com\",\n" +
                "   \"status\":\"active\"}";
        //Act
        new UsersClient().createUser(body)
                .then()
                .log().body()
        //Assert
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo("aditirao1t5412@gmail.com"))
                .body("name",Matchers.equalTo("Aditi Rao"))
        ;
    }





}
