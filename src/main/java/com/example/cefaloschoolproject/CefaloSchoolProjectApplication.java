package com.example.cefaloschoolproject;

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
    private CommandLineHelper commandLineHelper;
    @Autowired
    private CommandDispatcher commandDispatcher;
    @Override
    public void run(String... args) throws Exception {
        commandLineHelper.defineOptions();
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String line = sc.nextLine();
                ICommand command = commandLineHelper.parse(line);
                commandDispatcher.dispatch(command);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
