package commands;

import IO.Printor;
import data.Movie;
import data.MyPriorityQueue;

public class RemoveByIdCommand implements Command{
    private MyPriorityQueue<Movie> collection;
    private final long id;
    private final Printor printor;

    public RemoveByIdCommand(MyPriorityQueue<Movie> collection, long id, Printor printor) {
        this.collection = collection;
        this.id = id;
        this.printor = printor;
    }

    @Override
    public void execute() throws Exception {
        try {
            collection.removeIf(movie -> movie.getId() == id);
            printor.println("Элемент удален из коллекции");
        } catch (NullPointerException e){
            throw new Exception("Элемента с таким id нет");
        }
    }
}
