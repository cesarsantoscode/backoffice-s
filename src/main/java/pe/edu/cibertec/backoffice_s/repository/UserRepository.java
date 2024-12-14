package pe.edu.cibertec.backoffice_s.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.backoffice_s.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
