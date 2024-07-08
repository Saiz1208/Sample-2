package hooks;

import java.time.Duration;

import drivers.driverinstance;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;


public class HooksDemo extends driverinstance {
    @Before
    public void beforeScenario(Scenario s1) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        System.out.println(driver.getTitle());
//		 String name = s1.getName();
//		 System.out.println("scenario name:" + name);
    }

    @After
    public void afterScenario(Scenario s2) {
        boolean failed = s2.isFailed();
        System.out.println("is failed:" + failed);
        byte[] screenshot = driver.getScreenshotAs(OutputType.BYTES);
        s2.embed(screenshot, "image/png");
        driver.quit();


    }

    @BeforeStep
    public void beforeSteps(Scenario st1) {
        st1.write("Started");
    }

    @AfterStep
    public void afterSteps(Scenario st2) {
        st2.write("Finished");

    }

}
