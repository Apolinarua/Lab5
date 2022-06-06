package itmo.java.manager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import itmo.java.data.Movie;
import itmo.java.data.MyPriorityQueue;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.ZonedDateTime;
import java.util.Arrays;

/**
 * класс для json
 */
public class JsonHelper {
    private Movie[] movies;
    private ZonedDateTime creationTime;

    public JsonHelper() {
    }

    /**
     * @param myPriorityQueue конструктор
     */
    public JsonHelper(MyPriorityQueue<Movie> myPriorityQueue) {
        movies = new Movie[myPriorityQueue.size()];
        int index = 0;
        for (Movie movie : myPriorityQueue) {
            movies[index++] = movie;
        }
        this.creationTime = myPriorityQueue.getCreationdate();
    }

    public Movie[] getMovies() {
        return movies;
    }

    public void setMovies(Movie[] movies) {
        this.movies = movies;
    }

    public ZonedDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(ZonedDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public void toJson(String filename) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); //делаем красиво все в одну строчку
        objectMapper.registerModule(new JavaTimeModule()); //чтобы время было в файле
        objectMapper.writeValue(new File(filename), this);
    }

    public static MyPriorityQueue<Movie> toMyPriorityQueue(String filename) throws Exception {
        if (!Files.exists(Paths.get(filename))){
            throw new Exception();
        }
        if (!Files.isReadable(Paths.get(filename))) {
            throw new Exception();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); //делаем красиво
        objectMapper.registerModule(new JavaTimeModule()); //чтобы время было
        JsonHelper jsonHelper = objectMapper.readValue(new File(filename), JsonHelper.class);

        return jsonHelper.getMyPriorityQueue();
    }

    private MyPriorityQueue<Movie> getMyPriorityQueue() {
        MyPriorityQueue<Movie> myPriorityQueue = new MyPriorityQueue<>();
        myPriorityQueue.addAll(Arrays.asList(movies));
        myPriorityQueue.setCreationdate(this.creationTime);

        return myPriorityQueue;
    }
}
