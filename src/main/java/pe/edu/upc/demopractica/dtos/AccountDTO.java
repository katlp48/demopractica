package pe.edu.upc.demopractica.dtos;

public class AccountDTO {
    private long idAccount;
    private String nameCustomer;

    private String numberAccount;

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
