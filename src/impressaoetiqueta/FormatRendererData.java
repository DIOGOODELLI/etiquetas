/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impressaoetiqueta;

/**
 *
 * @author suporte
 */
import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;


public class FormatRendererData extends DefaultTableCellRenderer
{
    @Override
    public void setValue(Object value)
    {    try
        {
            if (value != null)
            {
                try {
                    String data = value.toString();
                    
                    String formato = "";         
                    if (data.indexOf("-") > 0){
                        data = data.replace("-", "").trim();
                        
                        data = data.substring(0, 8);
                        formato = "yyyyMMdd"; 
                    }
                    else{
                        data = data.replace("/", "").trim();
                        if (data.length() == 8){    
                            formato = "ddMMyyyy"; 
                        }
                        if (data.length() == 7){   
                            formato = "dMMyyyy";
                        }
                        if (data.length() == 6){    
                            formato = "ddMMyy"; 
                        }
                        if (data.length() == 5){
                            formato = "dMMyy"; 
                        } 
                        if (data.length() == 4){
                            formato = "dMyy"; 
                        }
                    }
                    
                    SimpleDateFormat entrada = new SimpleDateFormat(formato);
                    Date date = entrada.parse(data);
                    
                    Long mill = date.getTime();
                    SimpleDateFormat saida = new SimpleDateFormat("dd/MM/yyyy");
                    
                    SimpleDateFormat year = new SimpleDateFormat("yyyy");
                    String ano = (String) year.format(mill);
                    
                    if(! ano.equals("1900"))
                       value = saida.format(mill);
                    else
                       value = "";
                    
                } catch (Exception e) {
 
                    value = "";
                }
            }       
        }
        catch(Exception e) {}
 
        super.setValue(value);
    }
    
    
    @Override 
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
        int row, int column) {
        
        JLabel cell = (JLabel) super.getTableCellRendererComponent(
          table, value, isSelected, hasFocus, row, column);

        //set Alignment
        cell.setHorizontalAlignment(SwingConstants.CENTER);
            if (hasFocus) {
               cell.setForeground(Color.white);  
               cell.setBackground(Color.BLUE.darker());  
           }else if (row % 2 == 0) {
               cell.setBackground(Color.white);
               cell.setForeground(Color.BLACK);
           } else {
               cell.setBackground(Color.lightGray);
               cell.setForeground(Color.BLACK);
           }  
           return cell;
    }
     
}