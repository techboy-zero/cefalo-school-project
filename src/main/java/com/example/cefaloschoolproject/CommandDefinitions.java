package com.example.cefaloschoolproject;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CommandDefinitions {
    @Autowired
    private CommandLineOptions options;
    public void defineOptions(){
        addHelpOption();
        addExitOption();
        addInsertCommand();
        addCountCommand();
        addContainsCommand();
        addPrefixCommand();
        addRemoveCommand();
    }

    private void addRemoveCommand() {
        Option option = new Option("remove", "remove",true, "Removes word from the dictionary");
        options.addOption(option);
    }

    private void addPrefixCommand() {
        Option option = new Option("prefix", "prefix",true, "Words in the dictionary with prefix-");
        options.addOption(option);
    }

    private void addContainsCommand() {
        Option option = new Option("contains", "contains",true, "If a word is present in the dictionary");
        options.addOption(option);
    }

    private void addCountCommand() {
        Option option = new Option("count", "count",true, "Shows total number of words");
        options.addOption(option);
    }

    private void addInsertCommand() {
        Option option = new Option("insert", "insert",true, "Insert words into the dictionary");
        options.addOption(option);
    }

    private void addExitOption() {
        Option option = new Option("exit", false, "Terminates the application");
        options.addOption(option);
    }

    private void addHelpOption() {
        Option option = new Option("help", false, "Displays helps");
        options.addOption(option);
    }
}
