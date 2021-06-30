package Controller;

import Model.ModelApp;
import View.ViewApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControllerApp extends Data implements ActionListener {

    ViewApp view;
    ModelApp model;
 
    public ControllerApp(ViewApp view, ModelApp model, String Judul, Double alur, Double penokohan, Double akting, Double nilai) {
        super(Judul, alur, penokohan, akting, nilai);
        this.view = view;
        this.model = model;

        view.tambah.addActionListener(this);
        view.update.addActionListener(this);
        view.delete.addActionListener(this);
        view.clear.addActionListener(this);

        if (model.HitungData() != 0) {
            model.showList();
            view.tabel.setModel((new JTable(model.data, view.namaKolom)).getModel());
            view.tabel.getColumnModel().getColumn(0).setPreferredWidth(100);
            view.tabel.getColumnModel().getColumn(1).setPreferredWidth(100);
            view.tabel.getColumnModel().getColumn(2).setPreferredWidth(100);
            view.tabel.getColumnModel().getColumn(3).setPreferredWidth(100);
            view.tabel.getColumnModel().getColumn(4).setPreferredWidth(100);
            view.tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        }
        else
        {
         JOptionPane.showMessageDialog(null,"Data Masih Kosong");
        }
        
        view.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int row = view.tabel.getSelectedRow();
                String judul = view.tabel.getValueAt(row, 0).toString();
                String alur = view.tabel.getValueAt(row,1).toString();
                String penokohan = view.tabel.getValueAt(row,2).toString();
                String akting = view.tabel.getValueAt(row,3).toString();
                
                view.fjudul.setText(judul);
                view.falur.setText(alur);
                view.fpenokohan.setText(penokohan);
                view.fakting.setText(akting);
                
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.tambah) {
            if (view.getFjudul().equals("") || view.getFalur().equals("") || view.getFpenokohan().equals("") || view.getFakting().equals("")) {
                JOptionPane.showMessageDialog(null,
                        "Mohon Lengkapi Data ");
            } else {
                try {
                    setJudul(view.getFjudul());
                    setAlur(Double.parseDouble(view.getFalur()));
                    setPenokohan(Double.parseDouble(view.getFpenokohan()));
                    setAkting(Double.parseDouble(view.getFakting()));

                    if (getAlur() > 5 || getPenokohan() > 5 || getAkting() > 5 || getAlur() < 0 || getPenokohan() < 0 || getAkting() < 0) {
                        throw new Exception();
                    }

                    super.HitungNilai(getAlur(), getPenokohan(), getAkting());
                    if (model.TambahData(getJudul(), getAlur(), getPenokohan(), getAkting(), getNilai()) == 1) {
                        JOptionPane.showMessageDialog(null,
                                "Berhasil Menambahkan Review " + getJudul());
                        refreshTabel();
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Gagal Menambahkan Review");
                    }
                } catch (NumberFormatException er) {
                    JOptionPane.showMessageDialog(null,
                            " Alur, Penokohan, dan Akting harus berupa angka");
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Nilai Alur, Penokohan, dan Akting harus di kisaran 0-5");
                }
            }
        } else if (e.getSource() == view.update) {
            if (view.getFjudul().equals("") || view.getFalur().equals("") || view.getFpenokohan().equals("") || view.getFakting().equals("")) {
                JOptionPane.showMessageDialog(null,
                        "Mohon Lengkapi Data ");
            } else {
                try {
                    setJudul(view.getFjudul());
                    setAlur(Double.parseDouble(view.getFalur()));
                    setPenokohan(Double.parseDouble(view.getFpenokohan()));
                    setAkting(Double.parseDouble(view.getFakting()));

                    if (getAlur() > 5 || getPenokohan() > 5 || getAkting() > 5 || getAlur() < 0 || getPenokohan() < 0 || getAkting() < 0) {
                        throw new Exception();
                    }

                    super.HitungNilai(getAlur(), getPenokohan(), getAkting());
                    if (model.UpdateData(getJudul(), getAlur(), getPenokohan(), getAkting(), getNilai()) == 1) {
                        JOptionPane.showMessageDialog(null,
                                "Berhasil Meng-Update " + getJudul());
                        refreshTabel();
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Gagal Update Data");
                    }
                } catch (NumberFormatException er) {
                    JOptionPane.showMessageDialog(null,
                            " Alur, Penokohan, dan Akting harus berupa angka");
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Nilai Alur, Penokohan, dan Akting harus di kisaran 0-5");
                }
            }
        } else if (e.getSource() == view.delete) {
           if (view.getFjudul().equals("") || view.getFalur().equals("") || view.getFpenokohan().equals("") || view.getFakting().equals("")) {
                JOptionPane.showMessageDialog(null,
                        "Mohon Lengkapi Data ");
            } else {
               
                    setJudul(view.getFjudul());
                    int confirm = JOptionPane.showConfirmDialog(null,
                        "Hapus Review untuk Film " + getJudul() + " ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

                if (confirm == 0) {
                    if (model.HapusData(getJudul()) == 1) {
                        JOptionPane.showMessageDialog(null,
                                "Berhasil Menghapus " + getJudul());
                         refreshTabel();
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Gagal Menghapus " + getJudul());
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Batal Hapus");
                }
               
            }
        } else if (e.getSource() == view.clear) {
            view.fjudul.setText("");
            view.falur.setText("");
            view.fpenokohan.setText("");
            view.fakting.setText("");
        }
    }

    public void refreshTabel() {
        model.showList();

        view.tabel.setModel((new JTable(model.data, view.namaKolom)).getModel());
        view.tabel.getColumnModel().getColumn(0).setPreferredWidth(100);
        view.tabel.getColumnModel().getColumn(1).setPreferredWidth(100);
        view.tabel.getColumnModel().getColumn(2).setPreferredWidth(100);
        view.tabel.getColumnModel().getColumn(3).setPreferredWidth(100);
        view.tabel.getColumnModel().getColumn(4).setPreferredWidth(100);
        view.tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    }
}
