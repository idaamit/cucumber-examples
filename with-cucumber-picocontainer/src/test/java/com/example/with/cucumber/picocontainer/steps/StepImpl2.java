package com.example.with.cucumber.picocontainer.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Assert;

public class StepImpl2 {
    private TestContext testContext;
    private StopWatch watch = new StopWatch();
    public StepImpl2(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void before(Scenario scenario) {
        watch.start();
        String rawFeatureName = scenario.getId().split(";")[0].replace("-", " ");
        String featureName = rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);
        System.out.println("============= starting scenario:" + scenario.getName() + " =============\n");
    }

    @After
    public void after(Scenario scenario) {
        watch.stop();
        String rawFeatureName = scenario.getId().split(";")[0].replace("-", " ");
        String featureName = rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);
        System.out.println("\n============= end scenario:" + scenario.getName() + " Time Elapsed: " + watch.getTime() +" =============\n");
    }

    @Then("^getting shared param \\$(\\d+)$")
    public void getting_shared_param(int expectingAmount) {
        Assert.assertEquals("shared amount passes", expectingAmount , testContext.sharedParam2);
        System.out.println("getting shared param world.sharedParam2= " + testContext.sharedParam2);
    }
}
