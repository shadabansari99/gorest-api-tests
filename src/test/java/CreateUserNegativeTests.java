import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

public class CreateUserNegativeTests {
    private UsersClient userClient;
    @BeforeClass
    public void beforeClass()
    {
        userClient = new UsersClient();
    }

    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail()
    {
        //Arrange
        String body ="{\"name\":\"Aditi Rao\",\n" +
                " \"gender\":\"female\",\n" +
                "  \"email\":\"aditirao121gmail.com\",\n" +
                "   \"status\":\"active\"}";
        //Act
        userClient.createUser(body)
                .then()
                .log().body()
                //Assert
                .statusCode(422)
                .body("", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }
}
