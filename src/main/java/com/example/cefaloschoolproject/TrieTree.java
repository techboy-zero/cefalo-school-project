package com.example.cefaloschoolproject;


import java.util.Dictionary;
import java.util.HashMap;

public class TrieTree {
    private HashMap<Character,TrieTree> edges = new HashMap<>();
    public TrieTree getNode(Character ch){
        return this.edges.getOrDefault(ch,null);
    }
    public void addNode(Character ch,TrieTree node){
        this.edges.put(ch,node);
    }
}
