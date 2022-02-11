package PerfisTweet;

import java.lang.String;

public class PessoaJuridica extends Perfil{
  private long cnpj;

  //construtor da pessoa jurídica
  public PessoaJuridica(String usuario){
    super(usuario);
    setCnpj(this.cnpj);
  }

  //armazena o cnpj
  public void setCnpj(long cnpj){
    this.cnpj = cnpj; 
  }

  //retorna o cnpj
  public long getCnpj(){
    return this.cnpj;
  }

}