package org.sda.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "iss_position")
public class IssDataDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "timestamp")
    private Long timestamp;

    @Column(name = "longitude")
    private Double longitute;

    @Column(name = "latitude")
    private Double latitude;

    public IssDataDao(IssData data){
        this.timestamp = data.getTimestamp();
        this.latitude = Double.parseDouble(data.getIssPosition().getLatitude());
        this.longitute = Double.parseDouble(data.getIssPosition().getLongitude());
    }


}
