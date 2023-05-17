package org.QA.Objects;

import java.util.ArrayList;
import java.util.List;

public class CountryPackages {
    public String CountryName ="";
    public String CountryCode = "";
    public List<Plan> Plans = new ArrayList<Plan>();
    public CountryPackages()
    {

    }
    public CountryPackages(String countryName, String countryCode, List<Plan> plans)
    {
        CountryName = countryName;
        CountryCode = countryCode;
        Plans = plans;
    }

}
