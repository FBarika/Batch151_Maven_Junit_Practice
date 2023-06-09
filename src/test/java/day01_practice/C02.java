package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @Test
    public void test01() {
        // https://www.techproeducation.com/ sayfasina gidin
        driver.get("https://www.techproeducation.com");

        // Title ve Url'ini alın ve yazdırın
        String techproeducationTitle = driver.getTitle();
        System.out.println("techproeducationTitle = " + techproeducationTitle);
        String techproeducationUrl = driver.getCurrentUrl();
        System.out.println("techproeducationUrl = " + techproeducationUrl);

        // Title'in "Techpro" kelimesini içerip içermedigini test edin
        Assert.assertTrue(techproeducationTitle.contains("Techpro"));

        // Url'in "techproeducation" kelimesini içerip içermedigini test edin
        Assert.assertTrue(techproeducationUrl.contains("techproeducation"));

        // https://www.amazon.com/ sayfasına gidin
        driver.get("https://www.amazon.com");

        // Title'ini alın ve yazdırın
        String amazonTitle = driver.getTitle();
        System.out.println("amazonTitle = " + amazonTitle);

        // Title'in "more" kelimesini içerip içermedigini test edin
        Assert.assertTrue("CÜNKÜ TITLE BARIKA ICERMIYOR MESAJ VEREBILIYORUZ BU SEKILDE" , amazonTitle.contains("barika"));

        // techproeducation.com'a geri dönün
        driver.navigate().back();

        // sayfayı yenileyin
        driver.navigate().refresh();

        // amazon.com'a tekrar gelin
        driver.navigate().forward();
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
