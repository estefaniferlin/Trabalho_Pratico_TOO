import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author estef
 */
public class Exercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DecimalFormat formatador = new DecimalFormat("0.00");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        
        Double valorCompra = null;
        int parcelas = 0;
        
        for(int i=0; i<1; i++){
            try{
                valorCompra = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da compra: "));
                parcelas = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de parcelas: "));

                if(valorCompra <=0 && parcelas == 0){
                    throw new Exception("Total da compra e quantidade de parcelas com valores inválidos");
                }
                else if(valorCompra <= 0 || parcelas == 0){
                    if(valorCompra <=0){
                        throw new Exception("Total da compra inválido");
                    }else{
                        throw new Exception("Quantidade de parcelas inválida");
                    }
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                i--;
            }
        }
        
        Double valorParcela[] = new Double[parcelas];
        Calendar dataVencimento[] = new Calendar[parcelas];
        
        for(int i=0; i<parcelas; i++){
            valorParcela[i] = valorCompra / parcelas;
        }
        
        for(int i=0; i<parcelas; i++){
            dataVencimento[i] = Calendar.getInstance();
        }
        
        dataVencimento[1] = Calendar.getInstance();
        
        System.out.println("Valor da compra: " + formatador.format(valorCompra) + "\nValor de parcelas: " + parcelas);
            
        for(int i=0; i<parcelas; i++){
            if(i==0){
                dataVencimento[i].add(Calendar.DAY_OF_MONTH, 30);
            }else{
                dataVencimento[i-1].add(Calendar.DAY_OF_MONTH, 30);
                dataVencimento[i] = dataVencimento[i-1]; 
            }
            
            System.out.println("Valor da parcela: " + formatador.format(valorParcela[i]) + 
                    " Data do " + (i+1) + "º vencimento: " + sdf.format(dataVencimento[i].getTime())
            );
        }  
    }
}
