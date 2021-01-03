import java.util.Date;

// Classe para Atributos e Metodos GET/SET.
// Classe implements Interface.
public class Dados_mkt_salao implements mkt_salao{
    // Atributos Particulares. 
    // private <tipo> e <nomeDoAtributo>;
    private String login;
    private String senha;
    private String nome;
    private String email;
    private String telefone;
    private Date data_nascimento;
    
    // Login.
    public String getLogin(){
        return login;
    }
    public void setLogin(String login){
        this.login = login;
    }
    
    // Senha.
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    // Nome.
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    // Email.
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    // Telefone.
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    // Data_Nascimento.
    public Date getData_Nascimento(){
        return data_nascimento;
    }
    public void setData_Nascimento(Date data_nascimento){
        this.data_nascimento = data_nascimento;
    }
}