package No3;

import java.util.Arrays;

public class ProblemThree {
    public static void main(String[] args) {
        int arr[] = {12, 4, 3, 1, 9, 657};
        int n = 3; // Mencari elemen terbesar ke-3

        int ans = Arrays.stream(arr)                 // [1] Arrays class
                .boxed()                             // [2] Konversi ke Stream<Integer>
                .sorted((a, b) -> Integer.compare(b, a)) // Urutkan descending
                .skip(n - 1)                         // [3] Lewati n-1 elemen pertama
                .findFirst()                         // [4] Ambil elemen pertama setelah skip
                .orElse(0);                          // [5] Nilai default jika stream kosong

        System.out.println("Elemen terbesar ke-3 adalah: " + ans);
    }
}