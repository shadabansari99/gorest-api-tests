package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.create.CreateUserRequestBody;

import static io.restassured.RestAssured.given;

public class UsersClient {

    public Response create(CreateUserRequestBody body) {
        Response response = given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                     .header("Authorization", "Bearer 7cdd64aabb300d0ca6a50051902eb68272e854a594eb5dd472fd70bb59377b20")
                     .body(body)
                .when()
                     .post("https://gorest.co.in/public/v1/users");


        response.then().log().body();
        return response;
    }


    public static Response getAll() {
        Response response = given()
                .when()
                .get("https://gorest.co.in/public/v1/users");
        response.then()
                .log()
                .body();
        return response;
    }


    public Response get(int id) {
        Response response = given()
                .pathParam("id", id)
                .header("Authorization", "Bearer 7cdd64aabb300d0ca6a50051902eb68272e854a594eb5dd472fd70bb59377b20")
                .when()
                .get("https://gorest.co.in/public/v1/users/{id}");
        response.then().log().body();
        return response;
    }
}
