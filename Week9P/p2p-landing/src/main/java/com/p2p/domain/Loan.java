package com.p2p.domain;

// Class ini merepresentasikan pinjaman
public class Loan {

    // Enum untuk status loan
    public enum Status {
        PENDING, APPROVED, REJECTED
    }

    private Status status;

    // Saat loan dibuat, status awal adalah PENDING
    public Loan() {
        this.status = Status.PENDING;
    }

    // Setter untuk mengubah status loan
    public void setStatus(Status status) {
        this.status = status;
    }

    // Getter untuk membaca status loan
    public Status getStatus() {
        return status;
    }

    // =========================
    // DOMAIN BEHAVIOR (Refactor Step 3 & 5 - Fowler: Replace Conditional Logic)
    // =========================
    // Service tidak lagi set state langsung,
    // domain object yang mengatur statusnya sendiri
    public void approve() {
        this.status = Status.APPROVED;
    }

    public void reject() {
        this.status = Status.REJECTED;
    }
}
