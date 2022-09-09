package StepDefinations;

import Core.ApiCall;
import Core.CoreConstrains;
import Core.FileServices;
import Core.HeaderFormat;
import com.google.gson.Gson;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import repository.remoteRepo.requestRepo.CreateVARequestClass;
import repository.remoteRepo.responseRepo.CreateVAResponseClass;

import java.io.FileReader;

import static Core.FilePath.*;

public class CreateVASteps extends CoreConstrains {
    private Response responseCreateVA;
    private Scenario scenario;
    CreateVARequestClass createVARequestClass;
    private String url ="";
    private String requestModel;
    private Gson gson = new Gson();
    @Given("create virtual account post api {string}")
    public void create_virtual_account_post_api(String path) {
        url = base_url+path;
    }

    @And("as request body provided {string} {string} {string}")
    public void as_request_body_provided(String external_id,String bank_code,String name) {
        JSONObject requestBody = new FileServices().readJsonFile(createVAFilepath);
        createVARequestClass = new Gson().fromJson(requestBody.toJSONString(),CreateVARequestClass.class);
        createVARequestClass.setExternal_id(external_id);
        createVARequestClass.setBank_code(bank_code);
        createVARequestClass.setName(name);
        requestModel = gson.toJson(createVARequestClass);

    }

    @When("user  calls post api with body")
    public void user_calls_post_api_with_body() {
        responseCreateVA = ApiCall.postCall(HeaderFormat.commonHeaders(),requestModel,url);
        System.out.println(responseCreateVA.body().asString());


    }

    @Then("create a virtual account successfully")
    public void create_virtual_account_post_api() {
        System.out.println("test");
        if(responseCreateVA.statusCode()==200) {
           FileServices file = new FileServices();
            boolean is_closed = false;
            file.clearFile(idReaderPath);
            file.clearFile(externalIdFilepath);
            CreateVAResponseClass createVAResponseClass = gson.fromJson(responseCreateVA.getBody().asString(), CreateVAResponseClass.class);
            Assert.assertEquals(createVAResponseClass.getExternal_id(), createVARequestClass.getExternal_id());
            Assert.assertEquals(createVAResponseClass.getBank_code(), createVARequestClass.getBank_code());
            Assert.assertEquals(createVAResponseClass.getName(), createVARequestClass.getName());
            Assert.assertEquals(createVAResponseClass.getStatus(), "PENDING");
            Assert.assertEquals(createVAResponseClass.isIs_closed(), is_closed);
            file.writeFile(idReaderPath,createVAResponseClass.getId());
            file.writeFile(externalIdFilepath,createVAResponseClass.getExternal_id());
        }
        if (responseCreateVA.statusCode()==404){
            System.out.println("Issue with api path");
        }
        else {
            System.out.println(responseCreateVA.body().asString());
        }

    }


    @Then("can not create a virtual account successfully")
    public void can_not_create_a_virtual_account_successfully() {
        if(responseCreateVA.statusCode()==400){
            CreateVAResponseClass createVAResponseClass = gson.fromJson(responseCreateVA.getBody().asString(), CreateVAResponseClass.class);
            Assert.assertEquals(createVAResponseClass.getError_code(), "API_VALIDATION_ERROR");
        }
        if(responseCreateVA.statusCode()==500){
          System.out.println("server error");
        }

    }
}
