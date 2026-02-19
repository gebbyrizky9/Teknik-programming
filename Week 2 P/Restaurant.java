public class Restaurant { //sesudah diperbaiki
    // 1. private
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id = 0;

    public Restaurant() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }

// 2. setter validasi
public void tambahMenuMakanan(String nama, double harga, int stok) {
    this.nama_makanan[id] = nama;
    this.harga_makanan[id] = harga;
    setStok(id, stok); // Memanggil setter untuk validasi
    id++; // Auto-increment id di internal class
}

// 3. Validasi stok: tidak boleh negatif
public void setStok(int id, int jumlah) {
    if (jumlah >= 0) {
        this.stok[id] = jumlah;
    } else {
        System.out.println("Gagal: Stok tidak boleh negatif!");
    }
}

// Getter untuk kebutuhan informasi
public int getStok(int id) {
    return this.stok[id];
}

public void tampilMenuMakanan() {
    for (int i = 0; i <= id; i++) {
        if (!isOutOfStock(i)) {
            System.out.println(
                nama_makanan[i] + "[" + stok[i] + "]" + "\tRp. " + harga_makanan[i]
            );
        }
    }
}

public boolean isOutOfStock(int id) {
    if (stok[id] == 0) {
        return true;
    } else {
        return false;
    }
}
// 4. Pengembangan Fitur: Pemesanan Menu 
public void pesanMenu(String nama, int jumlah, double harga) {
    for (int i = 0; i<id;i++){
        if (nama_makanan[i].equalsIgnoreCase(nama)){
                if(stok[i] >= jumlah){
                stok[i] -= jumlah;
                System.out.println("Pemesanan " + jumlah + " " + nama + " Berhasil!\nTotal harga: " + penjumlahanpemesanan(harga, jumlah));
            } else{
                System.out.println ("Pesan ditolak: Stock "+ nama + " tidak mencpukupi");
            }
        }
    }
}

public double penjumlahanpemesanan(double harga, int jumlah){ //saya mencoba menambahkan fitur baru yaitu total harga, bisa dihiraukan saja (hanya mencoba-coba)
    return (harga * jumlah);
}


}

