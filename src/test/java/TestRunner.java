import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@smoke",
        features = {"src/test/resources/featureFiles"},
        monochrome = true,
        dryRun = false,
        plugin = {
             "pretty","html:build/reports/feature.html"
        }
)
public class TestRunner {
}
