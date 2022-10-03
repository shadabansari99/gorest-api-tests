package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersClient {
    public static Response createUser(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 7cdd64aabb300d0ca6a50051902eb68272e854a594eb5dd472fd70bb59377b20")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v2/users");
    }
}