package com.jcg.hibernate.crud.operations;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// import java.util.List;

public class UserInterface extends JFrame implements ActionListener {

    private JPanel contentPane;
    
    private JTextField txtNome;
    private JTextField txtEndereco;
    private JTextField txtTel;
    
    private JComboBox cbPesquisar;
    // private ButtonGroup bt = new ButtonGroup();

    private JButton btnIncluir;
    private JButton btnExcluir;
    private JButton btnEditar;
    private JButton btnPesquisar;
    private JButton btnLimpar;

    public UserInterface() {
        setTitle("Cadastro de Contatos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 556, 413);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPesquisar = new JLabel("Pesquisar:");
        lblPesquisar.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblPesquisar.setBounds(10, 31, 109, 14);
        contentPane.add(lblPesquisar);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblNome.setBounds(10, 79, 109, 14);
        contentPane.add(lblNome);

        JLabel lblEndereo = new JLabel("Endere\u00E7o:");
        lblEndereo.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblEndereo.setBounds(10, 104, 109, 14);
        contentPane.add(lblEndereo);

        JLabel lblTel = new JLabel("Telefone:");
        lblTel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblTel.setBounds(10, 129, 109, 14);
        contentPane.add(lblTel);

        cbPesquisar = new JComboBox();
        cbPesquisar.setEditable(true);
        cbPesquisar.setBounds(129, 28, 283, 20);

        contentPane.add(cbPesquisar);

        txtNome = new JTextField();
        txtNome.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        txtNome.setBounds(129, 76, 283, 20);
        contentPane.add(txtNome);
        txtNome.setColumns(10);

        txtEndereco = new JTextField();
        txtEndereco.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        txtEndereco.setBounds(129, 101, 365, 20);
        contentPane.add(txtEndereco);
        txtEndereco.setColumns(10);

        try {
            txtTel = new JTextField();
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtTel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        txtTel.setBounds(129, 126, 143, 20);
        contentPane.add(txtTel);


        btnIncluir = new JButton("Incluir");
        btnIncluir.setBounds(193, 327, 75, 23);
        btnIncluir.addActionListener(this);
        btnIncluir.setActionCommand("salvar");
        contentPane.add(btnIncluir);

        btnEditar = new JButton("Editar");
        btnEditar.setBounds(280, 327, 75, 23);
        btnEditar.setText("Editar");
        btnEditar.addActionListener(this);
        btnEditar.setActionCommand("editar");
        contentPane.add(btnEditar);

        btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(360, 327, 75, 23);
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(this);
        btnLimpar.setActionCommand("limpar");
        contentPane.add(btnLimpar);

        btnExcluir = new JButton("");
        btnExcluir.setBounds(440, 327, 75, 23);
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(this);
        btnExcluir.setActionCommand("excluir");
        contentPane.add(btnExcluir);

        btnPesquisar = new JButton("Buscar");
        btnPesquisar.setBounds(422, 22, 80, 23);
        btnPesquisar.addActionListener(this);
        btnPesquisar.setActionCommand("pesquisar");
        contentPane.add(btnPesquisar);
    }

    public Contato montaContato() {
        // Pega os dados digitados nos campos do formulário e atribui ao objeto da
        // classe Contato;
        Contato c = new Contato();
        c.setNome(this.txtNome.getText());
        c.setEndereco(this.txtEndereco.getText());
        c.setTelefone(this.txtTel.getText());
        return c;
    }

    public void carregaContatonaTela(Contato c2) {
        // Pega os dados digitados nos campos do formulário e atribui ao objeto da
        // classe Contato;
        this.txtNome.setText(c2.getName());
        this.txtEndereco.setText(c2.getEndereco());
        this.txtTel.setText(c2.getTelefone());
    }

    public void limpaTela() {
        // laço de repetição percorrendo o contentPane - JPanel, o painel principal do formulário
        for (int i = 0; i < contentPane.getComponentCount(); i++) {

            // Cria um objeto Component c que recebe o componente na posição i do laço for
            Component c = contentPane.getComponent(i);
            
            if (c instanceof JTextField) { // se o componente c for uma instância de JTextField
                // cria uma variável JTextField recebendo o componente c com um cast
                JTextField campo = (JTextField) c;

                // apaga o conteúdo do campo JTextField;                
                campo.setText(null);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        // Condicional Create - se clicar no botão Incluir ...
        if (e.getActionCommand().equals(this.btnIncluir.getActionCommand())) {
            // Chama o método montaContato para pegar os dados e gravar no objeto c;
            Contato c = this.montaContato();

            // Chama o método insert da classe DbOperations para inserir os dados do objeto
            // Contato (c) de montaContato no banco;
            DbOperations.createRecord(c.getName(), c.getEndereco(), c.getTelefone());

            // Limpa os campos após inserir/salvar dados no banco;
            this.limpaTela();

            // Abre diálogo de mensagem, informando que o cliente foi cadastrado;
            JOptionPane.showMessageDialog(null, "Contato " + txtNome.getText() + " foi cadastrado com sucesso");
        } else 

        // Condicional Read - se clicar no botão buscar ...
        if (e.getActionCommand().equals(this.btnPesquisar.getActionCommand())) {
            this.limpaTela();
            
            Integer id = Integer.parseInt(cbPesquisar.getSelectedItem().toString().trim());
            Contato c = DbOperations.findRecordById(id);

            this.carregaContatonaTela(c);
        } else 
        
        // Lipa a tela do usuario
        if (e.getActionCommand().equals(this.btnLimpar.getActionCommand())) {
            this.limpaTela();
        } else 

        // Condicional Update - se clicar no botão editar ...
        if (e.getActionCommand().equals(this.btnEditar.getActionCommand())) {
            
            Integer id = Integer.parseInt(cbPesquisar.getSelectedItem().toString().trim());
            Contato c = DbOperations.findRecordById(id);

            if (c == null)
                JOptionPane.showMessageDialog(null, "Contato nao cadastrado...");

            else {
                JOptionPane.showMessageDialog(null, "Contato editado!");

                DbOperations.updateRecord(c.getId(), c.getName(), c.getEndereco(), c.getTelefone());
                this.limpaTela();
            }
        } else
        
        // Condicional Delete - se clicar no botão buscar ...       
        if (e.getActionCommand().equals(this.btnExcluir.getActionCommand())) {

            Integer id = Integer.parseInt(cbPesquisar.getSelectedItem().toString().trim());
            Contato cbusca = DbOperations.findRecordById(id);

            if (cbusca == null)
                JOptionPane.showMessageDialog(null, "Contato nao encontrado");

            else {
                JOptionPane.showMessageDialog(null, "Contato " + id + " excluido!");

                DbOperations.deleteRecord(id);
                this.carregaContatonaTela(cbusca);
                this.limpaTela();
            }
        }        
    }

    public static void main(String[] args) {
		UserInterface interface = new UserInterface();
		interface.setVisible(true);
	}
}