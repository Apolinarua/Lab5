package itmo.java.IO;

import java.io.IOException;

public interface Printor {
    void println(String message) throws IOException;

    void print(String message) throws IOException;

    void close() throws IOException;
}
