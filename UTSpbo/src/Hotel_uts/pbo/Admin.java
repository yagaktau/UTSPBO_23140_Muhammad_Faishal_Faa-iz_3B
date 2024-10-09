/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hotel_uts.pbo;

import java.util.Scanner;
/**
 *
 * @author Asus
 */
public class Admin extends Kamar {
    Kamar kamar = new Kamar();
    
    public void pesan(Kamar kamar){
        if(kamar.jumlah == 50){
            System.out.println("Kamar sudah terisi.");
        } else {
            Scanner input = new Scanner(System.in);
            System.out.print("Masukkan nomor kamar baru: ");
            String kamarBaru = input.nextLine();

            kamar.jumlah += 1;
            kamar.nomorKamar[kamar.jumlah-1] = kamarBaru;
        }
    }
    
    public void cekKamar(Kamar kamar){
        System.out.println("Jumlah kamar yang tersedia: " + kamar.jumlah);
        System.out.println("Nomor kamar yang tersedia: ");
        for(int i = 0; i < kamar.jumlah; i++){
            System.out.print(kamar.nomorKamar[i] + " ");
            if(i >= 20 && i%20 == 0){
                System.out.println("");
            }
        }
    }
    
    public void batal(Kamar kamar){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan nomor kamar yang ingin dibatalkan: ");     
        String nomorKamar = input.nextLine();
        
        for(int i = 0; i < kamar.jumlah; i++){
            if(nomorKamar.equals(kamar.nomorKamar[i])){
                for(int j = i; j < kamar.jumlah-1; j++){
                    kamar.nomorKamar[j] = kamar.nomorKamar[j+1];
                }
                kamar.jumlah-=1;
                System.out.println("Kamar batal dipesan.");
                i = kamar.jumlah;
            } else {
                System.out.println("Kamar tidak ada.");
            }
        }
    }
}