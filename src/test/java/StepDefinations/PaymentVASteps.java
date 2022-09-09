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
import repository.remoteRepo.requestRepo.PaymentVARequestClass;
import repository.remoteRepo.responseRepo.CreateVAResponseClass;
import repository.remoteRepo.responseRepo.PaymentVAResponseClass;

import static Core.CoreConstrains.base_url;
import static Core.FilePath.*;

public class PaymentVASteps {
    private Response responsePaymentVA;
    private Scenario scenario;
    CreateVARequestClass createVARequestClass;
    PaymentVARequestClass paymentVARequestClass;
    private String url ="";
    private String requestModel;
    private Gson gson = new Gson();
    @Given("payment post  api {string}")
    public void paymentPostApiPath(String path) {
        url = base_url+path;
        FileServices file = new FileServices();
        String externalId =file.readFile(externalIdFilepath);
        //https://api.xendit.co/callback_virtual_accounts/external_id=va_fixed-123/simulate_payment
        url = url+"external_id="+ externalId.trim() +"/simulate_payment";


    }


    @And("as request body amount will be provided {string}")
    public void asRequestBodyAmountWillBeProvidedAmount(String amount) {
        JSONObject requestBody = new FileServices().readJsonFile(paymentVAFilepath);
        paymentVARequestClass = new Gson().fromJson(requestBody.toJSONString(),PaymentVARequestClass.class);
        int amn = Integer.parseInt(amount);
        System.out.println("payment" + amn);
        paymentVARequestClass.setAmount(amn);
        requestModel = gson.toJson(paymentVARequestClass);
        System.out.println(requestModel);
    }

    @When("user calls the post api with body")
    public void userCallsThePostApiWithBody() {
        responsePaymentVA = ApiCall.postCall(HeaderFormat.commonHeaders(),requestModel,url);
        System.out.println(responsePaymentVA.body().asString());
    }

    @Then("payment will be succesfull")
    public void paymentWillBeSuccesfull() {
        System.out.println("testttttttttttttttt");
//        PaymentVAResponseClass paymentVAResponseClass = gson.fromJson(responsePaymentVA.getBody().asString(), PaymentVAResponseClass.class);
//        Assert.assertEquals(paymentVAResponseClass.getStatus(),"COMPLETED");
    }
}
