package itmo.java.commands;


import itmo.java.IO.Printor;
import itmo.java.data.Movie;
import itmo.java.data.MyPriorityQueue;

public class ClearCommand implements Command {
    private final MyPriorityQueue<Movie> collection;
    private final Printor printor;

    public ClearCommand(MyPriorityQueue<Movie> collection, Printor printor) {
        this.collection = collection;
        this.printor = printor;
    }

    @Override
    public void execute() throws Exception {
        collection.clear();
        printor.println("Все элементы коллекции были удалены");
    }
}
