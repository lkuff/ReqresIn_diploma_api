package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static specs.LoginSpecs.deleteUserSpec;
import static specs.LoginSpecs.requestSpec;

public class DeleteUserTest {
    @DisplayName("Delete user")
    @Test
    public void checkUserNotFound() {
        given(requestSpec)
                .when()
                .delete("/users/2")
                .then()
                .spec(deleteUserSpec);
    }
}
