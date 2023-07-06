package pe.edu.upc.demopractica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demopractica.entities.Transaction;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("FROM Transaction t where t.account.nameCustomer = :name")
    List<Transaction> BuscarxNombreCliente (@Param("name")String name);

    @Query ("FROM Transaction t WHERE t.createDate > :fecha1 AND t.createDate < :fecha2")
    List<Transaction> BuscarxRangoFecha (LocalDate fecha1, LocalDate fecha2);
}
