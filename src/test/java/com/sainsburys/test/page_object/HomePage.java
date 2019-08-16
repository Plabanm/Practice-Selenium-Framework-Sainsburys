package com.sainsburys.test.page_object;

import com.sainsburys.test.driver.Driver_Factory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends Driver_Factory {

    public static String searchProduct;

    @FindBy(name = "searchTerm")
    private WebElement searchBox;

    @FindBy(name = "searchSubmit")
    private WebElement submitButton;

    public void doSearch(String item){
        searchProduct = item;
        searchBox.sendKeys(item);
        submitButton.click();

    }

    public String getGroceryPageUrl(){
        return driver.getCurrentUrl();
    }


}
