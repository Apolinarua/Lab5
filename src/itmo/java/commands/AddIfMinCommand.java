package itmo.java.commands;


import itmo.java.IO.Printor;
import itmo.java.data.Movie;
import itmo.java.data.MyPriorityQueue;

public class AddIfMinCommand extends AddCommand implements Command {
    private final MyPriorityQueue<Movie> collection;
    private final Printor printor;
    private final Movie movie;

    public AddIfMinCommand(MyPriorityQueue<Movie> collection, Printor printor, Movie movie) {
        super(collection, printor, movie);
        this.collection = collection;
        this.printor = printor;
        this.movie = movie;
    }

    @Override
    public void execute() throws Exception {
        if (movie.getLength() < collection.peek().getLength()) {
            collection.add(movie);
            printor.println("Продолжительность фильма меньше чем в минимальном элементе коллекции,поэтому элемент добавлен в коллекцию. ");
        } else {
            printor.println("Продолжительность фильма больше чем в минимальном элементе коллекции,поэтому элемент не добавлен в коллекцию.");
        }
    }


}
