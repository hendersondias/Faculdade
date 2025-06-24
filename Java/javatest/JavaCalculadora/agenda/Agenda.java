import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Agenda extends JFrame implements ActionListener {

    // Constante que define o tamanho máximo do array
    public static final int TAMANHO = 10;

    // Array que armazena os nomes dos contatos
    private String[] nomes = new String[TAMANHO];

    // Array que armazena os telefones dos contatos
    private String[] telefones = new String[TAMANHO];

    // Variável que controla o número de contatos inseridos
    private int contador = 0;

    // Componentes da interface gráfica
    private JMenuBar menuBar;
    private JMenu menuArquivo, menuAjuda;
    private JMenuItem menuItemCadastrar, menuItemConsultar, menuItemExcluir, menuItemSair, menuItemSobre;
    private JPanel painelCadastrar, painelConsultar, painelExcluir, painelSobre;
    private JLabel labelNome, labelTelefone, labelConsulta, labelExcluir;
    private JTextField campoNome, campoTelefone, campoConsulta, campoExcluir;
    private JButton botaoCadastrar, botaoConsultar, botaoExcluir;
    private JTable tabelaContatos;
    private JScrollPane scrollTabela;

    // Construtor da classe
    public Agenda() {
        // Define o título da janela
        super("Agenda Telefônica");

        // Define o layout da janela como nulo
        setLayout(null);

        // Cria os componentes da interface gráfica
        menuBar = new JMenuBar();
        menuArquivo = new JMenu("Arquivo");
        menuAjuda = new JMenu("Ajuda");
        menuItemCadastrar = new JMenuItem("Cadastrar");
        menuItemConsultar = new JMenuItem("Consultar");
        menuItemExcluir = new JMenuItem("Excluir");
        menuItemSair = new JMenuItem("Sair");
        menuItemSobre = new JMenuItem("Sobre");
        painelCadastrar = new JPanel(null);
        painelConsultar = new JPanel(null);
        painelExcluir = new JPanel(null);
        painelSobre = new JPanel(null);
        labelNome = new JLabel("Nome:");
        labelTelefone = new JLabel("Telefone:");
        labelConsulta = new JLabel("Nome:");
        labelExcluir = new JLabel("Nome:");
        campoNome = new JTextField();
        campoTelefone = new JTextField();
        campoConsulta = new JTextField();
        campoExcluir = new JTextField();
        botaoCadastrar = new JButton("Cadastrar");
        botaoConsultar = new JButton("Consultar");
        botaoExcluir = new JButton("Excluir");
        tabelaContatos = new JTable();
        scrollTabela = new JScrollPane(tabelaContatos);

        // Define as posições e tamanhos dos componentes
        menuBar.setBounds(0, 0, 400, 20);
        menuArquivo.setBounds(0, 0, 100, 20);
        menuAjuda.setBounds(100, 0, 100, 20);
        menuItemCadastrar.setBounds(0, 0, 100, 20);
        menuItemConsultar.setBounds(0, 20, 100, 20);
        menuItemExcluir.setBounds(0, 40, 100, 20);
        menuItemSair.setBounds(0, 60, 100, 20);
        menuItemSobre.setBounds(0, 0, 100, 20);
        painelCadastrar.setBounds(0, 20, 400, 280);
        painelConsultar.setBounds(0, 20, 400, 280);
        painelExcluir.setBounds(0, 20, 400, 280);
        painelSobre.setBounds(0, 20, 400, 280);
        labelNome.setBounds(10, 10, 100, 20);
        campoNome.setBounds(120, 10, 200, 20);
        labelTelefone.setBounds(10, 40, 100, 20);
        campoTelefone.setBounds(120, 40, 200, 20);
        botaoCadastrar.setBounds(10, 70, 100, 20);
        labelConsulta.setBounds(10, 10, 100, 20);
        campoConsulta.setBounds(120, 10, 200, 20);
        botaoConsultar.setBounds(10, 40, 100, 20);
        scrollTabela.setBounds(10, 70, 380, 200);
        labelExcluir.setBounds(10, 10, 100, 20);
        campoExcluir.setBounds(120, 10, 200, 20);
        botaoExcluir.setBounds(10, 40, 100, 20);

        // Adiciona os componentes à janela
        add(menuBar);
        menuBar.add(menuArquivo);
        menuBar.add(menuAjuda);
        menuArquivo.add(menuItemCadastrar);
        menuArquivo.add(menuItemConsultar);
        menuArquivo.add(menuItemExcluir);
        menuArquivo.add(menuItemSair);
        menuAjuda.add(menuItemSobre);
        add(painelCadastrar);
        painelCadastrar.add(labelNome);
        painelCadastrar.add(campoNome);
        painelCadastrar.add(labelTelefone);
        painelCadastrar.add(campoTelefone);
        painelCadastrar.add(botaoCadastrar);
        add(painelConsultar);
        painelConsultar.add(labelConsulta);
        painelConsultar.add(campoConsulta);
        painelConsultar.add(botaoConsultar);
        painelConsultar.add(scrollTabela);
        add(painelExcluir);
        painelExcluir.add(labelExcluir);
        painelExcluir.add(campoExcluir);
        painelExcluir.add(botaoExcluir);
        add(painelSobre);

        // Adiciona os listeners aos itens de menu e botões
        menuItemCadastrar.addActionListener(this);
        menuItemConsultar.addActionListener(this);
        menuItemExcluir.addActionListener(this);
        menuItemSair.addActionListener(this);
        menuItemSobre.addActionListener(this);
        botaoCadastrar.addActionListener(this);
        botaoConsultar.addActionListener(this);
        botaoExcluir.addActionListener(this);

        // Define o tamanho e a posição da janela
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Define que a janela pode ser fechada
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Define que a janela é visível
        setVisible(true);

        // Define que o painel cadastrar é o inicial
        painelCadastrar.setVisible(true);
        painelConsultar.setVisible(false);
        painelExcluir.setVisible(false);
        painelSobre.setVisible(false);
    }

    // Método que trata os eventos dos itens de menu e botões
    public void actionPerformed(ActionEvent e) {
        // Se o item de menu Cadastrar foi clicado
        if (e.getSource() == menuItemCadastrar) {
            // Mostra o painel cadastrar e esconde os outros
            painelCadastrar.setVisible(true);
            painelConsultar.setVisible(false);
            painelExcluir.setVisible(false);
            painelSobre.setVisible(false);
        }

        // Se o item de menu Consultar foi clicado
        if (e.getSource() == menuItemConsultar) {
            // Mostra o painel consultar e esconde os outros
            painelCadastrar.setVisible(false);
            painelConsultar.setVisible(true);
            painelExcluir.setVisible(false);
            painelSobre.setVisible(false);
        }

        // Se o item de menu Excluir foi clicado
        if (e.getSource() == menuItemExcluir) {
            // Mostra o painel excluir e esconde os outros
            painelCadastrar.setVisible(false);
            painelConsultar.setVisible(false);
            painelExcluir.setVisible(true);
            painelSobre.setVisible(false);
        }

        // Se o item de menu Sair foi clicado
        if (e.getSource() == menuItemSair) {
            // Fecha o programa
            System.exit(0);
        }

        // Se o item de menu Sobre foi clicado
        if (e.getSource() == menuItemSobre) {
            // Mostra o painel sobre e esconde os outros
            painelCadastrar.setVisible(false);
            painelConsultar.setVisible(false);
            painelExcluir.setVisible(false);
            painelSobre.setVisible(true);

            // Mostra as informações do projeto
            JLabel labelSobre = new JLabel("<html><center>Agenda Telefônica<br>Data de criação: 12/11/2023<br>Desenvolvedor: Bing</center></html>");
            labelSobre.setBounds(10, 10, 380, 260);
            painelSobre.add(labelSobre);
        }

       // Se o botão Cadastrar foi clicado
if (e.getSource() == botaoCadastrar) {
    // Obtém os dados dos campos de texto
    String nome = campoNome.getText();
    String telefone = campoTelefone.getText();

    // Verifica se os campos não estão vazios
    if (!nome.isEmpty() && !telefone.isEmpty()) {
        // Verifica se o array ainda tem espaço
        if (contador < TAMANHO) {
            // Insere os dados nos arrays
            nomes[contador] = nome;
            telefones[contador] = telefone;

            // Incrementa o contador
            contador++;

             // Mostra uma mensagem de sucesso
            JOptionPane.showMessageDialog(this, "Contato inserido com sucesso!");

            // Limpa os campos de texto
            campoNome.setText("");
            campoTelefone.setText("");
        } else {
            // Mostra uma mensagem de erro
            JOptionPane.showMessageDialog(this, "A agenda está cheia!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        // Mostra uma mensagem de erro
        JOptionPane.showMessageDialog(this, "Preencha os campos nome e telefone!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
