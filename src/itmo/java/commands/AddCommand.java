package itmo.java.commands;


import itmo.java.IO.Printor;
import itmo.java.data.Movie;
import itmo.java.data.MyPriorityQueue;

public class AddCommand implements Command {
    private final MyPriorityQueue<Movie> collection;
    private final Printor printor;
    private final Movie movie;

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
