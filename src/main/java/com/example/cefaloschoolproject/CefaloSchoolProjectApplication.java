package com.example.cefaloschoolproject;

import com.example.cefaloschoolproject.commands.ICommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@SpringBootApplication
@Component
public class CefaloSchoolProjectApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(CefaloSchoolProjectApplication.class, args);
    }
    @Autowired
    CommandDefinitions commandDefinitions;
    @Autowired
    private CommandLineHelper commandLineHelper;

    @Override
    public void run(String... args) throws Exception {
        commandDefinitions.defineOptions();
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String line = sc.nextLine();
                ICommand command = commandLineHelper.parse(line);
                command.disPatch();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
