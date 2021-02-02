package br.com.carlos.terminalregister.repository;

import br.com.carlos.terminalregister.models.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TerminalRepository extends JpaRepository<Terminal, Integer> {

    Optional<Terminal> findByLogic(Integer logic);
}
