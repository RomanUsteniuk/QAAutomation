package org.usteniuk;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Alerts {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
    }

    By JsConfirm = By.xpath("//button[@onclick = 'jsConfirm()']");
    By JsPrompt = By.xpath("//button[@onclick = 'jsPrompt()']");
    By Result = By.xpath("//p[@id = 'result']");

    @Test
    public void jSConfirmОк() throws InterruptedException {
        driver.findElement(JsConfirm).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        Assert.assertEquals(driver.findElement(Result).getText(), "You clicked: Ok");
    }

    @Test
    public void jSConfirmCencel() throws InterruptedException {
        driver.findElement(JsConfirm).click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        Assert.assertEquals(driver.findElement(Result).getText(), "You clicked: Cancel");
    }

    @Test
    public void jSPromptWithText() throws InterruptedException {
        driver.findElement(JsPrompt).click();
        String text = "Я текст в алерт";
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();

        Assert.assertEquals(driver.findElement(Result).getText(), "You entered: " + text);
    }

    @Test
    public void jSPromptWithOutText() throws InterruptedException {
        driver.findElement(JsPrompt).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        Assert.assertEquals(driver.findElement(Result).getText(), "You entered:");
    }

    @Test
    public void jSPromptWithTextCencel() throws InterruptedException {
        driver.findElement(JsPrompt).click();
        String text = "Я текст в алерт";
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.dismiss();

        Assert.assertEquals(driver.findElement(Result).getText(), "You entered: null");
    }

    @Test
    public void jSPromptWithOutTextCencel() throws InterruptedException {
        driver.findElement(JsPrompt).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        Assert.assertEquals(driver.findElement(Result).getText(), "You entered: null");
    }

    @AfterClass
    public void afterClass() throws NullPointerException {
        driver.quit();
    }

}
