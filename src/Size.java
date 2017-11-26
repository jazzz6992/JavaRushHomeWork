import java.io.File;

/**
 * Created by vsevolodvisnevskij on 20.10.16.
 */
public class Size extends Thread {
    File fileIn;
    File[] fileList;
    Size size;
    public static int totalSize;
    @Override
    public void run() {
        if (fileIn != null) {
            if (fileIn.isDirectory()) {
                size = new Size(fileIn.listFiles());
                size.start();
                try {
                    size.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                totalSize += fileIn.length();
            }

        } else if (fileList != null) {
            for (int i = 0; i < fileList.length; i++) {
                if (fileList[i].isFile()) {
                    totalSize += fileList[i].length();
                } else if (fileList[i].isDirectory()) {
                   size = new Size(fileList[i].listFiles());
                    size.start();
                    try {
                        size.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public Size(File fileIn) {
        this.fileIn = fileIn;
    }

    public Size(File[] fileList) {
        this.fileList = fileList;
    }
}
