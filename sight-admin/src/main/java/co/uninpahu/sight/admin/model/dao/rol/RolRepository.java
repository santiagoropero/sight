package co.uninpahu.sight.admin.model.dao.rol;

import co.uninpahu.sight.admin.model.entity.rol.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
}
