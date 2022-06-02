package itmo.java.IO;

import java.io.IOException;

public interface Scannie {
    String scanString() throws Exception;

    boolean hasNextLine() throws IOException;
}
