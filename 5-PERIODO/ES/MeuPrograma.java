// package com.jcg.hibernate.crud.operations;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MeuPrograma extends JFrame {
    private JButton botao1;
    private JButton botao2;
    private JButton botao3;
    private JButton botao4;

    public MeuPrograma() {

        setSize(getPreferredSize());
        botao1 = new JButton("Criar contatos");
        botao2 = new JButton("Ler contatos");
        botao3 = new JButton("Atualizar contato");
        botao4 = new JButton("Deletar contato");

        final JList<Object> lista = new JList<Object>();
        final JScrollPane scrollPane = new JScrollPane(lista);

        scrollPane.setPreferredSize(getMaximumSize()); // Define o tamanho do JScrollPane

        // Define um layout de grade com uma linha e duas colunas
        setLayout(new GridLayout(2, 1));

        // Define o tamanho da janela
        setSize(500, 500);

        // Define o comportamento de fechar a janela ao clicar no botão de fechar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        botao1.addActionListener(new ActionListener() {

            JTextField textNome = new JTextField("Nome");
            JTextField textEndereco = new JTextField("Endereco");
            JTextField textTelefone = new JTextField("Telefone");
            JButton criar = new JButton("Criar");

            public void actionPerformed(ActionEvent e) {
                add(textNome);
                add(textEndereco);
                add(textTelefone);

                add(criar);

                criar.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        DbOperations.createRecord(textNome.getText(), textEndereco.getText(), textTelefone.getText());
                    }

                });
            }
        });

        // Adiciona um listener para o botão
        botao2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                add(scrollPane, BorderLayout.CENTER);
                ArrayList<Object> opcoes = new ArrayList<Object>();
                for (Contato item : DbOperations.displayRecords()) {
                    opcoes.add(
                            "     " + item.getId() + "     " + item.getName() + "     " + item.getEndereco() + "     "
                                    + item.getTelefone());
                }

                lista.setListData(opcoes.toArray(new Object[0]));
                lista.getAlignmentX();
            }

        });

        // botao3.addActionListener(new ActionListener() {
        // TextArea textId = new TextArea();
        // TextArea textNome = new TextArea();
        // TextArea textEndereco = new TextArea();
        // TextArea textTelefone = new TextArea();

        // public void actionPerformed(ActionEvent e) {
        // Contato contatoObj = new Contato();
        // // try {

        // // } catch() {

        // // }
        // }

        // });

        add(botao1, BorderLayout.NORTH);
        add(botao2, BorderLayout.NORTH);
        add(botao3, BorderLayout.NORTH);
        add(botao4, BorderLayout.NORTH);

        // Exibe a janela
        setVisible(true);
    }
}