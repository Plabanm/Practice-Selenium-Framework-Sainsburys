package com.sainsburys.test.page_object;

import com.sainsburys.test.driver.Driver_Factory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ResultPage extends Driver_Factory {


    @FindBy(className = "resultsHeading")
    private WebElement searchTerm;

    public String getSearchTitle(){
        return searchTerm.getText();

    }

    @FindBy(css = "#orderBy")
    private WebElement sortBy;

    public void sortByGivenCondition(String sortByCondition){
        Select orderBy = new Select(sortBy);
        orderBy.selectByVisibleText(sortByCondition);
    }

    @FindBy(xpath = "//ul[@class='productLister gridView']/li/div/div[3]/div/div/div/div/p")
    private List<WebElement> itemPrices;

    public List<Double> getAllPrice(){
        List<Double> priceList = new ArrayList<>();

        for (WebElement itemprice:itemPrices) {
            String princeInString = itemprice.getText();
            String newPrinceInString = princeInString.replaceAll("[^0-9.]", "");
            Double priceInDouble = Double.parseDouble(newPrinceInString);
            priceList.add(priceInDouble);
        }

        return priceList;
    }



}
