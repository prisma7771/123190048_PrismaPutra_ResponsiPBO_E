package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelApp implements InterfaceModel {

    int jmlData;
    public String data[][];
    private Statement statement;

    @Override
    public int HitungData() {
        int count = 5;
        try {
            String query = "SELECT COUNT(*) as count FROM movie";
            statement = (Statement) ConnectDatabase.Database().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                count = resultSet.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return count;
    }

    @Override
    public void showList() {
        try {
            data = new String[HitungData()][5];
            int jmlData = 0;
            String query = "Select * from movie";
            statement = (Statement) ConnectDatabase.Database().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                data[jmlData][0] = resultSet.getString("judul");
                data[jmlData][1] = resultSet.getString("alur");
                data[jmlData][2] = resultSet.getString("penokohan");
                data[jmlData][3] = resultSet.getString("akting");
                data[jmlData][4] = resultSet.getString("nilai");

                jmlData++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    @Override
    public int TambahData(String judul, Double alur, Double penokohan, Double akting, Double nilai) {
        int result = 0;
        try {
            if (CekData(judul) == 0) {

                String query = "INSERT INTO movie VALUES "
                        + "('" + judul + "','" + alur + "','" + penokohan + "','" + akting + "','" + nilai + "')";
                statement = ConnectDatabase.Database().createStatement();
                statement.executeUpdate(query);

                result = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public int UpdateData(String judul, Double alur, Double penokohan, Double akting, Double nilai) {
        int hitung = 0;
        try {
            if (CekData2(judul) == 1) {

                String query = "UPDATE movie SET judul ='" + judul + "',alur = '" + alur + "',penokohan ='" + penokohan + "',akting ='" + akting + "',nilai = '" + nilai
                        + "' WHERE judul = '" + judul + "'";
                statement = (Statement) ConnectDatabase.Database().createStatement();
                statement.executeUpdate(query);
                hitung = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return hitung;
    }
    @Override
    public int HapusData(String judul) {
        int result = 0;
        try {
            if (CekData2(judul) == 1) {
                String query = "DELETE from movie where judul ='" + judul + "'";
                statement = ConnectDatabase.Database().createStatement();
                statement.executeUpdate(query);

                result = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public int CekData(String Judul) {
        int hitung = 0;
        try {
            String query = "SELECT COUNT(*) as hitung from movie WHERE judul = '" + Judul + "'";
            statement = ConnectDatabase.Database().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                hitung = resultSet.getInt("hitung");
                if (hitung == 1) {

                    JOptionPane.showMessageDialog(null, "Data Sudah Ada!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return hitung;
    }

    @Override
    public int CekData2(String Judul) {
        int hitung = 0;
        try {
            String query = "SELECT COUNT(*) as hitung from movie WHERE judul = '" + Judul + "'";
            statement = ConnectDatabase.Database().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                hitung = resultSet.getInt("hitung");
                if (hitung == 0) {
                    JOptionPane.showMessageDialog(null, "Data Tidak Ada!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return hitung;
    }
}
