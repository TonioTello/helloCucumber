package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.jupiter.api.Assertions.*;


class IsItFriday {
    static String isItFriday(String today) {
        return "Nope";
    }
}

public class StepDefinitions {

    private String today;
    private String actualAnswer;

    private WebDriver driver;

    @Given("today is Sunday")
    public void today_is_sunday() {
        today = "Sunday";
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/drivers/chromedriver.exe");
        ChromeOptions o= new ChromeOptions();
        o.addArguments("--incognito");
        DesiredCapabilities c = DesiredCapabilities.chrome();
        c.setCapability(ChromeOptions.CAPABILITY, o);
        driver = new ChromeDriver(o);
        //driver.get("");
        driver.get("https://testautomationu.applitools.com/");
        driver.manage().window().maximize();
        //Provide a handler to the home page, from the framework level -->
        System.out.println(driver.getTitle());
    }
    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_friday_yet() {
        actualAnswer = IsItFriday.isItFriday(today);

    }
    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);

    }


}
