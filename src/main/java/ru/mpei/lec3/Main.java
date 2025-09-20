package ru.mpei.lec3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class Main {
    static Logger logger = LoggerFactory.getLogger(Main.class.getName());

    public static void main(String[] args) {
        PalindromeChecker p = new PalindromeChecker();

        boolean res = p.check(12321);
        logger.info("res: " + res);
        List<String> data = null;
        try {
            Path path = Paths.get("src/main/resources/fileTest.txt");
            data = Files.readAllLines(path);
            logger.info("read: " + data);
        } catch (IOException e) {
            logger.error("excpetion occurred during reading file:", e);
            throw new RuntimeException("File not found . Exiting programm");
        }
        if (data == null) {
            try {
                logger.info("Creating new file:");
                File f = new File("src/main/resources/fileTest2.txt");
                Files.createFile(f.toPath());
            } catch (Exception e){
                logger.error("excpetion occurred during creating file:", e);
                return;
            } finally {
                logger.info("Finally");
            }
        }

//        int b = 2 / 0;
//        logger.info("b: " + b);

        try {
            p.check(-123);
        } catch (ArithmeticException | NumberFormatException | PalindromeException e) {
            logger.error("excpetion occurred during checking:", e);
            e.printStackTrace();
        } catch (Exception e) {
            logger.error("Unepectede excpetion occurred during checking:", e);
        }

        logger.info("finish");
    }
}
