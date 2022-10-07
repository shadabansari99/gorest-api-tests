package users;

import io.restassured.response.Response;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;
import users.create.response.CreateUserResponse;
import users.get.GetUserErrorResponse;
import users.get.GetUserResponse;
import users.getAll.GetAllUsersResponse;

public class UsersService {
    public CreateUserResponse createUser(CreateUserRequestBody body) {

        Response response =   new UsersClient().create(body);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.statusCode());
        return createUserResponse;
    }
    public CreateUserErrorResponse createUserExpectingError (CreateUserRequestBody body){
        Response response = new UsersClient().create(body);
        CreateUserErrorResponse errorResponse = response.as(CreateUserErrorResponse.class);
        errorResponse.setStatuscode(response.statusCode());
        return errorResponse;
    }
    public GetUserResponse getUser(int id) {
        Response response = new UsersClient().get(id);
        int statusCode = response.statusCode();
        GetUserResponse getUserResponse = response.as(GetUserResponse.class);
        getUserResponse.setStatusCode(statusCode);
        return getUserResponse;
    }
    public GetAllUsersResponse getAllUsers() {
        Response response = new UsersClient().getAll();

        int statusCode = response.statusCode();
        GetAllUsersResponse getAllUsersResponse = response.as(GetAllUsersResponse.class);
        getAllUsersResponse.setStatusCode(statusCode);
        return getAllUsersResponse;
    }
    public int deleteUser(int id) {
        Response response = new UsersClient().delete(id);
       return response.statusCode();
    }
    public GetUserErrorResponse getUserExpectingError(int id) {
        Response response = new UsersClient().get(id);

        int statusCode = response.statusCode();

        GetUserErrorResponse getUserErrorResponse = response.as(GetUserErrorResponse.class);
        getUserErrorResponse.setStatusCode(statusCode);
        return getUserErrorResponse;
    }
}
