package com.jcg.hibernate.crud.operations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class InterfaceUsuario extends JFrame implements ActionListener {
    private JTextField campoNome;
    private JTextField campoTelefone;
    private JTextField campoEndereco;
    private JTextField campoExcluir;
    private JButton botaoSalvar;
    private JButton botaoLer;
    private JButton botaoDelete;
    private JButton botaoEditar;
    private JTextArea texto = new JTextArea("Para usar o delete, preencha somente o ID desejado e clique no Deletar");
    private JTextArea texto1 = new JTextArea(
            "Para usar o editar, preencha todos os campos que deseja mudar e coloque o ID desejado e clique no Editar");

    public InterfaceUsuario() {
        super("Formulário de Cadastro");

        // Cria os campos de texto para nome, telefone e endereço
        campoNome = new JTextField(20);
        campoTelefone = new JTextField(20);
        campoEndereco = new JTextField(20);
        campoExcluir = new JTextField(20);

        // Cria um botão para salvar os dados
        botaoSalvar = new JButton("Salvar");
        botaoLer = new JButton("Ler");
        botaoLer.addActionListener(this);
        botaoSalvar.addActionListener(this);
        botaoEditar = new JButton("Editar");
        botaoDelete = new JButton("Deletar");
        botaoDelete.addActionListener(this);
        botaoEditar.addActionListener(this);

        // Cria o painel e adiciona os campos de texto e o botão
        JPanel painel = new JPanel(new GridLayout(8, 4));
        painel.add(new JLabel("Nome:"));
        painel.add(campoNome);
        painel.add(new JLabel("Telefone:"));
        painel.add(campoTelefone);
        painel.add(new JLabel("Endereço:"));
        painel.add(campoEndereco);
        painel.add(new JLabel("(ID):"));
        painel.add(campoExcluir);
        painel.add(botaoSalvar);
        painel.add(botaoLer);
        painel.add(botaoDelete);
        painel.add(botaoEditar);
        painel.add(texto);
        painel.add(texto1);

        // Adiciona o painel à janela principal
        getContentPane().add(painel);

        // Configura a janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Ao clicar no botão, atribui os valores dos campos a 3 variáveis
        String nome = campoNome.getText();
        String telefone = campoTelefone.getText();
        String endereco = campoEndereco.getText();
        String ExcluirID = campoExcluir.getText();
        // Exibe os valores das variáveis no console
        if (e.getSource() == botaoLer) {

            JFrame novaJanela = new JFrame("Lista de Contatos");

            // Cria um novo painel para a lista de contatos
            JPanel novoPainel = new JPanel(new BorderLayout());
            novaJanela.getContentPane().add(novoPainel);

            // Cria um modelo de lista para exibir os dados do banco de dados
            DefaultListModel<Contato> modeloLista = new DefaultListModel();

            // Obtém a lista de contatos do banco de dados
            List<Contato> viewContatos = DbOperations.displayRecords();
            if (viewContatos != null && viewContatos.size() > 0) {
                // Adiciona cada contato ao modelo de lista
                for (Contato contatoObj : viewContatos) {
                    modeloLista.addElement(contatoObj);
                }
            }

            // Cria uma nova lista de contatos usando o modelo de lista
            JList<Contato> listaContatos = new JList(modeloLista);
            listaContatos.setCellRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                        boolean isSelected, boolean cellHasFocus) {
                    JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected,
                            cellHasFocus);
                    // Define o tamanho do padding do item
                    label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                    return label;
                }
            });

            // Adiciona a lista de contatos ao novo painel
            novoPainel.add(listaContatos, BorderLayout.CENTER);
            // Configura a nova janela e a torna visível

            novaJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            novaJanela.setSize(800, 500);
            novaJanela.setLocationRelativeTo(null);
            novaJanela.setVisible(true);
        }

        else if (e.getSource() == botaoSalvar) {
            DbOperations.createRecord(nome, telefone, endereco);

        } else if (e.getSource() == botaoDelete) {
            DbOperations.deleteRecord(Integer.parseInt(ExcluirID));
        } else if (e.getSource() == botaoEditar) {
            DbOperations.updateRecord(Integer.parseInt(ExcluirID), endereco, nome);
        }

    }

    public static void main(String[] args) {
        new InterfaceUsuario();
    }

}