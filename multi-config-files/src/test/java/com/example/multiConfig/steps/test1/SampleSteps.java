package com.example.multiConfig.steps.test1;

import com.example.multiConfig.steps.SampleTestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration(classes = {SampleTestConfig.class})
public class SampleSteps {
    SampleTestContext sampleTestContext;
    @Value("${inputText}")
    private String inputText;

    public SampleSteps(SampleTestContext sampleTestContext) {
        this.sampleTestContext = sampleTestContext;
    }

    @Then("^output OK$")
    public void output_OK() {
        Assert.assertEquals(sampleTestContext.getSampleService().get(),inputText) ;
    }

    @Given("^We have (\\d+) cookies in my belly$")
    public void weHaveCookiesInMyBelly(int cookies) {
        System.out.format("cookies: %d\n", cookies);
    }
}
