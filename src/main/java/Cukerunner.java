import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(

        features = {"FeatureFiles/"},

        glue = {"stepDefinitions"},

        plugin = {"pretty",

                "html:target/cucumber-html-report",

                "junit:target/cucumber-junit-report/allcukes.xml"},

//        tags = {"@Runme"},
        monochrome=true

)

public class Cukerunner {

}
