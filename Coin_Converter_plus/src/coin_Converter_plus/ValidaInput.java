package coin_Converter_plus;

public class ValidaInput {
	public static boolean validaInput(String input){
		boolean valido = true;
		if(!input.matches("[0-9]*\\.?[0-9]*")){
			valido = false;
		}
		return valido;
	}
}
