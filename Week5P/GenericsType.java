// Deklarasi class dengan Generic Type Parameter <T>
// <T> adalah "Type Parameter" yang berfungsi sebagai placeholder untuk tipe data
// T bisa diganti dengan tipe apapun (String, Integer, Double, dll.) saat objek dibuat
// Berbeda dengan GenericsTypeOld yang menggunakan Object, Generics memberikan
// keamanan tipe data (type safety) pada saat compile-time
public class GenericsType<T> {

    // Variabel bertipe T (bukan Object seperti di GenericsTypeOld)
    // Tipe T akan ditentukan saat objek dibuat, misalnya GenericsType<String>
    // maka t akan bertipe String secara otomatis
    private T t;

    // Method get() mengembalikan nilai bertipe T (bukan Object)
    // Keuntungan: TIDAK perlu melakukan casting saat mengambil nilai
    // Berbeda dengan GenericsTypeOld yang return Object dan harus di-cast manual
    public T get() {
        return this.t;
    }

    // Method set() menerima parameter bertipe T
    // Compiler akan memeriksa tipe data pada saat compile-time
    // Jika tipe tidak sesuai, error akan muncul SAAT KOMPILASI (lebih aman)
    // Berbeda dengan GenericsTypeOld yang baru error saat runtime (ClassCastException)
    public void set(T t1) {
        this.t = t1;
    }

    public static void main(String args[]) {

        // === CONTOH 1: Menggunakan Generics dengan Type Parameter ===
        // Membuat objek GenericsType dengan tipe String
        // <String> menentukan bahwa T = String untuk objek ini
        // Diamond operator <> pada sisi kanan: compiler otomatis mengenali tipe dari sisi kiri
        GenericsType<String> type = new GenericsType<>();

        // Valid: "Java" adalah String, sesuai dengan tipe yang ditentukan <String>
        type.set("Java"); // valid

        // Jika kita coba: type.set(10); → akan ERROR saat kompilasi!
        // Ini adalah keuntungan Generics: kesalahan tipe terdeteksi lebih awal

        // === CONTOH 2: Menggunakan Raw Type (tanpa Type Parameter) ===
        // Raw type = menggunakan class Generics TANPA menentukan tipe <T>
        // Ini mirip dengan cara kerja GenericsTypeOld (menggunakan Object)
        // Compiler akan memberikan warning "unchecked" karena tidak type-safe
        GenericsType type1 = new GenericsType(); // raw type

        // Valid: String bisa disimpan karena raw type menerima semua tipe (seperti Object)
        type1.set("Java"); // valid

        // Valid: angka 10 (int) otomatis di-convert ke Integer (autoboxing)
        // kemudian disimpan sebagai Object karena raw type
        // Ini berbahaya karena tidak ada pengecekan tipe saat kompilasi
        type1.set(10); // valid and autoboxing support

        // Mencetak objek type1             
        System.out.println(type.get());
    }
}
