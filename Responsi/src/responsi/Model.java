/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mfaja
 */
public class Model {
    public Connection koneksi;
    public Statement statement;
    static final String DBurl = "jdbc:mysql://localhost/movie_db";
    static final String DBusername = "root";
    static final String DBpassword = "";
    private String judul;
    private int nilai,alur, penokohan, akting;

    public void setNilai(int Nilai) {
        this.nilai = Nilai;
    }
    
    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setAlur(int alur) {
        this.alur = alur;
    }

    public void setPenokohan(int penokohan) {
        this.penokohan = penokohan;
    }

    public void setAkting(int akting) {
        this.akting = akting;
    }

    
    public void Connector() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            System.out.println("Koneksi gagal");
        }
    }
    
    public void insertData(){
        try {
                String query = "INSERT INTO `movie`(`judul`, `alur`, `penokohan`, `akting`, `nilai`) VALUES ('"+this.judul+"','"+this.alur+"','"+this.penokohan+"','"+this.akting+"','"+this.nilai+"')";
                this.Connector();
                statement = koneksi.createStatement();
                statement.execute(query);
                JOptionPane.showMessageDialog(null,"Insert Successful");
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null,ex, "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void table(Movie vu){
        try{
            this.Connector();
            statement = koneksi.createStatement();
            String query = "SELECT * FROM `movie`";
            ResultSet resultSet = statement.executeQuery(query);
            DefaultTableModel model = (DefaultTableModel) vu.table.getModel();
            model.setRowCount(0);
            while (resultSet.next()){
                model.addRow(new String[]{resultSet.getString(1)});

            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e, "Message", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void clearTab(){
        try{
            this.Connector();
            statement = koneksi.createStatement();
            String query = "DELETE FROM `movie`";
            statement.execute(query);
            JOptionPane.showMessageDialog(null,"Data Deleted");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e, "Message", JOptionPane.WARNING_MESSAGE);
        }
    }
}
