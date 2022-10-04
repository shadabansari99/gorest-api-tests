package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;
import users.create.response.CreateUserResponse;
import users.get.GetUserResponse;
import users.getAll.GetAllUsersResponse;

import static io.restassured.RestAssured.given;

public class UsersClient {
    public CreateUserResponse createUser(CreateUserRequestBody body) {

              Response response =   create(body);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.statusCode());
        return createUserResponse;
    }
    public CreateUserErrorResponse createUserExpectingError (CreateUserRequestBody body){
        Response response = create(body);
        CreateUserErrorResponse errorResponse = response.as(CreateUserErrorResponse.class);
        errorResponse.setStatuscode(response.statusCode());
        return errorResponse;
    }


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

    public GetAllUsersResponse getAllUsers() {
        Response response = given()
                .when()
                .get("https://gorest.co.in/public/v1/users");
        response.then()
                .log()
                .body();
        int statusCode = response.statusCode();
        GetAllUsersResponse getAllUsersResponse = response.as(GetAllUsersResponse.class);
       getAllUsersResponse.setStatusCode(statusCode);
        return getAllUsersResponse;
    }
public GetUserResponse getUser(int id)
{
    Response response = given()
            .pathParam("id", id)
            .header("Authorization", "Bearer 7cdd64aabb300d0ca6a50051902eb68272e854a594eb5dd472fd70bb59377b20")
            .when()
            .get("https://gorest.co.in/public/v1/users/{id}");
    response.then().log().body();
        int statusCode = response.statusCode();
    GetUserResponse getUserResponse = response.as(GetUserResponse.class);
    getUserResponse.setStatusCode(statusCode);
    return getUserResponse;
}
}
