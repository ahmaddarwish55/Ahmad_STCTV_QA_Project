package org.QA.Objects;


import java.util.Currency;

public class Plan {
    public String Name ="";
    public double Price = 0;
    public String Currency ="";

    public Plan(){

    }

    public Plan(String name, double price, String currency)
    {
        Name = name;
        Price = price;
        Currency = currency;
    }

    @Override
    public boolean equals(Object obj) {
        // Check if the other object is a Package
        if (!(obj instanceof Plan)) {
            return false;
        }

        // Cast the other object to Package
        Plan other = (Plan) obj;

        // Compare the fields. Depending on your requirements, you might want to
        // use a small tolerance for comparing the prices, since they're doubles.
        return Name.equals(other.Name) && Price == other.Price && Currency.equals(other.Currency);
    }
}
