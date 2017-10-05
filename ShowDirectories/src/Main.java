import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Utility utility = new Utility();

        String path = "c:\\Program Files\\Java";
        utility.getDirectories(Paths.get(path));

    }
}

class Utility {
    public void getDirectories(Path path) {

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path entry : stream) {

                if (Files.isDirectory(entry)) {
                    System.out.println(entry);

                    getDirectories(entry);
                }
            }
        } catch (Exception ex) {
            System.out.println("Can't access :" + path);
        }
    }
}
