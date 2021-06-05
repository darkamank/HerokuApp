import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class Hovers extends Base{

    @Test
    public void checkAllUsers(){
        for(int i = 1; i<4; i++){
            checkUsers(i);
        }
    }
    public void checkUsers(int numberUser){
        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions profile = new Actions(driver);
        List<WebElement> elements = driver.findElements(By.className("figure"));
        profile.moveToElement(elements.get(numberUser - 1)).click().build().perform();
     String name1 = driver.findElement(By.xpath("//div['avatar']/div/h5")).getText().split(" ")[1];
       Assert.assertEquals(name1,"user"+numberUser, "Name displayed incorrectly");
        driver.findElement(By.linkText("View profile")).click();
        boolean isError = driver.getPageSource().contains("Not Found");
        Assert.assertTrue(isError,"Page isn't found");


    }
}
