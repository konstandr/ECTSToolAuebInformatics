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
    ArrayList<Subject> Subjects;

    void loadCsvToList(String csvPath) throws IOException, CsvValidationException {
        Subjects = new ArrayList<>();
        CSVReader reader = new CSVReader(new FileReader(csvPath));
        String[] line;
        int i = 0;
        while ((line = reader.readNext()) != null) {
            Subjects.add(new Subject(line[0], line[1], line[2],line[3], line[4], line[5],
                            line[6], Boolean.parseBoolean(line[7]), Boolean.parseBoolean(line[8]), Boolean.parseBoolean(line[9])));

        }

    }

    void ListToUser() throws IOException {
       CSVWriter writer = new CSVWriter(new FileWriter(("userData/" + userName + ".csv"), true));
       for (Subject line : Subjects) {
           writer.writeNext(line.toStringArr());
       }
       writer.close();
   }

   void anaforaPerasmenwMathimatwn() throws CsvValidationException, IOException {
        boolean exists = Files.exists(Path.of("userData/" + userName + ".csv"));

        Scanner in = new Scanner(System.in);
        if (!exists) {
            for (Subject aSubject : Subjects) {
                System.out.println("Exeis perasei " + aSubject.getName() + "?");
                String apanthsh = in.nextLine();
                if (apanthsh.equals("Nai") || apanthsh.equals("nai")) {
                    aSubject.setPerasmeno("nai");
                }
            }
            ListToUser();
            System.out.println("Created user csv!\n");
        } else {
            System.out.println("Yparxei hdh");
        }
       loadCsvToList("userData/" + userName + ".csv");

   }

    double printEcts() throws IOException, CsvValidationException {
        loadCsvToList("userData/" + userName + ".csv");
        double ect = 0;
        for (Subject aSubject : Subjects) {
            if (aSubject.getPerasmeno().equals("nai")) {
                ect += Double.parseDouble(aSubject.getEcts());
            }
        }
        System.out.println("O xrhsths " + userName + " exei " + ect + " ects apo 240");
        return ect;
    }

    void printKuklos() throws FileNotFoundException {
        String epil = printInfoKuklwn();
        for (Subject aSubject : Subjects) {
            if (aSubject.getPerasmeno().equals("nai") && aSubject.getKukloi().contains(String.valueOf(epil))) {
                System.out.println("To auksha gia to " + aSubject.getName());
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
    String print = "";
    void writeToTxt(String apanthsh, int fores) throws IOException {
        FileWriter out = new FileWriter("users_kukloi.txt", true);

        if (fores > 1) {
            print += " " + apanthsh + ",";
        } else {
            out.write("/" + getUserName() + print + " " + apanthsh);
            out.close();

        }
    }

    void oristeKuklousXrhsth() throws IOException {
        System.out.println("H diadikasia ginetai gia enan kuklo thn fora");
        String epil = printInfoKuklwn();
        for (Subject aSubject: Subjects){
            if (aSubject.getKukloi().contains(epil)){
                System.out.println(aSubject.getName() + " " + aSubject.getCode());
            }
        }
        System.out.println("Epelekse 5 mathimata apo auta vash tou kwdikou");
        int fores = 5;
        while (fores > 0) {
            Scanner in = new Scanner(System.in);
            String apanthsh = in.nextLine();
            writeToTxt(apanthsh, fores);
            fores--;
        }
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
        for (Subject aSubject : Subjects){
            if (aSubject.getEksamhno().equals(epil)){
                System.out.println(aSubject.getName() + " " + aSubject.getPerasmeno());
            }
        }
    }

    void selectMexriEksamhno(){
        System.out.println("Mexri poio eksamhno tha thelate na deite?");
        Scanner in = new Scanner(System.in);
        int epil = in.nextInt();
        System.out.println("Oriste ta mathimata pou exete perasei/xrwstate mexri to " + epil + "o eksamhno");
        for (int i = 1; i <= epil; i++) {
            for (Subject aSubject : Subjects){
                if (aSubject.getEksamhno().equals(String.valueOf(i))) {
                    System.out.println(aSubject.getName() + " " + aSubject.getPerasmeno());
                }
            }
        }
    }

    void selectMathimataEpiloghshYpoxrewtika(){
        System.out.println("Thelete mathimata epiloghs gia earino h xeimerino eksamhno? 0 1 2");
        Scanner in = new Scanner(System.in);
        int epil = in.nextInt();

        if (epil == 1){
            for (Subject aSubject : Subjects) {
                if (Integer.parseInt(aSubject.getEksamhno()) % 2 != 0 && aSubject.getPerasmeno().equals("oxi")) {
                    System.out.println(aSubject.getName());
                }
            }
        }
        else if (epil == 2){
            for (Subject aSubject : Subjects) {
                if (Integer.parseInt(aSubject.getEksamhno()) % 2 == 0 && aSubject.getPerasmeno().equals("oxi")) {
                    System.out.println(aSubject.getName());
                }
            }
        }
        else{
            for (Subject aSubject : Subjects) {
                if (aSubject.getPerasmeno().equals("oxi")) {
                    System.out.println(aSubject.getName());
                }
            }
        }
    }

    void dhmiourgiaProswpikouProgrammatos(){
        //TODO: requestInfoAboutKuklous, CalculateEcts, proteineMathimataKyklwn, deikseDiathesimaMathimataGiaSumplhrwsh240, gg;
       //Ehoume apothikeusei sto txt tous kuklous tou xrhsth
    }

}
