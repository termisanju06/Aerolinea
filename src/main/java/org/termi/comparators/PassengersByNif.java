package org.termi.comparators;

import org.termi.Passengers;

import java.util.Comparator;

public class PassengersByNif implements Comparator<Passengers> {
    @Override
    public int compare(Passengers p1, Passengers p2) {
        return p1.getNif().compareTo(p2.getNif());
    }
}

