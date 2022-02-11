import java.util.Scanner;

import PerfisTweet.*;
import Interface.*;
import Exceçoes.*;


class Main {
  //menu interativo
  public static void Menu(){
    System.out.println("---------------------------------");
    System.out.println("  Bem-vindo(a) ao MyTwitter      ");
    System.out.println("Selecione uma das opções abaixo: ");
    System.out.println("1 - criar conta");
    System.out.println("2 - cancelar conta");
    System.out.println("3 - tweetar");
    System.out.println("4 - ver timeline");
    System.out.println("5 - ver seus tweets");
    System.out.println("6 - seguir conta");
    System.out.println("7 - número de seguidores");
    System.out.println("8 - ver seguidores");
    System.out.println("9 - ver seguidos");
    System.out.println("0 - sair");
    System.out.println("---------------------------------");
  }


  public static void main(String[] args) {
    String usuario,mensagem;
    Scanner scanner = new Scanner(System.in);

    Repositorio repo = new Repositorio();
    MyTwitter twitter = new MyTwitter(repo);

    int op = 1; 

    while(op != 0){
      Menu();
      op = scanner.nextInt(); 

      switch(op){
        case 1:
          System.out.println("Digite 1 para pessoa física");
          System.out.println("Digite 2 para pessoa jurídica");

          int aux = scanner.nextInt();

          if(aux == 1){
            //criando a conta da pessoa física
            System.out.println("Digite o nome de usuario: ");
		        usuario = scanner.next();
            Perfil user = new PessoaFisica(usuario);

            try {
              twitter.criarPerfil(user);
			        System.out.println("Informe o CPF: ");
			        int cpf = scanner.nextInt();
		      	  ((PessoaFisica) user).setCpf(cpf);
		        } 
            
            catch (PEException e) {
			        System.out.println("Erro, " + e.getUsuario()+ e.getMensagem());
		        }
		        user.setAtivo(true);

            
          }

          else if(aux == 2){
            //criando a conta da pessoa jurídica
            System.out.println("Digite o nome de usuario: ");
		        usuario = scanner.next();
            Perfil user = new PessoaJuridica(usuario);

            try {
              twitter.criarPerfil(user);
			        System.out.println("Informe o CNPJ: ");
			        int cnpj = scanner.nextInt();
			        ((PessoaJuridica) user).setCnpj(cnpj);
	          } 
    
            catch (PEException e) {
			       System.out.println("Erro, " + e.getUsuario() + e.getMensagem());
		        }
		        user.setAtivo(true);
            
          }

          else System.out.println("Erro, tente novamente!");
          break;
        
        case 2:
          //desativando o perfil do usuário
          System.out.println("Digite o usuário que deseja ter o perfil cancelado: ");
          usuario = scanner.next();
    
          try{
            twitter.cancelarPerfil(usuario);
          }

          catch (PIException e){
            System.out.println("Erro, " + e.getUsuario() + e.getMensagem());
          }

          catch (PDException e){
            System.out.println("Erro, " + e.getUsuario() + e.getMensagem());
          }
         break;

        case 3:
          //realizar um tweet
          System.out.println("Digite o usuário: ");
          usuario = scanner.next();
          System.out.println("Digite seu tweet: ");
          scanner.nextLine();
          mensagem = scanner.nextLine();

          try{
            twitter.tweetar(usuario,mensagem);
          }

          catch (PIException e){
            System.out.println("Erro, " + e.getUsuario() + e.getMensagem());
          }

          catch (MFPException e){
            System.out.println("Erro, " + e.getMensagemdiff());
          }
         break;

        case 4:
          //mostrar timeline do usuário
          System.out.println("Digite o usuário: ");
          usuario = scanner.next();

          try{
            for(Tweet tweet : twitter.timeline(usuario)){
              System.out.println("@" + tweet.getUsuario() + ": " + tweet.getMensagem());
            }
          }

          catch (PIException e){
            System.out.println("Erro, " + e.getUsuario() + e.getMensagem());
          }

          catch(PDException e){
            System.out.println("Erro, " + e.getUsuario() + e.getMensagem());
          }
          break; 

        case 5:
          //mostrando os tweets do usuário
          System.out.println("Digite o usuário: ");
          usuario = scanner.next();
          System.out.println("Seus tweets: ");

          try{
            for(Tweet tweet : twitter.tweets(usuario)){
              System.out.println(tweet.getMensagem());
            }
          }

          catch (PIException e){
            System.out.println("Erro, " + e.getUsuario() + e.getMensagem());
          }

          catch(PDException e){
            System.out.println("Erro, " + e.getUsuario() + e.getMensagem());
          }
          break;

        case 6:
          //seguir outro usuário
          System.out.println("Digite o seu usuário: ");
          usuario = scanner.next();
          System.out.println("Digite o usuário que você quer seguir: ");
          String follow = scanner.next();

          try{
            twitter.seguir(usuario,follow);
          }

          catch (PIException e){
            System.out.println("Erro, " + e.getUsuario() + e.getMensagem());
          }

          catch (PDException e){
            System.out.println("Erro, " + e.getUsuario() + e.getMensagem());
          }

          catch (SIException e){
            System.out.println("Erro, " + e.getUsuario() + e.getMensagem());
          }
          break;

        case 7:
          //ver o número de seguidores
          System.out.println("Digite o usuário: ");
          usuario = scanner.next();
          System.out.println("Número de seguidores: ");

          try{
            System.out.println(twitter.numeroSeguidores(usuario) + " é o número de seguidores");
          }

          catch (PIException e){
            System.out.println("Erro, " + e.getUsuario() + e.getMensagem());
          }

          catch (PDException e){
            System.out.println("Erro, " + e.getUsuario() + e.getMensagem());
          }
          break;

        case 8:
          //ver o nome dos seguidores
          System.out.println("Digite o usuário: ");
          usuario = scanner.next();
          System.out.println("Seus seguidores são: ");

          try{
            for(Perfil seguidor : twitter.seguidores(usuario)){
              System.out.println("@"+ seguidor.getUsuario());
            }
          }

          catch (PIException e){
            System.out.println("Erro, " + e.getUsuario() + e.getMensagem());
          }

          catch (PDException e){
            System.out.println("Erro, " + e.getUsuario() + e.getMensagem());
          }
          break;

        case 9:
          //ver o nome dos seguidores
          System.out.println("Digite o usuário: ");
          usuario = scanner.next();
          System.out.println("Seus seguidos são: ");

          try{
            for(Perfil seguido : twitter.seguidos(usuario)){
              System.out.println("@"+ seguido.getUsuario());
            }
          }

          catch (PIException e){
            System.out.println("Erro, " + e.getUsuario() + e.getMensagem());
          }

          catch (PDException e){
            System.out.println("Erro, " + e.getUsuario() + e.getMensagem());
          }
          break;

        case 0:
          System.out.println("Encerrado!");
          System.out.println("Desenvolvido por Catherine Markert em 2021 :)");
          System.exit(0);
          break;

        default: 
          System.out.println("Erro! Digite um número válido!");
					break;
      }
    }

    scanner.close();
  }
  
}