package itmo.java.commands;



import itmo.java.IO.Printor;
import itmo.java.data.Movie;
import itmo.java.data.MovieGenre;
import itmo.java.data.MyPriorityQueue;

import java.util.Locale;

public class FilterByGenreCommand implements Command {
    private final Printor printor;
    private final MyPriorityQueue<Movie> collection;
    private final String genre;

    public FilterByGenreCommand(MyPriorityQueue<Movie> collection, Printor printor, String genre) {
        this.printor = printor;
        this.collection = collection;
        this.genre = genre;
    }

    @Override
    public void execute() throws Exception {
        printor.println("Элементы у которых жанр " + genre);
        int num = 0;
        for (Movie movie : collection) {
            if (movie.getGenre().equals(MovieGenre.valueOf(genre.trim().toUpperCase(Locale.ROOT)))) {
                printor.println(movie.toString());
                num++;
            }
        }
        printor.println("Всего: " + num);
    }
}

