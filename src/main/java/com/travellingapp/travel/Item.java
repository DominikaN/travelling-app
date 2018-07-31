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
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "itemName")
    private String itemName;
    @Column(name = "number_of_items")
    private int numberOfItems;
    @Column(name = "is_available")
    private boolean isAvailable;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "user_item",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")})
    private Set<User> users = new HashSet<>();


    public Item(String itemName, int numberOfItems, boolean isAvailable) {
        this.itemName = itemName;
        this.numberOfItems = numberOfItems;
        this.isAvailable = isAvailable;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return "Item {itemName ='" + itemName + '\'' + ", numberOfItems=" + numberOfItems + ", isAvailable=" + isAvailable +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        if (getId() != item.getId()) return false;
        if (getNumberOfItems() != item.getNumberOfItems()) return false;
        if (isAvailable() != item.isAvailable()) return false;
        return getItemName().equals(item.getItemName());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getItemName().hashCode();
        result = 31 * result + getNumberOfItems();
        result = 31 * result + (isAvailable() ? 1 : 0);
        return result;
    }
}
