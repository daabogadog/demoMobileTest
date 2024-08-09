package com.labs.digital.aval.demoMobile.stepdefinitions;


import com.labs.digital.aval.demoMobile.ui.LoginUI;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.labs.digital.aval.demoMobile.ui.LoginUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ParameterDefinitions {

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("the {word} enter credential")
    public void userRole(String actorName)  {
        OnStage.theActorCalled(actorName);
        OnStage.withCurrentActor(
                WaitUntil.the(LoginUI.TITLEDASH,isVisible()).forNoMoreThan(5).seconds(),
                Click.on(MENU),
                Click.on(BUTTON_LOG_IN));

    }
    @When("the user logon with success")
    public void userLogonWithSucces(){
        OnStage.theActorInTheSpotlight().attemptsTo(WaitUntil.the(TITLE_LOGIN, isVisible()).forNoMoreThan(3).seconds(),
                Enter.keyValues("bod@example.com").into(INPUT_USER),
                Enter.keyValues("10203040").into(INPUT_KEY),
                Click.on(BUTTON_LOGIN));

    }
    @Then("he should see products")
    public void heShouldSeeProducts(){
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(TITLE_PRODUCTS, isVisible()).forNoMoreThan(3).seconds()
        );
    }
}
