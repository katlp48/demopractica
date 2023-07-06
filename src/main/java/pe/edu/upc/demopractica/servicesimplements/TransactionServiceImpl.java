package pe.edu.upc.demopractica.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demopractica.entities.Transaction;
import pe.edu.upc.demopractica.repositories.ITransactionRepository;
import pe.edu.upc.demopractica.services.ITransactionService;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionServiceImpl implements ITransactionService {

    @Autowired

    private ITransactionRepository aR;
    @Override
    public void insert(Transaction transactions) {
        aR.save(transactions);
    }

    @Override
    public List<Transaction> list() {
        return aR.findAll();
    }

    @Override
    public Transaction listId(long idtransactions) {
        return aR.findById(idtransactions).orElse(new Transaction());
    }

    @Override
    public List<Transaction> BuscarxNombreCliente(String name) {
        return aR.BuscarxNombreCliente(name);
    }

    @Override
    public List<Transaction> BuscarxRangoFecha(LocalDate f1, LocalDate f2) {
        return aR.BuscarxRangoFecha(f1,f2);
    }
}
