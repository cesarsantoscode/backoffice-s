package pe.edu.cibertec.backoffice_s.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.backoffice_s.dto.UserDto;
import pe.edu.cibertec.backoffice_s.service.ManageService;

import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    ManageService manageService;

    @GetMapping("/start")
    public String start(Model model) {

        try {
            List<UserDto> users = manageService.getAllUsers();
            model.addAttribute("users", users);
            model.addAttribute("error", null);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Ocurrio un error al obtener los datos");

        }
        return "manage";

    }

}
