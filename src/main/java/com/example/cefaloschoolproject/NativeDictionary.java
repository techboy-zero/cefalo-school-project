package com.example.cefaloschoolproject;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class NativeDictionary implements IDictionary {
    private Set<String > words = new TreeSet<>();

    @Override
    public void insert(String word) {
        this.words.add(word);
    }

    @Override
    public void remove(String word) {
        this.words.remove(word);
    }

    @Override
    public int count(String prefix) {
        if(prefix.compareTo("*") == 0) {
            return this.words.size();
        }
        int result = 0;
        for(String s : this.words){
            if(s.startsWith(prefix))result++;
        }
        return result;
    }

    @Override
    public boolean contains(String word) {
        return words.contains(word);
    }

    @Override
    public List<String> prefixSearch(String prefix, int count) {
        List<String> result = new ArrayList<>();
        for(String s : this.words){
            if(count==0)return result;
            if(s.startsWith(prefix)){
                result.add(s);
                count--;
            }
        }
        return result;
    }
}
