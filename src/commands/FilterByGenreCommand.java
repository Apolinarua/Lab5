package commands;

import data.Movie;
import inter.Printor;

public class FilterByGenreCommand implements Command{
    private final Printor printor;
    private final Movie movie;

    public FilterByGenreCommand(Printor printor, Movie movie) {
        this.printor = printor;
        this.movie = movie;
    }

    @Override
    public void execute() throws Exception {

    }
}
