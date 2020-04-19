package org.usteniuk;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class Context {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
    }

    By hotSpot = By.xpath("//div[@id = 'hot-spot']");

    @Test
    public void ContextClick() throws InterruptedException {
         WebElement spot = driver.findElement(hotSpot);

        Actions actions = new Actions(driver);
        actions.contextClick(spot).build().perform();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();
    }

    @AfterClass
    public void afterClass() throws NullPointerException {
        driver.quit();
    }
}
