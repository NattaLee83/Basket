package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MyStepdefs {

    private WebDriver driver; //Attribut

    private void waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    @Given("I am using {} as browser")
    public void iAmUsingAsBrowser(String browser) {

        if(browser.equals("firefox")){
            driver = new FirefoxDriver();
        }else {
            driver = new ChromeDriver();
        }
    }

    @Given("I have entered date of birth {string}")
    public void iHaveEnteredDateOfBirth(String date) {
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
        driver.manage().window().setSize(new Dimension(1710, 983));
        driver.findElement(By.id("dp")).sendKeys(date);
    }

    @And("I have entered first name {string}")
    public void iHaveEnteredFirstName(String firstname) {
        waitForElement(By.id("member_firstname"));
        driver.findElement(By.id("member_firstname")).sendKeys(firstname);
    }

    @And("I have entered last name {string}")
    public void iHaveEnteredLastName(String lastname) {
        driver.findElement(By.id("member_lastname")).sendKeys(lastname);
    }

    @And("I have entered email and confirmed email {string}")
    public void iHaveEnteredEmailAndConfirmedEmail(String email) {
        driver.findElement(By.id("member_emailaddress")).sendKeys(email);
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(email);
    }

    @And("I have entered password {string}")
    public void iHaveEnteredPassword(String password) {
        driver.findElement(By.id("signupunlicenced_password")).sendKeys(password);

    }
    @And("I have {string} password")
    public void iHavePassword(String confirmed) {
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys(confirmed);
    }

    @And("I have checked terms and conditions")
    public void iHaveCheckedTermsAndConditions() {
        driver.findElement(By.cssSelector(".md-checkbox > .md-checkbox:nth-child(1) .box")).click();

    }

    @And("I have checked Over 18 and code of conduct")
    public void iHaveCheckedOverAndCodeOfConduct() {
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(2) > label > .box")).click();
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(7) .box")).click();
    }

    @When("I press the join button")
    public void iPressTheJoinButton() throws InterruptedException {
        waitForElement(By.name("join"));
        driver.findElement(By.name("join")).click();
    }

    @Then("I am registered and verifies registered")
    public void iAmRegisteredAndVerifiesRegistered() {
        String expected = "THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND"; //Verifiera en text.
        String actual = driver.findElement(By.cssSelector("body > div > div.page-content-wrapper > div > h2")).getText();
        assertEquals(expected, actual);
    }

    @Then("I am registered and verifies missing lastname")
    public void iAmRegisteredAndVerifiesMissingLastname() {
        String expected = "Last Name is required";
        String actual = driver.findElement(By.cssSelector("#signup_form > div:nth-child(6) > div:nth-child(2) > div > span > span")).getText();
        assertEquals(expected, actual);                 //#signup_form > div:nth-child(6) > div:nth-child(2) > div > span > span
    }

    @Then("I am registered and verifies wrong password")
    public void iAmRegisteredAndVerifiesWrongPassword() {
        String expected = "Password did not match";
        String actual = driver.findElement(By.cssSelector(".row:nth-child(2) .warning > span")).getText();
        assertEquals(expected, actual);

    }

    @Then("I have not checked terms and conditions")
    public void iHaveNotCheckedTermsAndConditions() {

    }

    @Then("I am registered and verifies terms and conditions")
    public void iAmRegisteredAndVerifiesTermsAndConditions() {
        String expected = "You must confirm that you have read and accepted our Terms and Conditions";
        String actual = driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(2) > div:nth-child(1) > span > span")).getText();
        assertEquals(expected, actual);

    }
}



