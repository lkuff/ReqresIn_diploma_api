package tests;

import models.loginUser.LoginUserBody;
import models.loginUser.LoginUserResponse;
import models.loginUser.UnsuccessfulLoginUserBody;
import models.loginUser.UnsuccessfulLoginUserResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.LoginSpecs.*;

public class LoginUserTests {

    @Test
    public void checkLoginUser() {

        LoginUserBody data = new LoginUserBody();
        data.setEmail("eve.holt@reqres.in");
        data.setPassword("cityslicka");


        LoginUserResponse response = given(requestSpec)
                .body(data)
                .when()
                .post("/login")
                .then()
                .spec(loginResponseSpec)
                .extract().as(LoginUserResponse.class);
        assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }

    @Test
    public void checkUnsuccessfulLoginUser() {

        UnsuccessfulLoginUserBody data = new UnsuccessfulLoginUserBody();
        data.setEmail("eve.holt@reqres.i");
        data.setPassword("cityslicka");

        UnsuccessfulLoginUserResponse response = given(requestSpec)
                .body(data)
                .when()
                .post("/login")
                .then()
                .spec(unsuccessfulLoginResponseSpec)
                .extract().as(UnsuccessfulLoginUserResponse.class);
        assertThat(response.getError()).isEqualTo("user not found");
    }
}

