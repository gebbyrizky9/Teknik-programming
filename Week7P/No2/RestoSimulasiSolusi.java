package No2;

class RestoSolusi {
    private int chickenStock = 100;

    // SOLUSI: Penambahan keyword 'synchronized' secara eksplisit.
    // Ini mengunci objek RestoSolusi saat method ini dijalankan.
    // Thread lain harus mengantre dan tidak bisa masuk sampai thread yang di dalam selesai.
    public synchronized void serveCustomer(String cashierName) {
        if (chickenStock > 0) {
            // Simulasi jeda / proses transaksi
            try { 
                Thread.sleep(10); 
            } catch (InterruptedException e) {
                // Abaikan exception untuk simulasi ini
            }
            
            chickenStock--; 
            System.out.println(cashierName + " berhasil menjual 1 ayam. Sisa stok: " + chickenStock);
        } else {
            System.out.println(cashierName + " gagal: Stok Habis!");
        }
    }

    public int getRemainingStock() {
        return chickenStock;
    }
}

public class RestoSimulasiSolusi {
    public static void main(String[] args) throws InterruptedException {
        // Objek RestoSolusi (Shared Resource)
        RestoSolusi ayamJuicyLuicyGallagher = new RestoSolusi();

        // Tugas yang akan dijalankan oleh setiap kasir (Thread)
        Runnable task = () -> {
            for (int i = 0; i < 40; i++) {
                ayamJuicyLuicyGallagher.serveCustomer(Thread.currentThread().getName());
            }
        };

        // Pembuatan Thread (3 Kasir)
        Thread kasir1 = new Thread(task, "Kasir-A");
        Thread kasir2 = new Thread(task, "Kasir-B");
        Thread kasir3 = new Thread(task, "Kasir-C");

        // Menjalankan Thread bersamaan
        kasir1.start();
        kasir2.start();
        kasir3.start();

        // Menunggu semua Kasir selesai bekerja sebelum mencetak hasil akhir
        kasir1.join();
        kasir2.join();
        kasir3.join();

        // Menampilkan sisa stok yang dipastikan akan bernilai 0
        System.out.println("--- HASIL AKHIR STOK: " + ayamJuicyLuicyGallagher.getRemainingStock() + " ---");
    }
}