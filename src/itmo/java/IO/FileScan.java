package itmo.java.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileScan implements Scannie {
    private BufferedReader in;

    public FileScan(String filename) throws IOException {
        this.in = new BufferedReader(new FileReader(filename));
    }

    @Override
    public String scanString() throws Exception {
        if (!hasNextLine()) {
            return null;
        }
        return in.readLine();
    }

    @Override
    public boolean hasNextLine() throws IOException {
        return in.ready();
    }
}



