package store;

import com.travellingapp.travel.Flight;
import com.travellingapp.travel.User;
import org.hibernate.SessionFactory;

import java.util.HashSet;
import java.util.Set;

public class Examples {

    private static SessionFactory factory;

    public static void main(String[] args) {
        DataStore dataStore = new PostgresDB();
        Set<Flight> flights = new HashSet<>();
        Flight flight1 = new Flight("KL345","KLM");
        flights.add(flight1);
        //User user1 = new User("Domi", "domidomi",flights);
       // dataStore.save(user1);
       // dataStore.close();
    }
}
