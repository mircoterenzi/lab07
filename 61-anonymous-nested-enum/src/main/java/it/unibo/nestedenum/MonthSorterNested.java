package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {
    public enum Month {
        JANUARY(31),
        FEBRUARY(28), 
        MARCH(31), 
        APRIL(30), 
        MAY(31), 
        JUNE(30), 
        JULY(31), 
        AUGUST(31), 
        SEPTEMBER(30),
        OCTOBER(31), 
        NOVEMBER(30), 
        DECEMBER(31);

        private final int days;

        private Month(final int days) {
            this.days = days;
        }

        public static Month fromString(final String name) {
            Objects.requireNonNull(name);
            try {
                return valueOf(name);
            }
            catch (IllegalArgumentException e) {
                Month match = null;
                for (final Month curr : values()) {
                    if (curr.toString().toLowerCase().startsWith(name.toLowerCase())) {
                        if (match != null) {
                            throw new IllegalArgumentException(name + "could match both with " + match + "and" + curr);
                        }
                        match = curr;
                    }
                }
                if (match == null) {
                    throw new IllegalArgumentException("no matching months");
                }
                return match;
            }
        }
    }

    @Override
    public Comparator<String> sortByDays() {
        return new SortByDays();
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new SortByOrder();
    }

    private static class SortByDays implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            final Month m1 = Month.fromString(s1);
            final Month m2 = Month.fromString(s2);
            return Integer.compare(m1.days, m2.days);
        }
    
    }

    private static class SortByOrder implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            return Month.fromString(s1).compareTo(Month.fromString(s2));
        }
        
    }
}

