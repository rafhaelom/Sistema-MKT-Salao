import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame {
    private List<Dados_mkt_salao> lstDE = new ArrayList<>();
    private ManipulaDados md = new ManipulaDados();
    private JLabel lb_im;
    public Menu() {
        super("Cadastro de Cliente"); // Titulo barra.
        this.setSize(300, 300); // Tamanho Janela.
        
        // Menu de barras.
        JMenu aba1 = new JMenu("Cliente");
        JMenuItem aba1_item1 = new JMenuItem("Cadastrar");
        JMenuItem aba1_item2 = new JMenuItem("Alterar");
        JMenuItem aba1_item3 = new JMenuItem("Excluir");
        aba1_item1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                aoAcionar();
            }
        });
        
        JMenu aba2 = new JMenu("Listar");
        JMenuItem aba2_item1 = new JMenuItem("Todos");
        JMenuItem aba2_item2 = new JMenuItem("Pesquisar");
        aba2_item1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                aoLer();
            }
        });
        
        JMenu aba3 = new JMenu("Sair");
        aba3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                aoSair();
            }
        });
        
        ImageIcon imagem = new ImageIcon("logo.png");   //Definindo objeto e caminho da imagem.
                                          //Dimensões:   altura, largura, sinalizador para reamostragem da imagem.                                  
        imagem.setImage(imagem.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));  //Definindo tamanho da imagem.
        lb_im = new JLabel(imagem);
        lb_im.setHorizontalTextPosition( SwingConstants.CENTER );
        
        JMenuBar jmb = new JMenuBar();
        
        // Adicionando na janela.
        aba1.add(aba1_item1);
        aba1.add(aba1_item2);
        aba1.add(aba1_item3);
        aba2.add(aba2_item1);
        aba2.add(aba2_item2);
        
        jmb.add(aba1);
        jmb.add(aba2);
        jmb.add(aba3);
        
        this.setJMenuBar(jmb); // Exibe menu barras.
        this.add(lb_im);
        lstDE = md.lerDados();
        this.setVisible(true); // Exibe a janela.
    }
    
    private void aoAcionar() {
        System.out.println("Acionar Item");
        new Cadastro();
    }
    
    private void aoLer() {
        System.out.println("Listar Todos");
        ManipulaDados le = new ManipulaDados();
        lstDE = le.lerDados();
        for (Dados_mkt_salao de: lstDE) {
            System.out.println(" Cliente: " + de.getNome() + " Email: " + de.getEmail() + " Telefone: " + de.getTelefone() + "Data Nascimento " + de.getData_Nascimento());
        }
    }
    
    private void aoSair() {
        System.out.println("Fechando Janela");
        System.exit(0);
    }
    
    public static void main(String [] args) {
        new Menu().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}