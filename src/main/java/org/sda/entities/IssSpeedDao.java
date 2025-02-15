package org.sda.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "iss_speed")
public class IssSpeedDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "timestamp")
    private Long timestamp;

    @Column(name = "speed")
    private Double speed;


    public IssSpeedDao(Long timestamp, Double speed) {
        this.timestamp = timestamp;
        this.speed = speed;
    }

    public IssSpeedDao() {
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

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }
}
