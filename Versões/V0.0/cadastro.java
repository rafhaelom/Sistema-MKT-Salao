import java.util.Scanner;
import java.lang.String;

public class cadastro {
    
    private Scanner sc = new Scanner(System.in);
    
    public void cad(){
        System.out.println("Digite seu primeiro nome: ");
        String nome = sc.next();
        System.out.println("\nDigite seu e-mail: ");
        String email = sc.next();
        System.out.println("\nDigite seu telefone: ");
        String telefone = sc.next();
        System.out.println("\nData de nascimento: ");
        String data_nasc = sc.next();
        
        System.out.println("\nCadastro realizado com sucesso !!!");
        
        System.out.println("\n Primeiro Nome: " + nome);
        System.out.println("\n E-mail: " + email);
        System.out.println("\n Telefone: " + telefone);
        System.out.println("\n Data Nascimento: " + data_nasc);
    }
    
    public static void main(String [] args){
        cadastro cadastro1 = new cadastro();
        cadastro1.cad();
    }
}