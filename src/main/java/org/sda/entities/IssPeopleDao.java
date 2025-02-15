package org.sda.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "iss_people")
public class IssPeopleDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "timestamp")
    private Long timestamp;

    @Column(name = "number")
    private int number;

    public IssPeopleDao(int number) {
        this.timestamp = System.currentTimeMillis() / 1000;
        this.number = number;
    }

    public IssPeopleDao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
