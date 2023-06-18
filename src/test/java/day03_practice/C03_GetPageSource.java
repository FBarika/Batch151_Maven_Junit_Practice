package day03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C03_GetPageSource {

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
        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com");

        // Kaynak Kodlarini konsola yazdiriniz
        System.out.println(driver.getPageSource());

        // Kaynak Kodlarinda "Gateway" yazdigini test edin
        Assert.assertTrue(driver.getPageSource().contains("Gateway"));
    }

    @After
    public void tearDown() throws Exception {
       // driver.close();
    }
}
