package co.uninpahu.sight.admin.entity.person;

import co.uninpahu.sight.admin.entity.rol.Rol;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PERSONAS")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    @Id
    @Column(name = "PER_ID", nullable = false, length = 20)
    private Long idPerson;

    @Column(name = "PER_NOMBRES", nullable = false, length = 60)
    private String names;

    @Column(name = "PER_APELLIDOS", nullable = false, length = 60)
    private String lastNames;

    @Column(name = "PER_CORREO", unique = true, length = 40)
    private String email;

    @Column(name = "PER_ESTADO", nullable = false, length = 20)
    private String state;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "PER_ID_ROL", referencedColumnName = "R_ID")
    private Rol rol;
}
