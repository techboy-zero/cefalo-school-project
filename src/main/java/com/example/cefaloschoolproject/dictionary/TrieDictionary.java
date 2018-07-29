package com.example.cefaloschoolproject.dictionary;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

@Component
public class TrieDictionary implements IDictionary {
    private TrieTree root = new TrieTree();

    @Override
    public void insert(String word) {
        this.modifyDictionary(word, TrieOperation.INSERT);
    }

    @Override
    public void remove(String word) {
        this.modifyDictionary(word, TrieOperation.REMOVE);
    }

    private void modifyDictionary(String word, TrieOperation trieOperation) {
        int wordLength = word.length();
        ArrayList<TrieTree> path = new ArrayList<>();
        path.add(root);
        for (int index = 0; index < wordLength; index++) {
            TrieTree currentTree = path.get(index);
            char key = word.charAt(index);
            if (currentTree.getNode(key) == null) {
                if (trieOperation == TrieOperation.REMOVE) {
                    return;
                }
                currentTree.addNode(key, new TrieTree());
            }
            currentTree = currentTree.getNode(key);
            path.add(currentTree);
        }
        TrieTree endNode = path.get(wordLength);
        if (trieOperation == TrieOperation.INSERT) {
            endNode.setEndOfWord(true);
            path.forEach(node -> node.incDescendantCount());
        } else {
            if (endNode.isEndOfWord()) {
                endNode.setEndOfWord(false);
                path.forEach(node -> node.decDescendantCount());
                this.cleanUp(word, path);
            }
        }
    }

    private void cleanUp(String word, ArrayList<TrieTree> path) {
        int pathLength = path.size();
        for (int index = pathLength - 1; index >= 1; index--) {
            TrieTree node = path.get(index);
            if (node.getDescendantCount() > 0) {
                return;
            }

            if (index == 0) {

            }
            char key = word.charAt(index - 1);
            TrieTree parentNode = path.get(index - 1);
            parentNode.deleteNode(key);
        }
    }

    @Override
    public int count(String prefix) {
        int prefixLength = prefix.length();
        TrieTree currentTree = root;

        if (!prefix.equals("*")) {
            for (int index = 0; index < prefixLength; index++) {
                char key = prefix.charAt(index);
                currentTree = currentTree.getNode(key);
                if (currentTree == null) {
                    return 0;
                }
            }
        }

        return currentTree.getDescendantCount();
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
        int prefixLength = prefix.length();
        TrieTree currentTree = root;
        for (int index = 0; index < prefixLength; index++) {
            char key = prefix.charAt(index);
            currentTree = currentTree.getNode(key);
            if (currentTree == null) {
                return new ArrayList<>();
            }
        }
        return this.getFirstNMatches(prefix, currentTree, count);
    }

    private ArrayList<String> getFirstNMatches(
        String prefix, TrieTree node,
        int count
    ) {
        Deque<Pair<String, TrieTree>> store = new ArrayDeque<>();
        ArrayList<String> result = new ArrayList<>();

        if (count > 0) {
            store.addFirst(new Pair<>(prefix, node));
            while (!store.isEmpty()) {
                Pair<String, TrieTree> currentItem = store.removeFirst();
                String currentPrefix = currentItem.getFirst();
                TrieTree currentNode = currentItem.getSecond();

                if (currentNode.isEndOfWord()) {
                    count--;
                    result.add(currentPrefix);
                }

                if (count > 0) {
                    List<Character> keyList = currentNode.getChildrenKeys();
                    int keyListLength = keyList.size();

                    for (int i = keyListLength - 1; i >= 0; i--) {
                        char key = keyList.get(i);
                        String newPrefix = currentPrefix + key;
                        TrieTree newNode = currentNode.getNode(key);
                        store.addFirst(new Pair<>(newPrefix, newNode));
                    }
                }

                int storeSize = store.size();
                while(storeSize > count) {
                    store.removeLast();
                    storeSize--;
                }
            }
        }
        return result;
    }
}
