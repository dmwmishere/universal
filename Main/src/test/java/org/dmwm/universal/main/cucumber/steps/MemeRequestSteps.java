package org.dmwm.universal.main.cucumber.steps;

import org.apache.log4j.Logger;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MemeRequestSteps {

	private static final Logger log = Logger.getLogger(MemeRequestSteps.class);
	
	@Given("^I would liek to git some dank stuff$")
	public void init(){
		log.info("AT INIT");
	}
	
	@When("^I try to git '(\\w+)' meme$")
	public void requestMaymay(String meme){
		log.info("AT REQUESTMAYMAY: " + meme);
	}
	
	@Then("I should see it is as dank as '(\\d+)'")
	public void dankLevel(int level){
		log.info("AT DANKLEVEL: " + level);
	}
	
	
}
