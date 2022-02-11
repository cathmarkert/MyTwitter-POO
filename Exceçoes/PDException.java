package Exceçoes;
//import PerfisTweet.Perfil;

public class PDException extends Exception{
  String perfil;

  //construtor
  public PDException(String perfil){
    super("Perfil já desativado");
    this.perfil = perfil;
  }

  //mostrando qual o Usuário

  public String getUsuario(){
    return this.perfil;
  } 

  public String getMensagem(){
    return " já foi desativado!";
  }

}