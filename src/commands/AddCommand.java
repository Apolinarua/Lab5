package commands;

import inter.Printor;
import data.Movie;
import data.MyPriorityQueue;

public class AddCommand implements Command{
    private MyPriorityQueue<Movie> collection;
    private final Printor printor;
    private Movie movie;

    public AddCommand(MyPriorityQueue<Movie> collection, Printor printor, Movie movie) {
        this.collection = collection;
        this.printor = printor;
        this.movie = movie;
    }

    @Override
    public void execute() throws Exception {
        collection.add(movie);
        printor.println("Элемент добавлен в коллекцию");
    }
}
