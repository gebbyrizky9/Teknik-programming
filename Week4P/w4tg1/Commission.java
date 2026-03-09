package Week4P.w4tg1;

//********************************************************************
// Commission.java
//
// Represents an hourly employee who also earns commission on sales.
//********************************************************************
public class Commission extends Hourly {
    private double totalSales;
    private double commissionRate;

    // -----------------------------------------------------------------
    // Sets up a commission employee using the specified information.
    // The commission rate is in decimal form (e.g., 0.20 = 20%).
    // -----------------------------------------------------------------
    public Commission(String eName, String eAddress, String ePhone,
            String socSecNumber, double rate, double commRate) {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        commissionRate = commRate;
        totalSales = 0;
    }

    // -----------------------------------------------------------------
    // Adds the specified sales amount to the total sales.
    // -----------------------------------------------------------------
    public void addSales(double salesAmount) {
        totalSales += salesAmount;
    }

    // -----------------------------------------------------------------
    // Computes and returns the pay for this commission employee,
    // which is the hourly pay plus commission on total sales.
    // Total sales is reset to 0 after payment.
    // (hoursWorked is already reset by super.pay() in Hourly)
    // -----------------------------------------------------------------
    public double pay() {
        double payment = super.pay() + (totalSales * commissionRate);
        totalSales = 0;
        return payment;
    }

    // -----------------------------------------------------------------
    // Returns information about this commission employee as a string.
    // -----------------------------------------------------------------
    public String toString() {
        String result = super.toString();
        result += "\nTotal Sales: " + totalSales;
        return result;
    }
}
