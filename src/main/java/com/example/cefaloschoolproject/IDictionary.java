package com.example.cefaloschoolproject;

import java.util.List;

public interface IDictionary {
    void insert(String words);
    void remove(String words);
    int count(String prefix);
    boolean contains(String word);
    List<String> prefixSearch(String prefix,int count);
}
