package PerfisTweet;

public class Tweet{
  private String usuario;
  private String mensagem;

  //construtor
  public Tweet(String usuario, String mensagem){
    this.setUsuario(usuario);
    this.setMensagem(mensagem);

  }

  //configurando a estrutura do tweet

  public void setUsuario(String usuario){
    this.usuario = usuario;
  }

  public String getUsuario(){
    return this.usuario;
  }

  public void setMensagem(String mensagem){
    this.mensagem = mensagem;
  }

  public String getMensagem(){
    return this.mensagem;
  }
}