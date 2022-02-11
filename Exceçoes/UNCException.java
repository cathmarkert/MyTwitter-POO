package Exceçoes;
//import PerfisTweet.Perfil;

public class UNCException extends Exception{
  String perfil;

  //construtor
  public UNCException(String perfil){
    super("Usuário não cadastrado");
    this.perfil = perfil;
  }

  //mostrando qual o Usuário

  public String getUsuario(){
    return this.perfil;
  } 

  public String getMensagem(){
    return " não está cadastrado!";
  }

}