package container;

import java.util.*;

/**
 * This program sorts a set of item by comparing their descriptions.
 * @version 0.1 2019-03-09
 * @author Leson
 */

public class TreeSetTest {
    public static void main(String[] args){
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget",4562));
        parts.add(new Item("Modem",9912));
        System.out.println(parts);

        NavigableSet<Item> sortByDescription = new TreeSet<>(
                Comparator.comparing(Item::getDescription)
        );

        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}
