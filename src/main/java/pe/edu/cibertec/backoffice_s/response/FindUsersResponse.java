package pe.edu.cibertec.backoffice_s.response;

import pe.edu.cibertec.backoffice_s.dto.UserDto;

import java.util.List;

public record FindUsersResponse(String code,
                                String error,
                                List<UserDto> users) {

}