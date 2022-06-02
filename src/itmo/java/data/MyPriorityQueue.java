package itmo.java.data;

import java.time.ZonedDateTime;
import java.util.PriorityQueue;

public class MyPriorityQueue<E> extends PriorityQueue<E> {
    private ZonedDateTime creationdate;

    public MyPriorityQueue() {
        this.creationdate = ZonedDateTime.now();
    }

    public ZonedDateTime getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(ZonedDateTime creationdate0) {
        this.creationdate = creationdate;
    }
}
