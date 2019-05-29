package com.example.with.expressions.steps;

import com.example.with.expressions.JobResult;
import com.example.with.expressions.JobType;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class StepImpl2 {

    @Before
    public void before(Scenario scenario) {
        String rawFeatureName = scenario.getId().split(";")[0].replace("-", " ");
        String featureName = rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);
        System.out.println("============= starting scenario:" + scenario.getName() + " =============");
    }

    @Given("^hi1 (.*)$")
    public void hi(String name) throws Throwable {
        System.out.println("name=" + name);
    }


    @Then("^bi1 (\\d+)$")
    public void bi1(int price) throws Throwable {
        System.out.println("price=" + price);
    }

    @Given("mock PM {int}")
    public void mockPMEmpId(int employeeId) {
        System.out.println("employeeId=" + employeeId);
    }

    @When("execute PM {int}")
    public void executePM(Integer employeeId, io.cucumber.datatable.DataTable jobTypes) {
        System.out.println("executePMEmpId    employeeId=" + employeeId);
        System.out.println("executePMEmpId      jobTypes=");
        List<JobType> objects = jobTypes.asList(JobType.class);
        objects.forEach(System.out::println);
    }

    //    @Then("^job status should be (.*) for (\\d+) (\\d+)$")
    ////    @Then("^job status should be \"([^\"]*)\" for (\\d+) (\\d+)$")
    @Then("job status should be {jobResult} for {int} {digit}")
    public void jobStatusShouldBeFor(JobResult jobResult, Integer employeeId, Integer siteId) {
        System.out.println("employeeId=" + employeeId);
        System.out.println("jobResult=" + jobResult);
    }
}