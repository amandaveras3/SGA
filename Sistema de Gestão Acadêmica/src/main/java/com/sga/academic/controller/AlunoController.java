package com.sga.academic.controller;

import com.sga.academic.model.Aluno;
import com.sga.academic.model.Curso;
import com.sga.academic.repository.AlunoRepository;
import com.sga.academic.repository.CursoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public AlunoController(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    @PostMapping
    public ResponseEntity<Aluno> criar(@RequestBody Aluno aluno) {
        Curso curso = cursoRepository.findById(aluno.getCurso().getId())
                .orElse(null);

        if (curso == null) {
            return ResponseEntity.badRequest().build();
        }

        aluno.setCurso(curso);
        Aluno salvo = alunoRepository.save(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscar(@PathVariable Long id) {
        return alunoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno aluno) {
        if (!alunoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        aluno.setId(id);
        return ResponseEntity.ok(alunoRepository.save(aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!alunoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        alunoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}