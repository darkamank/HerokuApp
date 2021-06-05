import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddRemoveElement extends Base {
    @Test
    public void addAndRemoveElements(){

        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement buttonAdd = driver.findElement(By.cssSelector("[onclick= 'addElement()']"));
        buttonAdd.click();
        buttonAdd.click();
        List<WebElement> element = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        Assert.assertEquals(element.size(),2,"Не добавлен второй элемент");
        element.get(1).click();
        element = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        Assert.assertEquals(element.size(),1,"Элементов больше чем 2");
    }
}
