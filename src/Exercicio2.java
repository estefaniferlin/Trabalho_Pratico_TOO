import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author estef
 */
public class Exercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        DecimalFormat formatador = new DecimalFormat("0.00");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        
        Double valorDiaria = null;
        Double valorLocacao = null;
        String entrada;
        String saida;
        Date dataLocacao = null;
        Date dataDevolucao = null;
        int milisPorDia = (24 * 60 * 60 * 1000);
        Long qtdDias;
        Long dias;
        
        for(int i=0; i<1; i++){
            try{
                valorDiaria = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da diária: "));
                entrada = JOptionPane.showInputDialog("Informe a data de locação no formato dd/MM/yyyy");
                saida = JOptionPane.showInputDialog("Informe a data de retirada no formato dd/MM/yyyy");  
                dataLocacao = sdf.parse(entrada);
                dataDevolucao = sdf.parse(saida);
                
                if(valorDiaria <=0){
                    throw new Exception("Valor da diária inválido");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + ". Digite novamente");
                i--;
            }
        }
 
        qtdDias = dataDevolucao.getTime() - dataLocacao.getTime();
        dias = qtdDias / milisPorDia;
        
        valorLocacao = valorDiaria * dias;
        
        JOptionPane.showMessageDialog(null, "Valor da diária: " + formatador.format(valorDiaria) +
                    "\nData de locação: " + sdf.format(dataLocacao) +
                    "\nData de devolução: " + sdf.format(dataDevolucao) +
                    "\nDias de locação: " + dias +
                    "\nValor total da locação: " + formatador.format(valorLocacao)
        );
    } 
}
