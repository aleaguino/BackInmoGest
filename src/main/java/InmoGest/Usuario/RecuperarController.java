package InmoGest.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecuperarController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/recuperar")
    public String mostrarFormularioRecuperar() {
        return "recuperar"; // Asegúrate de tener este archivo en templates
    }

    @PostMapping("/recuperar")
    public String procesarFormularioRecuperar(@RequestParam String username, @RequestParam String fecha, Model model) {
        Usuario usuario = usuarioService.findByUsername(username);
        if (usuario != null && usuario.getFecha().toString().equals(fecha)) {
            model.addAttribute("usuario", usuario);
            return "cambiarContraseña"; // Asegúrate de tener este archivo en templates
        } else {
            model.addAttribute("error", "Usuario o fecha de nacimiento incorrectos.");
            return "recuperar"; // Asegúrate de tener este archivo en templates
        }
    }

    @PostMapping("/cambiarContraseña")
    public String cambiarContraseña(@RequestParam Long id, @RequestParam String nuevaContraseña) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        if (usuario != null) {
            usuario.setPassword(passwordEncoder.encode(nuevaContraseña));
            usuarioService.save(usuario);
            return "redirect:/login?success=true";
        } else {
            return "redirect:/recuperar?error=true";
        }
    }
}
