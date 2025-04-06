import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MemberShipRegistrationSelenium {

    @Test
    public void Registration() throws InterruptedException {
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
        Thread.sleep(5000);  // Let the user actually see something!
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

        WebElement Join = driver.findElement((By.name("join")));
        Join.click();

        try {
            WebElement resultMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/h2")));
            System.out.println("Test passed: " + resultMessage.getText());
        } catch (Exception e) {
            System.out.println("Test failed: An error occurred.");
        }

        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();
    }

    @Test
    public void LastNameMissing() throws InterruptedException {
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
        Thread.sleep(5000);  // Let the user actually see something!
        String email = "User" + System.currentTimeMillis() + "@gmail10p.com";
        WebElement BirthdayDate = driver.findElement(By.id("dp"));
        BirthdayDate.sendKeys("28/09/1983" + Keys.ENTER);
        Thread.sleep(5000);
        WebElement FirstName = driver.findElement(By.id("member_firstname"));
        FirstName.sendKeys("AlTest");
        WebElement LastName = driver.findElement(By.id("member_lastname"));
        LastName.sendKeys("");
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

        WebElement Join = driver.findElement((By.name("join")));
        Join.click();

        try {
            WebElement resultMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"signup_form\"]/div[5]/div[2]/div/span/span")));
            if (resultMessage != null && resultMessage.isDisplayed())
            {
                System.out.println("Test passed: Error message is shown for missing last name.");
            }
            else {
                System.out.println("Test failed: No error message for missing last name.");
            }



        } catch (Exception e) {
            System.out.println("Test failed: An error occurred.");

        }


        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();
    }
    @Test
    public void PassworDontMatch() throws InterruptedException {
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
        Thread.sleep(5000);  // Let the user actually see something!
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

        WebElement Join = driver.findElement((By.name("join")));
        Join.click();

        try {
            WebElement resultMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"signup_form\"]/div[8]/div/div[2]/div[2]/div/span/span")));
            if (resultMessage != null && resultMessage.isDisplayed())
            {
                System.out.println("Test passed: Error message is shown for Password didnt match.");
            }
            else {
                System.out.println("Test failed: Password dont match.");
            }



        } catch (Exception e) {
           System.out.println("Test failed: An error occurred.");

        }


        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();
    }
    @Test
    public void TermsAndConditionsNotConfirm() throws InterruptedException {
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
        Thread.sleep(5000);  // Let the user actually see something!
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

        WebElement Join = driver.findElement((By.name("join")));
        Join.click();

        try {
            WebElement resultMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[2]/div[1]/span/span")));
            if (resultMessage != null && resultMessage.isDisplayed())
            {
                System.out.println("Test passed: Error message is shown for Terms and Conditions Not Confirm");
            }
            else {
                System.out.println("Test failed: No error message for Terms and Conditions. *");
            }

        } catch (Exception e) {
           System.out.println("Test failed: An error occurred.");

        }


        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();
    }
}
