package br.ufpb.minicursospring.avaliacaoDisciplina.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.ufpb.minicursospring.avaliacaoDisciplina.entities.Disciplina;
import br.ufpb.minicursospring.avaliacaoDisciplina.services.DisciplinasServices;

@RestController
public class DisciplinaController {
    
    @Autowired
    private DisciplinasServices disciplinaService;

    @PostMapping("/v1/api/disciplinas")
    public ResponseEntity<Disciplina> addDisciplina(@RequestBody Disciplina disciplina) {
        return new ResponseEntity<>(disciplinaService.addDisciplina(disciplina), HttpStatus.OK);
    }

    @GetMapping("/v1/api/disciplinas")
    public ResponseEntity<List<Disciplina>> getTodasDisciplinas() {
        return new ResponseEntity<List<Disciplina>>(disciplinaService.getTodasDisciplinas(), HttpStatus.OK);
    }

    @GetMapping("/v1/api/disciplinas/{id}")
    public ResponseEntity<Disciplina> getDisciplinaPorId(@PathVariable Integer id) throws Exception {
        try {
            return new ResponseEntity<Disciplina>(disciplinaService.getDisciplinaPorId(id), HttpStatus.OK);
        
        } catch(Exception ex) {
            return new ResponseEntity<Disciplina> (new Disciplina(), HttpStatus.NOT_FOUND);
        }
    }
    
    @PatchMapping("v1/api/disciplinas/{id}/nome")
    public ResponseEntity<Disciplina> editNomeDisciplina(@PathVariable Integer id, @RequestBody Disciplina disciplina) throws Exception {
        return new ResponseEntity<>(disciplinaService.editNomeDisciplina(id, disciplina), HttpStatus.OK);
    }

    @PatchMapping("v1/api/disciplinas/{id}/nota")
    public ResponseEntity<Disciplina> editNotaDisciplina(@PathVariable int id, @RequestBody Disciplina disciplina) throws Exception {
        return new ResponseEntity<>(disciplinaService.editNotaDisciplina(id, disciplina), HttpStatus.OK);
    }

    @DeleteMapping("v1/api/disciplinas/{id}")
    public ResponseEntity<Disciplina> deleteDisciplina(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(disciplinaService.deleteDisciplina(id), HttpStatus.OK);
    }

    @GetMapping("v1/api/disciplinas/ranking")
    public ResponseEntity<List<Disciplina>> getRankingDisciplina(){
        return new ResponseEntity<>(disciplinaService.getRanking(), HttpStatus.OK);
    }

}
