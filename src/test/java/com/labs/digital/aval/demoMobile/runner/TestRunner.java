package com.labs.digital.aval.demoMobile.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
     plugin={"pretty"},
     features="classpath:features",
     glue= "com.labs.digital.aval.demoMobile.stepdefinitions",
     tags = "@demo"
)
public class TestRunner {
}
