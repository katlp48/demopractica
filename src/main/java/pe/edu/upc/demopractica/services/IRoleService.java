package pe.edu.upc.demopractica.services;

import pe.edu.upc.demopractica.entities.Role;

import java.util.List;

public interface IRoleService {
    public void insert(Role role);

    List<Role> list();
}
