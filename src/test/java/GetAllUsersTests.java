import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import users.UsersClient;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class GetAllUsersTests {

    //Arrange
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass()
    {
        usersClient = new UsersClient();
    }

    @Test
    public void shouldGetAllUsers()
    {
        //Act
        usersClient
                .getAllUsers()
                    .then()
         //Assert
                     .statusCode(200)
                     .body("", Matchers.hasSize(10))
                     .body("",Matchers.hasItem(Matchers.hasEntry("gender","female")))
                     .log().body();
    }




}
