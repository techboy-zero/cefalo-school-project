package com.example.cefaloschoolproject;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class TrieDictionary implements IDictionary {
    private TrieTree root = new TrieTree();;

    @Override
    public void insert(String word) {

    }

    @Override
    public void remove(String words) {

    }

    @Override
    public int count(String prefix) {
        return 0;
    }

    @Override
    public boolean contains(String word) {
        return true;
    }

    @Override
    public List<String> prefixSearch(String prefix, int count) {
        return null;
    }
}
