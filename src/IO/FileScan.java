package IO;

import java.io.*;

public class FileScan implements Scannie{
    private BufferedReader in;
    private boolean eof=false;
    public FileScan(String filename) throws IOException {
        this.in = new BufferedReader(new FileReader(filename));
        if (in.read() == -1) {
            this.eof=true;
        }
        this.in = new BufferedReader(new FileReader(filename));
    }

    @Override
    public String scanString() throws Exception {
        if (!hasNextLine()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int c = in.read();
            if (c == -1) {
                eof = true;
                break;
            }
            char ch = (char) c;
            if (ch == '\n') {
                break;
            }
            stringBuilder.append(ch);
        }
        return stringBuilder.toString().replace("\r","");
    }

    @Override
    public boolean hasNextLine() {
        return !eof;
    }
}



