package com.star.step_defs;

import com.star.utils.ConfigurationReader;
import com.star.utils.Driver;
import com.star.utils.Environment;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setup(){

        Driver.getDriver().get(Environment.URL);

    }


    @After
    public void teardown(Scenario scenario){
        if (scenario.isFailed()){

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();
    }

}
