package com.sainsburys.test;

import com.sainsburys.test.driver.Driver_Factory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.Scenario;


public class Hooks {


    Driver_Factory driverFactory = new Driver_Factory();
    private String url = "https://www.sainsburys.co.uk/shop/gb/groceries";

    @Before
    public void setUp(){
        //driverFactory.runOnLocalHost();
        driverFactory.runOnRemoteHost();
        driverFactory.goToUrl(url);
        System.out.println("loading: "+ url);
        driverFactory.maxiBrowser();
        driverFactory.impWait();
        driverFactory.handleCookeis();

    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            driverFactory.embedScreenShot(scenario);
        }

        driverFactory.closeBrowser();

    }
}
