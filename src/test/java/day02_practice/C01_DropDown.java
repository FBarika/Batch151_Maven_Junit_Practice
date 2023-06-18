package day02_practice;

import com.sun.source.tree.AssertTree;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropDown {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--lang=en");
        driver= new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() {


        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com");

        // dropdown'dan "Books" secenegini secin

        //1-Dropdown locate edilir
        WebElement ddm= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //2-Select objesi olusturulur
        Select select = new Select(ddm);

        //3-Opsiyonlardan bir tanesi secilir.
        select.selectByVisibleText("Books");
        //select.selectByIndex(5);
        //select.selectByValue("search-alias=stripbooks-intl-ship");

        // arama cubuguna "Java" aratın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

        // arama sonuclarinin Java icerdigini test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));

        Assert.assertTrue(sonucYazisi.getText().contains("Java"));



    }



    @After
    public void tearDown() throws Exception {
        //driver.close();
    }
}
