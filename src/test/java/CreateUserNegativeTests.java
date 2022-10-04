import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;

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

        CreateUserRequestBody requestBody =  CreateUserRequestBody.builder()
                .name("Aditi Rao")
                .gender("female")
                .email("aditirao121gmail.com")
                .status("active")
                .build();
        //Act
        userClient.createUser(requestBody)
                .then()
                .log().body()
                //Assert
                .statusCode(422)
                .body("", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }
}
