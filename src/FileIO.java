import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class FileIO {

    private String directoryName;
    private String fileName;
    private String logFileName;
    private Path directoryPath;
    private Path filePath;
    private Path logFilePath;
    private List<String> fileLines;
    private List<String> logFile;


    public FileIO(String directoryName, String fileName, String logFileName) throws IOException {
        this.directoryName = directoryName;
        this.fileName = fileName;
        this.logFileName = logFileName;
        this.directoryPath = Paths.get(directoryName);
        this.filePath = Paths.get(directoryName, fileName);
        this.logFilePath = Paths.get(directoryName, logFileName);

        if (Files.notExists(this.logFilePath)) {
            try {
                Files.createFile(this.logFilePath);
            } catch (IOException e) {
                throw new IOException("Unable to create the logfile (" + this.logFileName + ")!");
            }
        }
        if (Files.notExists(this.directoryPath)) {
            try {
                Files.createDirectories(this.directoryPath);
            } catch (IOException e) {
                Files.write(this.logFilePath, Arrays.asList(e.getMessage()), StandardOpenOption.APPEND);
                throw new IOException("Unable to create the data directory (" + this.directoryPath + ")!");
            }
        }
        if (Files.notExists(this.filePath)) {
            try {
                Files.createFile(filePath);
            } catch (IOException e) {
                Files.write(this.filePath, Arrays.asList(e.getMessage()), StandardOpenOption.APPEND);
                throw new IOException("Unable to create the file (" + this.filePath + ")!");
            }
        }
        System.out.println(filePath);
        this.fileLines = Files.readAllLines((this.filePath));
    }

    public static void main(String[] args) throws IOException {
        FileIO contactsReader = new FileIO("data", "contacts.txt", "contacts.log");

    }

    public void writeToLog(String message) throws IOException {
        try {
            // write the string 'message' to the log file of THIS INSTANCE of a FileReader object
            Files.write(this.logFilePath, Arrays.asList(message), StandardOpenOption.APPEND);
        } catch (IOException e) {
            Files.write(this.logFilePath, Arrays.asList(e.getMessage()), StandardOpenOption.APPEND);
            throw new IOException("Unable to write custom message to log file.");
        }
    }

    // getters and setter
    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLogFileName() {
        return logFileName;
    }

    public void setLogFileName(String logFileName) {
        this.logFileName = logFileName;
    }

    public Path getDirectoryPath() {
        return directoryPath;
    }

    public void setDirectoryPath(Path directoryPath) {
        this.directoryPath = directoryPath;
    }

    public Path getFilePath() {
        return filePath;
    }

    public void setFilePath(Path filePath) {
        this.filePath = filePath;
    }

    public Path getLogFilePath() {
        return logFilePath;
    }

    public void setLogFilePath(Path logFilePath) {
        this.logFilePath = logFilePath;
    }

    public List<String> getFileLines() {
        return fileLines;
    }

    public void setFileLines(List<String> fileLines) {
        this.fileLines = fileLines;
    }

    public List<String> getLogFile() {
        return logFile;
    }

    public void setLogFile(List<String> logFile) {
        this.logFile = logFile;
    }
}
