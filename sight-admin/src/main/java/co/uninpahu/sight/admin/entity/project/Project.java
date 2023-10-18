package co.uninpahu.sight.admin.entity.project;

import co.uninpahu.sight.admin.entity.client.Client;
import co.uninpahu.sight.admin.entity.person.Person;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "PROYECTOS")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "PRY_ID", nullable = false, length = 20)
    private Long idProject;

    @Column(name = "PRY_NOMBRE", nullable = false, length = 60)
    private String name;

    @Column(name = "PRY_FECHA_INICIO", nullable = false)
    private Date startDate;

    @Column(name = "PRY_FECHA_FIN", nullable = false)
    private Date endDate;

    @Column(name = "PRY_ESTADO", nullable = false, length = 20)
    private String state;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRY_ID_CLIENTE", referencedColumnName = "CL_ID")
    private Client client;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRY_ID_PERSONA", referencedColumnName = "PER_ID")
    private Person person;

}
