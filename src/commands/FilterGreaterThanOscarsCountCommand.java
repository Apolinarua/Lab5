package commands;

import data.Movie;
import data.MyPriorityQueue;
import IO.Printor;

public class FilterGreaterThanOscarsCountCommand implements Command {
    private MyPriorityQueue<Movie> collection;
    private final Long id;
    private final Printor printor;

    public FilterGreaterThanOscarsCountCommand(MyPriorityQueue<Movie> collection, Long id, Printor printor) {
        this.collection = collection;
        this.id = id;
        this.printor = printor;
    }

    @Override
    public void execute() throws Exception {
        printor.println("Элементы у которых количество оскаров больше чем " + id);
        int num = 0;
        for (Movie movie : collection) {
            if(movie.getOscarsCount()>id){
                printor.println(movie.toString());
                num++;
            }
        }
        printor.println("Всего: "+num);
    }
}

