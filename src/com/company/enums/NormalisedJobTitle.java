package com.company.enums;

public enum NormalisedJobTitle {
    ARCHITECT("Architect"),
    SOFTWARE_ENGINEER("Software engineer"),
    QUANTITY_SURVEYOR("Quantity surveyor"),
    ACCOUNTANT("Accountant");

    private final String title;

    NormalisedJobTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
