package com.example.Selenium.Package02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CheckAdsTOP_ESC implements Runnable {
    private WebDriver driver;
    private CountDownLatch countDownLatch;
    private List<WebElement> element_solve;
    private WebDriverWait wait;

    public CheckAdsTOP_ESC(WebDriver driver, CountDownLatch countDownLatch) {
        this.driver = driver;
        this.countDownLatch = countDownLatch;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public CheckAdsTOP_ESC(WebDriver driver, CountDownLatch countDownLatch, WebDriverWait wait) {
        this.driver = driver;
        this.countDownLatch = countDownLatch;
        this.wait = wait;
    }

    @Override
    public void run() {
        if (wait != null) {
            //  logic for the second constructor
            System.out.println("logic for the second constructor of ADsTOP_ESC");
        } else {
            // logic for the first constructor
            System.out.println("logic for the first constructor of ADsTOP_ESC");
            element_solve = driver.findElements(By.xpath("//ins[@data-anchor-status='displayed']"));
            if (element_solve.size() > 0 && element_solve.get(0).isDisplayed()) {
                driver.findElement(By.xpath("(//div[@class='grippy-host'])[1]")).click();
            }
            element_solve = driver.findElements(By.xpath("/html/body/div[1]/div[1]/small"));
            if (element_solve.size() > 0 && element_solve.get(0).isDisplayed()) {
                driver.findElement(By.xpath("/html/body/div[1]/div[1]/small")).click();
            }
        }
        countDownLatch.countDown();
    }
}