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
public class Hotel implements Menu{
    Scanner input = new Scanner(System.in);
    Kamar kamar = new Kamar();
    Admin admin = new Admin();
    Customer customer = new Customer();
    String pilihan;

    @Override
    public void mainMenu(){
        do {
            System.out.println("\n===== Selamat Datang di Aplikasi Pesan JM Hotel =====");
            System.out.println("=====       Silakan Pilih dari Menu Ini         =====\n");
            System.out.print("1. Login\n2. Logout\nMasukkan pilihan : ");
            pilihan = input.nextLine();
            switch(pilihan){
                case "1":
                    menuLogin();
                    break;
                case "2":
                    System.out.println("\n=====        Terimakasih Sudah Berkunjung       =====");
                    System.out.println("=====           Sampai jumpa lagi               =====");
                    break;
                default:
                    System.out.println("Masukkan tidak sesuai.");
                    break;
            }
        } while (!"2".equals(pilihan));      
    }
    @Override
    public void menuLogin(){
        System.out.println("\n===== Login =====\n");
        System.out.print("Masukkan Username Anda: ");
        String username = input.nextLine();
        System.out.print("Masukkan Password Anda: ");
        String password = input.nextLine();
        Login login = new Login(username, password);
        String isAdmin = login.cekUser();

        switch (isAdmin) {
            case "admin":
                menuAdmin();
                break;
            case "customer":
                menuCustomer();
                break;
            default:
                System.out.println("Pengguna tidak sesuai.\n");
        }
    }
    @Override
    public void menuAdmin(){
        do {
            System.out.println("\n===== Menu Admin =====\n");
            System.out.print("1. Pesan Kamar\n2. Cek Kamar\n3. Batal Kamar\n4. Keluar\n");
            System.out.print("Masukkan pilihan: ");
            pilihan = input.nextLine();
            switch (pilihan) {
                case "1":
                    admin.pesan(kamar);
                    break;
                case "2":
                    admin.cekKamar(kamar);
                    break;
                case "3":
                    admin.batal(kamar);
                    break;
                case "4":
                    System.out.println("Keluar.\n");
                    break;
                default:
                    System.out.println("Masukkan tidak sesuai.\n");
            }
        } while (!"4".equals(pilihan));
    }
    @Override
    public void menuCustomer(){
        do {
            System.out.println("\n===== Menu Customer =====\n");
            System.out.print("1. Pesan Kamar\n2. Cek Kamar \n3. Detail Pesanan\n4. Batalkan Pesanan\n5. Keluar\n");
            System.out.print("Masukkan pilihan: ");
            pilihan = input.nextLine();
            switch (pilihan) {
                case "1":
                    customer.pesan(kamar);
                    break;
                case "2":
                    customer.cekKamar(kamar);
                    break;
                case "3":
                    customer.cekDetailPesanan();
                    break;
                case "4":
                    customer.batal(kamar);
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Masukkan tidak sesuai.\n");
            }
        } while (!"5".equals(pilihan));
    }
}
