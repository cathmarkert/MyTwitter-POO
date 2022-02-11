package Interface;
import PerfisTweet.Perfil;
import PerfisTweet.Tweet;
import Exceçoes.*;
import java.util.Vector;

//configurando a interface 
public interface ITwitter{
  //criando o Perfil com exceção PE
  public void criarPerfil(Perfil usuario) throws PEException;

  //cancelando o perfil com exceções PI e PD
  public void cancelarPerfil(String usuario) throws PIException, PDException;

  //configurando o tweet com exceções PI e MFP
  public void tweetar(String usuario, String mensagem) throws PIException, MFPException;

  //configurando a timeline com exceções PI e PD
  public Vector<Tweet> timeline(String usuario) throws PIException, PDException;

  //configurando os tweets com exceções PI e PD
  public Vector<Tweet> tweets(String usuario) throws PIException, PDException;

  //configurando a função seguir com exceções PI, PD e SI
  public void seguir(String seguidor, String seguido) throws PIException, PDException, SIException;

  //configurando o número de seguidores com exceções PI e PD
  public int numeroSeguidores(String usuario) throws PIException, PDException;

  //recuperando os seguidores do perfil com exceções PI e PD
  public Vector<Perfil> seguidores(String usuario) throws PIException, PDException;

  //recuperando os seguidos do perfil com exceções PI e PD 
  public Vector<Perfil> seguidos(String usuario) throws PIException, PDException;


}