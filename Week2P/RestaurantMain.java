public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant menu = new Restaurant();

        // Penambahan menu tanpa perlu memanggil nextId() secara manual dari luar
        menu.tambahMenuMakanan("Pizza", 250000, 20);
        menu.tambahMenuMakanan("Spaghetti", 80000, 20);
        menu.tambahMenuMakanan("Tenderloin Steak", 60000, 30);
        menu.tambahMenuMakanan("Chicken Steak", 45000, 30);

        System.out.println("--- DAFTAR MENU AWAL ---");
        menu.tampilMenuMakanan();

        // Uji Coba Fitur Pemesanan
        System.out.println("\n--- PROSES PEMESANAN ---");
        menu.pesanMenu("Pizza", 5, 250000); //saya mencoba menambahkan fitur baru yaitu total harga, bisa dihiraukan saja (hanya mencoba-coba)      
        menu.pesanMenu("Spaghetti", 20, 80000); 
        menu.pesanMenu("Chicken Steak", 50, 45000);     

        System.out.println("\n--- DAFTAR MENU SETELAH PEMESANAN ---");
        menu.tampilMenuMakanan();
    }
}