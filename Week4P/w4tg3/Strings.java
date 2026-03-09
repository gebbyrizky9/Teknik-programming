package Week4P.w4tg3;

//******************************************************
// Strings.java
//
// Demonstrates insertionSort on an array of Strings.
//******************************************************
import java.util.Scanner;

public class Strings {
    // --------------------------------------------
    // Reads in an array of Strings, sorts them,
    // then prints them in sorted order.
    // --------------------------------------------
    public static void main(String[] args) {
        String[] stringList;
        int size;
        Scanner scan = new Scanner(System.in);

        System.out.print("\nHow many strings do you want to sort? ");
        size = scan.nextInt();
        scan.nextLine(); // consume the newline
        stringList = new String[size];

        System.out.println("\nEnter the strings...");
        for (int i = 0; i < size; i++)
            stringList[i] = scan.nextLine();

        Sorting.insertionSort(stringList); // descending order

        System.out.println("\nYour strings in sorted order (descending)...");
        for (int i = 0; i < size; i++)
            System.out.println(stringList[i]);
    }
}
