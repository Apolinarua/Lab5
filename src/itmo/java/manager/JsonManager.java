package itmo.java.manager;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import itmo.java.data.Movie;
import itmo.java.data.MyPriorityQueue;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class JsonManager {
    public static String toJson(MyPriorityQueue<Movie> myCollection) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        return objectMapper.writeValueAsString(myCollection);
    }

    public static MyPriorityQueue<Movie> toMyPriorityQueue(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        return (MyPriorityQueue<Movie>) objectMapper.readValue(json, MyPriorityQueue.class);
    }

}
