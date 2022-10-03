import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;

public class CreateUserNegativeTests {
    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail()
    {
        //Arrange
        String body ="{\"name\":\"Aditi Rao\",\n" +
                " \"gender\":\"female\",\n" +
                "  \"email\":\"aditirao121gmail.com\",\n" +
                "   \"status\":\"active\"}";
        //Act
        new UsersClient().createUser(body)
                .then()
                .log().body()
                //Assert
                .statusCode(422)
                .body("", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }
}
