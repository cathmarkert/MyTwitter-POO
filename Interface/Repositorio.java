package Interface;
import PerfisTweet.Perfil;
import Exceçoes.UJCException;
import Exceçoes.UNCException;
import java.util.Vector;

//implementando IRepositorioUsuario 
public class Repositorio implements IRepositorioUsuario{
  private Vector<Perfil> Repousuarios;

  //construtor
  public Repositorio(){
    Repousuarios = new Vector<Perfil>();
  }

  //usamos o Override para garantir que estamos sobrescrevendo um método, e não criando um novo.

  //para cadastrar o usuário, devemos ver inicialmente se ele já não está cadastrado (se tem um nome igual já armazenado). Se não estiver, fazemos o seu cadastro. Se sim, vamos para a exceção.
  @Override
  public void cadastrar(Perfil usuario) throws UJCException{
    if(buscar(usuario.getUsuario()) == null) {
      Repousuarios.add(usuario);
      System.out.println("Parabéns, você foi cadastrado!");
    }

    else throw new UJCException(usuario.getUsuario());
  }


  //para buscar o usuário, fazemos a busca dele no vector ja criado que armazena todos os cadastrados até o momento. Se ele existir, ele é retornado. Se não, retorna-se null.
  @Override
  public Perfil buscar(String usuario){
    for(int i=0; i<Repousuarios.size();i++){
      if(usuario.equals(Repousuarios.get(i).getUsuario())){
        return Repousuarios.get(i);
      } 
    }

    return null;
  }


  //para atualizar o usuário, inicialmente buscamos a existência do Perfil antigousuario. Se ele existir, fazemos a atualização. Se não, partimos para a exceção.
  @Override
  public void atualizar(Perfil usuario) throws UNCException{
    Perfil antigousuario = buscar(usuario.getUsuario());

    if(antigousuario == null) throw new UNCException(usuario.getUsuario());


    else {
      antigousuario = usuario;
      System.out.println("Seu usuário foi atualizado com sucesso");
    }
  }



}