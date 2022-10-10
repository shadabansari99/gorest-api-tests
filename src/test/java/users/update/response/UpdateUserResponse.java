package users.update.response;


import lombok.Getter;
import lombok.Setter;
import users.create.response.CreateUserResponse;
import users.update.UpdateUserRequestBody;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Getter
public class UpdateUserResponse{

	@Setter
	private int statusCode;
	private String meta;
	private Data data;


	public void assertUser(UpdateUserRequestBody updateUserRequestBody) {
			assertEquals(this.getStatusCode(),200);
			assertNotNull(this.getData().getId());
			assertEquals(this.getData().getEmail(),updateUserRequestBody.getEmail());
			assertEquals(this.getData().getName(),updateUserRequestBody.getName());
			assertEquals(this.getData().getGender(),updateUserRequestBody.getGender());
			assertEquals(this.getData().getStatus(),updateUserRequestBody.getStatus());
	}
	@Getter
	public class Data {
		private int id;
		private String name;
		private String gender;
		private String email;
		private String status;
	}
}