package itmo.java.comparators;


import itmo.java.data.Movie;

import java.util.Comparator;

//compares Movie by length of it
public class MovieComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return o1.compareTo(o2);
    }
}
