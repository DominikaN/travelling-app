package com.travellingapp.travel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "transport")
public class Transport {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "transport_type")
    private String transportType;
    @Column(name = "transport_price")
    private double transportPrice;
    @Column(name = "transport_destination")
    private String transportDestination;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "user_transport",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "travel_id")})
    private Set<User> users = new HashSet<>();

    public Transport(String transportType, double transportPrice, String transportDestination) {
        this.transportPrice = transportPrice;
        this.transportType = transportType;
        this.transportDestination = transportDestination;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTransportDestination() {
        return transportDestination;
    }

    public void setTransportDestination(String transportDestination) {
        this.transportDestination = transportDestination;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public void setTransportPrice(double transportPrice) {
        this.transportPrice = transportPrice;
    }

    public String getTransportType() {
        return transportType;
    }

    public double getTransportPrice() {
        return transportPrice;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", transportType='" + transportType + '\'' +
                ", transportPrice=" + transportPrice +
                ", transportDestination='" + transportDestination + '\'' +
                '}';
    }
}
