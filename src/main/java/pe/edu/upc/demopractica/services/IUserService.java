package pe.edu.upc.demopractica.services;

import pe.edu.upc.demopractica.entities.Users;

import java.util.List;

public interface IUserService {
    public Integer insert(Users user);

    List<Users> list();
}
