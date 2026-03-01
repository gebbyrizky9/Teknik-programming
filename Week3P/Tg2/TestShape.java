package Tg2;
public class TestShape {
    public static void main(String[] args) {
        
        System.out.println("=========================================");
        System.out.println("          PENGUJIAN KELAS SHAPE          ");
        System.out.println("=========================================\n");

        // 1. Menguji Superclass Shape beserta Getter & Setternya
        System.out.println("--- 1. UJI KELAS SHAPE ---");
        Shape s1 = new Shape(); 
        Shape s2 = new Shape("blue", false); 
        System.out.println("Shape 1 (Default) : " + s1.toString());
        System.out.println("Shape 2 (Custom)  : " + s2.toString());
        
        s1.setColor("yellow");
        s1.setFilled(false);
        System.out.println("Shape 1 (Diubah)  : " + s1.toString() + "\n");

        // 2. Menguji Subclass Circle dan Rumus Lingkaran
        System.out.println("--- 2. UJI KELAS CIRCLE ---");
        Circle c1 = new Circle(5.0, "red", true);
        System.out.println(c1.toString());
        System.out.println("Luas Lingkaran     : " + c1.getArea());
        System.out.println("Keliling Lingkaran : " + c1.getPerimeter() + "\n");

        // 3. Menguji Subclass Rectangle dan Rumus Persegi Panjang
        System.out.println("--- 3. UJI KELAS RECTANGLE ---");
        Rectangle r1 = new Rectangle(4.0, 5.0, "green", true);
        System.out.println(r1.toString());
        System.out.println("Luas Persegi Pjg   : " + r1.getArea());
        System.out.println("Keliling P. Pjg    : " + r1.getPerimeter() + "\n");

        // 4. Menguji Subclass Square dan Pembuktian Override Geometri
        System.out.println("--- 4. UJI KELAS SQUARE (PEMBUKTIAN OVERRIDE) ---");
        Square sq1 = new Square(4.0, "purple", false);
        System.out.println("Kondisi Awal       : " + sq1.toString());
        System.out.println("Luas Awal          : " + sq1.getArea());

        // Membuktikan bahwa jika Width diubah, Length ikut berubah
        System.out.println("\n>> Aksi: Mengubah Width menjadi 8.0");
        sq1.setWidth(8.0);
        System.out.println("Hasil toString()   : " + sq1.toString());
        System.out.println("Luas Sekarang      : " + sq1.getArea() + " (Karena 8.0 x 8.0)");

        // Membuktikan bahwa jika Length diubah, Width ikut berubah
        System.out.println("\n>> Aksi: Mengubah Length menjadi 10.0");
        sq1.setLength(10.0);
        System.out.println("Hasil toString()   : " + sq1.toString());
        System.out.println("Luas Sekarang      : " + sq1.getArea() + " (Karena 10.0 x 10.0)");
        
        System.out.println("\n=========================================");
    }
}