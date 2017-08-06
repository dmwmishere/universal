package org.dmwm.universal.main.cucumber.steps;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = {
		"classpath:request_meme.feature"
},
plugin = "json:target/cucumber-report.json"
)
public class CucumberRunner {

}
