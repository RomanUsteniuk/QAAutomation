package org.usteniuk;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HWTest1 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
      public void test1() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick = 'jsConfirm()']")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        Assert.assertEquals(driver.findElement(By.xpath("//p[@id = 'result']")).getText(), "You clicked: Ok");
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick = 'jsConfirm()']")).click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        Assert.assertEquals(driver.findElement(By.xpath("//p[@id = 'result']")).getText(), "You clicked: Cancel");
    }

    @Test
    public void test3() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick = 'jsPrompt()']")).click();
        String text = "Я текст в алерт";
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();

        Assert.assertEquals(driver.findElement(By.xpath("//p[@id = 'result']")).getText(), "You entered: " + text);
    }

    @Test
    public void test4() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick = 'jsPrompt()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        Assert.assertEquals(driver.findElement(By.xpath("//p[@id = 'result']")).getText(), "You entered:");
    }

    @Test
    public void test5() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick = 'jsPrompt()']")).click();
        String text = "Я текст в алерт";
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.dismiss();

        Assert.assertEquals(driver.findElement(By.xpath("//p[@id = 'result']")).getText(), "You entered: null");
    }

    @Test
    public void test6() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick = 'jsPrompt()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        Assert.assertEquals(driver.findElement(By.xpath("//p[@id = 'result']")).getText(), "You entered: null");
    }

    @AfterClass
    public void afterClass() throws NullPointerException{
        driver.quit();
    }

}
