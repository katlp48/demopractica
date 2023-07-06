package pe.edu.upc.demopractica.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demopractica.entities.Role;
import pe.edu.upc.demopractica.repositories.RoleRepository;
import pe.edu.upc.demopractica.services.IRoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleRepository rR;

    @Override
    public void insert(Role role) {
        rR.save(role);
    }

    @Override
    public List<Role> list() {
        // TODO Auto-generated method stub
        return rR.findAll();
    }
}