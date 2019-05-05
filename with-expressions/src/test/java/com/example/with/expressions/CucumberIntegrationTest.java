package com.example.with.expressions;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		snippets = SnippetType.CAMELCASE,
		features =
				{
						"src/test/resources/features",
				},
		glue = {"com.example.with.expressions.steps"},
		plugin = {"pretty", "json:target/cucumber-report.json"})
public class CucumberIntegrationTest {


}
