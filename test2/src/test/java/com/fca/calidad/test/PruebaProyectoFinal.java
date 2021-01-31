package com.fca.calidad.test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PruebaProyectoFinal {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\lalo_\\Desktop\\MATERIAS 7MO\\Calidad de software\\chromedriver\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAgregarMernCrud() throws Exception {
    driver.get("https://mern-crud.herokuapp.com/");
    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Monsi Colmenares");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("monsicolmenares@gmail.com");
    driver.findElement(By.name("age")).click();
    driver.findElement(By.name("age")).clear();
    driver.findElement(By.name("age")).sendKeys("23");
    driver.findElement(By.xpath("//div[3]/div[2]/div")).click();
    driver.findElement(By.xpath("//div[2]/div[2]")).click();
    driver.findElement(By.xpath("//form/button")).click();
    // Warning: assertTextPresent may require manual changes
  }
  @Test
  public void testEliminarMernCrud() throws Exception {
    driver.get("https://mern-crud.herokuapp.com/");
    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Prueba eliminar");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("prueba@prueba.com");
    driver.findElement(By.name("age")).click();
    driver.findElement(By.name("age")).clear();
    driver.findElement(By.name("age")).sendKeys("25");
    driver.findElement(By.xpath("//div[3]/div[2]/div/div")).click();
    driver.findElement(By.xpath("//div[2]/div/div[2]/div")).click();
    driver.findElement(By.xpath("//form/button")).click();
    driver.findElement(By.xpath("//i")).click();
    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/table/tbody/tr/td[5]/button[2]")).click();
    driver.findElement(By.xpath("//div[3]/button")).click();
    // Warning: assertTextNotPresent may require manual changes
    assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]prueba@prueba\\.com[\\s\\S]$"));
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