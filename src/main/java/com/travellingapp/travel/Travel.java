package com.travellingapp.travel;

import java.util.List;

public class Travel {

    private List<User> users;
    private List<Flight> flights;
    private List<Item> items;

    public Travel(List<User> users, List<Flight> flights, List<Item> items) {
        this.users = users;
        this.flights = flights;
        this.items = items;
    }

    public void addUser(User user) {
        if (!existUser(user)) {
            users.add(user);
        } else {
            System.out.println("There is an user wth a nickname: " + user.getNickname() + " in your list of users");
        }
    }

    boolean existUser(User user) {
        return users.contains(user);
    }

    public void removeUser(User user) {
        if (existUser(user)) {
            users.remove(user);
        } else {
            System.out.println("There is no such user with a nickname: " + user.getNickname());
        }
    }

    public void addFlight(Flight flight) {
        if (!existFlight(flight)) {
            flights.add(flight);
        } else {
            System.out.println("There is a flight: " + flight.getFlightNumber() + " in your list of flights");
        }
    }

    boolean existFlight(Flight flight){
        return flights.contains(flight);
    }

    public void removeFlight(Flight flight) {
        if (existFlight(flight)) {
            flights.remove(flight);
        } else {
            System.out.println("There is no such flight: " + flight.getFlightNumber());
        }
    }

    public void addItem(Item item) {
        if (!items.contains(item)) {
            items.add(item);
        } else {
            System.out.println("There is " + item.getItemName() + " already in your list");
        }
    }

    public void removeItem(Item item) {
        if (items.contains(item)) {
            items.remove(item);
        } else {
            System.out.println("There is no such item of list " + item.getItemName());
        }
    }

    boolean existItem(Item item){
        return items.contains(item);
    }
}
