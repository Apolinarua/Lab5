package commands;

import inter.Printor;
import data.Movie;
import data.MyPriorityQueue;

public class RemoveFirstCommand implements Command{
    private final Printor printor;
    private MyPriorityQueue<Movie> collection;

    public RemoveFirstCommand(Printor printor, MyPriorityQueue<Movie> collection) {
        this.printor = printor;
        this.collection = collection;
    }

    @Override
    public void execute() throws Exception {
        if(collection.size()==0){
            printor.println("В коллекции нечего удалять ,она пустая :)");
        }
        collection.remove();
        printor.println("Элемент удален");
    }
}
