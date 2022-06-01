package commands;

import IO.Printor;
import data.Movie;
import data.MyPriorityQueue;

public class UpdateIdCommand implements Command{
    private MyPriorityQueue<Movie> collection;
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
        } catch (NullPointerException e){
            throw new Exception("No element with such id");
        }

    }
}
