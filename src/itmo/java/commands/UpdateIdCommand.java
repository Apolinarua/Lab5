package itmo.java.commands;


import itmo.java.IO.Printor;

import itmo.java.data.Movie;
import itmo.java.data.MyPriorityQueue;

public class UpdateIdCommand implements Command {
    private final MyPriorityQueue<Movie> collection;
    private final long id;
    private final Movie movie;
    private final Printor printor;

    public UpdateIdCommand(MyPriorityQueue<Movie> collection, long id, Movie movie, Printor printor) {
        this.collection = collection;
        this.id = id;
        this.movie = movie;
        this.printor = printor;
    }

    @Override
    public void execute() throws Exception {
        try {
            collection.removeIf(movie -> movie.getId() == id);
            movie.setId(id);
            collection.add(movie);
            printor.println("The element with id " + id + "was updated");
        } catch (NullPointerException e) {
            printor.println("нет такого");
        }

    }
}
