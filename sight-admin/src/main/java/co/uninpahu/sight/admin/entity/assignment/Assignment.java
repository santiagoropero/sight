package co.uninpahu.sight.admin.entity.assignment;

import co.uninpahu.sight.admin.entity.person.Person;
import co.uninpahu.sight.admin.entity.project.Project;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ASIGNACIONES")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Assignment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ASG_ID", nullable = false, length = 20)
    private Long idAssignment;

    @Column(name = "ASG_DEDICACION", nullable = false, length = 20)
    private Integer dedication;

    @Column(name = "ASG_FECHA_INCIO", nullable = false)
    private Date startDate;

    @Column(name = "ASG_FECHA_FIN", nullable = false)
    private Date endDate;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "ASG_ID_PERSONA", referencedColumnName = "PER_ID")
    private Person person;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "ASG_ID_PROYECTO", referencedColumnName = "PRY_ID")
    private Project project;
}
