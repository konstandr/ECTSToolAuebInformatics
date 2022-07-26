import java.io.*;
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
    List<Subject> Subjects;
    void loadTxtToList(String txt) throws FileNotFoundException {
        Subjects = new ArrayList<>();
        //Scammer me delimiter to ", "
        Scanner sc = new Scanner(new FileReader(txt)).useDelimiter(", ");
        //String opoy tha vazw kathe string xD?!
        String str;
        boolean bool;
        // checking end of file
        while (sc.hasNext()) {
            Subject cla = new Subject();
            str = sc.next();
            cla.setEksamhno(str);
            str = sc.next();
            cla.setCode(str);
            str = sc.next();
            cla.setName(str);
            str = sc.next();
            cla.setEcts(str);
            str = sc.next();
            cla.setProapaitoumena(str);
            str = sc.next();
            cla.setKukloi(str);
            str = sc.next();
            cla.setPerasmeno(str);
            str = sc.next();
            cla.setPurhna(Boolean.parseBoolean(str));
            str = sc.next();
            cla.setKuklous(Boolean.parseBoolean(str));
            str = sc.next();
            cla.setEpiloghs(Boolean.parseBoolean(str));
            Subjects.add(cla);
        }

    }

    void anaforaPerasmenwMathimatwn() throws IOException {


        boolean exists = Files.exists(Path.of("/home/konstandr/ectsTOOL/" + userName + ".txt"));

        Scanner in = new Scanner(System.in);
        if (!exists) {
            FileWriter fout = new FileWriter(userName + ".txt", true);
            for (Subject aSubject : Subjects) {
                System.out.println("Exeis perasei " + aSubject.getName() + "?");
                String apanthsh = in.nextLine();
                if (apanthsh.equals("Nai") || apanthsh.equals("nai")) {
                    aSubject.setPerasmeno("nai");
                }
            }
            createTxt(fout);
            System.out.println("Created user txt!\n");
            fout.close();
        }
        /*else if (flag){
            System.out.println("Θα θέλατε να προσθέσετε/αφαιρέσετε μαθήματα ή απλά να συνεχίσετε; Απαντήστε 1 για να προσθέσετε/αφαιρέσετε, οτιδήποτε άλλο για να συνεχίσετε");
            int ap = in.nextInt();
            if (ap == 1){
                String fileName = userName+".txt";
                try {
                    Files.delete(Paths.get(fileName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                FileWriter fout1 = new FileWriter(userName + ".txt", true);
                for (Subject aSubject : Subjects) {
                    System.out.println("Exeis perasei " + aSubject.getName() + "?");
                    String apanthsh = in.next();
                    if (apanthsh.equals("Nai") || apanthsh.equals("nai") || apanthsh.equals("n")) {
                        aSubject.setPerasmeno("nai");
                    }
                    else{
                        aSubject.setPerasmeno("oxi");
                    }
                }
                createTxt(fout1);
                System.out.println("Recreated user txt!\n");
                fout1.close();
                flag = false;

            }
        }*/
    }

    private void createTxt(FileWriter fout) throws IOException {
        for (int i = 0; i < Subjects.size(); i++){
            fout.write(Subjects.get(i).getEksamhno() + ", ");
            fout.write(Subjects.get(i).getCode() + ", ");
            fout.write(Subjects.get(i).getName() + ", ");
            fout.write(Subjects.get(i).getEcts() + ", ");
            fout.write(Subjects.get(i).getProapaitoumena() + ", ");
            fout.write(Subjects.get(i).getKukloi() + ", ");


                fout.write(Subjects.get(i).getPerasmeno() + ", ");

            fout.write(Subjects.get(i).getPurhna() + ", ");
            fout.write(Subjects.get(i).getKuklous() + ", ");
            if (i < Subjects.size()-1) {
                fout.write(Subjects.get(i).getEpiloghs() + ", ");
            }
            else{
                fout.write(String.valueOf(Subjects.get(i).getEpiloghs()));
            }
        }
    }

    void printString() throws FileNotFoundException {
        //loadTxtToList(userName+".txt");
        for (int i = 0; i < Subjects.size(); i++){
            System.out.println(Subjects.get(i).getName() + " | " + Subjects.get(i).getEcts() + " | " +Subjects.get(i).getPerasmeno());
        }
    }

    double printEcts() throws FileNotFoundException {
        //loadTxtToList(userName+".txt");
        double ect = 0;
        System.out.println(Subjects.size());
        for (int i = 0; i < Subjects.size(); i++){
            //System.out.println(classes.get(i).getName() + " " + classes.get(i).getPerasmeno());
            if (Subjects.get(i).getPerasmeno().equals("nai")){
                ect += Double.parseDouble(Subjects.get(i).getEcts());
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

 /*   String oristeKuklousXrhsth() throws IOException {
        printInfoKuklwn();

    }*/

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
            for (Subject aClasRoom : Subjects) {

                if (Integer.parseInt(aClasRoom.getEksamhno()) % 2 != 0 && aClasRoom.getPerasmeno().equals("oxi")) {
                    System.out.println(aClasRoom.getName());
                }
            }
        }
        else if (epil == 2){
            for (Subject aClasRoom : Subjects) {
                if (Integer.parseInt(aClasRoom.getEksamhno()) % 2 == 0 && aClasRoom.getPerasmeno().equals("oxi")) {
                    System.out.println(aClasRoom.getName());
                }
            }
        }
        else{
            for (Subject aClasRoom : Subjects) {
                if (aClasRoom.getPerasmeno().equals("oxi")) {
                    System.out.println(aClasRoom.getName());
                }
            }
        }
    }

    void dhmiourgiaProswpikouProgrammatos(){
        //TODO: requestInfoAboutKuklous, CalculateEcts, proteineMathimataKyklwn, deikseDiathesimaMathimataGiaSumplhrwsh240, gg;
       //Ehoume apothikeusei sto txt tous kuklous tou xrhsth

    }


}
