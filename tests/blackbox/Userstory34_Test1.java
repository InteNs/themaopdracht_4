package blackbox;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Userstory34_Test1 {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost:8080/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUserstory34_Test1() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.cssSelector("div.p > a > input.button")).click();
        try {
            assertEquals("Registreren", driver.findElement(By.cssSelector("legend")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("d@d.nl");
        driver.findElement(By.id("emailrepeat")).clear();
        driver.findElement(By.id("emailrepeat")).sendKeys("d@d.nl");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.id("passwordrepeat")).clear();
        driver.findElement(By.id("passwordrepeat")).sendKeys("12345");
        driver.findElement(By.id("realname")).clear();
        driver.findElement(By.id("realname")).sendKeys("d");
        driver.findElement(By.id("date")).clear();
        driver.findElement(By.id("date")).sendKeys("2015-06-01");
        driver.findElement(By.id("address")).clear();
        driver.findElement(By.id("address")).sendKeys("dreefstraat 123");
        driver.findElement(By.id("postalcode")).clear();
        driver.findElement(By.id("postalcode")).sendKeys("3511AA");
        driver.findElement(By.id("phonenumber")).clear();
        driver.findElement(By.id("phonenumber")).sendKeys("0612345678");
        driver.findElement(By.cssSelector("div.buttonBox > input[name=\"button\"]")).click();
        try {
            assertEquals("Inloggen", driver.findElement(By.cssSelector("legend")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("d");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("d@d.nl");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.id("login")).click();
        try {
            assertEquals("Welkom d,", driver.findElement(By.cssSelector("h2")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.cssSelector("form.formMainmenu > input[name=\"button\"]")).click();
        try {
            assertEquals("Verwijder", driver.findElement(By.cssSelector("span.smalltext")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("//input[@value='Auto Toevoegen']")).click();
        driver.findElement(By.id("carBrand")).clear();
        driver.findElement(By.id("carBrand")).sendKeys("ferrari");
        driver.findElement(By.id("carType")).clear();
        driver.findElement(By.id("carType")).sendKeys("sportwagen");
        driver.findElement(By.id("licensePlate")).clear();
        driver.findElement(By.id("licensePlate")).sendKeys("11-AA-22");
        driver.findElement(By.cssSelector("div.buttonBox > input[name=\"button\"]")).click();
        try {
            assertEquals("Kenteken", driver.findElement(By.xpath("//th[2]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.cssSelector("input.buttonsmall")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
