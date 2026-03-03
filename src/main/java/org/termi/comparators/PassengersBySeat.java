package org.termi.comparators;

import org.termi.Passengers;

import java.util.Comparator;

public class PassengersBySeat implements Comparator<Passengers> {
    @Override
    public int compare(Passengers p1, Passengers p2) {
        return p1.getSeatNumber().compareTo(p2.getSeatNumber());
    }
}
