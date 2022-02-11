package Exceçoes;
//import PerfisTweet.Perfil;

public class PIException extends Exception{
  String perfil;

  //construtor
  public PIException(String perfil){
    super("Perfil inexistente");
    this.perfil = perfil;
  }

  //mostrando qual o Usuário

  public String getUsuario(){
    return this.perfil;
  } 

  public String getMensagem(){
    return " não existe!";
  }

}