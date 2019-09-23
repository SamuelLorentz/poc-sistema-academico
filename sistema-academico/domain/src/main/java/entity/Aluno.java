package entity;

public class Aluno {

    private int id;
    private String nome;

    public Aluno(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static AlunoBuilder builder() {
        return new AlunoBuilder();
    }

    public static class AlunoBuilder {
        private int id;
        private String nome;

        AlunoBuilder() {
        }

        public AlunoBuilder id(final int id) {
            this.id = id;
            return this;
        }

        public AlunoBuilder nome(final String nome) {
            this.nome = nome;
            return this;
        }

        public Aluno build() {
            return new Aluno(id, nome);
        }
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
}
