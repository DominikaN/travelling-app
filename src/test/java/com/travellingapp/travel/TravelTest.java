package com.travellingapp.travel;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TravelTest {

    private Travel travel;

    @Test
    public void shouldAddFlight() {
        // given
        travel = new Travel(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Flight flight1 = new Flight("KLM2345", "KLM");
        flight1.setId(1L);

        // when
        travel.addFlight(flight1);

        // then
        assertTrue(travel.existFlight(flight1));
    }


    @Test
    public void shouldRemoveFlight() {
        //given
        Flight flight1 = new Flight("KLM2345", "KLM");
        flight1.setId(1L);
        Flight flight2 = new Flight ("LH6195", "Lufthansa");
        flight2.setId(2L);

        List<Flight> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);

        travel = new Travel(new ArrayList<>(), flights, new ArrayList<>());

        //when
        travel.removeFlight(flight2);

        //then
        assertTrue(travel.existFlight(flight1));
        assertFalse(travel.existFlight(flight2));
    }

    @Test
    public void shouldAddItem() {
        //given
        travel = new Travel(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Item item1 = new Item("Tshirt", 7, true);
        item1.setId(3L);

        //when
        travel.addItem(item1);

        //then
        assertTrue(travel.existItem(item1));
    }

    @Test
    public void shouldRemoveItem() {
        //given
        Item item1 = new Item("Tshirt", 7, true);
        item1.setId(3L);
        Item item2 = new Item("Dresses", 3, false);
        item1.setId(4L);

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        travel = new Travel(new ArrayList<>(), new ArrayList<>(), items);

        //when
        travel.removeItem(item1);

        //then
        assertTrue(travel.existItem(item2));
        assertFalse(travel.existItem(item1));

    }

    @Test
    public void shouldAddUser(){
        //given
        travel = new Travel(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user1 = new User("Aleksandra", "Ola");
        user1.setId(6L);

        //when
        travel.addUser(user1);

        //then
        assertTrue(travel.existUser(user1));
    }

    @Test
    public void shouldRemoveUser(){
        //given
        User user1 = new User("Aleksandra", "Ola");
        user1.setId(6L);
        User user2 = new User("Tomasz", "Tomek");
        user2.setId(7L);
        User user3 = new User("Jan", "Jasiek");
        user3.setId(8L);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        travel = new Travel (users, new ArrayList<>(), new ArrayList<>());

        //when
        travel.removeUser(user2);

        //then
        assertTrue(travel.existUser(user1));
        assertTrue(travel.existUser(user3));
        assertFalse(travel.existUser(user2));

    }
}
