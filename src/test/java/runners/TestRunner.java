package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // Path to all the feature files
        features = "src/test/resources/features/",
        // Name of the package where all the step definitions are available
        glue = "steps",
        // If set to true, it stops execution and scans all the step definitions for missing steps
        dryRun = false,
        // Specify the tags to run specific scenarios
        tags = "@smoke",
        // Generate reports
        plugin = {
                "pretty",

        }
)
public class TestRunner {
}