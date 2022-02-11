package PerfisTweet;

import java.util.Vector;
import java.lang.String;
import Exceçoes.SIException;

public abstract class Perfil{

  private String usuario;
  private Vector<String> seguidos;
  private Vector<String> seguidores;
  private Vector<Tweet> timeline;
  private boolean ativo;

  //construtor da classe Perfil

  public Perfil(String usuario){
    this.usuario = new String();
    this.usuario = usuario;

    ativo = true;
    seguidos = new Vector<String>();
    seguidores = new Vector<String>();
    timeline = new Vector<Tweet>();
  }

  //adicionar seguidores 

  public void addSeguido(String usuario) throws SIException{
    seguidos.add(usuario);
  }

  //a conta seguir alguém

  public void addSeguidor(String usuario) throws SIException{
    seguidores.add(usuario);
  }

  //adicionar um tweet à timeline

  public void addTweet(Tweet tweet){
    timeline.add(tweet);
  }

  //receber um usuário e alterar o seu campo

  public void setUsuario(String usuario){
    this.usuario = usuario;
  }

  //retorna o número do usuário

  public String getUsuario(){
    return this.usuario;
  }

  //returna o vector de seguidos

  public Vector<String> getSeguidos(){
    return seguidos;
  }

  //retorna o vector de seguidores

  public Vector<String> getSeguidores(){
    return seguidores;
  }

  //retorna o vector da timeline de tweets

  public Vector<Tweet> getTimeline(){
    return this.timeline;
  }

  //coloca o campo de ativação do perfil em verdadeiro ou falso

  public void setAtivo(boolean valor){
    this.ativo = valor;
  }

  //retorna o estado de ativo (ativo ou inativo)
  
  public boolean isAtivo(){
    return this.ativo;
  }

}