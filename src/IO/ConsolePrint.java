package IO;

import java.io.IOException;

public class ConsolePrint implements Printor{
    @Override
    public void println(String message) throws IOException {
        System.out.println(message);
    }

    @Override
    public void print(String message) throws IOException {
        System.out.print(message);
    }

    @Override
    public void close() throws IOException {

    }
}
