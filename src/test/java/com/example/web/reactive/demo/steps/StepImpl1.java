package com.example.web.reactive.demo.steps;

import com.example.web.reactive.demo.Color;
import com.example.web.reactive.demo.Grocery;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StepImpl1 {
    private TestContext testContext;

    public StepImpl1(TestContext testContext) {
        this.testContext = testContext;
    }

    private Map<String, Grocery> priceList;

    @Given("I have (\\d+) cookies in my belly")
    public void i_have_n_cukes_in_my_belly(int cookies) {
        System.out.format("cookies: %d\n", cookies);
        testContext.sharedParam2 = cookies;
    }

    @Given("I have {digit} {color} balls")
    public void i_have_red_balls(Integer digit, Color color) {
        System.out.println("int=" +digit);
        System.out.println("color=" +color);
    }

    @Given("I have {int} cucumber(s) in my belly/stomach")
    public void i_have_red_balls3(int int3) {
        System.out.println("belly/stomach int3=" +int3);
    }

    @Given("I have {color} balls")
    public void i_have_red_balls2(Color color) {
        System.out.println("color=" +color);
    }

    @Given("the price list for an international coffee shop")
    public void the_price_list_for_an_international_coffee_shop(List<Grocery> groceries) {
        priceList = new HashMap<>();

        for (Grocery grocery : groceries) {
            String key = grocery.getName();
            System.out.println("key=" +key);
            priceList.put(key, grocery);
        }
    }

    @Then("^the result should be (.+)$")
    public void the_result_should_be(String expectedResult) {
        assertEquals(expectedResult, "ABC");
        assertThat(expectedResult, is("ABC"));
    }
}