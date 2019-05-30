package com.example.with.cucumber.picocontainer.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepImpl1 {
    private TestContext testContext;

    public StepImpl1(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("^put \\$(\\d+) in the bank$")
    public void hi(int amount) {
        testContext.sharedParam2 = amount;
    }

    @Then("^bi$")
    public void bi() {
        System.out.println(" testContext.sharedParam2="+  testContext.sharedParam2);
    }


}
