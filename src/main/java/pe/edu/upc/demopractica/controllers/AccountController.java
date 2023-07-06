package pe.edu.upc.demopractica.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demopractica.dtos.AccountDTO;
import pe.edu.upc.demopractica.entities.Account;
import pe.edu.upc.demopractica.services.IAccountService;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/bank/v1/accounts")
public class AccountController {
    @Autowired

    private IAccountService aS;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void insert(@RequestBody AccountDTO dto) {
        ModelMapper m = new ModelMapper();
        Account a = m.map(dto, Account.class);
        aS.insert(a);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('USUARIO')")
    public List<AccountDTO> list() {
        return aS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, AccountDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AccountDTO listId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        AccountDTO dto = m.map(aS.listId(id), AccountDTO.class);
        return dto;
    }
}
