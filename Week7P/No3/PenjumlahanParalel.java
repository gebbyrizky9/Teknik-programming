package No3;

import java.util.Scanner;

// Kelas ini bertindak sebagai "Shared Resource" tempat menyimpan total akhir
class SharedResult {
    private long totalSum = 0; // Menggunakan long untuk menghindari limit (overflow) jika angka besar

    // PENTING: Keyword 'synchronized' menjamin Thread Safety
    // Mencegah Race Condition saat beberapa thread mencoba menjumlahkan hasil parsial ke total akhir di waktu yang sama.
    public synchronized void addPartialSum(long partial) {
        totalSum += partial;
    }

    public long getTotalSum() {
        return totalSum;
    }
}

// Kelas ini mendefinisikan tugas spesifik yang akan dijalankan oleh setiap Thread
class SumTask implements Runnable {
    private String threadName;
    private int startRange;
    private int endRange;
    private SharedResult sharedResult;

    public SumTask(String threadName, int startRange, int endRange, SharedResult sharedResult) {
        this.threadName = threadName;
        this.startRange = startRange;
        this.endRange = endRange;
        this.sharedResult = sharedResult;
    }

    @Override
    public void run() {
        // 1. Menampilkan tugas yang dikerjakan oleh thread ini
        System.out.println(threadName + "   : Menjumlahkan " + startRange + " - " + endRange);

        long partialSum = 0;
        
        // 2. Melakukan penjumlahan dalam rentang bagiannya sendiri
        for (int i = startRange; i <= endRange; i++) {
            partialSum += i;
        }

        // 3. Menampilkan hasil parsial masing-masing thread
        System.out.println(threadName + " -> Hasil parsial: " + partialSum);

        // 4. Menyimpan hasil parsial ke total akhir secara sinkron (aman)
        sharedResult.addPartialSum(partialSum);
    }
}

public class PenjumlahanParalel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- MENERIMA INPUT ---
        System.out.print("Masukkan Jumlah Thread: ");
        int jumlahThread = scanner.nextInt();

        System.out.print("Masukkan Angka Akhir  : ");
        int angkaAkhir = scanner.nextInt();
        scanner.close();

        SharedResult sharedResult = new SharedResult();
        Thread[] threads = new Thread[jumlahThread];

        // --- MEKANISME PEMBAGIAN TUGAS (DIVIDE AND CONQUER) ---
        int rangeDasar = angkaAkhir / jumlahThread;
        int sisaBagi = angkaAkhir % jumlahThread; // Jika angka tidak bisa dibagi habis

        int currentStart = 1;

        System.out.println("\n--- Proses Penjumlahan Berjalan ---");
        
        for (int i = 0; i < jumlahThread; i++) {
            int currentEnd = currentStart + rangeDasar - 1;

            // Jika ini thread terakhir, masukkan sisa angka agar tidak ada yang terlewat
            if (i == jumlahThread - 1) {
                currentEnd += sisaBagi;
            }

            // Membuat tugas dan mengutus thread untuk menjalankannya
            SumTask task = new SumTask("Thread " + (i + 1), currentStart, currentEnd, sharedResult);
            threads[i] = new Thread(task);
            threads[i].start(); // Menjalankan thread secara asinkron

            // Menentukan start untuk thread selanjutnya
            currentStart = currentEnd + 1;
        }

        // --- SYNCHRONIZATION: MAIN THREAD MENUNGGU ---
        // Kita menggunakan metode .join() agar Main Thread menunggu 
        // hingga semua Thread Pekerja menyelesaikan tugasnya sebelum mencetak hasil akhir
        for (int i = 0; i < jumlahThread; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println("Thread terinterupsi!");
            }
        }

        // --- MENAMPILKAN HASIL AKHIR ---
        System.out.println("\n--- HASIL AKHIR ---");
        System.out.println("Total Penjumlahan (1 - " + angkaAkhir + ") adalah: " + sharedResult.getTotalSum());
    }
}