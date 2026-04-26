package com.p2p;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;
import com.p2p.service.LoanService;

// ============================
// LOGGING di Test (Tools: Log4j2)
// ============================
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoanServiceTest {

    // Logger untuk mencatat proses testing
    private static final Logger logger = LogManager.getLogger(LoanServiceTest.class);

    // ================================================================
    // TC-01: shouldRejectLoanWhenBorrowerNotVerified
    // ================================================================
    // SKENARIO : Borrower TIDAK terverifikasi (KYC = false)
    //            mengajukan loan
    // EXPECTED : Exception / loan tidak dibuat
    // ================================================================
    @Test
    void shouldRejectLoanWhenBorrowerNotVerified() {

        logger.info("========== TC-01: START ==========");
        logger.info("Skenario: Borrower TIDAK terverifikasi mencoba mengajukan loan");

        // =========================
        // Arrange (Initial Condition)
        // =========================
        // Borrower belum lolos proses KYC (verified = false)
        // Credit score 700 (tinggi, tapi tidak relevan karena KYC gagal)
        Borrower borrower = new Borrower(false, 700);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        logger.info("Arrange: Borrower(verified=false, creditScore=700), amount=1000");

        // =========================
        // Act & Assert
        // =========================
        // Borrower mencoba mengajukan loan → HARUS throw exception
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });

        logger.info("Assert: IllegalArgumentException BERHASIL dilempar");
        logger.info("========== TC-01: PASSED ✅ ==========");
    }

    // ================================================================
    // TC-02: shouldRejectLoanWhenAmountIsZeroOrNegative
    // ================================================================
    // SKENARIO : Borrower VALID (verified, score tinggi)
    //            tapi Amount ≤ 0
    // EXPECTED : Exception
    // ================================================================
    @Test
    void shouldRejectLoanWhenAmountIsZeroOrNegative() {

        logger.info("========== TC-02: START ==========");
        logger.info("Skenario: Borrower valid, tapi amount <= 0");

        // =========================
        // Arrange
        // =========================
        Borrower borrower = new Borrower(true, 700);
        LoanService loanService = new LoanService();
        BigDecimal zeroAmount = BigDecimal.ZERO;
        BigDecimal negativeAmount = BigDecimal.valueOf(-500);

        logger.info("Arrange: Borrower(verified=true, creditScore=700)");

        // =========================
        // Act & Assert — Test dengan amount = 0
        // =========================
        logger.info("Act: Mencoba createLoan dengan amount = 0");
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, zeroAmount);
        });
        logger.info("Assert: Exception dilempar untuk amount = 0 ✅");

        // =========================
        // Act & Assert — Test dengan amount negatif
        // =========================
        logger.info("Act: Mencoba createLoan dengan amount = -500");
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, negativeAmount);
        });
        logger.info("Assert: Exception dilempar untuk amount = -500 ✅");

        logger.info("========== TC-02: PASSED ✅ ==========");
    }

    // ================================================================
    // TC-03: shouldApproveLoanWhenCreditScoreHigh
    // ================================================================
    // SKENARIO : Borrower VERIFIED
    //            Credit score ≥ 600 (threshold)
    // EXPECTED : Status = APPROVED
    // ================================================================
    @Test
    void shouldApproveLoanWhenCreditScoreHigh() {

        logger.info("========== TC-03: START ==========");
        logger.info("Skenario: Borrower verified dengan credit score tinggi");

        // =========================
        // Arrange
        // =========================
        Borrower borrower = new Borrower(true, 750);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(5000);

        logger.info("Arrange: Borrower(verified=true, creditScore=750), amount=5000");

        // =========================
        // Act
        // =========================
        logger.info("Act: Memanggil createLoan()");
        Loan loan = loanService.createLoan(borrower, amount);

        // =========================
        // Assert
        // =========================
        assertNotNull(loan);
        assertEquals(Loan.Status.APPROVED, loan.getStatus());

        logger.info("Assert: Loan status = {} ✅", loan.getStatus());
        logger.info("========== TC-03: PASSED ✅ ==========");
    }

    // ================================================================
    // TC-04: shouldRejectLoanWhenCreditScoreLow
    // ================================================================
    // SKENARIO : Borrower VERIFIED
    //            Credit score < 600 (di bawah threshold)
    // EXPECTED : Status = REJECTED
    // ================================================================
    @Test
    void shouldRejectLoanWhenCreditScoreLow() {

        logger.info("========== TC-04: START ==========");
        logger.info("Skenario: Borrower verified tapi credit score rendah");

        // =========================
        // Arrange
        // =========================
        Borrower borrower = new Borrower(true, 400);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(5000);

        logger.info("Arrange: Borrower(verified=true, creditScore=400), amount=5000");

        // =========================
        // Act
        // =========================
        logger.info("Act: Memanggil createLoan()");
        Loan loan = loanService.createLoan(borrower, amount);

        // =========================
        // Assert
        // =========================
        assertNotNull(loan);
        assertEquals(Loan.Status.REJECTED, loan.getStatus());

        logger.info("Assert: Loan status = {} ✅", loan.getStatus());
        logger.info("========== TC-04: PASSED ✅ ==========");
    }
}
