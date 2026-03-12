
package View;

import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import model.Gerente;
import model.RepositorioDados;
import model.Horista;

public class TelaListaFuncionarioModal extends javax.swing.JDialog {

 private Funcionario funcionarioEmEdicao;
    
    public TelaListaFuncionarioModal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Cargo", "Salário"
            }
        ));
        jScrollPane1.setViewportView(tblFuncionarios);

        jButton1.setText("Novo");

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        atualizarTabela();
    }//GEN-LAST:event_formWindowActivated

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   int linhaSelecionada = tblFuncionarios.getSelectedRow();//voltaa linha que estava selecionada
        if (linhaSelecionada == -1) {
            // Alerta o utilizador caso ele tenha esquecido de selecionar alguém
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, selecione um funcionário na tabela para editar.", 
                "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
        }else{
            model.Funcionario funcionarioEscolhido = model.RepositorioDados.listaFuncionarios.get(linhaSelecionada);            
            TelaEdicaoFuncionario telaEdicao = new TelaEdicaoFuncionario((java.awt.Frame) this.getParent(), true); //cria a tela de edição funcionario
            telaEdicao.setFuncionario(funcionarioEscolhido);
            telaEdicao.setLocationRelativeTo(this);
            telaEdicao.setVisible(true);
        }        
    }//GEN-LAST:event_jButton2ActionPerformed
 private void atualizarTabela() {
        // 1. Pega o modelo (a estrutura) da tabela que está na tela
        DefaultTableModel modelo = (DefaultTableModel) tblFuncionarios.getModel();

        // 2. Limpa a tabela antes de desenhar de novo (para não duplicar)
        modelo.setNumRows(0);

        // 3. Percorre a nossa lista do ArrayList
        for (Funcionario f : RepositorioDados.listaFuncionarios) {

            // Descobre qual é o cargo para colocar na coluna
            String cargo = "Funcionário Comum";
            if (f instanceof Gerente) {
                cargo = "Gerente";
            } 
            else if (f instanceof Horista) {
                cargo = "Horista";
            }
            
            // Se houver o Horista (Desafio 1), pode colocar um else if aqui

            // 4. Adiciona uma linha nova na tabela com os dados 
            modelo.addRow(new Object[]{
                f.getNome(),
                cargo,
                "R$ " + f.calcularLiquido()
            });
        }}

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaListaFuncionarioModal dialog = new TelaListaFuncionarioModal(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFuncionarios;
    // End of variables declaration//GEN-END:variables
}
