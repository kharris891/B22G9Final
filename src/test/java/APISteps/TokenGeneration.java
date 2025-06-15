package APISteps;

import io.restassured.RestAssured;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import utils.APIConstants;
import utils.CommonMethods;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TokenGeneration extends CommonMethods {
    public static String token;
    RequestSpecification req;
    Response resp;

    @When("a JWT token is generated with a response that contains the key \"token\" with a valid token value")
    public void a_JWT_token_is_generated_with_a_response_that_contains_the_key_token_with_a_valid_token_value() {
        req = given()
                .baseUri(baseURI)
                .header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.HEADER_CONTENT_TYPE_VALUE)
                .body("{\n" +
                        "\"email\": \"peter.parker@example.com\",\n" + // Replace with a valid email generated in API User Story 1
                        "\"password\": \"PassPass123\"\n" + // Replace with a valid password generated in API User Story 1
                        "}");
        resp = req.when().post(APIConstants.GENERATE_TOKEN_URI);
        resp.prettyPrint();
        token = "Bearer " + resp.jsonPath().getString("token");
    }

    @Given("a POST call is made to generate the API token with an invalid email format")
    public void a_post_call_is_made_to_generate_the_api_token_with_an_invalid_email_format() {

        resp = given()
                .header(APIConstants.HEADER_CONTENT_TYPE_KEY, APIConstants.HEADER_CONTENT_TYPE_VALUE)
                .body("{\n" +
                        "\"email\": \"invalidEmail\",\n" + // Invalid email
                        "\"password\": \"Pass123\"\n" + // Replace with a valid password generated in API User Story 1
                        "}")
                .when()
                .post(APIConstants.GENERATE_TOKEN_URI);
    }

    @Then("the response contains the key {string} with a message indicating invalid email format")
    public void the_response_contains_the_key_with_a_message_indicating_invalid_email_format(String string) {
        JsonPath jsonPath = new JsonPath(resp.getBody().asString());

        // Check the key exists
        String key = "Error";
        Assert.assertTrue(jsonPath.get(key) != null, "Key '" + key + "' was not found in the response!");

        String errorMessage = jsonPath.getString(key).toLowerCase();

        Assert.assertTrue(
                errorMessage.contains("email format") || errorMessage.contains("invalid email"),
                "Error: Email or Password is incorrect. " + errorMessage
        );
    }

    @Given("a POST call is made to generate the API token with an incorrect email or password combination")
    public void a_post_call_is_made_to_generate_the_api_token_with_an_incorrect_email_or_password_combination() {
        RestAssured.baseURI = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/api";

        String payload = "{ \"email\": \"wrong@email.com\", \"password\": \"incorrectPass\" }";

        resp = given()
                .header(APIConstants.HEADER_CONTENT_TYPE_KEY, APIConstants.HEADER_CONTENT_TYPE_VALUE)
                .body(payload)
                .when()
                .post(APIConstants.GENERATE_TOKEN_URI);
    }

    @Then("the response contains the key {string} with a message indicating invalid credentials")
    public void the_response_contains_the_key_with_a_message_indicating_invalid_credentials(String string) {

        String key = "Error";
        String errorMessage = resp.jsonPath().getString(key);

        Assert.assertNotNull(errorMessage, "Expected key not found: " + key);

        Assert.assertTrue(
                errorMessage.toLowerCase().contains("incorrect") ||
                        errorMessage.toLowerCase().contains("invalid"),
                "Error\": \"Email or Password is incorrect. " + errorMessage);
    }

    @Given("a POST call is made to generate the API token with missing required fields")
    public void a_post_call_is_made_to_generate_the_api_token_with_missing_required_fields() {
        String requestBody = "{ \"email\": \"peter.parker92@example.com\" }"; //Replace with a valid email generated in API User Story 1

        resp = given()
                .header(APIConstants.HEADER_CONTENT_TYPE_KEY, APIConstants.HEADER_CONTENT_TYPE_VALUE)
                .body(requestBody)
                .when()
                .post(APIConstants.GENERATE_TOKEN_URI);
    }

    @Then("the response contains the key {string} with a message indicating missing required fields")
    public void the_response_contains_the_key_with_a_message_indicating_missing_required_fields(String string) {
        String key = "Error";
        String expectedErrorMessage = "Please fill all inputs";
        String actualMessage = resp.jsonPath().getString(key);
        Assert.assertEquals(actualMessage, expectedErrorMessage, "Error: Please fill all inputs");
    }

}
