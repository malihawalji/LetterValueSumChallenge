package main;

import java.util.HashMap;

public class LetterSum {

    int sum = 0;
    private char[] wordArray;
    private HashMap<Character, Integer> letterValues = new HashMap<>();

    public LetterSum() {
        setLetterValues();
    }

    private void setLetterValues() {
        String abc = "abcdefghijklmnopqrstuvwxyz";
        int i = 1;
        for(char c : abc.toCharArray()) {
                letterValues.put(c, i);
                i++;
        }
    }

    public String getLetterValues() {
        return letterValues.toString();
    }

    public int calculateWordTotal(String word) {
        for(char c : word.toCharArray()) {
            if(letterValues.containsKey(c)) {
                sum += letterValues.get(c);
            }
        }
        return sum;
    }

}
