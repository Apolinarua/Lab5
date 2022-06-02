package itmo.java.IO;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePrint implements Printor {
    private final BufferedOutputStream out;

    public FilePrint(String filename) throws IOException {
        this.out = new BufferedOutputStream(Files.newOutputStream(Paths.get(filename)));
    }

    @Override
    public void println(String message) throws IOException {
        out.flush();
        byte[] b = message.getBytes(StandardCharsets.UTF_8);
        out.write(b);
        out.write('\n');
    }

    @Override
    public void print(String message) throws IOException {
        out.flush();
        byte[] b = message.getBytes(StandardCharsets.UTF_8);
        out.write(b);
    }

    @Override
    public void close() throws IOException {
        out.close();
    }
}

