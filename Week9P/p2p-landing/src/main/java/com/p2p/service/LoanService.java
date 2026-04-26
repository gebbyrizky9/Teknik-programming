package com.p2p.service;

import com.p2p.domain.*;
import java.math.BigDecimal;

// ============================
// LOGGING (Tools: Log4j2)
// ============================
// Import Log4j untuk mencatat aktivitas sistem
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoanService {

    // Membuat logger untuk class ini
    // Logger = "buku catatan" yang merekam semua aktivitas
    private static final Logger logger = LogManager.getLogger(LoanService.class);

    // =========================
    // METHOD UTAMA: createLoan (Final Refactored Version)
    // =========================
    // Setelah semua refactoring step (1-6), method ini menjadi:
    // - Bersih (hanya orchestration)
    // - Validasi di-delegasi ke private method
    // - Business action di-delegasi ke domain object
    public Loan createLoan(Borrower borrower, BigDecimal amount) {

        // LOG INFO: mencatat bahwa ada permintaan loan masuk
        logger.info("Menerima permintaan loan - Verified: {}, CreditScore: {}, Amount: {}",
                borrower.isVerified(), borrower.getCreditScore(), amount);

        // =========================
        // VALIDASI (delegasi ke private methods)
        // =========================
        validateBorrower(borrower);   // TC-01: cek KYC verification
        validateAmount(amount);       // TC-02: cek amount > 0

        // =========================
        // CREATE LOAN (domain object)
        // =========================
        Loan loan = new Loan();
        logger.info("Loan object dibuat dengan status awal: {}", loan.getStatus());

        // =========================
        // BUSINESS ACTION (domain behavior)
        // =========================
        // TC-03: credit score >= 600 → APPROVED
        // TC-04: credit score < 600 → REJECTED
        if (borrower.getCreditScore() >= 600) {
            loan.approve();     // Refactor Step 3: domain behavior
            logger.info("Loan APPROVED - Credit Score: {} (>= 600)", borrower.getCreditScore());
        } else {
            loan.reject();      // Refactor Step 5: domain behavior
            logger.warn("Loan REJECTED - Credit Score: {} (< 600)", borrower.getCreditScore());
        }

        logger.info("Proses createLoan selesai - Status akhir: {}", loan.getStatus());
        return loan;
    }

    // =========================
    // PRIVATE VALIDATION METHODS
    // =========================

    // Refactor Step 1 (Extract Method) + Step 2 (Move Method ke domain)
    private void validateBorrower(Borrower borrower) {
        if (!borrower.canApplyLoan()) {
            // LOG ERROR: borrower tidak terverifikasi
            logger.error("VALIDASI GAGAL - Borrower tidak terverifikasi (KYC = false)");
            throw new IllegalArgumentException("Borrower not verified");
        }
        logger.info("Validasi borrower BERHASIL - KYC verified");
    }

    // Validasi untuk TC-02: amount harus positif
    private void validateAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            // LOG ERROR: jumlah pinjaman tidak valid
            logger.error("VALIDASI GAGAL - Amount tidak valid: {}", amount);
            throw new IllegalArgumentException("Loan amount must be greater than zero");
        }
        logger.info("Validasi amount BERHASIL - Amount: {}", amount);
    }
}
