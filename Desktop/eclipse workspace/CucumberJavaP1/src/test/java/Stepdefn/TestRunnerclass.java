package Stepdefn;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Features/GoogleSearch.feature",
    glue = {"Stepdefn"},
    monochrome = true,  // Optional: Makes the console output more readable
    plugin = {
        "pretty",  // Ensures detailed step/feature output in console
        "html:target/Htmlreports",  // HTML report in target/Htmlreports
        "json:target/cucumber.json",  // Optional: JSON format output
        "junit:target/cucumber.xml"   // Optional: JUnit XML output
    }
)
public class TestRunnerclass {
}

