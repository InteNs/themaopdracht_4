package Selenium_test;

        import java.util.regex.Pattern;
        import java.util.concurrent.TimeUnit;
        import org.junit.*;
        import static org.junit.Assert.*;
        import static org.hamcrest.CoreMatchers.*;
        import org.openqa.selenium.*;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.support.ui.Select;

public class Userstory30_Test2 {
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
    public void testUserstory30Test2() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.cssSelector("a > input.button")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("joop@hotmail.com");
        driver.findElement(By.id("emailrepeat")).clear();
        driver.findElement(By.id("emailrepeat")).sendKeys("joop1@hotmail.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.id("passwordrepeat")).clear();
        driver.findElement(By.id("passwordrepeat")).sendKeys("123456");
        driver.findElement(By.id("realname")).clear();
        driver.findElement(By.id("realname")).sendKeys("joopie");
        driver.findElement(By.id("date")).clear();
        driver.findElement(By.id("date")).sendKeys("2015-06-05");
        driver.findElement(By.id("address")).clear();
        driver.findElement(By.id("address")).sendKeys("dreefstraat 123");
        driver.findElement(By.id("postalcode")).clear();
        driver.findElement(By.id("postalcode")).sendKeys("3500AA");
        driver.findElement(By.id("phonenumber")).clear();
        driver.findElement(By.id("phonenumber")).sendKeys("0612345678");
        driver.findElement(By.name("button")).click();
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
