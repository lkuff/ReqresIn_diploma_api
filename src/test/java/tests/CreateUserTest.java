package tests;

import models.createUser.CreateUserBody;
import models.createUser.CreateUserResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.LoginSpecs.createUserResponseSpec;
import static specs.LoginSpecs.requestSpec;

public class CreateUserTest {

    @Test
    public void checkCreateUser() {

        CreateUserBody data = new CreateUserBody();
        data.setName("chamomile");
        data.setJob("qa");

        CreateUserResponse response = given(requestSpec)
                .body(data)
                .when()
                .post("/users")
                .then()
                .spec(createUserResponseSpec)
                .extract().as(CreateUserResponse.class);
        assertThat(response.getName()).isEqualTo("chamomile");
        assertThat(response.getJob()).isEqualTo("qa");
    }
}
