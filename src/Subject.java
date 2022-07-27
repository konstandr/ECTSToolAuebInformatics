package src;

public class Subject {
    String eksamhno;
    String code;
    String name;
    String ects;
    String proapaitoumena;
    String kukloi;
    String perasmeno;
    Boolean purhna;
    Boolean kuklous;
    Boolean epiloghs;

    Subject(String eksamhno, String code, String name, String ects, String proapaitoumena, String kukloi, String perasmeno, boolean purhna, boolean kuklous, boolean epiloghs){
        this.eksamhno = eksamhno;
        this.code = code;
        this.name = name;
        this.ects = ects;
        this.proapaitoumena = proapaitoumena;
        this.kukloi = kukloi;
        this.perasmeno = perasmeno;
        this.purhna = purhna;
        this.kuklous = kuklous;
        this.epiloghs = epiloghs;
    }
    public Boolean getPurhna() {
        return purhna;
    }


    public Boolean getKuklous() {
        return kuklous;
    }


    public Boolean getEpiloghs() {
        return epiloghs;
    }


    public String getPerasmeno() {
        return perasmeno;
    }

    public void setPerasmeno(String perasmeno) {
        this.perasmeno = perasmeno;
    }

    public String getEksamhno() {
        return eksamhno;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getEcts() {
        return ects;
    }

    public String getProapaitoumena() {
        return proapaitoumena;
    }

    public String getKukloi() {
        return kukloi;
    }

    public String[] toStringArr() {
        String toString = eksamhno + "/" +  code + "/" + name + "/" + ects + "/" + proapaitoumena + "/" + kukloi + "/" +
                          perasmeno + "/" + purhna + "/" + kuklous + "/" + epiloghs;
        return toString.split("/");
    }
}