package org.brixen.example.priceline;

public enum PriceLinePageTab {
    HOTELS("Hotels"),
    FLIGHTS("Flights"),
    CARS("Cars"),
    VACATION_PACKAGES("Vacation Packages"),
    CRUISES("Cruises"),
    MORE("More");

    private final String alias;
    
    PriceLinePageTab(String alias) {
        this.alias = alias;
    }
    
    public String getAlias() {
        return alias;
    }
}
