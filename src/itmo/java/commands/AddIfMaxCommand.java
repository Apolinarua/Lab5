package itmo.java.commands;



import itmo.java.IO.Printor;
import itmo.java.comparators.MovieComparator;
import itmo.java.data.Movie;
import itmo.java.data.MyPriorityQueue;

import java.util.Comparator;

public class AddIfMaxCommand extends AddCommand implements Command {
    private final MyPriorityQueue<Movie> collection;
    private final Printor printor;
    private final Movie movie;

    public AddIfMaxCommand(MyPriorityQueue<Movie> collection, Printor printor, Movie movie) {
        super(collection, printor, movie);
        this.collection = collection;
        this.printor = printor;
        this.movie = movie;
    }

    @Override
    public void execute() throws Exception {
        Comparator<Movie> movieComparator = new MovieComparator();
        collection.stream().sorted(movieComparator.reversed());
        if (movie.getLength() > collection.peek().getLength()) {
            collection.add(movie);
            printor.println("Продолжительность фильма больше чем в максимальном элементе коллекции,поэтому элемент  добавлен ");
        } else {
            printor.println("Продолжительность фильма меньше чем в максимальном элементе коллекции,поэтому элемент не добавлен в коллекцию.");
        }
    }
}
