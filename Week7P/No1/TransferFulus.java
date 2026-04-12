package No1;
class Account {
    int balance = 150;
}

public class TransferFulus {
    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account();
        Account acc2 = new Account();

        // Thread 1: Menjumlahkan/ transfer fulus dari acc1 ke acc2
        Thread t1 = new Thread(() -> {
            synchronized (acc1) { // Mengunci acc1 terlebih dahulu
                System.out.println("Thread 1: Mengunci acc1...");
                // Jeda simulasi. Perlu Exception (InterruptedException) karena thread yang tertidur rentan diinterupsi oleh thread lain.
                try { Thread.sleep(100); } catch (Exception e) {} 

                synchronized (acc2) { // Mengunci acc2 setelah berhasil mengunci acc1
                    System.out.println("Thread 1: Mengunci acc2. Transfer acc1 ke acc2 berjalan...");
                    acc2.balance += acc1.balance;
                }
            }
        });

        // Thread 2: Menjumlahkan/ transfer fulus dari acc2 ke acc1
        Thread t2 = new Thread(() -> {
            // SOLUSI: Urutan penguncian disamakan dengan Thread 1 untuk mencegah deadlock.
            synchronized (acc1) { // Mengunci acc1 terlebih dahulu (BUKAN acc2)
                System.out.println("Thread 2: Mengunci acc1...");
                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (acc2) { // Mengunci acc2 setelah berhasil mengunci acc1
                    System.out.println("Thread 2: Mengunci acc2. Transfer acc2 ke acc1 berjalan...");
                    acc1.balance += acc2.balance;
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Saldo Akhir acc1: " + acc1.balance);
        System.out.println("Saldo Akhir acc2: " + acc2.balance);
    }
}