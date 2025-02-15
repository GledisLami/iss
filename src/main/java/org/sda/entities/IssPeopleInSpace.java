package org.sda.entities;

import java.util.List;

public class IssPeopleInSpace {
    private List<IssPeopleDetails> people;

    private int number;

    private String message;

    public IssPeopleInSpace(List<IssPeopleDetails> people, int number, String message) {
        this.people = people;
        this.number = number;
        this.message = message;
    }

    public IssPeopleInSpace() {
    }

    public List<IssPeopleDetails> getPeople() {
        return people;
    }

    public void setPeople(List<IssPeopleDetails> people) {
        this.people = people;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
