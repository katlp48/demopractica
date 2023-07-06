package pe.edu.upc.demopractica.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pe.edu.upc.demopractica.dtos.AccountDTO;
import pe.edu.upc.demopractica.dtos.RoleDTO;
import pe.edu.upc.demopractica.dtos.UserDTO;
import pe.edu.upc.demopractica.entities.Account;
import pe.edu.upc.demopractica.entities.Role;
import pe.edu.upc.demopractica.entities.Users;
import pe.edu.upc.demopractica.services.IRoleService;
import pe.edu.upc.demopractica.services.IUserService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@SessionAttributes
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private IRoleService rService;

    @GetMapping
    public List<RoleDTO> list(){
        return rService.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, RoleDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
        public void insert(@RequestBody RoleDTO dto) {
        ModelMapper m = new ModelMapper();
        Role r = m.map(dto, Role.class);
        rService.insert(r);
    }
}
