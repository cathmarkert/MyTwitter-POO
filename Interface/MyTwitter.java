package Interface;
import PerfisTweet.Perfil;
import PerfisTweet.Tweet;
import Exceçoes.*;
import java.util.Vector; 

public class MyTwitter implements ITwitter{
  private IRepositorioUsuario repositorio;

  //construtor
  public MyTwitter(IRepositorioUsuario repositorio){
    super();
    this.repositorio = repositorio;
  }

  //confere se o usuário não foi cadastrado anterior para criar o perfil. Se ele não existir, pegaremos uma exceção UJC e puxaremos a exceção de "perfil existente" PE.
  @Override
  public void criarPerfil(Perfil usuario) throws PEException{
    try{
      repositorio.cadastrar(usuario);
    }

    catch(UJCException a){
      throw new PEException(usuario.getUsuario());
    }
  }

  //confere se o perfil existe e já foi cancelado anteriormente. Se ele existir e não estiver desativado, ele será cancelado.
  @Override
  public void cancelarPerfil(String usuario) throws PIException, PDException{
      Perfil user = this.repositorio.buscar(usuario);

      if(user != null){
        if(user.isAtivo()){
          user.setAtivo(false);
          System.out.println("Perfil cancelado com sucesso!");
        }

        else throw new PDException(usuario);
      }

   else throw new PIException(usuario);
  }

  //confere se a conta existe, se o tweet possui o valor mínimo ou máximo de caracteres e adiciona o tweet à timeline dos outros seguidores ativos.
  @Override
  public void tweetar(String usuario, String mensagem) throws PIException, MFPException{
    Perfil user = this.repositorio.buscar(usuario);

    if(user != null){
      if(mensagem.length()>0 && mensagem.length()<=140){
        Tweet tweet = new Tweet(usuario,mensagem);
        tweet.setUsuario(usuario);
        tweet.setMensagem(mensagem);
        repositorio.buscar(usuario).addTweet(tweet);

        //adicionando para os outros seguidores ativos
        Vector<String> segs = user.getSeguidores();
        
        for (String seguidor : segs) {
						this.repositorio.buscar(seguidor).addTweet(tweet);
					}

        System.out.println("Tweet feito!");

      }

      else throw new MFPException(mensagem);
    }

    else throw new PIException(usuario);
  }

  //retorna a timeline do usuário, se ele existir e for ativo.
  @Override
  public Vector<Tweet> timeline(String usuario) throws PIException, PDException{
     Perfil user = this.repositorio.buscar(usuario);

     if(user != null){
       if(user.isAtivo()){
         return user.getTimeline();
       }

       else throw new PDException(usuario);
     }

    else throw new PIException(usuario);
  }

  //recupera todos os tweets postados pelo usuário, se ele existir e estiver ativo.
  @Override
  public Vector<Tweet> tweets(String usuario) throws PIException, PDException{
    Perfil user = this.repositorio.buscar(usuario);
    Vector<Tweet> tweetar = new Vector<Tweet>();

    if(user != null){
      if(user.isAtivo()){

        for(Tweet tweet : user.getTimeline()){
          if(tweet.getUsuario().equals(usuario)){
            tweetar.add(tweet);
          }
        }

        return tweetar;
      }

      else throw new PDException(usuario);
    }

    else throw new PIException(usuario);
  }

  //confere se o perfil seguir e seguidor existem, se são ativos e depois faz a alteração dos seguidores/seguindo.
  @Override
  public void seguir(String seguidor, String seguido) throws PIException, PDException, SIException{
  Perfil usuarioseguido = this.repositorio.buscar(seguido);
  Perfil usuarioseguidor = this.repositorio.buscar(seguidor);

    if(usuarioseguido != null && usuarioseguidor != null){
      if(usuarioseguido.isAtivo() && usuarioseguidor.isAtivo()){
        if(usuarioseguido != usuarioseguidor){
          usuarioseguido.addSeguidor(seguidor);
          usuarioseguidor.addSeguido(seguido);

          //adicionando os tweets do usuário à timeline da pessoa seguida.
          for(Tweet tweet : tweets(seguido)){
            usuarioseguidor.addTweet(tweet);
          }

          System.out.println("Seguido/seguindo concluído!");
        }

        else throw new SIException(seguido);

      }

      else {
        if (!usuarioseguido.isAtivo()) {
          throw new PDException(seguido);
        } 

        else {
          throw new PDException(seguidor);
        }
      }

    }

    else {
      if (usuarioseguido == null) {
        throw new PIException(seguido);
      } else {
        throw new PIException(seguidor);
      }
    }
  }
  
  //retorna o número de seguidores do perfil, se ele existir e for ativo.
  @Override
  public int numeroSeguidores(String usuario) throws PIException, PDException{
    Perfil user = this.repositorio.buscar(usuario);

    if(user != null){
      if(user.isAtivo()){
        return user.getSeguidores().size();
      }

      else throw new PDException(usuario);
    }

    else throw new PIException(usuario);
  }

  //retorna o nome dos seguidores do perfil, se ele existir e for ativo.
  @Override
   public Vector<Perfil> seguidores(String usuario) throws PIException, PDException{
    Perfil user = this.repositorio.buscar(usuario);

    if(user != null){
      if(user.isAtivo()){
        Vector<Perfil> seguidores = new Vector<Perfil>();
        for (String seguidor : user.getSeguidores()) {
					seguidores.add(this.repositorio.buscar(seguidor));
				}
				return seguidores;
      }

      else throw new PDException(usuario);
    }

    else throw new PIException(usuario);

   }

  //retorna o nome dos seguidos pelo perfil, se ele existir ou foi ativo.
  @Override
  public Vector<Perfil> seguidos(String usuario) throws PIException, PDException{
    Perfil user = this.repositorio.buscar(usuario);

    if(user != null){
      if(user.isAtivo()){
        Vector<Perfil> seguidos = new Vector<Perfil>();
				for (String seguido : user.getSeguidos()) {
					seguidos.add(this.repositorio.buscar(seguido));
				}
				return seguidos;
      }

      else throw new PDException(usuario);
    }

    else throw new PIException(usuario);
  }

}
