import java.io.*;

/**
 * Created by vsevolodvisnevskij on 20.10.16.
 */
public class MainClass {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File fileIn = new File("/Users/vsevolodvisnevskij/IdeaProjects/JavaRushHomeWork/JavaRushHomeWork/src");
        Size size = new Size(fileIn);
        size.start();

        try {
            size.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Size.totalSize);

    }
}
