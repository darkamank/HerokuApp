import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationMessages extends BaseTest {

    @Test
    public void checkNotification(){
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        WebElement button = driver.findElement(By.xpath("//a[text()='Click here']"));
        button.click();
        String flashNotice = driver.findElement(By.xpath("//div[@class='flash notice']")).getText();
     //   System.out.println(flashNotice);
        Assert.assertEquals(flashNotice,"Action successful"+"\n"+"×","Action unsuccessful");
    }
}
