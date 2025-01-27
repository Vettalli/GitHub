package APITests;

import Core.UserData;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class ApiTest {

    private static final int CODE_SUCCESS = 200;
    private static final int CODE_ERROR_UNAUTHORISED = 401;

    @Test(description = "Auth test with valid token")
    public void authToGitHubValidToken() {
        int statusCode = RestAssured.given()
                .auth()
                .oauth2(UserData.LOGIN_TOKEN)
                .get("https://api.github.com").statusCode();

        Assert.assertEquals(statusCode, CODE_SUCCESS, "Wrong code! Expected code 200");
    }

    @Test(description = "Auth test with invalid token")
    public void authToGitHubInvalidToken() {
        int statusCode = RestAssured.given()
                .auth()
                .oauth2("egb")
                .get("https://api.github.com").statusCode();

        Assert.assertEquals(statusCode, CODE_ERROR_UNAUTHORISED, "Wrong code! Expected code 401");
    }

    @Test(description = "Auth test with empty token")
    public void authToGitHubEmptyToken() {
        int statusCode = RestAssured.given()
                .auth()
                .oauth2("")
                .get("https://api.github.com").statusCode();

        Assert.assertEquals(statusCode, CODE_ERROR_UNAUTHORISED, "Wrong code! Expected code 401");
    }
}
