package itmo.java.commands;

import itmo.java.IO.FilePrint;
import itmo.java.IO.Printor;
import itmo.java.Main;
import itmo.java.data.Movie;
import itmo.java.data.MyPriorityQueue;
import itmo.java.manager.JsonHelper;

import java.nio.file.Files;
import java.nio.file.Paths;

public class SaveCommand implements Command{
    private MyPriorityQueue<Movie> collection;
    private final Printor printor;

    public SaveCommand(MyPriorityQueue<Movie> collection, Printor printor) {
        this.collection = collection;
        this.printor = printor;
    }
    @Override
    public void execute() throws Exception {
        JsonHelper jsonHelper = new JsonHelper(collection);
        jsonHelper.toJson(Main.filename);
        printor.println("Collection was saved to the file");
    }
}
