package com.sga.academic.repository;

import com.sga.academic.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    boolean existsByCursoId(Long cursoId);
}