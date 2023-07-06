package pe.edu.upc.demopractica.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pe.edu.upc.demopractica.dtos.UserDTO;
import pe.edu.upc.demopractica.entities.Users;
import pe.edu.upc.demopractica.services.IUserService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private PasswordEncoder bcrypt;
    @Autowired
    private IUserService uService;

    @GetMapping
    public List<UserDTO> list(){
        return uService.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, UserDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public String saveUser(@Valid Users usuario, BindingResult result, Model model, SessionStatus status, @RequestBody UserDTO dto)
            throws Exception {
        if (result.hasErrors()) {
            return "usersecurity/user";
        } else {
            ModelMapper m = new ModelMapper();
            Users u = m.map(dto, Users.class);
            String bcryptPassword = bcrypt.encode(u.getPassword());
            u.setPassword(bcryptPassword);
            uService.insert(u);
            return "Usuario creado";
        }
    }

}
