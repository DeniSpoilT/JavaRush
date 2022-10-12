package com.jrproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class AlphabetEng implements Alphabet {

    private static AlphabetEng INSTANCE;

    private AlphabetEng() {
    }

    public static AlphabetEng getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AlphabetEng();
        }
        return INSTANCE;
    }

    public final static HashMap<Integer, Character> ALPHABET;


    static {
        ALPHABET = new HashMap<>();
        ALPHABET.put(1, 'A');
        ALPHABET.put(2, 'B');
        ALPHABET.put(3, 'C');
        ALPHABET.put(4, 'D');
        ALPHABET.put(5, 'E');
        ALPHABET.put(6, 'F');
        ALPHABET.put(7, 'G');
        ALPHABET.put(8, 'H');
        ALPHABET.put(9, 'I');
        ALPHABET.put(10, 'J');
        ALPHABET.put(11, 'K');
        ALPHABET.put(12, 'L');
        ALPHABET.put(13, 'M');
        ALPHABET.put(14, 'N');
        ALPHABET.put(15, 'O');
        ALPHABET.put(16, 'P');
        ALPHABET.put(17, 'Q');
        ALPHABET.put(18, 'R');
        ALPHABET.put(19, 'S');
        ALPHABET.put(20, 'T');
        ALPHABET.put(21, 'U');
        ALPHABET.put(22, 'V');
        ALPHABET.put(23, 'W');
        ALPHABET.put(24, 'X');
        ALPHABET.put(25, 'Y');
        ALPHABET.put(26, 'Z');
        ALPHABET.put(27, 'a');
        ALPHABET.put(28, 'b');
        ALPHABET.put(29, 'c');
        ALPHABET.put(30, 'd');
        ALPHABET.put(31, 'e');
        ALPHABET.put(32, 'f');
        ALPHABET.put(33, 'g');
        ALPHABET.put(34, 'h');
        ALPHABET.put(35, 'i');
        ALPHABET.put(36, 'j');
        ALPHABET.put(37, 'k');
        ALPHABET.put(38, 'l');
        ALPHABET.put(39, 'm');
        ALPHABET.put(40, 'n');
        ALPHABET.put(41, 'o');
        ALPHABET.put(42, 'p');
        ALPHABET.put(43, 'q');
        ALPHABET.put(44, 'r');
        ALPHABET.put(45, 's');
        ALPHABET.put(46, 't');
        ALPHABET.put(47, 'u');
        ALPHABET.put(49, 'v');
        ALPHABET.put(48, 'x');
        ALPHABET.put(50, 'w');
        ALPHABET.put(51, 'y');
        ALPHABET.put(52, 'z');
    }

    public int getSize() {
        return ALPHABET.size();
    }

    public boolean contains(Character letter) {
        return ALPHABET.containsValue(letter);
    }

    public int getIndexOf(Character letter) {
        if (contains(letter)) {
            Set<Map.Entry<Integer, Character>> entrySet = ALPHABET.entrySet();
            for (Map.Entry<Integer, Character> pair : entrySet) {
                if (letter.equals(pair.getValue())) {
                    return pair.getKey();
                }
            }
        }
        return -1;
    }

    public char getLetterByIndex(int number) {
        char letter;
        try {
            letter = ALPHABET.get(number);
        } catch (Exception ex) {
            throw new RuntimeException("The symbol does not match this number.");
        }
        return letter;
    }

    public static ArrayList<Character> getAlphabetList() {
        ArrayList<Character> listAlphabetEng = new ArrayList<>(ALPHABET.values());
        return listAlphabetEng;
    }


}