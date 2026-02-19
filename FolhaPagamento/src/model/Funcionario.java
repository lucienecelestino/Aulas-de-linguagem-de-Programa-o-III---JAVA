
package model;

public class Funcionario {
   // // Atributos Protected : Para que os Filhos ( Gerente ) possam ver
    protected String nome;
    protected double salarioBase;
    
    // Construtor
    public Funcionario (String nome, double salario){
        this.nome = nome;
        // O ’this ’ diferencia o atributo do parametro
        this.salarioBase = salario;
    }
    
    // Regra : INSS de 11% ( fixo para exemplo )
    public double calcularINSS(){
        return this.salarioBase * 0.11;
    }
    
    // Calculo do Liquido
    public double calcularLiquido(){
        return this.salarioBase - calcularINSS();
    }
    
    // Getters ( Para a tela pegar os valores )
    public String getNome() {return nome;}
    public double getSalarioBase() {return salarioBase;}


}
