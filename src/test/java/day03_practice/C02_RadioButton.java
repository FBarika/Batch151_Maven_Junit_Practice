package day03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C02_RadioButton {
    /*
    RadioButton ==> Birden fazla haneye tik atilamaz.
    */

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--lang=en");
        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {

        // https://demo.guru99.com/test/radio.html adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");

        //iframe daha görmedik
        // İframe'e geçiş yapma
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gdpr-consent-notice']"));
        driver.switchTo().frame(iframe);
        //Cerezleri kapatma
        driver.findElement(By.xpath("(//div[@class='action-wrapper'])[3]")).click();
        // Ana sayfaya geri dönme
        driver.switchTo().defaultContent();



        // radiobutton elementlerini locate edin
        WebElement radioButton1 = driver.findElement(By.id("vfb-7-1"));
        WebElement radioButton2 = driver.findElement(By.id("vfb-7-2"));
        WebElement radioButton3 = driver.findElement(By.id("vfb-7-3"));


        // option2'yi secin
        radioButton2.click();

        // option2 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(radioButton2.isSelected());

        // option1 elementlerinin secili olmadıgını test edin
        Assert.assertFalse(radioButton1.isSelected());

        // option3 elementlerinin secili olmadıgını test edin
        Assert.assertFalse(radioButton3.isSelected());
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
