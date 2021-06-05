import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortableDataTables extends Base{

    @Test
    public void checkFirstTable(){
        driver.get("http://the-internet.herokuapp.com/tables");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[1]/td[1]"));
        Assert.assertEquals(element.getText(),"Smith","The values didn't match");
        element = driver.findElement(By.xpath("//table//tr[3]//td[5]"));
        Assert.assertEquals(element.getText(),"http://www.jdoe.com","The values didn't match");
        element = driver.findElement(By.xpath("//table//tr[2]//td[4]"));
        Assert.assertEquals(element.getText(),"$51.00","The values didn't match");
    }
}
