import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Lesson2_1 {
    public static void main(String[] args) {

        Logger logger = Logger.getAnonymousLogger();
        int[] arr = new int[]{1, 2, 3, 4, 0};
        try {
            FileHandler fh = new FileHandler("Lesson2_1log.xml");
            logger.addHandler(fh);

            for (int i = arr.length - 1; i >= 1; i--) {
                int[] arr2 = arr.clone();
                for (int j = 0; j < i; j++) {
                    if (arr2[j] > arr2[j + 1]) {
                        int shift = arr2[j];
                        arr2[j] = arr2[j + 1];
                        arr2[j + 1] = shift;
                    }
                }
                arr = arr2.clone();
            }
            logger.info(Arrays.toString(arr));
        } catch (IOException e) {
            logger.info(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}