package Exceçoes;
//import PerfisTweet.Perfil;

public class UJCException extends Exception{
  String perfil;

  //construtor
  public UJCException(String perfil){
    super("Usuário já cadastrado");
    this.perfil = perfil;
  }

  //mostrando qual o Usuário

  public String getUsuario(){
    return this.perfil;
  } 

  public String getMensagem(){
    return " já está cadastrado!";
  }

}