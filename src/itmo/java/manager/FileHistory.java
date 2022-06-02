package itmo.java.manager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileHistory {

    /**
     * instance of this class
     */

    private static FileHistory instance = null;
    /**
     * array of files
     */
    private List<File> fileList = new ArrayList<>();

    public static FileHistory getInstance() {
        if (instance == null)
            instance = new FileHistory();

        return instance;
    }

    /**
     * constructor for class
     */
    private FileHistory() {
    }

    /**
     * @param file is a file that is being added to array
     */
    public void addToHistory(File file) {
        fileList.add(file);
    }

    /**
     * @param file is a file to check
     * @return boolean
     */
    public boolean contains(File file) {
        return fileList.stream().anyMatch(fileInHistory -> file.getAbsolutePath().equals(fileInHistory.getAbsolutePath()));
    }

    /**
     * @param file is file that should be removed
     */
    public void remove(File file) {
        fileList.removeIf(fileInHistory -> file.getAbsolutePath().equals(fileInHistory.getAbsolutePath()));
    }
}

