package Service;
// Request HTTP para transformar os arquivos em um array de Strings.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import Exception.CepInvalidoException;

public class ConsultaCep {	
	
	public String[] buscaEnderecoPorCepApi(String cep){
		
		String url = "http://viacep.com.br/ws/"+cep+"/json/";
		String [] result = null;
		
		try {
			
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			
			conn.setRequestMethod("GET");
			
			if(conn.getResponseCode() != 200) {
				System.out.println("Erro " + conn.getResponseCode() + " ao obter dados da url " + url);
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			result = new String[10];
			String line;
			int i = 0;
			while((line = br.readLine()) != null) {
				if(!line.equals("{") && !line.equals("}")) {					
					String [] l = new String[2];
					l = line.split(": ");					
					result [i] = l[1].substring(1, l[1].length() - 2);
					i++;
				}			
			}
			conn.disconnect();
			
		}catch(IOException e){
			System.out.println("Erro!" + e.getMessage());
		}		
		
		return result;
	}
	
	public boolean cepValido(String cep) throws CepInvalidoException {
		
		if(cep.length() != 8) {
			throw new CepInvalidoException("Verifique se os dados foram inseridos corretamente.");
		}
		
		return true;
	}
	
	public boolean cepExistente(String[] dados) {
		if(dados[0].equals("r")) {
			return false;
		}
		
		return true;
	}
	
}
