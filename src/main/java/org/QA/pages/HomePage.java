package org.QA.pages;

import org.QA.Objects.CountryPackages;
import org.QA.Objects.Plan;
import org.QA.utils.PackageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class HomePage extends BasePage
{
    public HomePage ()
    {
    }
    //define Elements locator
    private String CountryNameLocator = "country-name";
    private String PackageTypeRowXpath = "//strong[contains(@id, 'name')]";
    private String TypeTagLocator ="strong";
    private String PackagePriceRowXpath = "//div[@class='plan-names']//div[contains(@class, 'price')]";
    private String PriceTagLocator = "b";
    private String CurrencyTagLocator = "i";
    private String CountryPopupIdLocator = "country-wrapper";

    //get country name for the current page
    public String AccessCountryPage(String countryCode)
    {
        String countryName = Driver.findElement(By.id(CountryNameLocator)).getText().trim();
        return countryName;
    }

    // navigate to country page by country code (sa,bh,kw)
    public void navigateToCountry(String countryId) {
        // click on the country button
        CountryButton = Driver.findElement(By.id("country-btn"));
        CountryButton.click();

        // wait until the country popup appear
        DriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CountryPopupIdLocator)));

        // click on the selected country
        WebElement country = Driver.findElement(By.id(countryId));
        country.click();
        //DriverWait.until(ExpectedConditions.elementToBeClickable(By.id("country-btn")));
    }

    // Get packages for the country
    public CountryPackages GetCountryPackages() {
        CountryPackages result = new CountryPackages();
        result.CountryName = Driver.findElement(By.id(CountryNameLocator)).getText().trim();
        result.Plans = GetPlans();
        return  result;
    }

    //get plans for country
    private List<Plan> GetPlans() {
        List<Plan> plans = new ArrayList<Plan>();
        List<WebElement> TypeCells = Driver.findElements(By.xpath(PackageTypeRowXpath));
        List<WebElement> PriceCells = Driver.findElements(By.xpath(PackagePriceRowXpath));
        if (TypeCells.size() != PriceCells.size())
            return plans;
        for (int i=0; i<TypeCells.size();i++)
        {
            plans.add(GetSinglePlan(TypeCells.get(i),PriceCells.get(i)));
        }
        return plans;
    }

    private Plan GetSinglePlan(WebElement typeCell, WebElement priceCell) {
        Plan plan = new Plan();
        plan.Name = PackageHelper.removeUnicodeSymbols(typeCell.getText().trim());
        String price = priceCell.findElement(By.tagName(PriceTagLocator)).getText().trim();
        plan.Price = Double.parseDouble(price);
        String currency_string = priceCell.findElement(By.tagName(CurrencyTagLocator)).getText().trim();
        String [] split_currency = currency_string.split("/");
        plan.Currency = PackageHelper.removeUnicodeSymbols(split_currency[0].trim());
        return plan;
    }
}
