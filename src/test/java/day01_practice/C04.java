package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class C04 {

    /*Bir testte sadece arama yapilacak veya gorunurluk sorgulanacaksa (cikan urune click yapmamak kaydiyla) before ve after methodlari yerine
            beforeclass ve afterclass methodlari kullanildiginda tek browser'da tum methodlari test etmis oluruz

         */
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
        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        // arama motorunda nutella yazip aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella", Keys.ENTER);

        // sayfada karsınıza cıkan tum urunlere tıklayın ve title'ını yazdırın
        List<WebElement> tümÜrünler =driver.findElements(By.xpath("//h2//span"));
        for (int i = 0; i < tümÜrünler.size() ; i++) {
            tümÜrünler=driver.findElements(By.xpath("//h2//span"));
            tümÜrünler.get(i).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
