package src;

import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {



    // include throws to handle some file handling exceptions
    public static void main(String[] args) throws IOException, CsvValidationException {

        System.out.println("Parakalw oriste xrhsth");
        Scanner in = new Scanner(System.in);
        String user = in.nextLine();
        Methods methods = new Methods(user);
        System.out.println(("Καλώς 'Ηρθατε αγαπητέ/ή " + methods.getUserName()));
        methods.loadCsvToList("data/mathimata.csv");
        methods.anaforaPerasmenwMathimatwn();
        //methods.loadTxtToList(methods.getUserName() + ".txt");
        while (true) {
            System.out.println("Epelekse 1 gia na deis posa ects eheis");
            System.out.println("Epelekse 2 gia na deis analytika poia mathimata eheis perasei kai poia oxi");
            System.out.println("Epelekse 3 gia na deis posa mathimata soy menoyn gia enan kyklo");
            String epil = in.next();
           // methods.anaforaPerasmenwMathimatwn();

            switch (epil) {
                case "1" -> System.out.println(methods.printEcts());
                //case "2" -> methods.printString();
                case "3" -> methods.printKuklos();
                case "4" -> methods.selectEksamhno();
                case "5" -> methods.selectMexriEksamhno();
                case "6" -> methods.selectMathimataEpiloghshYpoxrewtika();
                default -> {
                }
            }
            System.out.println("Tha thelate kati allo?");
            String ap = in.next();
            if(ap.equals("0")){
                break;
            }
        }

    }



}