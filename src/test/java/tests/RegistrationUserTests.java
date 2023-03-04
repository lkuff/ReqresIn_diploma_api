package tests;

import models.registrationUser.RegistrationUserBody;
import models.registrationUser.RegistrationUserResponse;
import models.registrationUser.UnsuccessfulRegistrationBody;
import models.registrationUser.UnsuccessfulRegistrationUserResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.LoginSpecs.*;

public class RegistrationUserTests {

    @Test
    public void checkRegisterUser() {

        RegistrationUserBody data = new RegistrationUserBody();
        data.setEmail("eve.holt@reqres.in");
        data.setPassword("pistol");

        RegistrationUserResponse response = given(requestSpec)
                .body(data)
                .when()
                .post("/register")
                .then()
                .spec(registrationResponseSpec)
                .extract().as(RegistrationUserResponse.class);
        assertThat(response.getId()).isEqualTo("4");
        assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }

    @Test
    public void checkUnsuccessfulRegisterUser() {

        UnsuccessfulRegistrationBody data = new UnsuccessfulRegistrationBody();
        data.setEmail("eve.holt@reqres.i");
        data.setPassword("pistol");

        UnsuccessfulRegistrationUserResponse response = given(requestSpec)
                .body(data)
                .when()
                .post("/register")
                .then()
                .spec(unsuccessfulRegistrationResponseSpec)
                .extract().as(UnsuccessfulRegistrationUserResponse.class);
        assertThat(response.getError()).isEqualTo("Note: Only defined users succeed registration");
    }
}
