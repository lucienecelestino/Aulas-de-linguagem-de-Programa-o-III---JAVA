
package model;

// " extends " indica Heranca
public class Gerente extends Funcionario {
 
    private double bonus;
    
    public Gerente(String nome, double salario, double bonus) {
        super(nome, salario);// Chama o construtor do Pai ( Funcionario )
        this.bonus = bonus;
    }
 // Polimorfismo : Sobrescrevemos o metodo calcularLiquido
    @Override
    public double calcularLiquido(){
        // Liquido do Gerente = ( Salario + Bonus ) - INSS
         // Usamos super.calcularINSS() para garantir o calculo base
         return (this.salarioBase + this.bonus) - super.calcularINSS();
         
    }
}
