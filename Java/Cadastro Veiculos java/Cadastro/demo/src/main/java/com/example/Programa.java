// Nome: Henderson Dias Matias da Silva RA: 0973/23-1
// Nome: Maysa Francisca de Lima  RA: 0907/23-1

package com.example;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Programa extends JFrame {

    private JButton btnVeiculo, btnPessoa;
    private JanelaVeiculo janelaVeiculo;
    private JanelaPessoa janelaPessoa;
    private ArrayList<Veiculo> veiculos;
    private ArrayList<Pessoa> pessoas;

    public Programa() {
        btnVeiculo = new JButton("Cadastro de Veículo");
        btnPessoa = new JButton("Cadastro de Pessoa");
        janelaVeiculo = new JanelaVeiculo(this);
        janelaPessoa = new JanelaPessoa(this);
        veiculos = new ArrayList<>();
        pessoas = new ArrayList<>();

        lerDados();

        JPanel painel = new JPanel();
        painel.add(btnVeiculo);
        painel.add(btnPessoa);

        btnVeiculo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                janelaVeiculo.setVisible(true);
            }
        });

        btnPessoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                janelaPessoa.setVisible(true);
            }
        });

        this.setTitle("Cadastros");
        this.setSize(400, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(painel);
    }

    public void lerDados() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("dados.txt"));

            String linha = br.readLine();

            while (linha != null) {
                String[] dados = linha.split(";");

                if (dados[0].equals("V")) {
                    Veiculo v = new Veiculo(dados[1], Double.parseDouble(dados[2]), dados[3]);

                    veiculos.add(v);
                } else if (dados[0].equals("P")) {
                    Pessoa p = new Pessoa(dados[1], dados[2], dados[3], dados[4]);

                    pessoas.add(p);
                }

                linha = br.readLine();
            }

            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public void salvarDados() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("dados.txt"));

            for (Veiculo v : veiculos) {
                pw.println("V;" + v.getModelo() + ";" + v.getValor() + ";" + v.getOpcionais());
            }

            for (Pessoa p : pessoas) {
                pw.println("P;" + p.getNome() + ";" + p.getTelefone() + ";" + p.getDataCompra() + ";" + p.getVeiculoComprado());
            }

            pw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }
}

class Veiculo {

    private String modelo;
    private double valor;
    private String opcionais;

    public Veiculo(String modelo, double valor, String opcionais) {
        this.modelo = modelo;
        this.valor = valor;
        this.opcionais = opcionais;
    }

    public String getModelo() {
        return modelo;
    }

    public double getValor() {
        return valor;
    }

    public String getOpcionais() {
        return opcionais;
    }

    public String toString() {
        return modelo + " - R$ " + valor + " - " + opcionais;
    }

    public void setModelo(String modelo2) {
    }

    public void setValor(double valor2) {
    }

    public void setOpcionais(String opcionais2) {
    }
}

class Pessoa {

    private String nome;
    private String telefone;
    private String dataCompra;
    private String veiculoComprado;

    public Pessoa(String nome, String telefone, String dataCompra, String veiculoComprado) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataCompra = dataCompra;
        this.veiculoComprado = veiculoComprado;
    }

    public String getModelo() {
        return veiculoComprado;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public String getVeiculoComprado() {
        return veiculoComprado;
    }

    public String toString() {
        return nome + " - " + telefone + " - " + dataCompra + " - " + veiculoComprado;
    }

    public void setNome(String nome2) {
    }

    public void setTelefone(String telefone2) {
    }

    public void setDataCompra(String dataCompra2) {
    }

    public void setVeiculoComprado(String string) {
    }
}

class JanelaVeiculo extends JDialog {

    private JTextField txtModelo, txtValor, txtOpcionais;
    private JButton btnIncluir, btnAlterar, btnExcluir, btnFechar;
    private JList<Veiculo> lstVeiculos;
    private DefaultListModel<Veiculo> modeloLista;
    private Programa programa;

    public JanelaVeiculo(Programa programa) {
        this.programa = programa;

        txtModelo = new JTextField(20);
        txtValor = new JTextField(10);
        txtOpcionais = new JTextField(30);
        btnIncluir = new JButton("Incluir");
        btnAlterar = new JButton("Alterar");
        btnExcluir = new JButton("Excluir");
        btnFechar = new JButton("Fechar");
        modeloLista = new DefaultListModel<>();
        lstVeiculos = new JList<>(modeloLista);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 2, 5, 5));
        painel.add(new JLabel("Modelo:"));
        painel.add(txtModelo);
        painel.add(new JLabel("Valor:"));
        painel.add(txtValor);
        painel.add(new JLabel("Opcionais:"));
        painel.add(txtOpcionais);
        painel.add(btnIncluir);
        painel.add(btnAlterar);
        painel.add(btnExcluir);
        painel.add(btnFechar);

        btnIncluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                incluirVeiculo();
            }
        });

        btnAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                alterarVeiculo();
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                excluirVeiculo();
            }
        });

        btnFechar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fecharJanela(); } 
            });
    lstVeiculos.addListSelectionListener(new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent e) {
            preencherCampos();
        }
    });

    this.setTitle("Cadastro de Veículo");
    this.setSize(500, 300);
    this.setModal(true);
    this.setLocationRelativeTo(null);
    this.setLayout(new BorderLayout());
    this.add(painel, BorderLayout.NORTH);
    this.add(new JScrollPane(lstVeiculos), BorderLayout.CENTER);
}

public void incluirVeiculo() {
    try {
        String modelo = txtModelo.getText();
        double valor = Double.parseDouble(txtValor.getText());
        String opcionais = txtOpcionais.getText();

        if (modelo.isEmpty() || valor <= 0) {
            JOptionPane.showMessageDialog(this, "Dados inválidos!");
            return;
        }

        Veiculo v = new Veiculo(modelo, valor, opcionais);

        programa.getVeiculos().add(v);

        modeloLista.addElement(v);

        programa.salvarDados();

        JOptionPane.showMessageDialog(this, "Veículo incluído com sucesso!");

        limparCampos();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Valor inválido!");
    }
}

public void alterarVeiculo() {
    try {
        int indice = lstVeiculos.getSelectedIndex();

        if (indice == -1) {
            JOptionPane.showMessageDialog(this, "Nenhum veículo selecionado!");
            return;
        }

        String modelo = txtModelo.getText();
        double valor = Double.parseDouble(txtValor.getText());
        String opcionais = txtOpcionais.getText();

        if (modelo.isEmpty() || valor <= 0) {
            JOptionPane.showMessageDialog(this, "Dados inválidos!");
            return;
        }

        Veiculo v = modeloLista.getElementAt(indice);

        v.setModelo(modelo);
        v.setValor(valor);
        v.setOpcionais(opcionais);

        modeloLista.setElementAt(v, indice);

        programa.salvarDados();

        JOptionPane.showMessageDialog(this, "Veículo alterado com sucesso!");

        limparCampos();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Valor inválido!");
    }
}

public void excluirVeiculo() {
    int indice = lstVeiculos.getSelectedIndex();

    // Valida o índice
    if (indice == -1) {
        JOptionPane.showMessageDialog(this, "Nenhum veículo selecionado!");
        return;
    }

    Veiculo v = modeloLista.getElementAt(indice);

    int opcao = JOptionPane.showConfirmDialog(this, "Deseja excluir o veículo " + v + "?");

    if (opcao == JOptionPane.YES_OPTION) {
        programa.getVeiculos().remove(v);

        modeloLista.removeElementAt(indice);

        programa.salvarDados();

        JOptionPane.showMessageDialog(this, "Veículo excluído com sucesso!");

        limparCampos();
    }
}

public void fecharJanela() {
    this.dispose();
}

public void preencherCampos() {
    int indice = lstVeiculos.getSelectedIndex();

    if (indice != -1) {
        Veiculo v = modeloLista.getElementAt(indice);

        txtModelo.setText(v.getModelo());
        txtValor.setText(String.valueOf(v.getValor()));
        txtOpcionais.setText(v.getOpcionais());
    }
}


public void limparCampos() {
    txtModelo.setText("");
    txtValor.setText("");
    txtOpcionais.setText("");
}

public void atualizarLista() {
    modeloLista.clear();

    for (Veiculo v : programa.getVeiculos()) {
        modeloLista.addElement(v);
    }
}
}
class JanelaPessoa extends JDialog { 

private JTextField txtNome, txtTelefone, txtDataCompra;
private JComboBox<Veiculo> cmbVeiculoComprado;
private JButton btnIncluir, btnAlterar, btnExcluir, btnFechar;
private JList<Pessoa> lstPessoas;
private DefaultListModel<Pessoa> modeloLista;
private Programa programa;

public JanelaPessoa(Programa programa) {
    this.programa = programa;

    txtNome = new JTextField(20);
    txtTelefone = new JTextField(10);
    txtDataCompra = new JTextField(10);
    cmbVeiculoComprado = new JComboBox<>();
    btnIncluir = new JButton("Incluir");
    btnAlterar = new JButton("Alterar");
    btnExcluir = new JButton("Excluir");
    btnFechar = new JButton("Fechar");
    modeloLista = new DefaultListModel<>();
    lstPessoas = new JList<>(modeloLista);

    JPanel painel = new JPanel();
    painel.setLayout(new GridLayout(5, 2, 5, 5));
    painel.add(new JLabel("Nome:"));
    painel.add(txtNome);
    painel.add(new JLabel("Telefone:"));
    painel.add(txtTelefone);
    painel.add(new JLabel("Data da compra:"));
    painel.add(txtDataCompra);
    painel.add(new JLabel("Veículo comprado:"));
    painel.add(cmbVeiculoComprado);
    painel.add(btnIncluir);
    painel.add(btnAlterar);
    painel.add(btnExcluir);
    painel.add(btnFechar);

    btnIncluir.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            incluirPessoa();
        }
    });

    btnAlterar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            alterarPessoa();
        }
    });

    btnExcluir.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            excluirPessoa();
        }
    });

    btnFechar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            fecharJanela();
        }
    });

    lstPessoas.addListSelectionListener(new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent e) {
            preencherCampos();
        }
    });

    this.setTitle("Cadastro de Pessoa");
    this.setSize(500, 300);
    this.setModal(true);
    this.setLocationRelativeTo(null);
    this.setLayout(new BorderLayout());
    this.add(painel, BorderLayout.NORTH);
this.add(new JScrollPane(lstPessoas), BorderLayout.CENTER); 
}

public void incluirPessoa() {
    try {
        String nome = txtNome.getText();
        String telefone = txtTelefone.getText();
        String dataCompra = txtDataCompra.getText();
        Veiculo veiculoComprado = (Veiculo) cmbVeiculoComprado.getSelectedItem();

        if (nome.isEmpty() || telefone.isEmpty() || dataCompra.isEmpty() || veiculoComprado == null) {
            JOptionPane.showMessageDialog(this, "Dados inválidos!");
            return;
        }

        Pessoa p = new Pessoa(nome, telefone, dataCompra, veiculoComprado.toString());

        programa.getPessoas().add(p);

        modeloLista.addElement(p);

        programa.salvarDados();
        JOptionPane.showMessageDialog(this, "Pessoa incluída com sucesso!");

        limparCampos();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao incluir pessoa: " + e.getMessage());
    }
}

public void alterarPessoa() {
    try {
        int indice = lstPessoas.getSelectedIndex();

        if (indice == -1) {
            JOptionPane.showMessageDialog(this, "Nenhuma pessoa selecionada!");
            return;
        }

        String nome = txtNome.getText();
        String telefone = txtTelefone.getText();
        String dataCompra = txtDataCompra.getText();
        Veiculo veiculoComprado = (Veiculo) cmbVeiculoComprado.getSelectedItem();

        if (nome.isEmpty() || telefone.isEmpty() || dataCompra.isEmpty() || veiculoComprado == null) {
            JOptionPane.showMessageDialog(this, "Dados inválidos!");
            return;
        }

        Pessoa p = modeloLista.getElementAt(indice);

        p.setNome(nome);
        p.setTelefone(telefone);
        p.setDataCompra(dataCompra);
        p.setVeiculoComprado(veiculoComprado.toString());

        modeloLista.setElementAt(p, indice);

        programa.salvarDados();

        JOptionPane.showMessageDialog(this, "Pessoa alterada com sucesso!");

        limparCampos();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao alterar pessoa: " + e.getMessage());
    }
}

public void excluirPessoa() {
    int indice = lstPessoas.getSelectedIndex();

    // Valida o índice
    if (indice == -1) {
        JOptionPane.showMessageDialog(this, "Nenhuma pessoa selecionada!");
        return;
    }

    Pessoa p = modeloLista.getElementAt(indice);

    int opcao = JOptionPane.showConfirmDialog(this, "Deseja excluir a pessoa " + p + "?");

    if (opcao == JOptionPane.YES_OPTION) {
        programa.getPessoas().remove(p);

        modeloLista.removeElementAt(indice);

        programa.salvarDados();

        JOptionPane.showMessageDialog(this, "Pessoa excluída com sucesso!");

        limparCampos();
    }
}


public void fecharJanela() {
    this.dispose();
}

public void preencherCampos() {
    int indice = lstPessoas.getSelectedIndex();

    if (indice != -1) {
        // Obtém a pessoa selecionada na lista
        Pessoa p = modeloLista.getElementAt(indice);

        txtNome.setText(p.getNome());
        txtTelefone.setText(p.getTelefone());
        txtDataCompra.setText(p.getDataCompra());
        cmbVeiculoComprado.setSelectedItem(buscarVeiculo(p.getVeiculoComprado()));
    }
}

public void limparCampos() {
    txtNome.setText("");
    txtTelefone.setText("");
    txtDataCompra.setText("");
    cmbVeiculoComprado.setSelectedIndex(-1);
}

public void atualizarLista() {
    modeloLista.clear();

    for (Pessoa p : programa.getPessoas()) {
        modeloLista.addElement(p);
    }
}

public void atualizarComboBox() {
    cmbVeiculoComprado.removeAllItems();
   
    for (Veiculo v : programa.getVeiculos()) {
        cmbVeiculoComprado.addItem(v);
    }
}

public Veiculo buscarVeiculo(String modelo) {
    for (Veiculo v : programa.getVeiculos()) {
        if (v.getModelo().equals(modelo)) {
            return v;
        }
    }
    return null;
}
}