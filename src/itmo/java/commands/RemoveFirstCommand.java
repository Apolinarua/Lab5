package itmo.java.commands;


import itmo.java.IO.Printor;
import itmo.java.data.Movie;
import itmo.java.data.MyPriorityQueue;

public class RemoveFirstCommand implements Command {
    private final Printor printor;
    private final MyPriorityQueue<Movie> collection;

    public RemoveFirstCommand(Printor printor, MyPriorityQueue<Movie> collection) {
        this.printor = printor;
        this.collection = collection;
    }

    @Override
    public void execute() throws Exception {
        if (collection.size() == 0) {
            printor.println("В коллекции нечего удалять ,она пустая :)");
        }
        collection.remove();
        printor.println("Элемент удален");
    }
}
