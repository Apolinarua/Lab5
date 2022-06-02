package itmo.java.IO;

import java.util.Scanner;

public class ConsoleScan implements Scannie {
    private final Scanner scanner;

    public ConsoleScan() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String scanString() throws Exception {
        return scanner.nextLine();
    }

    @Override
    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }
}
