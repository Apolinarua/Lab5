package commands;

import inter.Printor;
import data.Movie;
import data.MyPriorityQueue;

public class ClearCommand implements Command{
    private MyPriorityQueue<Movie> collection;
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
