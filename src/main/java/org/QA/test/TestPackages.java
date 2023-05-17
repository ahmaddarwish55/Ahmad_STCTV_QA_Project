package org.QA.test;

import org.QA.Objects.CountryPackages;
import org.QA.Objects.Plan;
import org.QA.pages.HomePage;
import org.QA.utils.Config;
import org.QA.utils.PackageHelper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestPackages {
    HomePage homePage;

    //initialize Home page and web driver
    @BeforeClass
    public void setUp() {
       homePage = new HomePage();
    }

    @DataProvider(name = "testData") //get test date to assert the package for all countries
    public Object[][] dataProviderMethod() throws IOException {
        // Read package from json file according to selected language, you can change language (en, ar) from /resources/config.properties
        ObjectMapper mapper = new ObjectMapper();
        List<CountryPackages> list = mapper.readValue(new File(Config.getDataFile()), new TypeReference<List<CountryPackages>>(){});
        //Prepare input data
        Object[][] data = new Object[list.size()][1];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i);
        }
        System.out.println("Number of test cases: " + data.length);
        return data;
    }

    // validate the packages for all countries
    @Test(dataProvider = "testData")
    public  void ValidatePackages(CountryPackages countryPackages)
    {
        // Navigate to the home page
        homePage.GoTo();
        // Navigate to the country
        homePage.navigateToCountry(countryPackages.CountryCode);
        //Assert that the country page is accessible and it is the right country name
        Assert.assertEquals(homePage.AccessCountryPage(countryPackages.CountryCode),countryPackages.CountryName ,String.format(" Page for country %s is not accessible", countryPackages.CountryName));
        // Extract packages (Name, Price, Currency) for the country
        CountryPackages Result = homePage.GetCountryPackages();
        // Assert that extracted packages equals the input data
        Assert.assertTrue(PackageHelper.areEqual(countryPackages,Result),String.format(" Packages for country %s is not correct", countryPackages.CountryName));
    }

    // Quit web driver
    @AfterClass
    public void tearDown() {
        homePage.Driver.quit();
    }

}
