package com.jrproject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class StaticAnalyzerDecoder {

    public void hack(String filePath, String filePathForStaticAnalysis) {

        int key = StaticAnalyzer.findTheKey(filePath, filePathForStaticAnalysis);

        Cryptographer crypt = new Cryptographer();
        crypt.decode(filePath, key);
        saveDecoderFile(filePath, key);
    }

    private void saveDecoderFile(String filePath, int key) {
        Path path1 = Path.of(Utils.addOperationToFileName(filePath, "_decoded"));
        Path path2 = Path.of(Utils.addOperationToFileName(filePath, "_bruteForced(" + key + ")"));

        try {
            Files.move(path1, path2);
        } catch (IOException ex) {
            throw new RuntimeException("Save file failed.", ex);
        }
    }
}