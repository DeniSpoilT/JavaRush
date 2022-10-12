package com.jrproject;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Cryptographer {
    private AlphabetEng eng = AlphabetEng.getInstance();
    private AlphabetRus rus = AlphabetRus.getInstance();
    private int correctKey;

    public void encode(String pathOfFile, int key) {

        try (FileReader reader = new FileReader(pathOfFile, StandardCharsets.UTF_8);
             FileWriter writer = new FileWriter(Utils.addOperationToFileName(pathOfFile, "_encoded"), StandardCharsets.UTF_8)) {
            int symbol;

            while ((symbol = reader.read()) != -1) {

                if (eng.contains((char) symbol)) {
                    correctKey = checkAndModifyWrongKey(key);
                    int newNumSymbol = getEncodedSymbol(eng, symbol, correctKey);
                    char currentLetterEng = eng.getLetterByIndex(newNumSymbol);
                    writer.append(currentLetterEng);

                } else if (rus.contains((char) symbol)) {
                    correctKey = checkAndModifyWrongKey(key);
                    int newNumSymbol = getEncodedSymbol(rus, symbol, correctKey);
                    char currentLetterRus = rus.getLetterByIndex(newNumSymbol);
                    writer.append(currentLetterRus);

                } else {
                    writer.append((char) symbol);
                }
            }

        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public void decode(String filePath, int key) {

        try (FileReader reader = new FileReader(filePath, StandardCharsets.UTF_8);
             FileWriter writer = new FileWriter(Utils.addOperationToFileName(filePath, "_decoded"), StandardCharsets.UTF_8)) {
            int symbol;

            while ((symbol = reader.read()) != -1) {

                if (eng.contains((char) symbol)) {
                    correctKey = checkAndModifyWrongKey(key);

                    int newNumSymbol = getDecodedSymbol(eng, symbol, correctKey);
                    char currentLetterEng = eng.getLetterByIndex(newNumSymbol);
                    writer.append(currentLetterEng);

                } else if (rus.contains((char) symbol)) {
                    correctKey = checkAndModifyWrongKey(key);

                    int newNumSymbol = getDecodedSymbol(rus, symbol, correctKey);
                    char currentLetterRus = rus.getLetterByIndex(newNumSymbol);
                    writer.append(currentLetterRus);

                } else {
                    writer.append((char) symbol);
                }
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    int checkAndModifyWrongKey(int key) {
        if (key < 0) {
            key *= -1;
        }
        if (key % eng.getSize() == 0 || key % rus.getSize() == 0) {
            key++;
        }
        return key;
    }


    private int getEncodedSymbol(Alphabet abc, int symbol, int key) {
        int oldNumSymbol = abc.getIndexOf((char) symbol);
        int newNumSymbol = oldNumSymbol + key;
        while (newNumSymbol > abc.getSize()) {
            newNumSymbol = newNumSymbol - abc.getSize();
        }
        return newNumSymbol;
    }

    private int getDecodedSymbol(Alphabet abc, int symbol, int key) {
        int oldNumSymbol = abc.getIndexOf((char) symbol);

        int newNumSymbol = oldNumSymbol - key;
        while (newNumSymbol <= 0) {
            newNumSymbol = newNumSymbol + abc.getSize();
        }
        return newNumSymbol;
    }

}