public class GenericsTypeOld {

    // Variabel bertipe Object digunakan untuk menyimpan data apa saja
    // karena semua class di Java merupakan turunan dari Object
    private Object t;

    // Method get() digunakan untuk mengambil nilai dari variabel t
    // Return type menggunakan Object sehingga perlu dilakukan casting saat digunakan
    public Object get() {
        return t;
    }

    // Method set() digunakan untuk memasukkan nilai ke dalam variabel t
    // Parameter bertipe Object sehingga dapat menerima berbagai tipe data
    public void set(Object t) {
        this.t = t; // menyimpan nilai parameter ke variabel instance t
    }

    public static void main(String args[]) {

        // Membuat objek dari class GenericsTypeOld
        GenericsTypeOld type = new GenericsTypeOld();

        // Menyimpan data bertipe String ke dalam variabel t
        // karena tipe Object bisa menyimpan tipe data apapun
        type.set("Java");

        // Mengambil nilai dari method get()
        // Karena return type Object, maka harus dilakukan casting ke String
        String str = (String) type.get(); 
        // type casting ini berisiko error jika tipe data tidak sesuai
        // bisa menyebabkan ClassCastException
        
        System.out.println("Nilai: " + str);
    }
}
