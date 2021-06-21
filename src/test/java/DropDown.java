import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDown extends BaseTest{

    @Test
    public void setValue (){
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select dropDown = new Select(driver.findElement(By.id("dropdown")));
        dropDown.selectByValue("1");
        String nameFirstElement = dropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(nameFirstElement,"Option 1", "The first element didn't select");
        dropDown.selectByValue("2");
        String nameSecondElement = dropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(nameSecondElement,"Option 2", "The second element didn't select");
    }
}
