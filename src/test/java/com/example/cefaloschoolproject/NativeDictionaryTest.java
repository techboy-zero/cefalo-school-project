package com.example.cefaloschoolproject;

import com.example.cefaloschoolproject.dictionary.NativeDictionary;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NativeDictionaryTest {

    @org.junit.jupiter.api.Test
    void insertWorksWell() {
        NativeDictionary nativeDictionary =nativeDictionary = new NativeDictionary();;
        String[] words =  new String[]{"cat", "can", "cow", "coward", "city", "cab"};
        for(String s : words) nativeDictionary.insert(s);
    }
    @org.junit.jupiter.api.Test
    void removeWorksWell_remove_a_word_that_is_present_in_the_dictionary() {
        NativeDictionary nativeDictionary = new NativeDictionary();;
        String[] words =  new String[]{"cat", "can", "cow", "coward", "city", "cab"};
        for(String s : words) nativeDictionary.insert(s);
        assertEquals(true,nativeDictionary.contains("cat"));
        nativeDictionary.remove("cat");
        assertEquals(false,nativeDictionary.contains("cat"));
        assertEquals(words.length-1,nativeDictionary.count("*"));
        assertEquals(words.length-1,nativeDictionary.count("c"));
        assertEquals(2,nativeDictionary.count("ca")); // can,cab
        assertEquals(0,nativeDictionary.count("cat"));
        assertEquals(2,nativeDictionary.count("cow")); // cow , coward
        assertEquals(1,nativeDictionary.count("coward"));
        assertEquals(0,nativeDictionary.count("dick"));

    }
    @org.junit.jupiter.api.Test
    void removeWorksWell_prefix_of_an_existing_word_but_no_present_in_dictionary(){
        NativeDictionary nativeDictionary = new NativeDictionary();;
        String[] words =  new String[]{"cat", "can", "cow", "coward", "city", "cab"};
        for(String s : words) nativeDictionary.insert(s);
        nativeDictionary.remove("ca");
        assertEquals(words.length,nativeDictionary.count("*"));
    }
    @org.junit.jupiter.api.Test
    void removeWorksWell_removed_word_has_a_prefix_in_the_dictionary(){
        NativeDictionary nativeDictionary = new NativeDictionary();;
        String[] words =  new String[]{"cat", "can", "cow", "coward", "city", "cab"};
        for(String s : words) nativeDictionary.insert(s);
        nativeDictionary.remove("cate");
        assertEquals(words.length,nativeDictionary.count("*"));
    }

    @org.junit.jupiter.api.Test
    void removeWorksWell_just_a_random_word(){
        NativeDictionary nativeDictionary = new NativeDictionary();;
        String[] words =  new String[]{"cat", "can", "cow", "coward", "city", "cab"};
        for(String s : words) nativeDictionary.insert(s);
        nativeDictionary.remove("ball");
        assertEquals(words.length,nativeDictionary.count("*"));
    }

    @org.junit.jupiter.api.Test
    void countWorksWell() {
        NativeDictionary nativeDictionary =nativeDictionary = new NativeDictionary();;
        String[] words =  new String[]{"cat", "can", "cow", "coward", "city", "cab"};
        for(String s : words) nativeDictionary.insert(s);;
        assertEquals(words.length,nativeDictionary.count("*"));
        assertEquals(words.length,nativeDictionary.count("c"));
        assertEquals(3,nativeDictionary.count("ca"));
        assertEquals(1,nativeDictionary.count("cat"));
        assertEquals(2,nativeDictionary.count("cow"));
        assertEquals(1,nativeDictionary.count("coward"));
        assertEquals(0,nativeDictionary.count("dick"));
    }
    @org.junit.jupiter.api.Test

    void containsWorksWell() {
        NativeDictionary nativeDictionary =nativeDictionary = new NativeDictionary();;
        String[] words =  new String[]{"cat", "can", "cow", "coward", "city", "cab"};
        for(String s : words) nativeDictionary.insert(s);
        assertEquals(true,nativeDictionary.contains("cat"));
        assertEquals(true,nativeDictionary.contains("can"));
        assertEquals(true,nativeDictionary.contains("cow"));
        assertEquals(true,nativeDictionary.contains("coward"));
        assertEquals(true,nativeDictionary.contains("city"));
        assertEquals(true,nativeDictionary.contains("cab"));
        assertEquals(false,nativeDictionary.contains("dick"));
    }

    @org.junit.jupiter.api.Test
    void prefixSearch() {
        NativeDictionary nativeDictionary = nativeDictionary = new NativeDictionary();;
        String[] words =  new String[]{"cat", "can", "cow", "coward", "city", "cab"};
        for(String s : words) nativeDictionary.insert(s);
        List<String> strings = nativeDictionary.prefixSearch("ca", 3);
        assertEquals(true,strings.equals(Arrays.asList("cab","can", "cat")));
        assertEquals(true,nativeDictionary.prefixSearch("cat",1).equals(Arrays.asList("cat")));
        assertEquals(true,nativeDictionary.prefixSearch("ca",4).equals(Arrays.asList("cab","can", "cat")));
        assertEquals(true,nativeDictionary.prefixSearch("ca",2).equals(Arrays.asList("cab","can")));
        assertEquals(true,nativeDictionary.prefixSearch("ca",1).equals(Arrays.asList("cab")));
        assertEquals(true,nativeDictionary.prefixSearch("ca",0).equals(Arrays.asList()));
        assertEquals(true,nativeDictionary.prefixSearch("ba",10).equals(Arrays.asList()));
    }

}