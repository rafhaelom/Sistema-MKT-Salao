import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Inicio extends JFrame{
    
    private JButton bt;
    private JPanel pn;
    private JLabel lb_im;
    
    public Inicio(){
        super("Inicio"); //Titulo Janela.
        this.setSize(300, 300); //Tamanho da Janela.
        
        ImageIcon imagem = new ImageIcon("logo.png");   //Definindo objeto e caminho da imagem.
                                          //Dimensões:   altura, largura, sinalizador para reamostragem da imagem.                                  
        imagem.setImage(imagem.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));  //Definindo tamanho da imagem.
        lb_im = new JLabel(imagem);
        lb_im.setHorizontalTextPosition( SwingConstants.CENTER );
        
        JButton bt = new JButton("Começar");
        bt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                aoComecar();
            }
        });
        
        this.add(lb_im);
        this.add(bt, BorderLayout.SOUTH);   //Layout.
        this.setVisible(true);  //Exibe a Janela.
    }
    
    private void aoComecar(){
        System.out.println("Começando");
        new Menu();
    }
    
    public static void main(String [] args){
        new Inicio().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
