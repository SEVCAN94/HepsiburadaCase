package utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.driver.Driver;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Properties;

public class Utilities extends Driver {

    public void navigate(String url) {
        driver.get(url);
    }

    public Utilities(){PageFactory.initElements(driver,this);}  //constructor

    public void predeterminedNavigate(String pageName) {
        Properties properties = new Properties();
        String url;
        try{
            properties.load(new FileReader("src/main/resources/test.properties"));
            url = properties.getProperty("url."+pageName);
        }
        catch (IOException exception){return;}
        driver.get(url);
    }

    public void waitFor(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException ignored) {
        }
    }

    //centerElement methodu belirtilen element sayfanın ortasına gelecek şekilde scroll yapmamızı sağlar.
    public WebElement centerElement(WebElement element) {
        String script =
                "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0 );"
                        + "var elementTop = arguments[0].getBoundingClientRect().top;"
                        + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) driver).executeScript(script, element);
        return element;
    }

    //clickElement methodu belirtilen elementi sayfa ortasına alıp tıklama işlemi yapar.
    public void clickElement(WebElement element){centerElement(element).click();}

    //fillElement gelen input'u, input elemente gönderir.
    public void fillElement(String input, WebElement inputElement){inputElement.sendKeys(input);}

    //loopNMatch listeye aldığı elementlerin text değerlerini alır, bunları ile input olarak aldığı değer ile karşılaştırır.
    //Karşılaştırma eşit olursa bu webelement'i döner.
    public WebElement loopNMatch(List<WebElement> elementList, String itemText){
        for(WebElement item:elementList){
            if(item.getText().equalsIgnoreCase(itemText) || item.getText().contains(itemText))
                return item;
        }
        Assert.fail("Item could not be located!");
        return null;
    }

    //resultVerification  ekranda yazan değer ile istenen değer eşit mi kontrol ediyor.
    public void resultVerification(WebElement resultText, String expectedResult){
        if(resultText.getText().contains(expectedResult))
            System.out.println("Searched word found");

        else
            Assert.fail("No search item called "+expectedResult+" could be located on the search field.");
    }


}
