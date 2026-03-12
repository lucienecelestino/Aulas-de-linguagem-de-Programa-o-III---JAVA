
package model;

public class Horista extends Funcionario{
    int horasTrabalhadas;
    double valorHora;
    
    
    public Horista(String nome, int horasTrabalhadas, double valorHora) {
    super(nome, 0); // salário base = 0
    this.horasTrabalhadas = horasTrabalhadas;
    this.valorHora = valorHora;
}

     
      // Polimorfismo : Sobrescrevemos o metodo calcularLiquido
    @Override
    public double calcularLiquido(){
        double bruto = this.horasTrabalhadas * this.valorHora;
        double inss = bruto * 0.11;
        return bruto - inss;
         
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
}
