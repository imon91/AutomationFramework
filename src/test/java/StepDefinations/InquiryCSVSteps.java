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
import org.junit.Assert;
import repository.remoteRepo.requestRepo.CreateVARequestClass;
import repository.remoteRepo.responseRepo.CreateVAResponseClass;
import repository.remoteRepo.responseRepo.InquiryCVAResponseClass;

import static Core.CoreConstrains.base_url;
import static Core.FilePath.idReaderPath;
import static Core.FilePath.updateDateReaderFilepath;

public class InquiryCSVSteps {
    private Response responseInquiryCVA;
    private Scenario scenario;
    CreateVARequestClass createVARequestClass;
    private String url ="";
    private String requestModel;
    private Gson gson = new Gson();
    @Given("fetch status api {string}")
    public void fetchStatusApiPath(String path) {
        url = base_url+path;
    }

    @And("as a prams provided id")
    public void asAPramsProvidedId() {
        FileServices file = new FileServices();
        String id =file.readFile(idReaderPath);
        url = url+id;

    }

    @When("user calls the get api")
    public void userCallsTheGetApi() {
        responseInquiryCVA  = ApiCall.getCall(HeaderFormat.commonHeaders(),url);
        System.out.println(responseInquiryCVA.body().asString());
    }

    @Then("will find success status {string}")
    public void willFindSuccessStatusCode(String code) {
        if(responseInquiryCVA.statusCode()==200) {
            InquiryCVAResponseClass inquiryCVAResponseClass = gson.fromJson(responseInquiryCVA.getBody().asString(), InquiryCVAResponseClass.class);
            System.out.println(inquiryCVAResponseClass.getAccount_number());
            Assert.assertEquals(inquiryCVAResponseClass.getStatus(),"ACTIVE");
        }
    }

    @Then("valid provided date with updateDate")
    public void validProvidedDateWithUpdateDate() {
        FileServices file = new FileServices();

        String date  = file.readFile(updateDateReaderFilepath);
        InquiryCVAResponseClass inquiryCVAResponseClass = gson.fromJson(responseInquiryCVA.getBody().asString(), InquiryCVAResponseClass.class);
        Assert.assertEquals(inquiryCVAResponseClass.getExpiration_date(),date);

    }
}
