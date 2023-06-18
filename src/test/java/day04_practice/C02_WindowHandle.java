package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

public class C02_WindowHandle extends TestBase {

    @Test
    public void test01() {
        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        String amazonHandle = driver.getWindowHandle();

        // 2- url'in 'amazon' icerdigini test edelim
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestbuyHandle = driver.getWindowHandle();

        // 4- title'in 'Best Buy' icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));

        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(amazonHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

        // 6- arama sonuclarının 'Java' icerdigini test edelim
        String result = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText();
        Assert.assertTrue(result.contains("Java"));

        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(bestbuyHandle);

        // 8- logonun gorundugunu test edelim
        WebElement logo = driver.findElement(By.xpath("(//img)[1]"));
        Assert.assertTrue(logo.isDisplayed());

    }
}
