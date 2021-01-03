import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import java.io.*;

public class ManipulaDados {

    public void gravarDados(List<Dados_mkt_salao> lst) {
        try {
            System.out.println("Gravando os Dados");
            ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("dadosmktsalao.arq"));
            for (Dados_mkt_salao de : lst) {
                oos.writeObject(de);
            }
            oos.flush();
            oos.close();
        } catch (IOException e) {
            System.out.println("Erro G: " + e.getMessage());
        }
    }
    
    public List<Dados_mkt_salao> lerDados() {
        List<Dados_mkt_salao> lst = new ArrayList<>();
        System.out.println("Retornando os Dados");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(
                new FileInputStream("dadosmktsalao.arq"));
            Object obj;
            do {
                obj = ois.readObject();
                Dados_mkt_salao de = (Dados_mkt_salao)obj;
                lst.add(de);
            } while (true);
        } catch (ClassNotFoundException e) {
            System.out.println("Erro CF: " + e.getMessage());
        } catch (EOFException e) {
            try { ois.close(); } catch (IOException e1) { }
        } catch (IOException e) {
            System.out.println("Erro G: " + e.getMessage());
        }
        return lst;
    }

}
