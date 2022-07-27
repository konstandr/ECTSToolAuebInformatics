package src;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Methods {
//TODO: pare upopsin tis alusides

    private String userName;

    public Methods(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    private int episthmhDedomenwn = 0;
    private int epixeirisiakhEreuna = 0;
    private int efarmosmenaMathimatika = 0;
    private int thewritikhPlhroforikh = 0;
    private int susthmataKaiDiktua = 0;
    private int susthmataLogismikou = 0;
    private int diaxeirishDedKaiGnwsewn = 0;
    private int kuvernoasfaleia = 0;
    ArrayList<String[]> Subjects;

    void loadCsvToList(String csvPath) throws IOException, CsvValidationException {
        Subjects = new ArrayList<String[]>();
        CSVReader reader = new CSVReader(new FileReader(csvPath));
        String[] line;
        int i = 0;
        while ((line = reader.readNext()) != null) {
            Subjects.add(line);
        }

    }

    void ListToUser() throws IOException {
       CSVWriter writer = new CSVWriter(new FileWriter(("userData/" + userName + ".csv"), true));
       for (String[] line : Subjects) {
           writer.writeNext(line);
       }
       writer.close();
   }

    void anaforaPerasmenwMathimatwn() throws CsvValidationException, IOException {
        boolean exists = Files.exists(Path.of("userData/" + userName + ".csv"));
        loadCsvToList("userData/" + userName + ".csv");
        Scanner in = new Scanner(System.in);
        if (!exists) {
            for (String[] aSubject : Subjects) {
                System.out.println("Exeis perasei " + aSubject[2] + "?");
                String apanthsh = in.nextLine();
                if (apanthsh.equals("Nai") || apanthsh.equals("nai")) {
                    aSubject[6] = "nai";
                }
            }
            ListToUser();
            System.out.println("Created user csv!\n");
        } else {
            System.out.println("Yparxei hdh");
        }
    }

    double printEcts() throws IOException, CsvValidationException {
        loadCsvToList("userData/" + userName + ".csv");
        double ect = 0;
        for (String[] aSubject : Subjects) {
            if (aSubject[6].equals("nai")) {
                ect += Double.parseDouble(aSubject[3]);
            }
        }
        System.out.println("O xrhsths " + userName + " exei " + ect + " ects apo 240");
        return ect;
    }

    void printKuklos() throws FileNotFoundException {
        String epil = printInfoKuklwn();
        for (String[] aSubject : Subjects) {
            if (aSubject[6].equals("nai") && aSubject[5].contains(String.valueOf(epil))) {
                System.out.println("To auksha gia to " + aSubject[2]);
                switch (epil) {
                    case "1" -> episthmhDedomenwn++;
                    case "2" -> epixeirisiakhEreuna++;
                    case "3" -> efarmosmenaMathimatika++;
                    case "4" -> thewritikhPlhroforikh++;
                    case "5" -> susthmataKaiDiktua++;
                    case "6" -> susthmataLogismikou++;
                    case "7" -> diaxeirishDedKaiGnwsewn++;
                    case "8" -> kuvernoasfaleia++;
                }
            }
        }

        switch (epil) {
            case "1" -> System.out.println("Sou apomenoun "  + (5 - episthmhDedomenwn) +" mathimata gia auton ton kyklo!");
            case "2" -> System.out.println("Sou apomenoun "  + (5 - epixeirisiakhEreuna) +" mathimata gia auton ton kyklo!");
            case "3" -> System.out.println("Sou apomenoun "  + (5 - efarmosmenaMathimatika) +" mathimata gia auton ton kyklo!");
            case "4" -> System.out.println("Sou apomenoun "  + (5 - thewritikhPlhroforikh) +" mathimata gia auton ton kyklo!");
            case "5" -> System.out.println("Sou apomenoun "  + (5 - susthmataKaiDiktua) +" mathimata gia auton ton kyklo!");
            case "6" -> System.out.println("Sou apomenoun "  + (5 - susthmataLogismikou) +" mathimata gia auton ton kyklo!");
            case "7" -> System.out.println("Sou apomenoun "  + (5 - diaxeirishDedKaiGnwsewn) +" mathimata gia auton ton kyklo!");
            case "8" -> System.out.println("Sou apomenoun "  + (5 - kuvernoasfaleia) +" mathimata gia auton ton kyklo!");
        }

    }

    void oristeKuklousXrhsth() throws IOException {
        printInfoKuklwn();
    }

    String printInfoKuklwn(){
        System.out.println("Gia poion kyklo endiafereste?");
        System.out.println("Pathste 1 gia ton kyklo episthmhs dedomenwn");
        System.out.println("Pathste 2 gia ton kyklo epixeirisiakhs ereunas");
        System.out.println("Pathste 3 gia ton kyklo efarmosnenwn mathimatikwn");
        System.out.println("Pathste 4 gia ton kyklo thewritikhs plhroforikhs");
        System.out.println("Pathste 5 gia ton kyklo susthmata kai diktua");
        System.out.println("Pathste 6 gia ton kyklo susthmata logismikou");
        System.out.println("Pathste 7 gia ton kyklo diaxeirishs dedomenwn kai gnwsewn");
        System.out.println("Pathste 8 gia ton kyklo kyvernoasfaleias");
        Scanner in = new Scanner(System.in);
        String epil = in.next();
        System.out.println("Epelekses " + epil);
        return epil;
    }
    void selectEksamhno(){
        System.out.println("Poio eksamhno tha thelate na deite?");
        Scanner in = new Scanner(System.in);
        String epil = in.next();
        System.out.println("Oriste ta mathimata pou exete perasei/xrwstate sto " + epil + "o eksamhno");
        for (String[] aSubject : Subjects){
            if (aSubject[0].equals(epil)){
                System.out.println(aSubject[2] + " " + aSubject[6]);
            }
        }
    }

    void selectMexriEksamhno(){
        System.out.println("Mexri poio eksamhno tha thelate na deite?");
        Scanner in = new Scanner(System.in);
        int epil = in.nextInt();
        System.out.println("Oriste ta mathimata pou exete perasei/xrwstate mexri to " + epil + "o eksamhno");
        for (int i = 1; i <= epil; i++) {
            for (String[] aSubject : Subjects){
                if (aSubject[0].equals(String.valueOf(i))) {
                    System.out.println(aSubject[2] + " " + aSubject[6]);
                }
            }
        }
    }

    void selectMathimataEpiloghshYpoxrewtika(){
        System.out.println("Thelete mathimata epiloghs gia earino h xeimerino eksamhno? 0 1 2");
        Scanner in = new Scanner(System.in);
        int epil = in.nextInt();

        if (epil == 1){
            for (String[] aClasRoom : Subjects) {
                if (Integer.parseInt(aClasRoom[0]) % 2 != 0 && aClasRoom[6].equals("oxi")) {
                    System.out.println(aClasRoom[2]);
                }
            }
        }
        else if (epil == 2){
            for (String[] aClasRoom : Subjects) {
                if (Integer.parseInt(aClasRoom[0]) % 2 == 0 && aClasRoom[6].equals("oxi")) {
                    System.out.println(aClasRoom[2]);
                }
            }
        }
        else{
            for (String[] aClasRoom : Subjects) {
                if (aClasRoom[6].equals("oxi")) {
                    System.out.println(aClasRoom[2]);
                }
            }
        }
    }

    void dhmiourgiaProswpikouProgrammatos(){
        //TODO: requestInfoAboutKuklous, CalculateEcts, proteineMathimataKyklwn, deikseDiathesimaMathimataGiaSumplhrwsh240, gg;
       //Ehoume apothikeusei sto txt tous kuklous tou xrhsth
    }

}
