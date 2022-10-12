package com.jrproject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class AlphabetRus implements Alphabet {

    private static AlphabetRus INSTANCE;

    private AlphabetRus() {
    }

    public static AlphabetRus getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AlphabetRus();
        }
        return INSTANCE;
    }

    public final static HashMap<Integer, Character> ALPHABET;

    static {

        ALPHABET = new HashMap<>();
        ALPHABET.put(1, '\u0410');   //Symbol 'А'
        ALPHABET.put(2, '\u0411');   //Symbol 'Б'
        ALPHABET.put(3, '\u0412');   //Symbol 'В'
        ALPHABET.put(4, '\u0413');   //Symbol 'Г'
        ALPHABET.put(5, '\u0414');   //Symbol 'Д'
        ALPHABET.put(6, '\u0415');   //Symbol 'Е'
        ALPHABET.put(7, '\u0401');   //Symbol 'Ё'
        ALPHABET.put(8, '\u0416');   //Symbol 'Ж'
        ALPHABET.put(9, '\u0417');   //Symbol 'З'
        ALPHABET.put(10, '\u0418');   //Symbol 'И'
        ALPHABET.put(11, '\u0419');   //Symbol 'Й'
        ALPHABET.put(12, '\u041A');   //Symbol 'К'
        ALPHABET.put(13, '\u041B');   //Symbol 'Л'
        ALPHABET.put(14, '\u041C');   //Symbol 'М'
        ALPHABET.put(15, '\u041D');   //Symbol 'Н'
        ALPHABET.put(16, '\u041E');   //Symbol 'О'
        ALPHABET.put(17, '\u041F');   //Symbol 'П'
        ALPHABET.put(18, '\u0420');   //Symbol 'Р'
        ALPHABET.put(19, '\u0421');   //Symbol 'С'
        ALPHABET.put(20, '\u0422');   //Symbol 'Т'
        ALPHABET.put(21, '\u0423');   //Symbol 'У'
        ALPHABET.put(22, '\u0424');   //Symbol 'Ф'
        ALPHABET.put(23, '\u0425');   //Symbol 'Х'
        ALPHABET.put(24, '\u0426');   //Symbol 'Ц'
        ALPHABET.put(25, '\u0427');   //Symbol 'Ч'
        ALPHABET.put(26, '\u0428');   //Symbol 'Ш'
        ALPHABET.put(27, '\u0429');   //Symbol 'Щ'
        ALPHABET.put(28, '\u042A');   //Symbol 'Ъ'
        ALPHABET.put(29, '\u042B');   //Symbol 'Ы'
        ALPHABET.put(30, '\u042C');   //Symbol 'Ь'
        ALPHABET.put(31, '\u042D');   //Symbol 'Э'
        ALPHABET.put(32, '\u042E');   //Symbol 'Ю'
        ALPHABET.put(33, '\u042F');   //Symbol 'Я'
        ALPHABET.put(34, '\u0430');   //Symbol 'а'
        ALPHABET.put(35, '\u0431');   //Symbol 'б'
        ALPHABET.put(36, '\u0432');   //Symbol 'в'
        ALPHABET.put(37, '\u0433');   //Symbol 'г'
        ALPHABET.put(38, '\u0434');   //Symbol 'д'
        ALPHABET.put(39, '\u0435');   //Symbol 'е'
        ALPHABET.put(40, '\u0451');   //Symbol 'ё'
        ALPHABET.put(41, '\u0436');   //Symbol 'ж'
        ALPHABET.put(42, '\u0437');   //Symbol 'з'
        ALPHABET.put(43, '\u0438');   //Symbol 'и'
        ALPHABET.put(44, '\u0439');   //Symbol 'й'
        ALPHABET.put(45, '\u043A');   //Symbol 'к'
        ALPHABET.put(46, '\u043B');   //Symbol 'л'
        ALPHABET.put(47, '\u043C');   //Symbol 'м'
        ALPHABET.put(48, '\u043D');   //Symbol 'н'
        ALPHABET.put(49, '\u043E');   //Symbol 'о'
        ALPHABET.put(50, '\u043F');   //Symbol 'п'
        ALPHABET.put(51, '\u0440');   //Symbol 'р'
        ALPHABET.put(52, '\u0441');   //Symbol 'с'
        ALPHABET.put(53, '\u0442');   //Symbol 'т'
        ALPHABET.put(54, '\u0443');   //Symbol 'у'
        ALPHABET.put(55, '\u0444');   //Symbol 'ф'
        ALPHABET.put(56, '\u0445');   //Symbol 'х'
        ALPHABET.put(57, '\u0446');   //Symbol 'ц'
        ALPHABET.put(58, '\u0447');   //Symbol 'ч'
        ALPHABET.put(59, '\u0448');   //Symbol 'ш'
        ALPHABET.put(60, '\u0449');   //Symbol 'щ'
        ALPHABET.put(61, '\u044A');   //Symbol 'ъ'
        ALPHABET.put(62, '\u044B');   //Symbol 'ы'
        ALPHABET.put(63, '\u044C');   //Symbol 'ь'
        ALPHABET.put(64, '\u044D');   //Symbol 'э'
        ALPHABET.put(65, '\u044E');   //Symbol 'ю'
        ALPHABET.put(66, '\u044F');   //Symbol 'я'
    }

    public final static int ALPHABET_SIZE = ALPHABET.size();

    public int getSize() {
        return ALPHABET_SIZE;
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
        ArrayList<Character> listAlphabetRus = new ArrayList<>(ALPHABET.values());
        return listAlphabetRus;
    }
}