package steps;

import org.openqa.selenium.By;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import drivers.driverinstance;

public class Loginsteps extends driverinstance {

    @And("User click on the Login Link")
    public void userClickOnTheLoginLink() {
        System.out.println("Login Link");
    }

    @And("User enters the username as {string}")
    public void userEntersTheUsernameAsSathishkumarsekarGmailCom(String username) {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        System.out.println("3");
    }

    @And("User enters the Password as {string}")
    public void userEntersThePasswordAsSaiz(String password) {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        System.out.println("4");
    }

    @When("User click on the login button")
    public void userClickOnTheLoginButton() {
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        System.out.println("5");
    }

    @When("Login should be success")
    public void loginShouldBeSuccess() {
        System.out.println("6");

    }

    @Then("Login should be fail")
    public void loginShouldBeFail() {
        String errmsg = driver
                .findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]"))
                .getText();
        Assert.assertEquals(errmsg, "Epic sadface: Username and password do not match any user in this service");
        System.out.println(errmsg);

    }

}
