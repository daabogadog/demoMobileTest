package com.labs.digital.aval.demoMobile.runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    plugin = {"pretty","rerun:target/rerun.txt", "json:target/destination/cucumber.json"},
    features = {"classpath:features"},
    glue = {"com.labs.digital.aval.demoMobile.stepdefinitions"},
    snippets = SnippetType.CAMELCASE,
    tags = "@demo"
)
public class RunnerLambdatest {
}
