import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get(System.getProperty("user.dir"),"logs","application.log");
        System.out.format("toString: %s%n", path.toString());
        System.out.format("getFileName: %s%n", path.getFileName());
        System.out.format("getName(0): %s%n", path.getName(0));
        System.out.format("getNameCount: %d%n", path.getNameCount());
        System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
        System.out.format("getParent: %s%n", path.getParent());
        System.out.format("getRoot: %s%n", path.getRoot());

        //Converting a Path
        System.out.format("%s%n", path.toUri());

        try {
            Path fp = path.toRealPath();
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", path);
            // Logic for case when file doesn't exist.
        } catch (IOException x) {
            System.err.format("%s%n", x);
            // Logic for other sort of file error.
        }

        Path p1 = Paths.get(System.getProperty("user.dir"),"logs","error");

        System.out.format("%s%n",p1.resolve("today"));

        Path p2 = Paths.get(System.getProperty("user.dir"),"logs","error","today");

        Path p1_p2 = p1.relativize(p2);

        System.out.format("%s%n",p1_p2.toString());

    }
}
