import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class Hovers extends BaseTest{

//    @Test
//    public void checkAllUsers(){
//        for(int i = 1; i<4; i++){
//            checkUsers(i);
//        }
//    }
    @Test
    public void checkUsers(){
        driver.get("http://the-internet.herokuapp.com/hovers");
        List<WebElement> elements = driver.findElements(By.className("figure"));
        Actions profile = new Actions(driver);
        profile.moveToElement(elements.get(0)).click().build().perform();
        String name1 = driver.findElement(By.xpath("//div['avatar']/div/h5")).getText();
        Assert.assertEquals(name1,"name: user1", "Name displayed incorrectly");
//profile.moveToElement(elements.get(1)).build().perform();
        driver.findElement(By.linkText("View profile")).click();
        boolean isError = driver.getPageSource().contains("Not Found");
        Assert.assertTrue(isError,"Page isn't found");

    }
}
