package com.example.cefaloschoolproject.dictionary;

import java.util.List;

public interface IDictionary {
    void insert(String word);
    void remove(String word);
    int count(String prefix);
    boolean contains(String word);
    List<String> prefixSearch(String prefix,int count);
}
