/**
 * 
 */
package br.com.diego.cifracesar;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import br.com.diego.cifracesar.logica.LogicaCifra;
import br.com.diego.cifracesar.logica.TipoProcesso;

/**
 * @author diegoadricandido23@gmail.com
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String texto = "a ligeira raposa marrom saltou sobre o cachorro cansado";
		texto = LogicaCifra.aplicaCifraCesar(texto, 3, TipoProcesso.CODIFICA);
		System.out.println("Encript: " + texto);
		System.out.println("************************************************");
		texto = LogicaCifra.aplicaCifraCesar(texto, 3, TipoProcesso.DECODIFICA);
		System.out.println("Decript: " + texto);
	}

}
