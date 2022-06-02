package itmo.java.commands;

import itmo.java.IO.FileScan;
import itmo.java.IO.Printor;
import itmo.java.IO.Scannie;
import itmo.java.data.Movie;
import itmo.java.data.MyPriorityQueue;
import itmo.java.manager.CommandManager;
import itmo.java.manager.FileHistory;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExecuteScript implements Command {
    private final MyPriorityQueue<Movie> myPriorityQueue;
    private final Printor printor;
    private final String filename;

    public ExecuteScript(MyPriorityQueue<Movie> myPriorityQueue, Printor printor, String filename) {
        this.myPriorityQueue = myPriorityQueue;
        this.printor = printor;
        this.filename = filename;
    }


    @Override
    public void execute() throws Exception {
        if (!Files.isReadable(Paths.get(filename))) {
            throw new Exception("Can't read " + filename);
        }
        File file = new File(filename);
        if (FileHistory.getInstance().contains(file))
            throw new Exception("Oops, haha recursion");
        FileHistory.getInstance().addToHistory(file);
        try {
            Scannie scannable = new FileScan(filename);
            CommandManager commandManager = new CommandManager(printor, myPriorityQueue);
            while (scannable.hasNextLine()) {
                commandManager.getCommand(scannable.scanString(), false, scannable).execute();
            }
        } catch (Exception e) {
            System.out.println("ooops: " + e.getMessage());
        }
        FileHistory.getInstance().remove(file);
    }

}

