package com.example.cefaloschoolproject;
import com.example.cefaloschoolproject.dictionary.TrieDictionary;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TrieDictionaryTest {

    @org.junit.jupiter.api.Test
    void insertWorksWell() {
        TrieDictionary trieDictionary = new TrieDictionary();;
        String[] words =  new String[]{"cat", "can", "cow", "coward", "city", "cab"};
        for(String s : words) trieDictionary.insert(s);
    }
    @org.junit.jupiter.api.Test
    void removeWorksWell_remove_a_word_that_is_present_in_the_dictionary() {
        TrieDictionary trieDictionary = new TrieDictionary();;
        String[] words =  new String[]{"cat", "can", "cow", "coward", "city", "cab"};
        for(String s : words) trieDictionary.insert(s);
        assertEquals(true,trieDictionary.contains("cat"));
        trieDictionary.remove("cat");
        assertEquals(false,trieDictionary.contains("cat"));
        assertEquals(words.length-1,trieDictionary.count("*"));
        assertEquals(words.length-1,trieDictionary.count("c"));
        assertEquals(2,trieDictionary.count("ca")); // can,cab
        assertEquals(0,trieDictionary.count("cat"));
        assertEquals(2,trieDictionary.count("cow")); // cow , coward
        assertEquals(1,trieDictionary.count("coward"));
        assertEquals(0,trieDictionary.count("dick"));

    }
    @org.junit.jupiter.api.Test
    void removeWorksWell_prefix_of_an_existing_word_but_no_present_in_dictionary(){
        TrieDictionary trieDictionary = new TrieDictionary();;
        String[] words =  new String[]{"cat", "can", "cow", "coward", "city", "cab"};
        for(String s : words) trieDictionary.insert(s);
        trieDictionary.remove("ca");
        assertEquals(words.length,trieDictionary.count("*"));
    }
    @org.junit.jupiter.api.Test
    void removeWorksWell_removed_word_has_a_prefix_in_the_dictionary(){
        TrieDictionary trieDictionary = new TrieDictionary();;
        String[] words =  new String[]{"cat", "can", "cow", "coward", "city", "cab"};
        for(String s : words) trieDictionary.insert(s);
        trieDictionary.remove("cate");
        assertEquals(words.length,trieDictionary.count("*"));
    }

    @org.junit.jupiter.api.Test
    void removeWorksWell_just_a_random_word(){
        TrieDictionary trieDictionary = new TrieDictionary();;
        String[] words =  new String[]{"cat", "can", "cow", "coward", "city", "cab"};
        for(String s : words) trieDictionary.insert(s);
        trieDictionary.remove("ball");
        assertEquals(words.length,trieDictionary.count("*"));
    }

    @org.junit.jupiter.api.Test
    void countWorksWell() {
        TrieDictionary trieDictionary =trieDictionary = new TrieDictionary();;
        String[] words =  new String[]{"cat", "can", "cow", "coward", "city", "cab"};
        for(String s : words) trieDictionary.insert(s);;
        assertEquals(words.length,trieDictionary.count("*"));
        assertEquals(words.length,trieDictionary.count("c"));
        assertEquals(3,trieDictionary.count("ca"));
        assertEquals(1,trieDictionary.count("cat"));
        assertEquals(2,trieDictionary.count("cow"));
        assertEquals(1,trieDictionary.count("coward"));
        assertEquals(0,trieDictionary.count("dick"));
    }
    @org.junit.jupiter.api.Test

    void containsWorksWell() {
        TrieDictionary trieDictionary =trieDictionary = new TrieDictionary();;
        String[] words =  new String[]{"cat", "can", "cow", "coward", "city", "cab"};
        for(String s : words) trieDictionary.insert(s);
        assertEquals(true,trieDictionary.contains("cat"));
        assertEquals(true,trieDictionary.contains("can"));
        assertEquals(true,trieDictionary.contains("cow"));
        assertEquals(true,trieDictionary.contains("coward"));
        assertEquals(true,trieDictionary.contains("city"));
        assertEquals(true,trieDictionary.contains("cab"));
        assertEquals(false,trieDictionary.contains("dick"));
    }

    @org.junit.jupiter.api.Test
    void prefixSearch() {
        TrieDictionary trieDictionary = new TrieDictionary();;
        String[] words =  new String[]{"cat", "can", "cow", "coward", "city", "cab"};
        for(String s : words) trieDictionary.insert(s);
        List<String> strings = trieDictionary.prefixSearch("ca", 3);
        assertEquals(true,strings.equals(Arrays.asList("cab","can", "cat")));
        assertEquals(true,trieDictionary.prefixSearch("cat",1).equals(Arrays.asList("cat")));
        assertEquals(true,trieDictionary.prefixSearch("ca",4).equals(Arrays.asList("cab","can", "cat")));
        assertEquals(true,trieDictionary.prefixSearch("ca",2).equals(Arrays.asList("cab","can")));
        assertEquals(true,trieDictionary.prefixSearch("ca",1).equals(Arrays.asList("cab")));
        assertEquals(true,trieDictionary.prefixSearch("ca",0).equals(Arrays.asList()));
        assertEquals(true,trieDictionary.prefixSearch("ba",10).equals(Arrays.asList()));
    }

}