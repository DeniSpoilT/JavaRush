package com.jrproject;


public interface Alphabet {

    int getSize();
    boolean contains(Character letter);
    int getIndexOf(Character letter);
    char getLetterByIndex(int number);

}