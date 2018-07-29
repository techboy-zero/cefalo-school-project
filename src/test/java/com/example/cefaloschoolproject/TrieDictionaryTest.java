package com.example.cefaloschoolproject;

import com.example.cefaloschoolproject.dictionary.TrieDictionary;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrieDictionaryTest {

    void dictionaryStateIsNotChanged(
        TrieDictionary trieDictionary, String[]
        words
    ) {
        int wordsLength = words.length;
        assertEquals(wordsLength, trieDictionary.count("*"));
        for (int i = 0; i < wordsLength; i++) {
            assertEquals(true, trieDictionary.contains(words[i]));
        }
    }

    @Test
    void insertOp_works_properly() {
        TrieDictionary trieDictionary = new TrieDictionary();
        String[] words = new String[]{"cat", "can", "cow", "coward", "city"};
        for (String s : words) trieDictionary.insert(s);
        assertEquals(words.length, trieDictionary.count("*"));
        assertTrue(trieDictionary.prefixSearch("", 5)
                       .containsAll(Arrays.asList(words)));
    }

    @Test
    void insertOp_works_properly_in_any_order() {
        TrieDictionary trieDictionary = new TrieDictionary();
        String[] words0 = new String[]{"cat", "can", "cow"};
        String[] words1 = new String[]{"can", "cat", "cow"};
        for (String s : words0) trieDictionary.insert(s);
        assertEquals(words0.length, trieDictionary.count("*"));
        assertTrue(trieDictionary.prefixSearch("", 3)
                       .containsAll(Arrays.asList(words0)));
        for (String s : words0) trieDictionary.remove(s);
        for (String s : words1) trieDictionary.insert(s);
        assertEquals(words0.length, trieDictionary.count("*"));
        assertTrue(trieDictionary.prefixSearch("", 3)
                       .containsAll(Arrays.asList(words0)));
    }

    @Test
    void removeOp_works_on_a_word_that_is_present_in_the_dictionary() {
        TrieDictionary trieDictionary = new TrieDictionary();
        String[] words = new String[]{"cat", "can", "cow", "coward", "city"};
        for (String s : words) trieDictionary.insert(s);
        assertEquals(true, trieDictionary.contains("cat"));
        trieDictionary.remove("cat");
        assertEquals(false, trieDictionary.contains("cat"));
        assertEquals(0, trieDictionary.count("cat"));
        assertEquals(words.length - 1, trieDictionary.count("*"));
        assertEquals(1, trieDictionary.count("ca"));
    }

    @Test
    void removeOp_avoids_words_not_present_in_dictionary() {
        TrieDictionary trieDictionary = new TrieDictionary();
        String[] words = new String[]{"cat", "can", "cow", "coward", "city"};
        for (String s : words) trieDictionary.insert(s);
        trieDictionary.remove("camera");
        this.dictionaryStateIsNotChanged(trieDictionary, words);
    }

    @Test
    void removeOp_avoids_prefixes_of_words_in_the_dictionary() {
        TrieDictionary trieDictionary = new TrieDictionary();
        String[] words = new String[]{"cat", "can", "cow", "coward", "city"};
        for (String s : words) trieDictionary.insert(s);
        trieDictionary.remove("ca");
        this.dictionaryStateIsNotChanged(trieDictionary, words);
    }

    @Test
    void removeOp_avoids_words_that_have_prefixes_in_the_dictionary() {
        TrieDictionary trieDictionary = new TrieDictionary();
        String[] words = new String[]{"cat", "can", "cow", "coward", "city",};
        for (String s : words) trieDictionary.insert(s);
        trieDictionary.remove("cate");
        this.dictionaryStateIsNotChanged(trieDictionary, words);
    }

    @Test
    void removeOp_works_properly_in_any_order() {
        TrieDictionary trieDictionary = new TrieDictionary();
        String[] words = new String[]{"cat", "can", "cow"};
        for (String s : words) trieDictionary.insert(s);
        trieDictionary.remove("can");
        assertEquals(2, trieDictionary.count("*"));
        trieDictionary.remove("cat");
        assertEquals(1, trieDictionary.count("*"));
        trieDictionary.remove("cow");
        assertEquals(0, trieDictionary.count("*"));
    }

    @Test
    void count_works_properly() {
        TrieDictionary trieDictionary = new TrieDictionary();
        String[] words = new String[]{"cat", "can", "cow", "coward", "city"};
        for (String s : words) trieDictionary.insert(s);
        assertEquals(words.length, trieDictionary.count("*"));
        assertEquals(words.length, trieDictionary.count("c"));
        assertEquals(0, trieDictionary.count("b"));
        assertEquals(2, trieDictionary.count("ca"));
        assertEquals(1, trieDictionary.count("cat"));
        assertEquals(2, trieDictionary.count("cow"));
        assertEquals(1, trieDictionary.count("coward"));
    }

    @Test
    void contains_works_properly() {
        TrieDictionary trieDictionary = new TrieDictionary();
        String[] words = new String[]{"cat", "can", "cow", "coward", "city"};
        for (String s : words) trieDictionary.insert(s);
        assertEquals(true, trieDictionary.contains("cat"));
        assertEquals(true, trieDictionary.contains("can"));
        assertEquals(true, trieDictionary.contains("cow"));
        assertEquals(true, trieDictionary.contains("coward"));
        assertEquals(true, trieDictionary.contains("city"));
        assertEquals(false, trieDictionary.contains("cab"));
    }

    @Test
    void prefixSearch_works_properly() {
        TrieDictionary trieDictionary = new TrieDictionary();
        String[] words = new String[]{"cat", "can", "cow", "coward", "city",
            "cab"};
        for (String s : words) trieDictionary.insert(s);
        List<String> strings = trieDictionary.prefixSearch("ca", 3);
        assertEquals(true, strings.equals(Arrays.asList("cab", "can", "cat")));
        assertEquals(true, trieDictionary.prefixSearch("cat", 1).equals(
            Arrays.asList("cat")));
        assertEquals(true, trieDictionary.prefixSearch("ca", 4).equals(
            Arrays.asList("cab", "can", "cat")));
        assertEquals(true, trieDictionary.prefixSearch("ca", 2).equals(
            Arrays.asList("cab", "can")));
        assertEquals(true, trieDictionary.prefixSearch("ca", 1).equals(
            Arrays.asList("cab")));
        assertEquals(true, trieDictionary.prefixSearch("ca", 0).equals(
            Arrays.asList()));
        assertEquals(true, trieDictionary.prefixSearch("ba", 10).equals(
            Arrays.asList()));
        List<String> allWords = trieDictionary.prefixSearch("", 100);
        assertEquals(true, allWords.containsAll(Arrays.asList(words)));
    }
}