/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;


/**
 *
 * @author mfaja
 */

public class Controller extends Movie {
    Model md;
    private String judul;
    private int alur, penokohan, akting, nilai;

    public void setMo(Model mo){
        this.md = mo;
    }
    
    public Controller() {

    }
    
    public void inputData(Movie mv){
        this.judul = mv.getJudul();
        this.penokohan =  Integer.valueOf(mv.getPenokohan());
        this.akting = Integer.valueOf(mv.getAkting());
        this.alur = Integer.valueOf(mv.getAlur());
        this.nilai = (penokohan + alur + akting)/3;
        System.out.println(nilai);
        md.setJudul(this.judul);
        md.setAlur(this.alur);
        md.setPenokohan(this.penokohan);
        md.setAkting(this.akting);
        md.setNilai(this.nilai);
        md.insertData();
    }
    
    

    public void viewTable(Movie vu){
        md.table(vu);
    }
    
    public void clearTab(){
        md.clearTab();
    }
}
