package com.githubTaskProject.step_defs;

import com.githubTaskProject.utils.Environment;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Api_Test_Step_Defnitions {

    Response createResponse;

    Response getResponse;

    Response deleteResponse;
    String organization = Environment.ORG_NAME;

    String owner = Environment.ORG_NAME;

    String token = Environment.TOKEN;

    String nameOfNewRepo = "NewRepo";

    String description = "A New Repo Created With API Post Request";




    //api base url is for every snippet in this class
    @Before
    public void setupBaseURL() {
        RestAssured.baseURI = Environment.API_BASE_URL;
    }


    //Scenario 1 : Create
    @When("Send a Post HTTP request for creating a new repository in a GitHub Organization")
    public void send_a_post_http_request_for_creating_a_new_repository_in_a_git_hub_organization() {

        //For be able to give a name and description to the created Repository,
        //We are adding them as a request body in Json format
        String body = "{\n" +
                "  \"name\": \"" + nameOfNewRepo + "\",\n" +
                "  \"description\": \"" + description + "\",\n" +
                "  \"homepage\": \"https://github.com\",\n" +
                "  \"private\": false,\n" +
                "  \"has_issues\": false,\n" +
                "  \"has_projects\": false,\n" +
                "  \"has_wiki\": false\n" +
                "}";


        //Request of the post method, we store that response in a response class object.
        createResponse =
                given().accept("application/json")
                        .contentType(ContentType.JSON)
                        .header("Authorization", token)             //Authorization
                        .pathParam("ORG", organization)             //we pass the organization name as a path parameter
                        .body(body)                                    //we added the body
                        .log().all()                                   //For screening whole request
                        .when()                                        //syntactic sugar
                        .post("orgs/{ORG}/repos")           //https request and endPoint
                        .then()
//                      .statusCode(200)
                        .log().all()                            //For screening whole response
                        .extract().response();                  //we use the extract method for be able to store the response in a response object after use 'then part'


    }

    @Then("Verify the status code is {int} for creating a repo")
    public void verify_the_status_code_is_for_creating_a_repo(int expectedStatusCode) {
        int actualStatusCode = createResponse.statusCode();

        //Asserted the status code if it is 201
        assertThat(actualStatusCode, is(expectedStatusCode));

    }

    @Then("Verify the response body for creating a repo")
    public void verify_the_response_body_for_creating_a_repo() {
        JsonPath jsonPath = createResponse.jsonPath();

        //Check if the new repo's name is correct
        assertThat(jsonPath.getString("name"), is(nameOfNewRepo));

        //check if the organization's name is correct
        assertThat(jsonPath.getString("organization.login"), is(organization));

        //check if the description is correct
        assertThat(jsonPath.getString("description"), is(description));


    }

    @Then("verify the headers for creating a repo")
    public void verify_the_headers_for_creating_a_repo() {

        //check if the content-Type is json
        assertThat(createResponse.getHeader("Content-Type"), is("application/json; charset=utf-8"));

        //Validating a random header
        assertThat(createResponse.getHeader("Server"), is("GitHub.com"));


    }





}