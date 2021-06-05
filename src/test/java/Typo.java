import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Typo extends Base{

    @Test
    public void checkTypo(){
        driver.get("http://the-internet.herokuapp.com/typos");
        List<WebElement> typo = driver.findElements(By.tagName("p"));
        Assert.assertEquals(typo.get(1).getText(),"Sometimes you'll see a typo, other times you won't.", "Has a typo");

    }
}
