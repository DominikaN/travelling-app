package store;

import com.travellingapp.travel.User;

public interface DataStore {
    Long save(User userToSave);
    void close();
}
