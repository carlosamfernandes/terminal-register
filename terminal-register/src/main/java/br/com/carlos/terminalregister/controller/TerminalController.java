package br.com.carlos.terminalregister.controller;


import br.com.carlos.terminalregister.controller.dto.TerminalDto;
import br.com.carlos.terminalregister.models.Terminal;
import br.com.carlos.terminalregister.repository.TerminalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    // TODO: revisar os endpoints já criados
    // TODO: implementar os demais endpoints
}
