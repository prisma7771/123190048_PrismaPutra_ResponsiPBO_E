package Model;

public interface InterfaceModel {
    public int HitungData();
    public void showList();
    public int TambahData(String judul, Double alur, Double penokohan, Double Akting, Double Nilai);
    public int UpdateData(String judul, Double alur, Double penokohan, Double akting, Double nilai);
    public int HapusData(String judul);
    public int CekData(String judul);
    public int CekData2(String Judul);
}
