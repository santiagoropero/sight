package co.uninpahu.sight.admin.entity.client;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CLIENTES")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CL_ID", nullable = false, length = 20)
    private Long idClient;

    @Column(name = "CL_NOMBRE", nullable = false, length = 40)
    private String name;

    @Column(name = "CL_ESTADO", nullable = false, length = 20)
    private String state;
}
