package pe.edu.upc.demopractica.services;

import pe.edu.upc.demopractica.entities.Account;

import java.util.List;

public interface IAccountService {
    public void insert(Account account);

    List<Account> list();
    public Account listId(long idAccount);
}
