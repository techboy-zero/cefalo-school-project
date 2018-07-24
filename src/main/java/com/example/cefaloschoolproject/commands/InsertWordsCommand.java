package com.example.cefaloschoolproject.commands;

import java.util.List;

public class InsertWordsCommand implements ICommand{
    private List<String> words;

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }
}
