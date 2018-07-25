package com.example.cefaloschoolproject;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class TrieDictionary implements IDictionary {
    private TrieTree root = new TrieTree();

    @Override
    public void insert(String word) {
        int wordLength = word.length();
        TrieTree currentTree = root;
        for (int index = 0; index < wordLength; index++) {
            char key = word.charAt(index);
            if (currentTree.getNode(key) == null) {
                currentTree.addNode(key, new TrieTree());
            }
            currentTree = currentTree.getNode(key);
            if (index == wordLength - 1) {
                currentTree.setEndOfWord(true);
            }
        }
    }

    @Override
    public void remove(String word) {
        int wordLength = word.length();
        TrieTree currentTree = root;
        for (int index = 0; index < wordLength; index++) {
            char key = word.charAt(index);
            currentTree = currentTree.getNode(key);
            if (currentTree == null) {
                return;
            }
            if (index == wordLength - 1) {
                currentTree.setEndOfWord(false);
            }
        }
    }

    @Override
    public int count(String prefix) {
        int prefixLength = prefix.length();
        TrieTree currentTree = root;

        if (prefix.compareTo("*") == 0) {
            return countAllWord(currentTree);
        }

        for (int index = 0; index < prefixLength; index++) {
            char key = prefix.charAt(index);
            currentTree = currentTree.getNode(key);
            if (currentTree == null) {
                return 0;
            }
        }

        return countAllWord(currentTree);
    }

    private int countAllWord(TrieTree node) {
        if (node == null) return 0;
        int wordCount = node.isEndOfWord() ? 1 : 0;
        List<TrieTree> children = node.getChildren();
        for (TrieTree child : children) {
            wordCount += countAllWord(child);
        }
        return wordCount;
    }

    @Override
    public boolean contains(String word) {
        int wordLength = word.length();
        TrieTree currentTree = root;
        for (int index = 0; index < wordLength; index++) {
            char key = word.charAt(index);
            currentTree = currentTree.getNode(key);
            if (currentTree == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<String> prefixSearch(String prefix, int count) {
        return null;
    }
}
