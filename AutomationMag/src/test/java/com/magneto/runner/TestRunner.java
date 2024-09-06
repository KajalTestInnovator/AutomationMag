package com.magneto.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
/*@CucumberOptions(
    features="src/test/resources/features",
    glue="com.example.stepdefinitions",
    plugin={"pretty","html:target/target/cucumber.html"},
    monochrome=true
)*/
@CucumberOptions(
	    features="src/test/resources/Features",
	    glue="com.magneto.stepdefinitions", 
	    plugin={"pretty","html:target/target/cucumber.html"},
	    monochrome=true
	)
public class TestRunner {

}
