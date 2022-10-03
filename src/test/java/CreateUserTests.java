import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTests {
    @Test
    public void shouldCreateMaleUser()
    {
        //Arrange
        String body = "{\"name\":\"Shadab Ansari\",\n" +
                " \"gender\":\"male\",\n" +
                "  \"email\":\"shadabzt151@gmail.com\",\n" +
                "   \"status\":\"active\"}";
        //Act
        createUser(body)
                .then()
                .log().body()
        //Assert
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo("shadabzt151@gmail.com"))
                .body("name",Matchers.equalTo("Shadab Ansari"))
        ;
    }


    @Test
    public void shouldCreateFemaleUser()
    {
        //Arrange
        String body = "{\"name\":\"Aditi Rao\",\n" +
                " \"gender\":\"female\",\n" +
                "  \"email\":\"aditirao1t51@gmail.com\",\n" +
                "   \"status\":\"active\"}";
        //Act
        createUser(body)
                .then()
                .log().body()
        //Assert
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo("aditirao1t51@gmail.com"))
                .body("name",Matchers.equalTo("Aditi Rao"))
        ;
    }
    private static Response createUser(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 7cdd64aabb300d0ca6a50051902eb68272e854a594eb5dd472fd70bb59377b20")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v2/users");
    }

}
