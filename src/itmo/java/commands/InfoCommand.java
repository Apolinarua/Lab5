package itmo.java.commands;


import itmo.java.IO.Printor;
import itmo.java.data.MyPriorityQueue;

public class InfoCommand implements Command {
    private final Printor printor;
    private final MyPriorityQueue<?> collection;

    public InfoCommand(Printor printor, MyPriorityQueue<?> collection) {
        this.printor = printor;
        this.collection = collection;
    }

    @Override
    public void execute() throws Exception {
        printor.println("Тип коллекции: " + collection.getClass().getSuperclass().getSimpleName());
        printor.println("Размер коллекции: " + collection.size());
        printor.println("Дата создания коллекции: " + collection.getCreationdate());

    }
}
