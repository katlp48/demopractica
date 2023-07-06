package pe.edu.upc.demopractica.services;

import pe.edu.upc.demopractica.entities.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface ITransactionService {
    public void insert(Transaction transactions);
    List<Transaction> list();
    public Transaction listId(long idtransactions);

    public List<Transaction> BuscarxNombreCliente(String name);

    public List<Transaction> BuscarxRangoFecha (LocalDate f1, LocalDate f2);
}
