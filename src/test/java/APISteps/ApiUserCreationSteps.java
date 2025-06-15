package APISteps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ApiUserCreationSteps {

    private static final String BASE_URL = "http://hrm.syntaxtechs.net/syntaxapi/api/createUser.php";
    private RequestSpecification req;
    private Response response;

    @Given("a request is prepared to make a POST call for creation of an Employee")
    public void a_request_is_prepared_to_make_a_post_call_for_creation_of_an_employee() throws InterruptedException {
        req = given()
                .header("Content-Type", "application/json");
        Thread.sleep(1000);
    }

    @Given("the user provides name {string} email {string} password {string}")
    public void the_user_provides_name_email_password(String name, String email, String password) throws InterruptedException {
        req.body("{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"password\": \"" + password + "\"\n" +
                "}");

        Thread.sleep(1000);

    }

    @When("the user sends a POST request to create User")
    public void the_user_sends_a_post_request_to_create_user() {
        response = req.when().post("http://hrm.syntaxtechs.net/syntaxapi/api/createUser.php");
        // Print the response body for debugging purposes
        System.out.println(response.getBody().asString());
    }

    @Then("the status code is {int} for this call")
    public void the_status_code_is_for_this_call(Integer statusCode) throws InterruptedException {
        response.then().assertThat().statusCode(statusCode);

    }

    @Then("the response body should contain message {string}")
    public void the_response_body_should_contain_message(String expectedMessage) {
        response.then().assertThat().body("Message", equalTo(expectedMessage));
    }

    @When("the user attempts to register with an already registered email:")
    public void the_user_attempts_to_register_with_an_already_registered_email(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        if (req == null) {
            req = given().header("Content-Type", "application/json");
        }
        String body = "{\n" +
                "  \"name\": \"Peter Parker\",\n" +
                "  \"email\": \"peter.parker@example.com\",\n" +
                "  \"password\": \"PassPass123\"\n" +
                "}";
        req.body(body);
        response = req.post(BASE_URL);

    }

    @Then("the API response status should be {int}")
    public void the_api_response_status_should_be(Integer statusCode) {
        assertEquals(statusCode.intValue(), response.getStatusCode(), "Status code did not match");
    }

    @Then("the response should contain message {string}")
    public void the_response_should_contain_message(String message) {
        String actualMessage = response.jsonPath().getString("Message");
        assertEquals(message, actualMessage, "Message content did not match");
    }

    @When("the user attempts to register with an invalid email format:")
    public void the_user_attempts_to_register_with_an_invalid_email_format(io.cucumber.datatable.DataTable dataTable) {
        if (req == null) {
            req = given().header("Content-Type", "application/json");
        }
        String body = "{\n" +
                "  \"name\": \"Peter Parker\",\n" +
                "  \"email\": \"invalidEmail\",\n" +
                "  \"password\": \"PassPass123\"\n" +
                "}";
        req.body(body);
        response = req.post(BASE_URL);
    }

    @Then("the API response should contain:")
    public void the_api_response_should_contain(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> entries = dataTable.asMaps();
        Map<String,String> actualData = response.jsonPath().get();
        for (Map<String, String> row : entries) {
            Set<String> keys = row.keySet();
            for (String key : keys) {
                String expectedValue = row.get(key);
                String actualValue = actualData.get(key);
               // System.out.println(expectedValue);
               // System.out.println(actualValue);
                assertEquals(expectedValue, actualValue, "Response mismatch for key: " + key);
            }
        }
    }

    @When("the user attempts to register without a password:")
    public void the_user_attempts_to_register_without_a_password(io.cucumber.datatable.DataTable dataTable) {
        if (req == null) {
            req = given().header("Content-Type", "application/json");
        }
        String body = "{\n" +
                "  \"name\": \"Peter Parker\",\n" +
                "  \"email\": \"peter.parker@example.com\",\n" +
                "  \"password\": \"\"\n" +
                "}";
        req.body(body);
        response = req.post(BASE_URL);
    }

    @When("the user attempts to register without a name:")
    public void the_user_attempts_to_register_without_a_name(io.cucumber.datatable.DataTable dataTable) {
        if (req == null) {
            req = given().header("Content-Type", "application/json");
        }
        String body = "{\n" +
                "  \"name\": \"\",\n" +
                "  \"email\": \"peter.parker@example.com\",\n" +
                "  \"password\": \"PassPass123\"\n" +
                "}";
        req.body(body);
        response = req.post(BASE_URL);
    }

    @Then("the API response should contain error message {string}")
    public void the_api_response_should_contain_error_message(String errorMessage) {
        String actualMessage = response.jsonPath().getString("message");
        assertEquals(errorMessage, actualMessage, "Error message mismatch");
    }
}