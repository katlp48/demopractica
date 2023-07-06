package pe.edu.upc.demopractica.entities;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idAccount;
    @Column(name = "nameCustomer", length = 60, nullable = false)
    private String nameCustomer;

    @Column(name = "numberAccount", length = 9, nullable = false)
    private String numberAccount;

    public Account() {
    }

    public Account(long idAccount, String nameCustomer, String numberAccount) {
        this.idAccount = idAccount;
        this.nameCustomer = nameCustomer;
        this.numberAccount = numberAccount;
    }

    public long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(long idAccount) {
        this.idAccount = idAccount;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }
}
