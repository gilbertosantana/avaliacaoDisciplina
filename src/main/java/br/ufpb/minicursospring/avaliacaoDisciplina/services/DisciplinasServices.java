package br.ufpb.minicursospring.avaliacaoDisciplina.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import br.ufpb.minicursospring.avaliacaoDisciplina.entities.*;

@Service
public class DisciplinasServices {
    
    private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();

    public Disciplina addDisciplina(Disciplina disciplina) {
        int id = disciplinas.size() + 1;
        String nome = disciplina.getNome();
        double nota = disciplina.getNota();
        
        Disciplina disciplina2 = new Disciplina(id, nome, nota);
        disciplinas.add(disciplina2);

        return disciplina2;
    }

    public List<Disciplina> getTodasDisciplinas() {
        return disciplinas;
    }

    public Disciplina getDisciplinaPorId(int id) throws Exception {
        Disciplina disciEncontrada = new Disciplina();
        if(id <= 0 || disciplinas.isEmpty()){
            throw new Exception();
        }
        
        for (Disciplina disci : disciplinas) {
            if(disci.getId() == id){
                disciEncontrada = disci;
            }
        }
        return disciEncontrada;
    }

    public Disciplina editNomeDisciplina(int id, Disciplina disciplina) throws Exception{
        Disciplina disciplinaEdited = getDisciplinaPorId(id);
        disciplinaEdited.setNome(disciplina.getNome());
        
        return disciplinaEdited;
    }

    public Disciplina editNotaDisciplina(int id, Disciplina disciplina) throws Exception{
        Disciplina disciplinaEdited = getDisciplinaPorId(id);
        disciplinaEdited.setNota(disciplina.getNota());

        return disciplinaEdited;
        
    }

    public Disciplina deleteDisciplina(Integer id) throws Exception {
        Disciplina disciplina = getDisciplinaPorId(id);

        if(disciplinas.contains(disciplina)){
            disciplinas.remove(disciplina);
        }
        return disciplina;
    }

    public List<Disciplina> getRanking() {
        List<Disciplina> disciplinasOrdenadas = getTodasDisciplinas();
        
        Collections.sort(disciplinasOrdenadas);
        return disciplinasOrdenadas;
    }
}
