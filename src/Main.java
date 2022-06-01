import data.Movie;
import data.MyPriorityQueue;
import IO.ConsolePrint;
import IO.ConsoleScan;
import IO.Scannie;
import manager.CommandManager;

public class Main {
    public static void main(String args[]) {

        MyPriorityQueue<Movie> myPriorityQueue = new MyPriorityQueue<>();
        CommandManager commandManager = new CommandManager(new ConsolePrint(),myPriorityQueue);
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
