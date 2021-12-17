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
public class Exercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        
        String entrada;
        Calendar data[] = new Calendar[5];
        Calendar dataPagamento = Calendar.getInstance();
        
        for(int i=0; i<1; i++){
            try{
                data[i] = Calendar.getInstance();
                entrada = JOptionPane.showInputDialog("Informe uma data no formato dd/MM/yyyy: ");
                dataPagamento.setTime(sdf.parse(entrada));
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                i--;
            }
        }
        
        System.out.println("Data informada: " + sdf.format(dataPagamento.getTime()));
        for(int i=0; i<5; i++){
           data[i] = dataPagamento;
           dataPagamento.add(Calendar.DAY_OF_MONTH, 7);
           
           System.out.println("Data de pagamento: " + sdf.format(data[i].getTime()));
        }
    }
}
