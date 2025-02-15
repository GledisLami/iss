package org.sda.entities;

public class IssPeopleDetails {
    private String craft;

    private String name;

    public IssPeopleDetails(String craft, String name) {
        this.craft = craft;
        this.name = name;
    }

    public IssPeopleDetails() {
    }

    public String getCraft() {
        return craft;
    }

    public void setCraft(String craft) {
        this.craft = craft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
