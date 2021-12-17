import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author estef
 */
public class Exercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DecimalFormat formatador = new DecimalFormat("0.00");
        
        String nome = "";
        Double salarioBruto = null;
        Double salarioLiquido = null;
        Double descontoINSS = null;
        Double tetoINSS = 6433.57;
        
        for(int i=0; i<1; i++){
            try{
                nome = JOptionPane.showInputDialog("Informe o nome: ");
                salarioBruto = Double.parseDouble(JOptionPane.showInputDialog("Informe o salário atual: "));
                if(salarioBruto <= 0 && nome.isEmpty()){
                    throw new Exception("Nome e salário inválidos, digite novamente");
                }
                else if(salarioBruto <=0){
                    throw new Exception("Salário inválido, digite novamente");
                }
                else if(nome.isEmpty()){
                    throw new Exception("Nome não pode ser nulo, digite novamente");
                } 
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());    
                i--;
            }
        }
        
        if(salarioBruto > 0 && salarioBruto <=1100){
            descontoINSS = (salarioBruto * 0.075);
        }
        else if(salarioBruto >= 1100.01 && salarioBruto <= 2203.48){
            descontoINSS = (salarioBruto * 0.09);
        }
        else if(salarioBruto >= 2203.49 && salarioBruto <= 3305.22){
            descontoINSS = (salarioBruto * 0.12);
        }
        else if(salarioBruto >= 3305.23 && salarioBruto <= 6433.57){
            descontoINSS = (salarioBruto * 0.14);
        }
        else if(salarioBruto > 6433.57){
            descontoINSS = (tetoINSS * 0.14);
        }
        
        salarioLiquido = salarioBruto - descontoINSS;
        
        JOptionPane.showMessageDialog(null, "Nome: " + nome + 
                "\nSalário bruto: " + formatador.format(salarioBruto)+
                "\nINSS: " + formatador.format(descontoINSS) + 
                "\nSalário líquido: " + formatador.format(salarioLiquido)
        );
    }
}
