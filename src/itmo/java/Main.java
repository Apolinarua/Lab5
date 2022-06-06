package itmo.java;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import itmo.java.IO.ConsolePrint;
import itmo.java.IO.ConsoleScan;
import itmo.java.IO.Scannie;
import itmo.java.data.Movie;
import itmo.java.data.MyPriorityQueue;
import itmo.java.manager.CommandManager;
import itmo.java.manager.JsonHelper;

import java.io.File;


public class Main {
    public static String filename;
    public static void main(String[] args) {

        if (args.length < 1){
            System.out.println("There is no filename");
            System.exit(1);
        }
        filename = args[0];

        MyPriorityQueue<Movie> myPriorityQueue = new MyPriorityQueue<>();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            myPriorityQueue = JsonHelper.toMyPriorityQueue(filename);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        CommandManager commandManager = new CommandManager(new ConsolePrint(), myPriorityQueue);
        Scannie scannie = new ConsoleScan();
        while (true) {
            System.out.println("Enter the command:");
            try {
                commandManager.getCommand(scannie.scanString(), true, scannie).execute();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
