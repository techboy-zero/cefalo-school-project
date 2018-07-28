package com.example.cefaloschoolproject.dictionary;


import java.util.*;

public class TrieTree {
    private boolean isWord = false;
    private int descendantCount = 0;
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

    public void deleteNode(Character key) {
        this.edges.remove(key);
    }

    public ArrayList<Character> getChildrenKeys() {
        Collection<Character> keys = edges.keySet();
        ArrayList<Character> keyList = new ArrayList<>(keys);
        Collections.sort(keyList);
        return keyList;
    }

    public int getDescendantCount() {
      return this.descendantCount;
    }

    public void incDescendantCount() {
        this.descendantCount++;
    }

    public void decDescendantCount() {
        if (this.descendantCount > 0) {
            this.descendantCount--;
        }
    }
}
