package users.update.response;


import lombok.Getter;
import lombok.Setter;
import users.update.UpdateUserRequestBody;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Getter
public class UpdateUserResponse{

	@Setter
	private int statusCode;

	private String gender;
	private String name;
	private int id;
	private String email;
	private String status;

	public void assertUser(UpdateUserRequestBody updateUserRequestBody) {
			assertEquals(this.getStatusCode(),200);
			assertNotNull(this.getId());
			assertEquals(this.getEmail(),updateUserRequestBody.getEmail());
			assertEquals(this.getName(),updateUserRequestBody.getName());
			assertEquals(this.getGender(),updateUserRequestBody.getGender());
			assertEquals(this.getStatus(),updateUserRequestBody.getStatus());
	}
}