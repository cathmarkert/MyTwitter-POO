package PerfisTweet;

import java.lang.String;

public class PessoaFisica extends Perfil{
  private long cpf;

  //construtor da pessoa física
  public PessoaFisica(String usuario){
    super(usuario);
    setCpf(this.cpf);
  }

  //ajusta o cpf
  public void setCpf(long cpf){
    this.cpf = cpf; 
  }

  //retorna o cpf
  public long getCpf(){
    return this.cpf;
  }

}