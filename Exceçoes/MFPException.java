package Exceçoes;

public class MFPException extends Exception{
  String mensagem;

  //construtor
  public MFPException(String mensagem){
    super("Mensagem não suportada");
    this.mensagem = mensagem;
  }

  public String getMensagemdiff(){
    if(mensagem.length() <= 0) return "Mensagem muito curta!";

    else return "Mensagem muito longa!";
  } 

  public String getMensagem(){
    return this.mensagem;
  }

}