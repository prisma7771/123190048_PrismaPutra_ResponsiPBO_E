package Controller;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Data {
   private String Judul;
   private Double alur,penokohan,akting,nilai;

    public Data(String Judul, Double alur, Double penokohan, Double akting, Double nilai) {
        this.Judul = Judul;
        this.alur = alur;
        this.penokohan = penokohan;
        this.akting = akting;
        this.nilai = nilai;
    }
 
    public Double HitungNilai (Double alur, Double penokohan, Double akting){
        nilai = (alur+penokohan+akting)/3;
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.DOWN);
        nilai = Double.parseDouble(df.format(nilai));
        return  nilai;
    }

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String Judul) {
        this.Judul = Judul;
    }

    public Double getAlur() {
        return alur;
    }

    public void setAlur(Double alur) {
        this.alur = alur;
    }

    public Double getPenokohan() {
        return penokohan;
    }

    public void setPenokohan(Double penokohan) {
        this.penokohan = penokohan;
    }

    public Double getAkting() {
        return akting;
    }

    public void setAkting(Double akting) {
        this.akting = akting;
    }

    public Double getNilai() {
        return nilai;
    }

    public void setNilai(Double nilai) {
        this.nilai = nilai;
    }
    
    
}
