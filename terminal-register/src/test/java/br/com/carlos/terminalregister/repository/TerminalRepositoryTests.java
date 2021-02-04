package br.com.carlos.terminalregister.repository;

import br.com.carlos.terminalregister.models.Terminal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TerminalRepositoryTests {

    @Autowired
    private TerminalRepository terminalRepository;

    // There's no need to create new terminal instance neither configure another database since H2 is used
    // Using a regular database, we should configure a H2 database for test environment and create a new terminal instance for tests scenarios

    @Test
    public void shouldReturnTerminalByLogic() {
        Integer logic = 88449944;
        Optional<Terminal> terminal = terminalRepository.findByLogic(logic);
        Assert.assertTrue(terminal.isPresent());
        Assert.assertEquals(logic, terminal.get().getLogic());
    }

    @Test
    public void shouldNotReturnTerminalWhenLogicDoesNotExist() {
        Integer logic = 88441234;
        Optional<Terminal> terminal = terminalRepository.findByLogic(logic);
        Assert.assertFalse(terminal.isPresent());
    }
}
