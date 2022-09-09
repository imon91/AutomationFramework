package StepDefinations;

import Core.ApiCall;
import Core.FileServices;
import Core.HeaderFormat;
import com.google.gson.Gson;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;
import repository.remoteRepo.requestRepo.CreateVARequestClass;
import repository.remoteRepo.requestRepo.UpdateDateRequestClass;
import repository.remoteRepo.responseRepo.CreateVAResponseClass;
import repository.remoteRepo.responseRepo.UpdateDateResponseClass;

import static Core.CoreConstrains.base_url;
import static Core.FilePath.*;

public class UpdateDateSteps {

    private Response responseUpdateDate;
    private Scenario scenario;
    CreateVARequestClass createVARequestClass;
    UpdateDateRequestClass updateDateRequestClass;
    UpdateDateResponseClass updateDateResponseClass;
    private String url ="";
    private String requestModel;
    private Gson gson = new Gson();
    @Given("update date api patch {string}")
    public void updateDateApiPatchPath(String path) {
        url = base_url+path;
        FileServices file = new FileServices();
        String id =file.readFile(idReaderPath);
        url = url+id;
    }

    @And("as a body provided update date {string}")
    public void asABodyProvidedUpdateDateDate(String date) {

        JSONObject requestBody = new FileServices().readJsonFile(updateDateFilepath);
        updateDateRequestClass = new Gson().fromJson(requestBody.toJSONString(),UpdateDateRequestClass.class);
        updateDateRequestClass.setExpiration_date(date);
        requestModel = gson.toJson(updateDateRequestClass);
    }

    @When("user  calls patch api with body")
    public void userCallsPatchApiWithBody() {
        responseUpdateDate =  ApiCall.patchCall(HeaderFormat.commonHeaders(),requestModel,url);
        System.out.println(responseUpdateDate.body().asString());

    }

    @Then("date update sucessfully")
    public void dateUpdateSucessfully() {
        if(responseUpdateDate.statusCode()==200) {
            FileServices file = new FileServices();
            file.clearFile(updateDateReaderFilepath);
            UpdateDateResponseClass updateDateResponseClass = gson.fromJson(responseUpdateDate.getBody().asString(), UpdateDateResponseClass.class);
            Assert.assertEquals(updateDateResponseClass.getStatus(), "PENDING");
            file.writeFile(updateDateReaderFilepath,updateDateResponseClass.getExpiration_date());

        }

    }


    @Then("response would be validation error")
    public void responseWouldBeValidationError() {
        if(responseUpdateDate.statusCode()==400){
            UpdateDateResponseClass updateDateResponseClass = gson.fromJson(responseUpdateDate.getBody().asString(),  UpdateDateResponseClass.class);
            Assert.assertEquals(updateDateResponseClass.getError_code(), "API_VALIDATION_ERROR");
        }
        if(responseUpdateDate.statusCode()==500){
            System.out.println("server error");
        }
    }

}
