package com.sainsburys.test.step_def;

import com.sainsburys.test.page_object.ResultPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FiltersStepDef {
    ResultPage resultPage = new ResultPage();

    @When("^Select price \"([^\"]*)\"$")
    public void select_price(String sortByCondition) {
        resultPage.sortByGivenCondition("Price - Low to High");
    }

    @Then("^I should see products ordered accordingly$")
    public void i_should_see_products_ordered_accordingly() {
        List<Double> actual = resultPage.getAllPrice();
        List<Double> expected = new ArrayList<>(actual);
        Collections.sort(expected);
        assertThat(actual, contains(expected.toArray()));
    }
}
