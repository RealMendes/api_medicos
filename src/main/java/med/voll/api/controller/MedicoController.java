package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao) {
        return repository.findAllByInativoFalse(paginacao).map(DadosListagemMedico::new);
    }

    @GetMapping("/{id}")
    public Optional<DadosListagemMedico> detalhar(@PathVariable Long id) {
        return repository.findById(id).map(DadosListagemMedico::new);
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizarMedico dados) {
        Medico medico = repository.findById(id).orElseThrow();
        medico.atualizar(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        Medico medico = repository.findById(id).orElseThrow();
        medico.setInativo();
    }



}
