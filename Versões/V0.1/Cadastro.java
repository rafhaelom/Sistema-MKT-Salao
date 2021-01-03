import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.*; // Caminho de Pesquisa
import java.awt.*;
import java.awt.event.*;

public class Cadastro extends JDialog {
    
    private JTextField nome = new JTextField("",20);
    private JTextField email = new JTextField("",15);
    private JTextField telefone = new JTextField("",13);
    private JTextField data_nascimento = new JTextField("",20);
    
    private ManipulaDados md = new ManipulaDados();
    private List<Dados_mkt_salao> lstDE = new ArrayList<>();
    
    public Cadastro(){
        this.setSize(450,350);
        this.setModal(true);
        
        montarTelaCentral();
        
        JPanel pnBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btSalvar = new JButton("Salvar");
        btSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aoGravar();
            }
        });
        
        pnBotoes.add(btSalvar);
        
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                aoFechar();
            }
        }); 
        
        this.add(pnBotoes, BorderLayout.SOUTH);
        lstDE = md.lerDados();
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void montarTelaCentral() {
        // Criar um painel - FlowLayout   
        JPanel pn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pn1.add(new JLabel("Nome:"));
        pn1.add(nome);
        pn1.add(new JLabel("Exemplo: Nome e Sobrenome."));
        
        JPanel pn2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pn2.add(new JLabel("Email:"));
        pn2.add(email);
        pn2.add(new JLabel("Exemplo: aaaaaa@bbbb.com"));
        
        JPanel pn3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pn3.add(new JLabel("Telefone:"));
        pn3.add(telefone);
        pn3.add(new JLabel("Exemplo: 00-112345678"));

        JPanel pn4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pn4.add(new JLabel("Data:"));
        pn4.add(data_nascimento);
        pn4.add(new JLabel("Exemplo: DD/MM/AAAA."));
        
        JPanel pn = new JPanel();
        pn.setLayout(new GridLayout(4,1,5,5));
        pn.add(pn1); // 1ª Linha
        pn.add(pn2); // 2ª Linha
        pn.add(pn3); // 3ª Linha
        pn.add(pn4); // 4ª Linha

        this.add(pn);
    }
    
    private void aoGravar() {
        System.out.println("Gravando os dados");
        // Campo 1
        String nom = nome.getText();
        // Campo 2
        String ema = email.getText();
        // Campo 3
        String tel = telefone.getText();
        // Campo 4
        Date data_nasc = stToDate(data_nascimento.getText());
        
        Dados_mkt_salao de = adicionarParaObjeto(nom, ema, tel, data_nasc);
        lstDE.add(de);
    }
    
    public void aoListar() {
        for (Dados_mkt_salao de: lstDE) {
            System.out.println(" Cliente: " + de.getNome() + " Email: " + de.getEmail() + " Telefone: " + de.getTelefone() + "Data Nascimento " + de.getData_Nascimento());
        }
    }
    
    private Dados_mkt_salao adicionarParaObjeto(String nom, String ema, String tel, Date data_nasc) {
        // Criar objeto
        Dados_mkt_salao de = new Dados_mkt_salao();
        de.setNome(nom);
        de.setEmail(ema);
        de.setTelefone(tel);
        de.setData_Nascimento(data_nasc);
        return de;
    }
    
    private Date stToDate(String val) {
        Date datan = new Date();
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            datan = formatter.parse(val);        
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
        return datan;
    }
    
    private void aoFechar() {
        System.out.println("Fechando Janela");
        md.gravarDados(lstDE);
    }
    
    public static void main(String [] args){
        new Cadastro();
    }
}