package Exceçoes;
//import PerfisTweet.Perfil;

public class PEException extends Exception{
  String perfil;

  //construtor
  public PEException(String perfil){
    super("Perfil já existente");
    this.perfil = perfil;
  }

  //mostrando qual o Usuário

  public String getUsuario(){
    return this.perfil;
  } 

  public String getMensagem(){
    return " já existe!";
  }

}