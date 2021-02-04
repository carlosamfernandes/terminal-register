package br.com.carlos.terminalregister.controller;

import br.com.carlos.terminalregister.controller.dto.TerminalDto;
import br.com.carlos.terminalregister.controller.form.TerminalForm;
import br.com.carlos.terminalregister.models.Terminal;
import br.com.carlos.terminalregister.repository.TerminalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/001/terminal")
public class TerminalController {

    @Autowired
    TerminalRepository terminalRepository;


    @GetMapping
    public List<TerminalDto> list() {
        List<Terminal> terminals = terminalRepository.findAll();
        return TerminalDto.convert(terminals);
    }

    @GetMapping("/{logic}")
    public ResponseEntity<TerminalDto> detail(@PathVariable Integer logic) {
        Optional<Terminal> terminal = terminalRepository.findByLogic(logic);
        if (terminal.isPresent()) {
            return ResponseEntity.ok(new TerminalDto(terminal.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{logic}")
    @Transactional
    public ResponseEntity<TerminalDto> update(@PathVariable Integer logic, @RequestBody TerminalForm form) {
        Optional<Terminal> optional = terminalRepository.findByLogic(logic);
        if (optional.isPresent()) {
            Terminal terminal = form.update(logic, terminalRepository);
            return ResponseEntity.ok(new TerminalDto(terminal));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TerminalDto> create(@RequestBody String inputTerminal, TerminalForm form, UriComponentsBuilder uriBuilder) {
        Terminal terminal = form.convert(inputTerminal);
        terminalRepository.save(terminal);
        URI uri = uriBuilder.path("/001/terminal/{id}").buildAndExpand(terminal.getLogic()).toUri();
        return ResponseEntity.created(uri).body(new TerminalDto(terminal));
    }

}
