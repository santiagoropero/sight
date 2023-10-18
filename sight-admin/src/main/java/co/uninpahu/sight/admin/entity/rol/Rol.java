package co.uninpahu.sight.admin.entity.rol;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ROLES")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "R_ID", nullable = false, length = 20)
    private Long idRol;

    @Column(name = "R_NOMBRE", nullable = false, length = 40)
    private String name;

    @Column(name = "R_ESTADO", nullable = false, length = 20)
    private String state;


}
