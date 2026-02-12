package projetocalculadora;
public class Calculadora {
    //Método para Somar
    public double somar(double a, double b){
        return a + b;
    }
    
    //Metodo para Subtrair
    public double subtrair(double a, double b){
        return a - b;
    }
    
       //Metodo para Multiplicar
    public double multiplicar(double a, double b){
        return a * b;
    }
    
           //Metodo para Dividir
    public double dividir(double a, double b){
        if (b == 0){
            return 0; // evita erro na divisão por zero
        }
        return a/b;
    }
}
