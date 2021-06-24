import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IFrame extends BaseTest{
    @Test
    public void getTextIFrame(){
        driver.get("http://the-internet.herokuapp.com/frames");
        driver.findElement(By.xpath("//a[@href='/iframe']")).click();
        driver.switchTo().frame("mce_0_ifr");
        String textFromFrame = driver.findElement(By.id("tinymce")).getText();
        Assert.assertEquals(textFromFrame,"Your content goes here.","Frame contains another text");
    }
}
