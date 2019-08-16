package com.sainsburys.test.step_def;

import com.sainsburys.test.page_object.HomePage;
import com.sainsburys.test.page_object.ResultPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;

public class SearchStepDef {

    private HomePage homePage = new HomePage();
    private ResultPage resultPage = new ResultPage();

    @Given("^I am on sainsburys gorcery site$")
    public void i_am_on_sainsburys_gorcery_site(){
        String actual = homePage.getGroceryPageUrl();
        assertThat("checking user on Grocery Page", actual, Matchers.endsWith("groceries"));
    }

    @When("^I search for product \"([^\"]*)\"$")
    public void i_search_for_product(String item){
        homePage.doSearch(item);

    }

    @Then("^I should be able to see respective products result$")
    public void i_should_be_able_to_see_respective_products_result(){
        String actual = resultPage.getSearchTitle();
        assertThat("",actual, Matchers.endsWith("‘"+HomePage.searchProduct+"’"));

    }
}
