package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features location
        features = "src/test/resources/features/",
        //steps location
        glue = "steps",
        //if we set the value to true, it stops execution and scan all the step definitions and gives missing steps
        //dryRun = false,
        tags = "@Test24",
        //html report

        plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json",
                "rerun:target/failed.txt"}
)


public class TestRunner {
}