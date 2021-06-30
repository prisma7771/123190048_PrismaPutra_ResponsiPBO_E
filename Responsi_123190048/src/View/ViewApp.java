package View;

import Model.ModelApp;

import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewApp extends JFrame{
    public JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"Judul", "Alur", "Penokohan", "Akting", "Nilai"};
    
    public JTextField fjudul, falur, fpenokohan, fakting;
    JLabel ljudul, lalur, lpenokohan, lakting;
    public JButton tambah,update,delete,clear;
    
    public ViewApp(){
        setTitle("Responsi_123190048                                             APLIKASI MOVIE REVIEW");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(350, 100);
        setResizable(false);
        setVisible(true);
        setLayout(null);
        setSize(800, 500);

        ljudul = new JLabel("Judul");
        lalur = new JLabel("Alur");
        lpenokohan = new JLabel("Penokohan");
        lakting = new JLabel("Akting");
        
        fjudul = new JTextField();
        falur = new JTextField();
        fpenokohan = new JTextField();
        fakting = new JTextField();
        
        tambah = new JButton("Tambah");
        update = new JButton("Update");
        delete = new JButton("Delete");
        clear = new JButton("Clear");
        
        
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        scrollPane = new JScrollPane(tabel);
        add(scrollPane);

        scrollPane.setBounds(20, 15, 503, 400);
        tabel.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabel.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabel.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabel.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabel.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    
        add(ljudul);
        ljudul.setBounds(540,20,100,20);
        ljudul.setFont(new java.awt.Font("Times New Roman", 1, 18)); 
        
        add(fjudul);
        fjudul.setBounds(540,40,200,25);
        fjudul.setFont(new java.awt.Font("Times New Roman", 0 ,16)); 
        
        add(lalur);
        lalur.setBounds(540,65,100,20);
        lalur.setFont(new java.awt.Font("Times New Roman", 1, 18)); 
        
        add(falur);
        falur.setBounds(540,85,200,25);
        falur.setFont(new java.awt.Font("Times New Roman", 0 ,16));
        
        add(lpenokohan);
        lpenokohan.setBounds(540,110,100,20);
        lpenokohan.setFont(new java.awt.Font("Times New Roman", 1, 18)); 
        
        add(fpenokohan);
        fpenokohan.setBounds(540,130,200,25);
        fpenokohan.setFont(new java.awt.Font("Times New Roman", 0 ,16));
        
        add(lakting);
        lakting.setBounds(540,155,100,20);
        lakting.setFont(new java.awt.Font("Times New Roman", 1, 18)); 
        
        add(fakting);
        fakting.setBounds(540,175,200,25);
        fakting.setFont(new java.awt.Font("Times New Roman", 0 ,16));
        
        add(tambah);
        tambah.setBounds(540,270,140,25);
        tambah.setFont(new java.awt.Font("Times New Roman", 1 ,18));
        
        add(update);
        update.setBounds(540,305,140,25);
        update.setFont(new java.awt.Font("Times New Roman", 1 ,18));
        
        add(delete);
        delete.setBounds(540,340,140,25);
        delete.setFont(new java.awt.Font("Times New Roman", 1 ,18));
        
        add(clear);
        clear.setBounds(540,375,140,25);
        clear.setFont(new java.awt.Font("Times New Roman", 1 ,18));
    }

    public String getFjudul() {
        return fjudul.getText();
    }

    public String getFalur() {
        return falur.getText();
    }

    public String getFpenokohan() {
        return fpenokohan.getText();
    }

    public String getFakting() {
        return fakting.getText();
    }
    
    
}
