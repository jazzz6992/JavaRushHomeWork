import java.io.*;

/**
 * Created by vsevolodvisnevskij on 18.10.16.
 */
public class Copy {


    public static void main(String[] args) {
        File fileIn;
        File fileOut;

        fileIn = new File("/Users/vsevolodvisnevskij/IdeaProjects/JavaRushHomeWork/JavaRushHomeWork/src/com/javarush/test");
        fileOut = new File("/Users/vsevolodvisnevskij/IdeaProjects/JavaRushHomeWork/JavaRushHomeWork/my.test.part2");

        if (!fileOut.exists()) {
            try {
                fileOut.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!fileIn.exists()) {
            return;
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOut));
            copy(fileIn, bufferedWriter);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copy(File fileIn, BufferedWriter bufferedWriter) {
        if (fileIn.isDirectory()) {
            File[] arr = fileIn.listFiles();
            for (File f : arr) {
                copy(f, bufferedWriter);
            }
        } else if (fileIn.isFile()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(fileIn));
                String s;
                while ((s = bufferedReader.readLine()) != null) {
                    bufferedWriter.write(s + "\n");
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
