package Interface;
import PerfisTweet.Perfil;
import Exceçoes.UJCException;
import Exceçoes.UNCException;

//criação da interface 
public interface IRepositorioUsuario{

  //cadastrar perfil, com execeção UJC 
  public void cadastrar(Perfil usuario) throws UJCException; 
  
  //procurar perfil, sem nenhuma exceção especificada
  public Perfil buscar(String usuario);

  //atualizar perfil, com exceção UNC
  public void atualizar(Perfil usuario) throws UNCException;


}
