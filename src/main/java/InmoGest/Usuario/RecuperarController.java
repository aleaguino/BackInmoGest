package InmoGest.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class RecuperarController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(RecuperarController.class);

    @GetMapping("/recuperar")
    public String mostrarFormularioRecuperar(Model model) {
        model.addAttribute("error", false);
        return "recuperar";
    }

    @PostMapping("/recuperar")
    public String procesarFormularioRecuperar(@RequestParam String username, @RequestParam String fecha, Model model) {
        logger.info("Procesando formulario de recuperación para usuario: " + username);
        Usuario usuario = usuarioService.findByUsername(username);
        if (usuario != null && usuario.getFecha().toString().equals(fecha)) {
            model.addAttribute("usuario", usuario);
            return "cambiarContraseña";
        } else {
            model.addAttribute("error", "Usuario o fecha de nacimiento incorrectos.");
            return "recuperar";
        }
    }

    @PostMapping("/cambiarContraseña")
    public String cambiarContraseña(@RequestParam Long id, @RequestParam String nuevaContraseña, RedirectAttributes redirectAttributes) {
        logger.info("Cambiando contraseña para el usuario con ID: " + id);
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        if (usuario != null) {
            usuario.setPassword(passwordEncoder.encode(nuevaContraseña));
            usuarioService.save(usuario);
            redirectAttributes.addFlashAttribute("correcto", "Contraseña cambiada correctamente.");
            return "redirect:/login";
        } else {
            redirectAttributes.addFlashAttribute("error", "Error al cambiar la contraseña. Por favor, inténtelo de nuevo.");
            return "redirect:/recuperar";
        }
    }
}
