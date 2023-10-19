package co.uninpahu.sight.admin.repository.client;

import co.uninpahu.sight.admin.entity.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
