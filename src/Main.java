import com.jrproject.Cryptographer;
import com.jrproject.StaticAnalyzerDecoder;

public class Main {

    public static void main(String[] args) {
        Cryptographer crypt = new Cryptographer();

        String operation= args[0];
        String filePath= args[1];
        String keyOrFilePathForStaticAnalyze= args[2];


        if (operation.equals("encode")) {
            crypt.encode(filePath, Integer.parseInt(keyOrFilePathForStaticAnalyze));
        } else if (operation.equals("decode")) {
            crypt.decode(filePath, Integer.parseInt(keyOrFilePathForStaticAnalyze));
        } else if (operation.equals("bruteForce")) {
            StaticAnalyzerDecoder decoder = new StaticAnalyzerDecoder();
            decoder.hack(filePath, keyOrFilePathForStaticAnalyze);
        }

    }
}
