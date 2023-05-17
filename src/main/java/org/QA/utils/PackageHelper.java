package org.QA.utils;

import org.QA.Objects.CountryPackages;
import org.QA.Objects.Plan;

import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class PackageHelper {

    //Verify that the plan lists are equal
    public static boolean areEqual(List<Plan> list1, List<Plan> list2) {
        // If the lists are not the same size, they're not equal
        if (list1.size() != list2.size()) {
            return false;
        }
        // Sort both lists
        list1.sort(Comparator.comparing(P -> P.Name));
        list2.sort(Comparator.comparing(P -> P.Name));

        // Compare the sorted lists item by item
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }


    // Verify that two country packages are equal
    public static boolean areEqual(CountryPackages sourcePackage, CountryPackages resultPackage) {
        //check if at least one package is null
        if (sourcePackage == null || resultPackage == null) {
            return false;
        }
        // check if country name is not equal
        if (!sourcePackage.CountryName.equals(resultPackage.CountryName)) {
            return false;
        }
        //check if the plans is not the same
        if(!areEqual(sourcePackage.Plans,resultPackage.Plans))
            return false;

        return true;
    }

    // remove RTL special charterer for Arabic language
    public static String removeUnicodeSymbols(String input) {
        return input.replaceAll("[\u202B]", "");
    }
}
