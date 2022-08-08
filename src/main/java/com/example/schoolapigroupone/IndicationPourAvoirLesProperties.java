package com.example.schoolapigroupone;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class IndicationPourAvoirLesProperties {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/application.properties");
            Properties p = new Properties();
            p.load(fis);
            System.out.println(p.get("spring.datasource.url"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
