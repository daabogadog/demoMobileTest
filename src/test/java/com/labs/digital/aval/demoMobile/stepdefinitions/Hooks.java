package com.labs.digital.aval.demoMobile.stepdefinitions;


import com.labs.digital.aval.demoMobile.runner.TunnelLambdatest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;


public class Hooks {
    private EnvironmentVariables environmentVariables;

    @BeforeAll
    public static void beforeAll()
    {
        EnvironmentVariables vars = SystemEnvironmentVariables.createEnvironmentVariables();
        if (vars.activeEnvironments().stream().iterator().next().contains("lambdatest"))
        {
            OnStage.setTheStage(new OnlineCast());
        }
    }

    @Before
    public void setTheStageMobilePlay(Scenario scenario) {
        TunnelLambdatest.starTunnel();
    }
    @After
    public void doSomethingAfterStep(Scenario scenario){

        TunnelLambdatest.updateStatusAndNameCase("lambda-status=",scenario.getStatus().name().toLowerCase());
        TunnelLambdatest.updateStatusAndNameCase("lambda-name=",scenario.getName().toLowerCase());

    }
}

