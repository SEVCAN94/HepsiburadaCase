package Steps;

import Pages.Reviews;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ReviewsSteps {

        Reviews reviews = new Reviews();

        @Given("Enter {} parameter to search box")  //anasayfada arama alanına parametre ekliyor.
        public void fillElement(String word){reviews.fillElement(word, reviews.searchBox);}

        @Given("Click search button")  //arama alanına eklenen parametreyi aratıyor.
        public void clickSearch(){reviews.clickElement(reviews.searchButton);}

        @Given("Click list item called {}")  //arama alanındaki önerilerden birini seçiyor.
        public void clickMenuItem(String itemName){reviews.clickListBoxElement(itemName);}

        @Given("Click product item called {}")  //arama sonucunda listelenen ürünlerden birine tıklayıp detayını açıyor.
        public void clickProductItem(String itemName){reviews.selectProduct(itemName);}


        @Given("Switch Page {}")   //tarayıcıda yeni açılan sekmede işlem yapabilmek için sayfa değiştiriyor.
        public void switchPage(int index) {
                ArrayList<String> newTab = new ArrayList<String>(reviews.driver.getWindowHandles());
                reviews.driver.switchTo().window(newTab.get(index));
        }


        @Given("Hover over navigation tab {}") //ürün detayında belirtilen taba tıklıyor.
        public void clickTab(String tabText){
                List<WebElement> tabItems = reviews.driver.findElements(By.cssSelector("[id='css-tab-buttons'] td a"));
                reviews.clickElement(reviews.loopNMatch(tabItems,tabText));
        }

        @Given("Click Yes icon for first comment")  //ürüne yapılan ilk yorum için evet ikonuna tıklıyor.
        public void clickFirstApproveYes(){
                WebElement yesIcon = reviews.driver.findElement(By.xpath("//*[@id=\"hermes-voltran-comments\"]/div[5]/div[3]/div/div[1]/div[2]/div[4]/div[1]/div/div[1]/div[1]/div"));
                reviews.clickElement(yesIcon);
        }

        @Given("Verify {} text displayed")  //ekranda yazılan yazıyı teyit ediyor.
        public void verifyText(String text){
                WebElement resultText = reviews.driver.findElement(By.cssSelector("[class='hermes-ReviewCard-module-1ZiTv']"));
                reviews.resultVerification(resultText,text);
        }

        @Given("Click sort dropdown")  //ürün detayındaki değerlendirmelerini sıralayan dropbox'a tıklar.
        public void clickSortDropdown(){
                WebElement sortDropdown = reviews.driver.findElement(By.cssSelector("[class='hermes-Sort-module-2IFgj']"));
                reviews.clickElement(sortDropdown);
        }

        @Given("List of dropdown elements:") //ürün detayındaki değerlendirmelerini sıralayan dropbox değerlerini ekrana yazar
        public void displayElements(){

                List<WebElement> elementsList = reviews.driver.findElements(By.cssSelector("[class='hermes-Sort-module-vYQvT hermes-Sort-module-11bSe']"));
                reviews.displayDropdownList(elementsList);

        }
    }


