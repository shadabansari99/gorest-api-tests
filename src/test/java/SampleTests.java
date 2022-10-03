import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class SampleTests {
    @Test
    public void shouldGetAllUsers()
    {
        //Arrange
        //Act
        //Assert
        given()
            .when()
                .get("https://gorest.co.in/public/v2/users")
            .then()
                .statusCode(200)
                .body("", Matchers.hasSize(10))
                .body("",Matchers.hasItem(Matchers.hasEntry("gender","female")))
                .log().body();
    }
    @Test
    public void shouldCreateUser()
    {
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer 7cdd64aabb300d0ca6a50051902eb68272e854a594eb5dd472fd70bb59377b20")
                .body("{\"name\":\"Tenali Ramakrishna\",\n" +
                        " \"gender\":\"male\",\n" +
                        "  \"email\":\"tenali.ramakrishna@1h1j.com\",\n" +
                        "   \"status\":\"active\"}")
                .when()
                .post("https://gorest.co.in/public/v2/users")
                .then()
                .log().body()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo("tenali.ramakrishna@1h1j.com"))
                ;
    }

}
