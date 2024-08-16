package co.animal.AnimalConsumer.model;

public class Animal {

    private int id;
    private String nome;
    private String dataNascimento;
    private String raca;

    public Animal(){
        this.id = 0;
        this.nome = "";
        this.dataNascimento = "";
        this.raca = "";
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
}
