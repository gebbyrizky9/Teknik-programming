// Generic Interface: T harus implements Comparable agar bisa dibandingkan
interface MinMax<T extends Comparable<T>> {
    T max();
}

// Implementasi MinMax — mencari nilai terbesar dari array
class MyClass<T extends Comparable<T>> implements MinMax<T> {
    T[] vals;

    MyClass(T[] o) {
        vals = o;
    }

    // Linear search: cari nilai terbesar dengan compareTo()
    public T max() {
        T v = vals[0];

        for (int i = 1; i < vals.length; i++) {
            // compareTo > 0 artinya vals[i] lebih besar dari v
            if (vals[i].compareTo(v) > 0) {
                v = vals[i];
            }
        }
        return v;
    }
}

public class Main {
    public static void main(String[] args) {
        Integer[] inums = { 3, 6, 2, 8, 6 };
        Character[] chs = { 'b', 'r', 'p', 'w' };

        // Integer & Character valid karena keduanya implements Comparable
        MyClass<Integer> a = new MyClass<>(inums);
        MyClass<Character> b = new MyClass<>(chs);

        System.out.println("Nilai Integer Terbesar: " + a.max());
        System.out.println("Karakter Terbesar: " + b.max());
    }
}
