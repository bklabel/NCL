package Scenario_ichi_bdd.feature;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@Cucumber.Options(features="C:\\Users\\kevin\\eclipse-workspace\\NCL3\\src\\Scenario_ichi_bdd\\feature",
glue = {"Scenario_ichi_bdd.feature"},
format = {"pretty", "html:target/cucumber-html-report", "json-pretty:target/cucumber-report.json"})
public class Runner {

}
