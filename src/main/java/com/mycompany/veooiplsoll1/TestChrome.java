/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.veooiplsoll1;

/**
 *
 * @author JMVAS
 */
import static com.google.common.collect.ContiguousSet.builder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import static java.util.stream.DoubleStream.builder;
import static java.util.stream.IntStream.builder;
import static java.util.stream.LongStream.builder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestChrome {

    public static void main(String[] args) throws InterruptedException {
        JsonObject jb = new JsonObject();
        JsonParser jsp = new JsonParser();
        JsonArray ja = jsp.parse(util.emailsjson.toString()).getAsJsonArray();
        System.out.println("Aka:: " + ja.toString());

        for (int i = 1; i <= 25; i++) {
            JsonObject jbt = new JsonObject();
            jbt = (JsonObject) ja.get(i);
            Set<Map.Entry<String, JsonElement>> entrySet = jbt.entrySet();
            for (Map.Entry<String, JsonElement> entry : entrySet) {
                String n = entry.getKey();
                String e = entry.getValue().toString();
//                System.out.println("AK:v: " +e);
//                System.out.println("AK:u: " +e.lastIndexOf("\""));
                startdata(n, e.replace("\"", ""));
                System.out.println("FINE");
                Thread.sleep(1000);
            }

//            startdata();
        }
    }

    private static void startdata(String nameA, String emailA) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JMVAS\\Downloads\\chromedriver_win32\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JMVAS\\Downloads\\chromedriver_win32\\chromedriver.exe");
// Initialize browser
        WebDriver driver = new ChromeDriver();
// Open facebook
//        driver.get("https://partner.cpiperform.co.in/5df0e615b6920d3f1f2d53d4?p1=%7Byour-transaction-id%7D&source=%7Byour-sub-aff-id%7D");
        UUID uuid = UUID.randomUUID();
//        String urlt = "http://jmvas.o18.click/c?o=1607362&m=2314&a=56076&aff_click_id=" + uuid.toString();
        String urlt = "https://partner.cpiperform.co.in/5df0e615b6920d3f1f2d53d4?p1=%7Byour-transaction-id%7D&source=%7Byour-sub-aff-id%7D";
        System.out.println("AK :: " + urlt);
        driver.get(urlt);
// Maximize browser
        driver.manage().window().maximize();
        try {
//        driver.findElement(By.className("si-btn si-btn__primary")).click();
            System.out.println("AAAAAAAAAAAAAAAAAA");
            Thread.sleep(2000);
            driver.findElement(By.className("si-popup__btn")).click();
//            class="si-btn si-btn__one"
            Thread.sleep(1000);
            driver.findElement(By.className("si-votenow__wrap")).click();
            Thread.sleep(1000);
//            driver.findElement(By.className("si-teams__logo")).click();

            for (int k = 1; k <= 10; k++) {
                driver.findElement(By.id("team-" + rndid())).click();
                Thread.sleep(1000);
            }

//            driver.findElement(By.id("team-0")).click();
//            Thread.sleep(1000);
//            driver.findElement(By.className("si-teams__list si-dc")).click();
//            Thread.sleep(1000);
//            driver.findElement(By.className("si-teams__logo")).click();
//            Thread.sleep(1000);
//            driver.findElement(By.className("si-teams__logo")).click();
//
//            Thread.sleep(1000);
//            driver.findElement(By.className("si-teams__logo")).click();
//            Thread.sleep(1000);
//            driver.findElement(By.className("si-teams__logo")).click();
//            Thread.sleep(1000);
//            driver.findElement(By.className("si-teams__logo")).click();
//
//            Thread.sleep(1000);
//            driver.findElement(By.className("si-teams__logo")).click();
//
//            Thread.sleep(1000);
//            driver.findElement(By.className("si-teams__logo")).click();
            Thread.sleep(1000);
            driver.findElement(By.className("si-btn__one")).click();
            Thread.sleep(1000);

            WebElement name = driver.findElement(By.className("si-form__control"));
            Actions actions = new Actions(driver);
            actions.moveToElement(name);
            actions.click();
            actions.sendKeys(nameA);
            actions.build().perform();
            Thread.sleep(1000);
            WebElement s = driver.findElement(By.xpath("//input[@placeholder='Email Id']"));
            s.sendKeys(emailA);
//            WebElement numberV = driver.findElement(By.id("name"));
//            numberV.sendKeys("akash mishra");
//            WebElement loginLink = driver.findElement(By.className("si-input"));
//            Actions actions1 = new Actions(driver);
//            actions1.moveToElement(loginLink);
//            actions1.click();
//            actions1.sendKeys("3333");
//            actions1.build().perform();
            Thread.sleep(1000);

//            WebElement captcha = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[2]/form/div[5]/div"));
//            Actions builder = new Actions(driver);
//            builder.moveToElement(captcha, 50, 30).click().build().perform();

//WebElement iFrame = driver.findElement(By.xpath("xpath_of_reCaptcha_iFrame"));
//driver.switchTo().frame(iFrame);
        } catch (Exception e) {
            System.err.println("EX ::" + e);
        }
    }

    private static int rndid() {
//        int i=0;
        Random r = new Random();
        return r.nextInt((7 - 0) + 1) + 0;
//        return i;
    }

}
