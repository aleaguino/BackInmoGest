package usuariosInmoGest.demo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PisoRepository extends JpaRepository<Piso, Long> {
    List<Piso> findByUsuario(Usuario usuario);
}

