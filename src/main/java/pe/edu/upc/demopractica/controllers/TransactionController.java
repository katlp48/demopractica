package pe.edu.upc.demopractica.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demopractica.dtos.TransactionDTO;
import pe.edu.upc.demopractica.entities.Transaction;
import pe.edu.upc.demopractica.services.ITransactionService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/bank/v1")
public class TransactionController {
    @Autowired
    private ITransactionService aS;

    @PostMapping("/accounts/{id}/transactions")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void insert(@RequestBody TransactionDTO dto) {
        ModelMapper m = new ModelMapper();
        Transaction a = m.map(dto, Transaction.class);
        aS.insert(a);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('USUARIO')")
    public List<TransactionDTO> list() {
        return aS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TransactionDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USUARIO')")
    public TransactionDTO listId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        TransactionDTO dto = m.map(aS.listId(id), TransactionDTO.class);
        return dto;
    }

    @GetMapping("/transactions/filterByNameCustomer")
    @PreAuthorize("hasAuthority('USUARIO')")
    public List<TransactionDTO> BuscarxNombreCliente(@RequestParam("name") String name) {
        return aS.BuscarxNombreCliente(name).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TransactionDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/transactions/filterByCreateDateRange")
    @PreAuthorize("hasAuthority('USUARIO')")
    public List<TransactionDTO> buscarPorRangoFecha(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin
    ) {
        return aS.BuscarxRangoFecha(fechaInicio, fechaFin).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TransactionDTO.class);
        }).collect(Collectors.toList());
    }
}
