package itmo.java.manager;


import itmo.java.IO.Printor;
import itmo.java.IO.Scannie;
import itmo.java.commands.*;
import itmo.java.data.Movie;
import itmo.java.data.MyPriorityQueue;
import itmo.java.data.make.MakeMovie;

public class CommandManager {
    private final Printor printor;
    private final MyPriorityQueue<Movie> collection;

    public CommandManager(Printor printor, MyPriorityQueue<Movie> collection) {
        this.printor = printor;
        this.collection = collection;
    }

    public Command getCommand(String name, boolean isConsole, Scannie scannie) throws Exception {

        String[] wordArray = name.trim().replaceAll("\\s{2,}", " ").trim().split(" ");

        if (wordArray.length == 0) {
            throw new Exception("Команда не была введена");
        }

        String command = wordArray[0];

        switch (command) {
            case "help":
                return new HelpCommand(printor);
            case "info":
                return new InfoCommand(printor, collection);
            case "show":
                return new ShowCommand(printor, collection);
            case "add": {
                Movie movie = new MakeMovie(isConsole).make(scannie, printor);
                return new AddCommand(collection, printor, movie);
            }
            case "update": {
                if (wordArray.length < 2) {
                    throw new Exception("Not enough arguments");
                }
                Movie movie = new MakeMovie(isConsole).make(scannie, printor);
                return new UpdateIdCommand(collection, Long.parseLong(wordArray[1]), movie, printor);
            }
            case "exit":
                return new ExitCommand(printor);
            case "remove_by_id":
                if (wordArray.length < 2) {
                    throw new Exception("Not enough arguments");
                }
                return new RemoveByIdCommand(collection, Long.parseLong(wordArray[1]), printor);
            case "clear":
                return new ClearCommand(collection, printor);
            case "add_if_min": {
                Movie movie = new MakeMovie(isConsole).make(scannie, printor);
                return new AddIfMinCommand(collection, printor, movie);
            }
            case "add_if_max":
                Movie movie = new MakeMovie(isConsole).make(scannie, printor);
                return new AddIfMaxCommand(collection, printor, movie);
            case "filter_less_than_length":
                if (wordArray.length < 2) {
                    throw new Exception("Not enough arguments");
                }
                return new FilterLessThanLength(collection, Integer.parseInt(wordArray[1]), printor);
            case "filter_by_genre":
                if (wordArray.length < 2) {
                    throw new Exception("Not enough arguments");
                }
                return new FilterByGenreCommand(collection, printor, wordArray[1]);
            case "filter_osc":
                if (wordArray.length < 2) {
                    throw new Exception("Not enough arguments");
                }
                return new FilterGreaterThanOscarsCountCommand(collection, Long.parseLong(wordArray[1]), printor);
            case "remove_first":
                return new RemoveFirstCommand(printor,collection);
            case "save":
                return new SaveCommand(collection,printor);
            case "execute_script":
                if (wordArray.length < 2) {
                    throw new Exception("Not enough arguments");
                }
                return new ExecuteScript(collection,printor, wordArray[1]);
            default:
                throw new Exception("Нет такой команды");
        }
    }
}
