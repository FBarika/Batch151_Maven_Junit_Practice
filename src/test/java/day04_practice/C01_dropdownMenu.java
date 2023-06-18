package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_dropdownMenu extends TestBase {


    @Test
    public void test01() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        // dropdown'dan "Books" secenegini secin
        //dropdown 3 adimda handle edilir
        //1- dropdown locate edilmeli
        WebElement ddm = driver.findElement(By.xpath("//select"));

        //2-select objesi olusturulur.
        Select select = new Select(ddm);

        //3-optionlardan bir tanesi secilir.
        //select.selectByVisibleText("Books");
        //select.selectByIndex(5);
        select.selectByValue("search-alias=stripbooks-intl-ship");


        // arama cubuguna "Java" aratın
        WebElement java = driver.findElement(By.id("twotabsearchtextbox"));
        java.sendKeys("Java", Keys.ENTER);

        // arama sonuclarinin Java icerdigini test edin.
        String result = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText();
        Assert.assertTrue(result.contains("Java"));
    }
}
