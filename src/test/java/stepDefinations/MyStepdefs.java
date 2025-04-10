package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class MyStepdefs {
   private WebDriver driver;
   private WebDriverWait wait;
   //privat metod med explicit wait
    private WebElement waitForClickableElement(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    private void initializeWait(){
        if(driver != null){
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
    }


    @Given("I am on basketballengland page")
    public void iAmOnBasketballenglandPage() {
        driver = new ChromeDriver();
        initializeWait();
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");

    }
    @Given("I am on basketballengland page using {string}")
    public void iAmOnBasketballenglandPageUsing(String browser) throws IllegalAccessException {
        switch (browser.toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalAccessException("UNSUPORTED BROWESER" + browser);
        }

        initializeWait();
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");


    }


    @When("I fill in the correct member details")
    public void iFillInTheCorrectMemberDetails() throws InterruptedException {
        String email = "User" + System.currentTimeMillis() + "@gmail10p.com";
        WebElement BirthdayDate = driver.findElement(By.id("dp"));
        BirthdayDate.sendKeys("28/09/1983" + Keys.ENTER);
        Thread.sleep(5000);
        WebElement FirstName = driver.findElement(By.id("member_firstname"));
        FirstName.sendKeys("AlTest");
        WebElement LastName = driver.findElement(By.id("member_lastname"));
        LastName.sendKeys("HerTest");
        WebElement Email = driver.findElement(By.name("EmailAddress"));
        Email.sendKeys(email);
        WebElement ConfirmEmail = driver.findElement(By.name("ConfirmEmailAddress"));
        ConfirmEmail.sendKeys(email);
        WebElement Password = driver.findElement(By.name("Password"));
        Password.sendKeys("1234p");
        WebElement ConfirmPassword = driver.findElement(By.name("ConfirmPassword"));
        ConfirmPassword.sendKeys("1234p");


        driver.findElement(By.cssSelector("label[for='signup_basketballrole_16'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for=\"signup_basketballrole_19\"] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for=\"sign_up_25\"] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for=\"sign_up_26\"] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for=\"fanmembersignup_agreetocodeofethicsandconduct\"] span[class='box']")).click();

    }

    @Then("I successfully become a member")
    public void iSuccessfullyBecomeAMember() {
        String expected = "THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND";
        String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/h2")).getText();
        assertEquals(expected, actual);
        System.out.println("we sent you an email to verify your email address (check your ");
        driver.quit();
    }


    @When("I fill in the correct member details without last name")
    public void iFillInTheCorrectMemberDetailsWithoutLastName() throws InterruptedException {
        String email = "User" + System.currentTimeMillis() + "@gmail10p.com";

        WebElement BirthdayDate = driver.findElement(By.id("dp"));
        BirthdayDate.sendKeys("28/09/1983" + Keys.ENTER);
        WebElement FirstName = driver.findElement(By.id("member_firstname"));
        FirstName.sendKeys("AlTest");
        WebElement LastName = driver.findElement(By.id("member_lastname"));
        WebElement Email = driver.findElement(By.name("EmailAddress"));
        Email.sendKeys(email);
        WebElement ConfirmEmail = driver.findElement(By.name("ConfirmEmailAddress"));
        ConfirmEmail.sendKeys(email);
        WebElement Password = driver.findElement(By.name("Password"));
        Password.sendKeys("1234p");
        WebElement ConfirmPassword = driver.findElement(By.name("ConfirmPassword"));
        ConfirmPassword.sendKeys("1234p");


        driver.findElement(By.cssSelector("label[for='signup_basketballrole_16'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for=\"signup_basketballrole_19\"] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for=\"sign_up_25\"] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for=\"sign_up_26\"] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for=\"fanmembersignup_agreetocodeofethicsandconduct\"] span[class='box']")).click();

    }


    @And("I press confirm and join")
    public void iPressConfirmAndJoin() {
        WebElement Join = driver.findElement((By.name("join")));
        Join.click();
    }
    @Then("I see the error message for the lastname missing")
    public void iSeeTheErrorMessageForTheLastnameMissing() {
        String expected = "Last Name is required";
        String actual = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[5]/div[2]/div/span")).getText();
        assertEquals(expected, actual);
        System.out.println("User not registered, Last name is required");
        driver.quit();
    }

    @When("I fill in the correct member details, and password dont match")
    public void iFillInTheCorrectMemberDetailsAndPasswordDontMatch() throws InterruptedException {
        String email = "User" + System.currentTimeMillis() + "@gmail10p.com";
        WebElement BirthdayDate = driver.findElement(By.id("dp"));
        BirthdayDate.sendKeys("28/09/1983" + Keys.ENTER);
        Thread.sleep(5000);
        WebElement FirstName = driver.findElement(By.id("member_firstname"));
        FirstName.sendKeys("AlTest");
        WebElement LastName = driver.findElement(By.id("member_lastname"));
        LastName.sendKeys("Her");
        WebElement Email = driver.findElement(By.name("EmailAddress"));
        Email.sendKeys(email);
        WebElement ConfirmEmail = driver.findElement(By.name("ConfirmEmailAddress"));
        ConfirmEmail.sendKeys(email);
        WebElement Password = driver.findElement(By.name("Password"));
        Password.sendKeys("1234p");
        WebElement ConfirmPassword = driver.findElement(By.name("ConfirmPassword"));
        ConfirmPassword.sendKeys("12345p");


        driver.findElement(By.cssSelector("label[for='signup_basketballrole_16'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for=\"signup_basketballrole_19\"] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for=\"sign_up_25\"] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for=\"sign_up_26\"] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for=\"fanmembersignup_agreetocodeofethicsandconduct\"] span[class='box']")).click();


    }

    @Then("I see the error message for the not matching password")
    public void iSeeTheErrorMessageForTheNotMatchingPassword() {
        String expected = "Password did not match";
        String actual = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[8]/div/div[2]/div[2]/div/span/span")).getText();
        assertEquals(expected, actual);
        System.out.println("User not registered, Password didnt match");
        driver.quit();


    }

    @When("I fill in the correct member details, without confirm terms and Conditions")
    public void iFillInTheCorrectMemberDetailsWithoutConfirmTermsAndConditions() throws InterruptedException {
        String email = "User" + System.currentTimeMillis() + "@gmail10p.com";
        WebElement BirthdayDate = driver.findElement(By.id("dp"));
        BirthdayDate.sendKeys("28/09/1983" + Keys.ENTER);
        Thread.sleep(5000);
        WebElement FirstName = driver.findElement(By.id("member_firstname"));
        FirstName.sendKeys("AlTest");
        WebElement LastName = driver.findElement(By.id("member_lastname"));
        LastName.sendKeys("Her");
        WebElement Email = driver.findElement(By.name("EmailAddress"));
        Email.sendKeys(email);
        WebElement ConfirmEmail = driver.findElement(By.name("ConfirmEmailAddress"));
        ConfirmEmail.sendKeys(email);
        WebElement Password = driver.findElement(By.name("Password"));
        Password.sendKeys("1234p");
        WebElement ConfirmPassword = driver.findElement(By.name("ConfirmPassword"));
        ConfirmPassword.sendKeys("1234p");
        driver.findElement(By.cssSelector("label[for='signup_basketballrole_16'] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for=\"signup_basketballrole_19\"] span[class='box']")).click();
        // driver.findElement(By.cssSelector("label[for=\"sign_up_25\"] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for=\"sign_up_26\"] span[class='box']")).click();
        driver.findElement(By.cssSelector("label[for=\"fanmembersignup_agreetocodeofethicsandconduct\"] span[class='box']")).click();



    }

    @Then("I see the error message for the not confirm terms and Conditions")
    public void iSeeTheErrorMessageForTheNotConfirmTermsAndConditions() {
        String expected = "You must confirm that you have read and accepted our Terms and Conditions";
        String actual = driver.findElement(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[2]/div[1]/span/span")).getText();
        assertEquals(expected, actual);
        System.out.println("User not registered, You must confirm that you have read and accepted our Terms and Conditions");
        driver.quit();

    }


}