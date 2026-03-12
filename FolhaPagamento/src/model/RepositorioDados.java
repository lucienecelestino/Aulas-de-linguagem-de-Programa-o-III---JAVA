
package model;
import java.util.ArrayList; // matriz rodadndo como um objeto


public class RepositorioDados { //essa é a classe
    public static ArrayList<Funcionario> listaFuncionarios = new ArrayList<>(); //lista funcionario será acessado por todos do meu projeto, mas só existe uma unica listaFuncionarios, o static garante que só pode sere instaciado uma vez

    private RepositorioDados() {
    }
    public static void iniciarDadosTeste(){
           if(listaFuncionarios.isEmpty()) {//verifica se a lista está vazia
            // Funcionários Comuns (Nome, Salário Base)
            listaFuncionarios.add(new Funcionario("Ana Silva", 3500.00));
            listaFuncionarios.add(new Funcionario("Daniel Costa", 2800.00));
            listaFuncionarios.add(new Funcionario("Gabriela Mendes", 4100.00));
            listaFuncionarios.add(new Funcionario("Isabela Castro", 3200.00));
            
            // Gerentes (Nome, Salário Base, Bônus)
            listaFuncionarios.add(new Gerente("Carlos Oliveira", 8000.00, 2500.00));
            listaFuncionarios.add(new Gerente("Eduarda Lima", 9500.00, 3000.00));
            listaFuncionarios.add(new Gerente("João Pereira", 10500.00, 4000.00));
            
            // Horistas (Nome, Horas Trabalhadas, Valor da Hora)
            listaFuncionarios.add(new Horista("Beatriz Souza", 160, 45.00));
            listaFuncionarios.add(new Horista("Fábio Rocha", 120, 50.00));
            listaFuncionarios.add(new Horista("Henrique Alves", 100, 40.00));
        }
    }
    
}
