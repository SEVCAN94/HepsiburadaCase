package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utilities;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class Reviews extends Utilities{


        @FindBy(css = "[id='SearchBoxOld'] div [type='text']")
        public WebElement searchBox;  //Anasayfadaki arama alanı

        @FindBy(css = "[class='SearchBoxOld-root'] [class='SearchBoxOld-buttonContainer']")
        public WebElement searchButton;  //Anasayfadaki arama butonu

        @FindBy(css = "[id*='react-autowhatever-1--item']")
        public List<WebElement> listElements;  //Anasayfa arama sonucu öneri listesi
        
        @FindBy(css= "[class='productListContent-item']  h3")
        public List<WebElement> listProducts;  //Arama sonucunda listelenen ürünlerin başlıkları

        @FindBy(css = "section[id='css-tab-buttons'] td a")
        public List<WebElement> listTabs;  // Ürün detayında yer alan ürün ile ilgili bilgilerin yer aldığı tablar


//clickListBoxElement methodu arama çubuğuna yazılıp aratılan ve bunun sonucunda listelenen öneriler içinden seçim yapmayı sağlayan
// bir method. Öneri listesindeki hangi değerin seçileceği feature dosyasında belirtiliyor.
    public void clickListBoxElement(String itemName) {
        for (WebElement listElement : listElements) {
            if (listElement.getText().equalsIgnoreCase(itemName)) {
                clickElement(listElement);
                return;
            }
        }
        Assert.fail("No menu item called "+itemName+ " could be located on the search box list.");
    }

//selectProduct methodu arama sonucunda listelenen ürünlerin olduğu sayfada belirtilen ürünü seçiyor. Hangi ürünün seçileceği
// feature dosyasında belirtiliyor.
    public void selectProduct(String itemName) {
        for (WebElement listProduct : listProducts) {
            if (listProduct.getText().equalsIgnoreCase(itemName)) {
                clickElement(listProduct);
                return;
            }
        }
        Assert.fail("No menu item called "+itemName+ " could be located on the product list page.");
    }

    //selectTab methodu ürün detayındaki tablardan belirtilen tabı seçiyor. Hangi tabın seçileceği feature
//  dosyasında belirtiliyor.
    public void selectTab(String itemName) {
        for (WebElement listTab : listTabs) {
            System.out.println(listTab.getText());
            if (listTab.getText().equalsIgnoreCase(itemName)) {
                clickElement(listTab);
                return;
            }
        }
        Assert.fail("No tab item called "+itemName+ " could be located on the product detail page.");
    }

    //displayDropdownList methodu ürün detayındaki değerlendirmeleri sıralama yöntemlerininin yer aldığı dropbox listesinde
    //yer alan değerleri ekrana yazdırıyor.
    public void displayDropdownList(List<WebElement> listElements) {

        List<WebElement> options = driver.findElements(By.cssSelector("[class='hermes-Sort-module-vYQvT hermes-Sort-module-2npZQ']"));
        List<String> text = new ArrayList<>();
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());

        }

    }

}


