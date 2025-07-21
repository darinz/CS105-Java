import java.util.*;
// uncomment this to use file input
// import java.io.*;

/**
 * UniqueWordsAnalyzer
 *
 * This program reads a text file, extracts words, and analyzes them using Sets and Maps.
 *
 * Instructions:
 * - Complete the methods below to implement the required functionality.
 * - Follow the comments for guidance.
 */
public class UniqueWordsAnalyzer {
    public static void main(String[] args) {
        // 1. Read the file (default: sample.txt)
        String filename = "sample.txt"; // You can change this or make it user input (stretch)
        List<String> words = readWordsFromFile(filename);

        // 2. Store unique words in a Set
        Set<String> uniqueWords = getUniqueWords(words);

        // 3. Count word frequencies using a Map
        Map<String, Integer> wordCounts = getWordCounts(words);

        // 4. Display results
        displayResults(uniqueWords, wordCounts);
    }

    /**
     * Reads words from a file, removes punctuation, and converts to lowercase.
     * @param filename The name of the file to read.
     * @return List of words.
     */
    public static List<String> readWordsFromFile(String filename) {
        List<String> words = new ArrayList<>();
        // TODO: Implement file reading, word extraction, and cleaning
        return words;
    }

    /**
     * Returns a Set of unique words from the list.
     * @param words List of words.
     * @return Set of unique words.
     */
    public static Set<String> getUniqueWords(List<String> words) {
        // TODO: Implement using HashSet
        return new HashSet<>();
    }

    /**
     * Returns a Map of word counts from the list.
     * @param words List of words.
     * @return Map of word to count.
     */
    public static Map<String, Integer> getWordCounts(List<String> words) {
        // TODO: Implement using HashMap
        return new HashMap<>();
    }

    /**
     * Displays the required results: unique count, top 5, words appearing once, etc.
     * @param uniqueWords Set of unique words.
     * @param wordCounts Map of word to count.
     */
    public static void displayResults(Set<String> uniqueWords, Map<String, Integer> wordCounts) {
        // TODO: Implement result display, sorting, and statistics
    }
} 