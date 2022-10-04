package users.get;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;
import users.create.CreateUserRequestBody;

import static org.testng.Assert.*;

@Getter
public class GetUserResponse {
    @Setter
    private int statusCode;
    private Data data;

    private String meta;

    public void assertUser(CreateUserRequestBody requestBody) {
        assertEquals(data.email,requestBody.getEmail());
        assertEquals(data.gender,requestBody.getGender());
        assertEquals(data.name,requestBody.getName());
        assertEquals(data.status,requestBody.getStatus());

    }

    @Getter
    public static class Data {
        private String gender;
        private String name;
        private String id;
        private String email;
        private String status;
    }
    }
