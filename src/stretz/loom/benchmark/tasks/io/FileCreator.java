package stretz.loom.benchmark.tasks.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *  Runnable for creation of a single file
 * @TODO Handle filepath
 * @TODO Create Error Logging
 * @TODO Get Lorem Ipsum from different file
 */
public class FileCreator implements Runnable {
    private final File file;
    private final String text;

    public FileCreator(String filePath, String format, String text) {
        this.file = new File(filePath + format);
        this.text = text;
    }

    public void run() {
        this.createFile();
        this.writeToFile();
    }

    private void createFile() {
        try {
            this.file.createNewFile();
        } catch (IOException e) {
            System.err.println("already exists: " + e.getMessage());
        }
    }

    private void writeToFile() {
        try {
            FileWriter writer = new FileWriter(this.file);
            writer.write(this.text);
            writer.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
