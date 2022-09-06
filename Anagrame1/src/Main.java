import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void bubbleSortCharArray(char arr[]){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n-i; j++) {
                if (arr[j - 1] > arr[j]) {
                    char temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public static void bubbleSortStringArray(String arr[]){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                if(arr[i].compareTo(arr[j]) < 0){
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static String path = "src/data";
    public static File file = new File(path);
    public static Scanner fileScanner;
    public static Scanner fileScanner2;
    public static String[] words;
    public static String[] sortedWords;
    public static int n;
    static {
        try {
            n = (int) Files.lines(Path.of(path)).count();
            fileScanner2 = new Scanner(file);
            fileScanner = new Scanner(file);
            words = new String[n];
            sortedWords = new String[n];
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void readFile(){
        int k = 0;
        while (fileScanner2.hasNextLine()){
            words[k] = fileScanner2.nextLine();
            k++;
        }
        System.out.println("\n");

    }
    public static void sortWords(){
        for (int i = 0; i < n; i++) {
            String word = words[i];
            char[] sortedWord = word.toCharArray();
            bubbleSortCharArray(sortedWord);
//            Arrays.sort(sortedWord);
            sortedWords[i] = String.valueOf(sortedWord);
        }
        bubbleSortStringArray(sortedWords);
    }

    public static void displaySortedWords(){

        for (int i = 0; i < n; i++) {
            String word = words[i];
            char[] sortedWord1 = new char[word.length()];
            char[] sortedWord = word.toCharArray();
            if(i < n-1) {
                sortedWord1 = words[i+1].toCharArray();
            }
//            Arrays.sort(sortedWord1);Arrays.sort(sortedWord);
            bubbleSortCharArray(sortedWord1);bubbleSortCharArray(sortedWord);

            for (int j = n-1; j >= 0; j--) {
                if (String.valueOf(sortedWord).equals(sortedWords[j])){
                    System.out.print(words[i] + " ");
                    break;
                }
            }
            if(!Arrays.equals(sortedWord, sortedWord1)){
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        readFile();
        sortWords();
        displaySortedWords();
    }
}