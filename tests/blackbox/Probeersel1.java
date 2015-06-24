package blackbox;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Probeersel1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get(baseUrl + "/");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("admin");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("admin@admin.nl");
    driver.findElement(By.id("login")).click();
    driver.findElement(By.cssSelector("form.formMainmenu > input[name=\"button\"]")).click();
    try {
      assertEquals("Postcode", driver.findElement(By.xpath("//th[4]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Huidig ingelogde gebruiker: admin.", driver.findElement(By.id("currentuserinfo")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @Test
  public void testProbeersel1() throws Exception {
    driver.findElement(By.cssSelector("div.container.table > div.right > a > input.button")).click();
    try {
      assertEquals("Niet aanwezig op de pagina van Gebruiker Toevoegen.", "Gebruiker Toevoegen", driver.findElement(By.cssSelector("legend")).getText());
    } catch (Error e) {
      verificationErrors.append(("\n")+e.toString()+("\n"));
    }
    driver.get(baseUrl + "/secure/user/adduser.jsp");
//    Invullen van velden.
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("a@a.nl");
    driver.findElement(By.id("emailrepeat")).clear();
    driver.findElement(By.id("emailrepeat")).sendKeys("a@a.nl");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("12345");
    driver.findElement(By.id("passwordrepeat")).clear();
    driver.findElement(By.id("passwordrepeat")).sendKeys("12345");
    driver.findElement(By.id("realname")).clear();
    driver.findElement(By.id("realname")).sendKeys("A");
    driver.findElement(By.id("date")).clear();
    driver.findElement(By.id("date")).sendKeys("2015-08-08");
    driver.findElement(By.id("address")).clear();
    driver.findElement(By.id("address")).sendKeys("A");
    driver.findElement(By.id("postalcode")).clear();
    driver.findElement(By.id("postalcode")).sendKeys("1234AA");
    driver.findElement(By.id("phonenumber")).clear();
    driver.findElement(By.id("phonenumber")).sendKeys("0612345789");
    new Select(driver.findElement(By.id("usertype"))).selectByVisibleText("Monteur");
//    Einde invullen van velden.

    driver.findElement(By.cssSelector("div.buttonBox > input[name=\"button\"]")).click();

    try {
      assertEquals("Niet aanwezig op de pagina van Gebruikersoverzicht.", "Telefoonnummer", driver.findElement(By.xpath("//th[5]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString()+("\n"));
    }

    driver.findElement(By.xpath("(//input[@name='button'])[13]")).click();

    try {
      assertEquals("Werkt de knop Gebruikers Details niet.", "Details Gebruiker", driver.findElement(By.cssSelector("legend")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString()+("\n"));
    }
    assertEquals("De status MONTEUR is niet aan de nieuw toegevoegde gebruiker toegewezen.", "MONTEUR", driver.findElement(By.id("usertype")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.findElement(By.cssSelector("div.buttonBoxLeft > form > input[name=\"button\"]")).click();
    driver.findElement(By.name("button")).click();
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
