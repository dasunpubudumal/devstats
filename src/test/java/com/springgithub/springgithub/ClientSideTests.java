package com.springgithub.springgithub;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClientSideTests {

    private static WebDriver webDriver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/usr/local/chromedriverfolder/chromedriver");
        testIndexLoad();
        testGitHubIndex();
        testTwitterIndex();
//        testStackInput();
    }

    private static void testIndexLoad() throws InterruptedException {
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080");
        Thread.sleep(5000);
        webDriver.quit();
    }

    private static void testGitHubIndex() throws InterruptedException {
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080");
        WebElement element = webDriver.findElement(By.xpath("//a[@href='/github']"));
        element.click();
        Thread.sleep(10000);
        webDriver.quit();
    }

    private static void testTwitterIndex() throws InterruptedException {
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080");
        WebElement element = webDriver.findElement(By.xpath("//a[@href='/twitter']"));
        element.click();
        Thread.sleep(10000);
        webDriver.quit();
    }

    private static void testStackInput() throws InterruptedException {
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080");
        WebElement element = webDriver.findElement(By.xpath("//input[@id='searchInput']"));
        element.sendKeys("7870026");
        element.sendKeys(Keys.RETURN);
        Thread.sleep(10000);
        webDriver.quit();
    }

}
