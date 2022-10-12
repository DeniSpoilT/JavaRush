package com.jrproject;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class StaticAnalyzer {
    public static int findTheKey(String filePath, String filePathForStaticAnalisis) {
        int key;
        try (FileReader reader = new FileReader(filePath, StandardCharsets.UTF_8);
             FileReader analizeReader = new FileReader(filePathForStaticAnalisis, StandardCharsets.UTF_8)) {

            HashMap<Character, Integer> analyzeEncode = getMapForStatics(reader);
            HashMap<Character, Integer> analyzeOrigin = getMapForStatics(analizeReader);

            char mostRepeatCharEnc = getMostRepeatChar(analyzeEncode);
            char mostRepeatCharOrigin = getMostRepeatChar(analyzeOrigin);

            key = getEncodeKey(mostRepeatCharEnc, mostRepeatCharOrigin);

        } catch (IOException ex) {
            throw new RuntimeException("Input/Output error" + ex);
        }
        System.out.println("File decoded. The key is: " + key);
        return key;
    }

    private static HashMap<Character, Integer> getMapForStatics(FileReader reader) {
        HashMap<Character, Integer> analizEng = getAlphabetForAnalyze("eng");
        HashMap<Character, Integer> analizRus = getAlphabetForAnalyze("rus");
        int symbol;
        try {
            while ((symbol = reader.read()) != -1) {
                if (analizEng.containsKey((char) symbol)) {
                    analizEng.put((char) symbol, analizEng.get((char) symbol) + 1);
                } else if (analizRus.containsKey((char) symbol)) {
                    analizRus.put((char) symbol, analizRus.get((char) symbol) + 1);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Input/Output error" + e);
        }
        if (Collections.max(analizEng.values()) > Collections.max(analizRus.values())) {
            return analizEng;
        } else {
            return analizRus;
        }
    }

    private static char getMostRepeatChar(HashMap map) {
        char indexMaxValue = getKeyByValue(map, (int) Collections.max(map.values()));
        return indexMaxValue;
    }

    private static int getEncodeKey(char mostRepeatCharEnc, char mostRepeatCharOrig) {
        int key = -1;
        AlphabetEng eng = AlphabetEng.getInstance();
        AlphabetRus rus = AlphabetRus.getInstance();
        if (eng.getIndexOf(mostRepeatCharEnc) > eng.getIndexOf(mostRepeatCharOrig)) {
            key = eng.getIndexOf(mostRepeatCharEnc) - eng.getIndexOf(mostRepeatCharOrig);

        } else if (eng.getIndexOf(mostRepeatCharEnc) < eng.getIndexOf(mostRepeatCharOrig)) {
            key = eng.getIndexOf(mostRepeatCharEnc) + eng.getSize() - eng.getIndexOf(mostRepeatCharOrig);

        } else if ((rus.getIndexOf(mostRepeatCharEnc) > rus.getIndexOf(mostRepeatCharOrig))) {
            key = rus.getIndexOf(mostRepeatCharEnc) - rus.getIndexOf(mostRepeatCharOrig);

        } else if ((rus.getIndexOf(mostRepeatCharEnc) < rus.getIndexOf(mostRepeatCharOrig))) {
            key = rus.getIndexOf(mostRepeatCharEnc) + rus.getSize() - rus.getIndexOf(mostRepeatCharOrig);
        }

        return key;
    }

    private static HashMap getAlphabetForAnalyze(String language) {
        HashMap<Character, Integer> alphabetForAnalyze = new HashMap<>();
        ArrayList<Character> alphabet;
        if ("eng".equals(language)) {
            alphabet = AlphabetEng.getAlphabetList();
        } else {
            alphabet = AlphabetRus.getAlphabetList();
        }
        for (Character symbol : alphabet) {
            alphabetForAnalyze.put(symbol, 0);
        }
        return alphabetForAnalyze;
    }

    private static Character getKeyByValue(HashMap map, Integer value) {

        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Character, Integer> pair : entrySet) {
            if (value.equals(pair.getValue())) {
                return pair.getKey();
            }
        }
        return null;
    }
}