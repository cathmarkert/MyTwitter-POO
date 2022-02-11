package Exceçoes;
//import PerfisTweet.Perfil;

public class SIException extends Exception{
  String perfil;

  //construtor
  public SIException(String perfil){
    super("seguidor e seguindo são iguais");
    this.perfil = perfil;
  }

  //mostrando qual o Usuário

  public String getUsuario(){
    return this.perfil;
  } 

  public String getMensagem(){
    return " não pode se seguir!";
  }

}