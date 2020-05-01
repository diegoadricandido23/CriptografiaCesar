package br.com.diego.cifracesar.logica;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author diegoadricandido23@gmail.com
 *
 */
public class LogicaCifra {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LogicaCifra.class);
	private static final char [] ALFABETO = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	
	/**
	 * Referência: https://pt.wikipedia.org/wiki/Cifra_de_C%C3%A9sar
	 * 
	 * Decodifica mensagem Cifra de Cesar.
	 * 
	 * A ideia do algoritmo é simplesmente a substuição da letra por outra
	 * a partir de um "índice" que é fornecido junto a palava que será decodificada
	 *
	 * @param msg Mensagem a ser Trabalhada
	 * @param numeroCasas para a Cifra
	 * @param tipoProcesso tipo de processo a executar
	 * @return the answer
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	public static String aplicaCifraCesar(String msg, Integer numeroCasas, TipoProcesso tipoProcesso) throws NoSuchAlgorithmException, UnsupportedEncodingException  {
		LOGGER.info("INICIANDO DECODIFICAÇÃO");
		
		char caracterCrip = 0;
		String texto = "";
		
		for(int i =0; i < msg.length(); i++) {
			if(TipoProcesso.CODIFICA == tipoProcesso) {
				caracterCrip= encriptaCharacter(numeroCasas, (char)msg.charAt(i));
				
			} else {
				
				caracterCrip= decriptaCharacter(numeroCasas, (char)msg.charAt(i));
			}
			
			texto += caracterCrip;
		}
		
        LOGGER.info("DeCodificado: %s\n", texto);
        LOGGER.info("FINALIZANDO DECODIFICAÇÃO");
        return texto;
	}
	
	/**
	 * Verifica a Posição em que a Letra se encontra no Alfabeto
	 * para decodificar
	 *
	 * @param indice the indice
	 * @param charAt the char at
	 * @return the char
	 */
	private static char decriptaCharacter(int indice, char charAt) {
		if(Character.isAlphabetic(charAt)) {
			int pos = 0;
			for(int i=0; i < ALFABETO.length; i++) {
				if( ALFABETO[i] == charAt) {
					pos = i;	
					break;
				}
			}
			while(indice > 0) {
				if(pos == 0)
					pos = ALFABETO.length;
				pos--;
				indice--;
			}
			return ALFABETO[pos];
		}
		return charAt;
	}
	
	/**
	 * Verifica a Posição em que a Letra se encontra no Alfabeto
	 * para decodificar
	 *
	 * @param indice the indice
	 * @param charAt the char at
	 * @return the char
	 */
	private static char encriptaCharacter(int indice, char charAt) {
		if(Character.isAlphabetic(charAt)) {
			int pos = 0;
			for(int i=0; i < ALFABETO.length; i++) {
				if( ALFABETO[i] == charAt) {
					pos = i;	
					break;
				}
			}
			while(indice > 0) {
				if(pos == ALFABETO.length)
					pos = 0;
				pos++;
				indice--;
			}
			return ALFABETO[pos];
		}
		return charAt;
	}
}