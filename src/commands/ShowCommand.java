package commands;

import IO.Printor;
import data.MyPriorityQueue;

import java.io.IOException;

public class ShowCommand implements Command {
    private final Printor printor;
    private final MyPriorityQueue<?> collection;

    public ShowCommand(Printor printor, MyPriorityQueue<?> collection) {
        this.printor = printor;
        this.collection = collection;
    }

    @Override
    public void execute() throws Exception {
        if (collection.size() == 0) {
            printor.println("Коллекция пуста");
        } else {
            collection.forEach(element -> {
                try {
                    printor.println(element.toString());
                } catch (IOException e) {
                }
            });

        }
    }
}
