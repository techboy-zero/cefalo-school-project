package com.example.cefaloschoolproject;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class TrieTree {
    private boolean isWord = false;
    private HashMap<Character,TrieTree> edges = new HashMap<>();

    public boolean isEndOfWord() {
        return isWord;
    }

    public void setEndOfWord(boolean isWord) {
        this.isWord = isWord;
    }

    public TrieTree getNode(Character key){
        return this.edges.getOrDefault(key,null);
    }

    public void addNode(Character key, TrieTree node){
        this.edges.put(key, node);
    }

    public ArrayList<TrieTree> getChildren() {
        Collection<TrieTree> nodes =  edges.values();
        return new ArrayList<>(nodes);
    }
}
