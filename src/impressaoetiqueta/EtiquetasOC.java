/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impressaoetiqueta;


import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**

/**
 *
 * @author diogo
 */
public class EtiquetasOC extends javax.swing.JFrame {
    
     String connectionUrl = "jdbc:sqlserver://DBPRODSNR01:1433;databaseName=sapiens;user=sapiens;password=Sen@SqlSap16";
     Connection con;
    /**
     * Creates new form Etiquetas
     * @param connectionUrl
     * @param con
     */
    public EtiquetasOC(String connectionUrl, Connection con) {
        
        this.connectionUrl = connectionUrl;
        this.con = con;
        
        initComponents();
        jTextProduto.setVisible(false);
        jLabel6.setVisible(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
         
        TableColumnModel tela = jTableEtiquetas.getColumnModel();
        tela.getColumn(0).setPreferredWidth(60);
        tela.getColumn(1).setPreferredWidth(60);
        tela.getColumn(2).setPreferredWidth(100);
        tela.getColumn(3).setPreferredWidth(350);
        tela.getColumn(4).setPreferredWidth(60);
        tela.getColumn(5).setPreferredWidth(80);
        tela.getColumn(6).setPreferredWidth(80);
        tela.getColumn(7).setPreferredWidth(80);
        tela.getColumn(8).setPreferredWidth(80);
        tela.getColumn(9).setPreferredWidth(80);
        tela.getColumn(10).setPreferredWidth(80);
        tela.getColumn(11).setPreferredWidth(80);
        tela.getColumn(12).setPreferredWidth(80);
        tela.getColumn(8).setCellRenderer(new FormatRendererData());
        tela.getColumn(9).setCellRenderer(new FormatRendererData());
        
        jTableEtiquetas.setDefaultRenderer(Object.class, new ZebradoGeral());
        
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);

        for (PrintService printer : printServices) {

            jComboBoxImp.addItem(printer.getName()); 
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxImp = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextOC = new javax.swing.JTextField();
        jTextProduto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButtonImprimir = new javax.swing.JButton();
        jButtonFiltrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEtiquetas = new javax.swing.JTable();
        jButtonImprimir1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBoxImp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxImpActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Etiqueta Recebimento P" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Layout:");

        jLabel3.setText("Impressora:");

        jLabel4.setText("OC:");

        jLabel6.setText("Produto:");

        jButtonImprimir.setText("Imprimir");
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
            }
        });

        jButtonFiltrar.setText("Filtrar");
        jButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarActionPerformed(evt);
            }
        });

        jTableEtiquetas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Filial", "OC", "Produto", "Descrição do Produto", "Derivacação", "UND", "Quantidade", "Centro Custo", "Data Ordem", "Data Prevista", "Status", "Código de Barras", "Familia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEtiquetas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableEtiquetas.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(jTableEtiquetas);

        jButtonImprimir1.setText("Relatório");
        jButtonImprimir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, 274, Short.MAX_VALUE)
                            .addComponent(jComboBoxImp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextOC)
                            .addComponent(jTextProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButtonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(jButtonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButtonImprimir1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxImp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTextOC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTextProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFiltrar)
                    .addComponent(jButtonImprimir)
                    .addComponent(jButtonImprimir1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxImpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxImpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxImpActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed
        
        if (jTextOC.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "OC deverá ser informado!", "Validação", JOptionPane.PLAIN_MESSAGE); 
            return;
        }
        
        String codigoProduto; 
        String quantidade;
        String unidade;
        String familia;
        String codigoBarras;
        String codigoDerivacao; 
        
        try {
            
            PrintService ps=PrintServiceLookup.lookupDefaultPrintService();
            DocPrintJob job=ps.createPrintJob();
            job.addPrintJobListener(new PrintJobAdapter() {
                @Override
                public void printDataTransferCompleted(PrintJobEvent event){}

                @Override
                public void printJobNoMoreEvents(PrintJobEvent event){}
            });

            String dadosPrint;
            int itm = jComboBox1.getSelectedIndex()+1;
            
            String printerName = (String)jComboBoxImp.getSelectedItem();
   
            boolean printerCheck = false;
            PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
            
            String CODBAR;
            String DERIVACAO;
            String TEXTO_1;
            
            for (PrintService printer : printServices) {    
                
                if (printer.getName().equalsIgnoreCase(printerName)) {
                    
                    for(int linha=0; linha < jTableEtiquetas.getRowCount(); linha++){
                        
                        codigoProduto      = (String)jTableEtiquetas.getModel().getValueAt(linha,2); 
                        unidade            = (String)jTableEtiquetas.getModel().getValueAt(linha,5); 
                        codigoBarras       = (String)jTableEtiquetas.getModel().getValueAt(linha,11);
                        quantidade         = (String)jTableEtiquetas.getModel().getValueAt(linha,9);
                        familia            = (String)jTableEtiquetas.getModel().getValueAt(linha,12);
                        codigoDerivacao    = (String)jTableEtiquetas.getModel().getValueAt(linha,4); 
                        
                        System.out.println(codigoProduto);
                        
                        if (! unidade.equalsIgnoreCase("FL") 
                            && ! unidade.equalsIgnoreCase("KG")
                            && ! unidade.equalsIgnoreCase("LT")       
                            && ! unidade.equalsIgnoreCase("MI")      
                            && ! unidade.equalsIgnoreCase("LT")       
                            && ! unidade.equalsIgnoreCase("M")          
                            && ! unidade.equalsIgnoreCase("MI")  
                            && ! unidade.equalsIgnoreCase("MT")
                            && ! familia.equalsIgnoreCase("10")       
                            && ! familia.equalsIgnoreCase("40")         
                            && ! familia.equalsIgnoreCase("50")){
                            
                            int contador = (int) Double.parseDouble(quantidade);
                                
                            switch (itm) {
           
                                case 1:
                                    for (int i = 1; i <= contador ; i++){
                                        
                                        CODBAR  = codigoBarras;
                                        DERIVACAO = codigoDerivacao;
                                        TEXTO_1 = codigoProduto;
                                        TEXTO_1 =  TEXTO_1.replaceAll("(\r\n|\n)","");

                                        if(CODBAR.equals("")){
                                            continue;
                                        }

                                        dadosPrint = getLayoutEtiqueta(itm).
                                        replace("CODBAR" , CODBAR).
                                        replace("CODDER" , DERIVACAO).        
                                        replace("CODPRO", TEXTO_1);
                                        
                                        InputStream inputStream = new ByteArrayInputStream(dadosPrint.getBytes());
                                        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
                                        Doc doc = new SimpleDoc(inputStream, flavor, null);
                                        job = printer.createPrintJob();

                                        job.print(doc, null);
                                    }
                                    break;

                                default:
                                    break;
                            }
  
                        }

                    }
                    printerCheck = true;
                }
            }

            if (printerCheck == false) {
                JOptionPane.showMessageDialog(null,"The printer you were searching for could not be found.");
            }
        } catch (Exception ex) {
            //Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonImprimirActionPerformed

    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarActionPerformed
        
        String FiltroOC = jTextOC.getText();
        String FiltroEndereco = jTextProduto.getText();
        buscaBancoOC(FiltroOC, FiltroEndereco);
   
    }//GEN-LAST:event_jButtonFiltrarActionPerformed

    private void jButtonImprimir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimir1ActionPerformed
   
        if (jTextOC.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "OC deverá ser informado!", "Validação", JOptionPane.PLAIN_MESSAGE); 
            //return;
        }
         String oc = jTextOC.getText();
         try {       
             execWebService(oc);
         } catch (SOAPException ex) {
             Logger.getLogger(EtiquetasOC.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(EtiquetasOC.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jButtonImprimir1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EtiquetasOC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         //</editor-fold>
         //</editor-fold>
         
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new EtiquetasOC("", null).setVisible(true);
        });
    }
           
    public String getLayoutEtiqueta(int iEtiqueta){
        
        StringBuffer dadosPrint = new StringBuffer();
            switch (iEtiqueta) {
                case 1://Etiqueta Recebimento P              
                        dadosPrint.append('\u0002' +"CT~~CD,~CC^~CT~\n" +
                        "^XA~TA000~JSN^LT0^MNW^MTD^PON^PMN^LH0,0^JMA^PR4,4~SD15^JUS^LRN^CI0^XZ\n" +
                        "^XA\n" +
                        "^MMT\n" +
                        "^PW216\n" +
                        "^LL0160\n" +
                        "^LS0\n" +
                        "^FT20,86^BQN,2,3\n" +
                        "^FH\\^FDMA,CODBAR^FS\n" +
                        "^FO90,34^GB98,17,17^FS\n" +
                        "^FT90,47^A0N,14,14^FR^FH\\^FDCODPRO^FS\n" +
                        "^FO109,54^GB25,17,17^FS\n" +
                        "^FT109,67^A0N,14,9^FR^FH\\^FDCODDER^FS\n" +
                        "^FO91,54^GB18,17,17^FS\n" +
                        "^FT91,67^A0N,14,9^FR^FH\\^FDDR: ^FS\n" +
                        "^PQ1,0,1,Y^XZ");
                        break;
                 default:
                     break;

                }
        dadosPrint.append("E" + "\r");        
        return dadosPrint.toString();
    }
    
    
    public void buscaBancoOC(String oc, String produto){

         DefaultTableModel model =(DefaultTableModel) jTableEtiquetas.getModel();
         model.setRowCount(0);
         try {

             Statement stmt = con.createStatement();

             String SQL = "SELECT " +
                         "a.codfil, " +
                         "a.numocp, " +
                         "A.codpro, " +
                         "B.despro, " +
                         "C.codder, " +
                         "b.unimed, " +
                         "A.qtdped, " +
                         "a.codccu, " +
                         "a.datger, " +
                         "a.datent, " +
                         "a.sitipo, " +
                         "C.codba2, " +
                         "a.codfam " +
                         "FROM e420ipo A " +
                         "LEFT JOIN e075pro B ON A.codemp = B.codemp AND A.codpro = B.codpro " +
                         "LEFT JOIN e075der C ON A.codemp = C.codemp AND A.codpro = C.codpro AND A.codder = C.codder " +
                         "WHERE A.codemp = 100 AND codfil = 7 "
                       + "and numocp =" + oc;

                 ResultSet rs = stmt.executeQuery(SQL);
                 while (rs.next()) {
                         model.addRow(new Object[]{                           
                         rs.getString(1), 
                         rs.getString(2), 
                         rs.getString(3), 
                         rs.getString(4), 
                         rs.getString(5),
                         rs.getString(6),
                         rs.getString(7),
                         rs.getString(8),
                         rs.getString(9),
                         rs.getString(10),
                         rs.getString(11),
                         rs.getString(12),
                         rs.getString(13),
                   }); 
               }
         }catch(Exception er){}
    }

    
    private static String execWebService(String oc) throws SOAPException, IOException {
        
        String url;
                       
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();
        StringBuffer requestSoap = new StringBuffer();
        requestSoap.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://services.senior.com.br\">" +
                "   <soapenv:Header/>" +
                "   <soapenv:Body>" +
                "      <ser:Executar>" +
                "           <user>sapienssid</user>" +
                "           <password>sapienssid</password>" +
                "           <encryption>0</encryption>" +
                "         <parameters>" +
                "            <prEntrada>&lt;ECodEmp=100&gt;&lt;ECodFil=7&gt;&lt;ENumOcp="+oc+"&gt;</prEntrada>" +
                "            <prEntranceIsXML>F</prEntranceIsXML>" +
                "            <prRelatorio>SCOC650.GER</prRelatorio>" +
                "            <prSaveFormat>tsfPDF</prSaveFormat>" +
                            " <prTypeBmp>N</prTypeBmp>" +
                            " <prExecFmt>tefFile</prExecFmt>" +
                            " <prTypeBmp>N</prTypeBmp>" +
                "         </parameters>" +
                "      </ser:Executar>" +
                "   </soapenv:Body>" +
                "</soapenv:Envelope>");

        url = "http://34.237.19.106:8080/g5-senior-services/sapiens_Synccom_senior_g5_co_ger_relatorio";        
        //url = this.sWebServiceUrl;

        MimeHeaders headers = new MimeHeaders();
        headers.addHeader("Content-Type", "text/xml");       
        MessageFactory messageFactory = MessageFactory.newInstance();

        
        SOAPMessage msg = null;
        try {
            msg = messageFactory.createMessage(headers, (new ByteArrayInputStream(requestSoap.toString().getBytes())));
        } catch (IOException ex) {}
 
        SOAPMessage soapResponse = soapConnection.call(msg, url);
        Document xmlRespostaARequisicao = soapResponse.getSOAPBody().getOwnerDocument();
        

        String XmlRetorno = passarXMLParaString(xmlRespostaARequisicao,4);
        NodeList entries =  xmlRespostaARequisicao.getElementsByTagName("result");
                 
        //System.out.println(XmlRetorno);

        String base = XmlRetorno.substring(XmlRetorno.indexOf("<prRetorno>"), XmlRetorno.indexOf("</prRetorno>"));
        base = base.replace("<prRetorno>", "");
        base = base.replace("</prRetorno>", "");
        
        Base64DecodePdf(base);
        return "";
    }
        
  
  
    
    public static String getValueTag(Element oEl, String name){
        NodeList oList = oEl.getElementsByTagName(name);      
        String value = getCharacterDataFromElement(oList);
        return value;
    }
    
    
    
    
    public static String getCharacterDataFromElement(  NodeList oList) {
            Element e = (Element) oList.item(0);
            Node child = e.getFirstChild();
            if (child instanceof CharacterData) {
              CharacterData cd = (CharacterData) child;
              return cd.getData();
            }
        return "";
    }

   
    
    
    private static String passarXMLParaString(Document xml, int espacosIdentacao){
        
        try {
            //set up a transformer
            TransformerFactory transfac = TransformerFactory.newInstance();
            transfac.setAttribute("indent-number", espacosIdentacao);
            Transformer trans = transfac.newTransformer();
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
 
            //create string from xml tree
            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult(sw);
            DOMSource source = new DOMSource(xml);
            trans.transform(source, result);
            String xmlString = sw.toString();
            return xmlString;
        }
        catch (TransformerException e) {
            //System.exit(0);
        }
        return null;
    }
    
    
    public static void Base64DecodePdf(String base64) {
        
            Random gerador = new Random();
            File file = new File("relatorio.pdf");
            try ( FileOutputStream fos = new FileOutputStream(file); ) {

              String b64 = base64;
              byte[] decoder = Base64.getDecoder().decode(b64);

              fos.write(decoder);
              
              Desktop.getDesktop().open(file);
            } catch (Exception e) {
              e.printStackTrace();
        }
    }
    
   
    
    

    
 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JButton jButtonImprimir1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBoxImp;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEtiquetas;
    private javax.swing.JTextField jTextOC;
    private javax.swing.JTextField jTextProduto;
    // End of variables declaration//GEN-END:variables
}
