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

public class C01_CheckBox {
    /*
    Checkbox ==> Birden fazla haneye tik atilabilir.
    CheckBox'larda birden fazla secenegi isaretleyebilirken radio butonlarinda sadece bir secenegi isaretleyebiliriz
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


        // checkbox elementlerini locate edin
        WebElement checkBox1 = driver.findElement(By.id("vfb-6-0"));
        WebElement checkBox2 = driver.findElement(By.id("vfb-6-1"));
        WebElement checkBox3 = driver.findElement(By.id("vfb-6-2"));




        // checkbox1 ve checkbox3  secili degil ise secin
        if(!checkBox1.isSelected()){
            checkBox1.click();
        }

        if(!checkBox3.isSelected()){
            checkBox3.click();
        }

        // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(checkBox1.isSelected());
        Assert.assertTrue(checkBox3.isSelected());

        // checkbox2 elementinin secili olmadıgını test edin
        Assert.assertFalse(checkBox2.isSelected());


    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
