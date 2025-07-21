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
 *
 * Java Concepts Practiced:
 * - Reading files (optionally)
 * - Using ArrayList, HashSet, and HashMap
 * - String manipulation and cleaning
 * - Sorting collections
 */
public class UniqueWordsAnalyzer {
    public static void main(String[] args) {
        // 1. Read the file (default: sample.txt)
        // You can change the filename or make it user input (see stretch ideas)
        String filename = "sample.txt";
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
     *
     * Why use a List? We want to keep all words (including duplicates) to count frequencies later.
     *
     * @param filename The name of the file to read.
     * @return List of words.
     */
    public static List<String> readWordsFromFile(String filename) {
        List<String> words = new ArrayList<>();
        // TODO: Implement file reading, word extraction, and cleaning
        // Hints:
        // - Use Scanner or BufferedReader to read each line from the file
        // - Use line.split("\\s+") to split a line into words
        // - Use word.replaceAll("[^a-zA-Z]", "") to remove punctuation
        // - Convert each word to lowercase for case-insensitive comparison
        // - Add non-empty words to the list
        return words;
    }

    /**
     * Returns a Set of unique words from the list.
     *
     * Why use a Set? Sets automatically ignore duplicates, so only unique words are kept.
     *
     * @param words List of words.
     * @return Set of unique words.
     */
    public static Set<String> getUniqueWords(List<String> words) {
        // TODO: Implement using HashSet
        // Example: return new HashSet<>(words);
        return new HashSet<>();
    }

    /**
     * Returns a Map of word counts from the list.
     *
     * Why use a Map? Maps let us associate each word (the key) with its count (the value).
     *
     * @param words List of words.
     * @return Map of word to count.
     */
    public static Map<String, Integer> getWordCounts(List<String> words) {
        // TODO: Implement using HashMap
        // Example logic:
        // - For each word in the list:
        //     - If the word is already in the map, increment its count
        //     - Otherwise, add it to the map with count 1
        return new HashMap<>();
    }

    /**
     * Displays the required results: unique count, top 5, words appearing once, etc.
     *
     * @param uniqueWords Set of unique words.
     * @param wordCounts Map of word to count.
     */
    public static void displayResults(Set<String> uniqueWords, Map<String, Integer> wordCounts) {
        // TODO: Implement result display, sorting, and statistics
        // Hints:
        // - Print the size of the uniqueWords set
        // - To find the top 5 most common words:
        //     - Convert the map's entrySet to a list
        //     - Sort the list by value (descending)
        //     - Print the first 5 entries
        // - To count words that appear only once:
        //     - Loop through the map values and count how many are 1
    }
} 