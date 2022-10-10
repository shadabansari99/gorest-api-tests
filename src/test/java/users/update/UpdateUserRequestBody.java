package users.update;

import lombok.Getter;
import users.create.CreateUserRequestBody;

import java.util.UUID;

@Getter
public class UpdateUserRequestBody {

    private String name;
    private String gender;
    private String email;
    private String status;

    public UpdateUserRequestBody(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.gender = builder.gender;
        this.status = builder.status;
    }

    public static class Builder {
        private String name;
        private String gender;
        private String email;
        private String status;

        public Builder() {
            this.name = "Created-Default";
            this.email = String.format("%s@gmail.com", UUID.randomUUID());
            this.gender = "male";
            this.status = "active";
        }

        public Builder gender(String gender) {

            this.gender = gender;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public UpdateUserRequestBody build() {
            UpdateUserRequestBody updateUserRequestBody = new UpdateUserRequestBody(this);
            return updateUserRequestBody;
        }
    }
}
