import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import users.UsersClient;
import users.getAll.GetAllUsersResponse;

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
        GetAllUsersResponse getAllUsersResponse = usersClient.getAllUsers();

        //Assert
                Assert.assertEquals(getAllUsersResponse.getStatusCode(),200);
                Assert.assertEquals(getAllUsersResponse.getDataList().size(),10);
                Assert.assertTrue(getAllUsersResponse.hasMaleUser());
    }




}
