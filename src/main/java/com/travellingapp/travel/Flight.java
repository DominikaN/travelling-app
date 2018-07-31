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
@Table(name = "Flight")
public class Flight {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "flight_number")
    private String flightNumber;
    @Column(name = "airlines")
    private String airlines;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "user_flight",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "flight_id")})
    private Set<User> users = new HashSet<>();

    public Flight(String flightNumber, String airlines) {
        this.flightNumber = flightNumber;
        this.airlines = airlines;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getAirlines() {
        return airlines;
    }

    public Set<User> getUsers() {
        return users;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;

        Flight flight = (Flight) o;

        if (id != flight.id) return false;
        if (!getFlightNumber().equals(flight.getFlightNumber())) return false;
        return getAirlines().equals(flight.getAirlines());
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + getFlightNumber().hashCode();
        result = 31 * result + getAirlines().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Flight = [flightNumber = " + flightNumber + " , airlines = " + airlines + " ]";
    }
}


