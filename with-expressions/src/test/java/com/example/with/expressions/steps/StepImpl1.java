package com.example.with.expressions.steps;


import com.example.with.expressions.Color;
import com.example.with.expressions.Grocery;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class StepImpl1 {
    private Map<String, Grocery> priceList;

    @Given("^We have (\\d+) cookies in my belly$")
    public void weHaveCookiesInMyBelly(int cookies) {
        System.out.format("cookies: %d\n", cookies);
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

    @Then("the result should be {int}")
    public void the_result_should_be(int expectedResult) {
        assertEquals(expectedResult, 123);
        assertThat(expectedResult, is(123));
    }

    @Given("the following colors are available")
    public void the_following_colors_are_available(List<Color> colors) {

         for (Color currColor : colors) {
            System.out.println("currColor=" +currColor);
        }
    }


}