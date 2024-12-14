package pe.edu.cibertec.backoffice_s.service;

import pe.edu.cibertec.backoffice_s.dto.UserDetailDto;
import pe.edu.cibertec.backoffice_s.dto.UserDto;
import pe.edu.cibertec.backoffice_s.dto.UserUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<UserDto> getAllUsers() throws Exception;

    Optional<UserDetailDto> getUserById(int id) throws Exception;

    boolean updateUser(UserDto userDto) throws Exception;

    boolean deleteUserById(int id) throws Exception;

    boolean addUser(UserUpdateDto userUpdateDto) throws Exception;

}
