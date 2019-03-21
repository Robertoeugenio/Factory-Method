package teste;
public class TesteApp {
     
    public static void main(String args[]) {
        FactoryPessoa factory = new FactoryPessoa();
        String nome = "Roberto";
        String sexo = "M";
        factory.getPessoa(nome, sexo);
    }
}