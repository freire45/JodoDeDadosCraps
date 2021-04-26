package br.com.jogodedadoscraps;

import java.security.SecureRandom;

/**
 * Programa em Java que simula o jogo de dados Craps
 * @author Erick Freire
 * @version 1 - Criado em 26-04-2021 as 00:05
 */

public class JogoDeDadosCraps {
	
	private static final SecureRandom NUMEROALEATORIO = new SecureRandom();
	
	private enum Status{
		CONTINUE,
		GANHOU,
		PERDEU,
	}
	
	private static final int OLHO_DE_COBRA = 2;
	private static final int TRES = 3;
	private static final int SETE = 7;
	private static final int ONZE = 11;
	private static final int CAIXA_DE_CARROS = 12;

	public static void main(String[] args) {
		
		int minhaPontuacao = 0;
		Status statusDoJogo;
		
		int somaRolagemDados = jogadaDeDados();
		
		switch(somaRolagemDados) {
		case SETE:
		case ONZE:
			statusDoJogo = Status.GANHOU;
			break;
			
		case OLHO_DE_COBRA:
		case TRES:
		case CAIXA_DE_CARROS:
			statusDoJogo = Status.PERDEU;
			break;
		default:
			statusDoJogo = Status.CONTINUE;
			minhaPontuacao = somaRolagemDados;
			System.out.printf("Pontuação é de: %d%n", minhaPontuacao);
			break;
			
			
		}
		
		while(statusDoJogo == Status.CONTINUE) {
			somaRolagemDados = jogadaDeDados();
			
			if(somaRolagemDados == minhaPontuacao)
				statusDoJogo = Status.GANHOU;
			else
				if(somaRolagemDados == SETE)
					statusDoJogo = Status.PERDEU;
		}
		
		if(statusDoJogo == Status.GANHOU)
			System.out.println("Você Ganhou!");
		else
			System.out.println("Você Perdeu!");		

	}
	
	public static int jogadaDeDados() {
		
		int morreu1 = 1 + NUMEROALEATORIO.nextInt(6);
		int morreu2 = 1 + NUMEROALEATORIO.nextInt(6);
		
		int soma = morreu1 + morreu2;
		
		System.out.printf("O Jogador rolou %d + %d = %d%n", morreu1, morreu2, soma);
		
		return soma;
		
	}

}
