package pe.edu.upc.demopractica.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @Column(name = "type", length = 60, nullable = false)
    private String type;

    @Column(name = "createDate", nullable = false)
    private LocalDate createDate;

    @Column(name = "amount", length = 10, nullable = false)
    private double amount;

    @Column(name = "balance", length = 10, nullable = false)
    private double balance;

    @ManyToOne
    @JoinColumn(name = "account", nullable = false)
    @JsonIgnore
    private Account account;

    public Transaction() {
    }

    public Transaction(long id, String type, LocalDate createDate, double amount, double balance, Account account) {
        this.id = id;
        this.type = type;
        this.createDate = createDate;
        this.amount = amount;
        this.balance = balance;
        this.account = account;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
