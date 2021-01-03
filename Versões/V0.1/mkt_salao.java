import java.util.Date;
import java.io.Serializable;

// Interface
public interface mkt_salao extends Serializable{
    String getLogin();
    void setLogin(String login);
    
    String getSenha();
    void setSenha(String senha);
    
    String getNome();
    void setNome(String nome);
    
    String getEmail();
    void setEmail(String email);
    
    String getTelefone();
    void setTelefone(String telefone);
    
    Date getData_Nascimento();
    void setData_Nascimento(Date data_nascimento);
}