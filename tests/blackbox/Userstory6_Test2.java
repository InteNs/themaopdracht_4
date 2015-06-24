package Selenium_test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Userstory6_Test2 {
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
    public void testUserstory6Test2() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("admin@admin.nl");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.id("login")).click();
        driver.findElement(By.xpath("(//input[@name='button'])[4]")).click();
        driver.findElement(By.xpath("//input[@value='Product Toevoegen']")).click();
        driver.findElement(By.id("productname")).clear();
        driver.findElement(By.id("productname")).sendKeys("Banden");
        driver.findElement(By.id("amount")).clear();
        driver.findElement(By.id("amount")).sendKeys("twee");
        driver.findElement(By.id("price")).clear();
        driver.findElement(By.id("price")).sendKeys("13.00");
        driver.findElement(By.cssSelector("div.p > input[name=\"button\"]")).click();
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
