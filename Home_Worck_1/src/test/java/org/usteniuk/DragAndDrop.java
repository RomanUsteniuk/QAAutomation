package org.usteniuk;

import io.github.bonigarcia.wdm.WebDriverManager;
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

import java.time.Duration;

public class DragAndDrop {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("http://www.pureexample.com/jquery-ui/basic-droppable.html");
    }

    By iframe = By.xpath("//iframe[@id='ExampleFrame-94']");
    By drag = By.xpath("//div[@class = 'square ui-draggable']");
    By drop = By.xpath("//div[@class = 'squaredotted ui-droppable']");
    By info = By.xpath("//div[@id = 'info']");

    @Test
    public void DragAndDrop() throws InterruptedException {
        WebDriver frame = driver.switchTo().frame(driver.findElement(iframe));
        WebElement elementDrag = frame.findElement(drag);
        WebElement elementDrop = frame.findElement(drop);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(elementDrag, elementDrop).release().build().perform();

        Assert.assertEquals(driver.findElement(info).getText(), "dropped!");
    }

    @AfterClass
    public void afterClass() throws NullPointerException {
        driver.quit();
    }
}
