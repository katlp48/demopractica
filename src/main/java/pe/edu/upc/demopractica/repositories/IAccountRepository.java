package pe.edu.upc.demopractica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demopractica.entities.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
}
