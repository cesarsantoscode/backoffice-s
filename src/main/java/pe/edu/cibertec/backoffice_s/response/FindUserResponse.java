package pe.edu.cibertec.backoffice_s.response;

import pe.edu.cibertec.backoffice_s.dto.UserDetailDto;

public record FindUserResponse(String code,
                               String error,
                               UserDetailDto userDetailDto) {

}