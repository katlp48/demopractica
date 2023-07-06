package pe.edu.upc.demopractica.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demopractica.entities.Users;
import pe.edu.upc.demopractica.repositories.UserRepository;
import pe.edu.upc.demopractica.services.IUserService;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository uR;

    @Override
    public Integer insert(Users user) {
        int rpta = uR.buscarUsername(user.getUsername());
        if (rpta == 0) {
            uR.save(user);
        }
        return rpta;
    }

    @Override
    public List<Users> list() {
        // TODO Auto-generated method stub
        return uR.findAll();
    }
}