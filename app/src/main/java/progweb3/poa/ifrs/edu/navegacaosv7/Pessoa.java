package progweb3.poa.ifrs.edu.navegacaosv7;

import java.util.Random;

public class Pessoa {

    private String nome;
    private String cidade;

    public Pessoa(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }

    private static String[] nomes = {"Marcos", "Arthur", "José", "Carlos", "Karina", "Matheus"};
    private static String[] cidades = {"Rio", "POA", "Canoas", "Viamão", "Sapucaia", "Alvorada"};

    public static Pessoa carrega() {
        return new Pessoa(nomes[getRandomValue(0, 5)],
                cidades[getRandomValue(0, 5)]);
    }

    private static int getRandomValue(int low, int high) {
        return new Random().nextInt(high - low) + low;
    }
}
