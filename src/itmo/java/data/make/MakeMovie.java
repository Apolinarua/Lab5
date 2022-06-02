package itmo.java.data.make;

import itmo.java.IO.Printor;
import itmo.java.IO.Scannie;
import itmo.java.data.Movie;
import itmo.java.data.MovieGenre;
import itmo.java.data.MpaaRating;
import itmo.java.generate.IdGenerate;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Locale;

public class MakeMovie {
    private final Movie movie;
    private final boolean isConsole;

    public MakeMovie(boolean isConsole) {
        this.movie = new Movie();
        this.isConsole = isConsole;
    }

    public Movie make(Scannie scannie, Printor printor) throws Exception {
        movie.setId(IdGenerate.generateId());
        movie.setCreationDate(ZonedDateTime.now());
        makeName(scannie, printor);
        makeCoordinates(scannie, printor);
        makeOscarCount(scannie, printor);
        makeLength(scannie, printor);
        makeMovieGenre(scannie, printor);
        makeMpaaRating(scannie, printor);
        makePerson(scannie, printor);
        return movie;
    }

    private void makeMpaaRating(Scannie scannie, Printor printor) throws Exception {
        if (isConsole) {
            printor.println("Введите рейтинг фильма: " + Arrays.toString(MpaaRating.values()));
            String rating = scannie.scanString();
            try {
                movie.setMpaaRating(MpaaRating.valueOf(rating.trim().toUpperCase(Locale.ROOT)));
            } catch (Exception e) {
                printor.println("Что-то не так" + e.getMessage());
                makeMpaaRating(scannie, printor);
            }
        } else {
            String rating = scannie.scanString();
            movie.setMpaaRating(MpaaRating.valueOf(rating.trim().toUpperCase(Locale.ROOT)));
        }
    }

    private void makeMovieGenre(Scannie scannie, Printor printor) throws Exception {
        if (isConsole) {
            printor.println("Введите жанр фильма: " + Arrays.toString(MovieGenre.values()));
            String genre = scannie.scanString();
            try {
                movie.setGenre(MovieGenre.valueOf(genre.trim().toUpperCase(Locale.ROOT)));
            } catch (Exception e) {
                printor.println("Что-то не так" + e.getMessage());
                makeMovieGenre(scannie, printor);
            }
        } else {
            String genre = scannie.scanString();
            movie.setGenre(MovieGenre.valueOf(genre.trim().toUpperCase(Locale.ROOT)));
        }
    }

    private void makeLength(Scannie scannie, Printor printor) throws Exception {
        if (isConsole) {
            printor.println("Введите продолжительность фильма: ");
            String length = scannie.scanString();
            try {
                movie.setLength(Integer.parseInt(length));
            } catch (Exception e) {
                printor.println("Что-то не так" + e.getMessage());
                makeLength(scannie, printor);
            }

        } else {
            String length = scannie.scanString();
            movie.setLength(Integer.parseInt(length));
        }
    }

    private void makeOscarCount(Scannie scannie, Printor printor) throws Exception {
        if (isConsole) {
            printor.println("Введите количество оскаров: ");
            String oscarcount = scannie.scanString();
            try {
                movie.setOscarsCount(Long.parseLong(oscarcount));
            } catch (Exception e) {
                printor.println("Что-то не так" + e.getMessage());
                makeOscarCount(scannie, printor);
            }
        } else {
            String oscarcount = scannie.scanString();
            movie.setOscarsCount(Long.parseLong(oscarcount));
        }
    }

    private void makeName(Scannie scannie, Printor printor) throws Exception {
        if (isConsole) {
            printor.println("Введите название фильма: ");
            String name = scannie.scanString();
            try {
                movie.setName(name);
            } catch (Exception e) {
                printor.println("Что-то не так: " + e.getMessage());
                makeName(scannie, printor);
            }
        } else {
            String name = scannie.scanString();
            if (name.equals("")) {
                throw new Exception();
            }
            movie.setName(name);
        }
    }

    private void makeCoordinates(Scannie scannie, Printor printor) throws Exception {
        MakeCoordinates coordinates = new MakeCoordinates(isConsole);
        movie.setCoordinates(coordinates.make(scannie, printor));
    }

    private void makePerson(Scannie scannie, Printor printor) throws Exception {
        MakePerson makePerson = new MakePerson(isConsole);
        movie.setDirector(makePerson.make(scannie, printor));
    }
}

