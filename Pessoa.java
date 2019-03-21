package teste;

public abstract class Pessoa {

	public String nome;
	public String sexo;

}

class Homem extends Pessoa {

	public Homem(String nome) {
        this.nome = nome;
        System.out.println("Olá Senhor " + this.nome);
    }
}

class Mulher extends Pessoa {

	public Mulher(String nome) {
        this.nome = nome;
        System.out.println("Olá Senhora " + this.nome);
    }

}