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
        tags = "@java",
        //html report
        plugin = {"pretty","html:target/cucumber.html","rerun:target/failed.txt","json:target/cucumber.json"}
)


public class TestRunner {
}
