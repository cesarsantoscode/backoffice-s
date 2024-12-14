package pe.edu.cibertec.backoffice_s.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.backoffice_s.dto.UserDetailDto;
import pe.edu.cibertec.backoffice_s.dto.UserDto;
import pe.edu.cibertec.backoffice_s.dto.UserUpdateDto;
import pe.edu.cibertec.backoffice_s.entity.User;
import pe.edu.cibertec.backoffice_s.repository.UserRepository;
import pe.edu.cibertec.backoffice_s.service.ManageService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() throws Exception {

        List<UserDto> users = new ArrayList<UserDto>();
        Iterable<User> iterable = userRepository.findAll();
        iterable.forEach(user -> {
            users.add(new UserDto(user.getId(),
                    user.getEmail(),
                    user.getFirstName(),
                    user.getLastName()));
        });
        return users;

    }

    @Override
    public Optional<UserDetailDto> getUserById(int id) throws Exception {

        Optional<User> optional = userRepository.findById(id);
        return optional.map(user -> new UserDetailDto(user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getRole(),
                user.getCreatedAt(),
                user.getUpdatedAt()));

    }

    @Override
    public boolean updateUser(UserDto userDto) throws Exception {

        Optional<User> optional = userRepository.findById(userDto.id());
        return optional.map(user -> {
            user.setEmail(userDto.email());
            user.setFirstName(userDto.firstName());
            user.setLastName(userDto.lastName());
            userRepository.save(user);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean deleteUserById(int id) throws Exception {

        Optional<User> optional = userRepository.findById(id);
        return optional.map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean addUser(UserUpdateDto userUpdateDto) throws Exception {

        Optional<User> optional = userRepository.findById(userUpdateDto.id());
        if (optional.isPresent())
            return false;
        else {
            User user = new User();
            user.setUsername(userUpdateDto.username());
            user.setPassword(userUpdateDto.password());
            user.setEmail(userUpdateDto.email());
            user.setFirstName(userUpdateDto.firstName());
            user.setLastName(userUpdateDto.lastName());
            user.setRole(userUpdateDto.role());
            user.setCreatedAt(new Date());
            userRepository.save(user);
            return true;
        }

    }

}
