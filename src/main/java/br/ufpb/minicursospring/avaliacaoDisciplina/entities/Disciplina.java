package br.ufpb.minicursospring.avaliacaoDisciplina.entities;

public class Disciplina implements Comparable<Disciplina>{
    
    private int id;
    private String nome;
    private double nota;

    public Disciplina() {
        super();
    }
    
    public Disciplina(int id, String nome, double nota) {
        super();
        this.id = id;
        this.nome = nome;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public int compareTo(Disciplina o) {
        if(this.getNota() < o.getNota()){
            return 1;
        } else if(this.getNota() > o.getNota()){
            return -1;
        }
        return 0;
    }
}
