package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public abstract class TestBase {

    //abstract yapmamiz sebebi obje olusturmayacagimiz icin depo olarak kullanacagimiz icin absatarct yaptik.


        /*
        TestBase class'indan obje olusturmanin önüne gecmek icin bu classi abstract yapabiliriz.
        TestBase testbase = new TestBase(); yani bu sekilde obje olusturmanin önüne gecmis oluruz.
        Bu class'a extends yaptigimiz test class'larindan ulasabiliriz.
         */
        protected WebDriver driver;// burasi default olursa test classlarimizda kullanamayiz bu yüzden protected yapmamiz yeterli olur public de olur
        //protected yeterli olacagindan bunu yaptik.

        @Before
        public void setUp() throws Exception {
            WebDriverManager.chromedriver().setup();
            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("--lang=en");
            driver = new ChromeDriver(opt);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        @After
        public void tearDown() throws Exception {
            // driver.quit(); tüm pencereleri kapatir.
            //driver.close(); acilan tek pencereyi kapatir.
        }

        //HARD WAIT( Bekleme Methodu)
        public void bekle(int saniye) {
            try {
                Thread.sleep(saniye * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        //AcceptAlert
        public void acceptAlert() {
            driver.switchTo().alert().accept();
        }

        //DismissAlert
        public void dismissAlert() {
            driver.switchTo().alert().dismiss();
        }

        //getTextAlert
        public String getTextAlert() {
            return driver.switchTo().alert().getText();
        }

        //sendKeysAlert
        public void sendKeysAlert(String text) {
            driver.switchTo().alert().sendKeys(text);
        }

        //Dropdown Visibletext
        public void selectVisibleText(WebElement ddm, String text) {

            Select select = new Select(ddm);
            select.selectByVisibleText(text);
        }

        //Dropdown Index
        public void selectIndex(WebElement ddm, int index) {

            Select select = new Select(ddm);
            select.selectByIndex(index);
        }

        //Dropdown Value
        public void selectValue(WebElement ddm, String value) {

            Select select = new Select(ddm);
            select.selectByValue(value);
        }


    }

