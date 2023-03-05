package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static specs.LoginSpecs.notFoundUserSpec;
import static specs.LoginSpecs.requestSpec;

public class NotFoundUserTest {
    @DisplayName("Search user and not found his")
    @Test
    public void checkUserNotFound() {
        given(requestSpec)
                .when()
                .get("/users/23")
                .then()
                .spec(notFoundUserSpec);
    }
}
