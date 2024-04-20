package strings;

import java.util.*;

public class StringsClass {
    public static String searchUniqueWordInFirstSentence(String text){
        String[] sentences = text.split("\\.");
        String[] firstSentence = sentences[0].split(" ");
        sentences[0] = " ";

        //clean words from wrong symbols at the end
        for(int i = 0; i < firstSentence.length; i++){
            StringBuilder sb = new StringBuilder(firstSentence[i]);
            if(!Character.isLetter(sb.charAt(sb.length() - 1))){
                sb.deleteCharAt(sb.length() - 1);
                firstSentence[i] = sb.toString();
            }
        }

        for(int i = 0; i < firstSentence.length; i++){
            boolean isFind = true;
            for(String sentence : sentences){
                if(sentence.contains(firstSentence[i])){
                    isFind = false;
                    break;
                }
            }
            if(isFind)
                return firstSentence[i];
        }
        return "No such word";
    }

    public static void changePositionsOfFirstAndLastWords(String text){
        String[] sentences = text.split("\\.");
        String result = "";
        System.out.println(text);
        for(String sentence : sentences){
            sentence = sentence.trim();
            StringBuilder sb = new StringBuilder(sentence);
            String firstWord = " " + sb.substring(0 ,sb.indexOf(" "));
            String lastWord = sb.substring(sb.lastIndexOf(" "), sb.length());
            //del last word
            sb.delete(sb.lastIndexOf(" "), sb.length() - 1);
            sb.replace(0, sb.indexOf(" "), lastWord);
            sb.append(firstWord);
            result += sb.toString() + ".";
        }
        System.out.println(result);
    }

    public static void replaceWordsWithSpecifiedLength(String text, int length, String str) {
        String output = "";
        String currentWord = "";
        int wordLength = 0;
        StringBuilder sb = new StringBuilder(text);
        System.out.println(sb);
        for (int i = 0; i < sb.length(); i++) {
            wordLength++;
            currentWord += sb.charAt(i);
            if (!Character.isLetter(sb.charAt(i))) {
                if (Character.isLetter(sb.charAt(i - 1)) && wordLength - 1 == length) {
                    currentWord = str + sb.charAt(i);
                }
                output += currentWord;
                currentWord = "";
                wordLength = 0;
            }
        }
        System.out.println(output);
    }

    public static void printAllSentencesIncOrder(String text) {
        String[] sentences = text.split("\\.");
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String sentence : sentences){
            map.put(sentence, sentence.split(" ").length);
        }
        map.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> System.out.println(k.getKey() + ":" + k.getValue()));
        map.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> System.out.print(k.getKey() + "."));
    }

    public static void sortTextByAmountOfLetter(String text, char letter) {
        HashMap<String, Integer> map = new HashMap<>();
        String currentWord = "";
        int letterCounter = 0;
        StringBuilder sb = new StringBuilder(text.toLowerCase());
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == letter)
                letterCounter++;
            if (Character.isLetter(sb.charAt(i)))
                currentWord += sb.charAt(i);
            else{
                map.put(currentWord, map.getOrDefault(currentWord, letterCounter));
                currentWord = "";
                letterCounter = 0;
            }
        }
        map.remove("");
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }
}
