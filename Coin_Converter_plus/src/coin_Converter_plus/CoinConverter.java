package coin_Converter_plus;

public class CoinConverter {
	
	public static double ConverterMXN(String coin1, String coin2, double cantidadDinero) {
		double result = 0;
		double rate = 0.058;
		
		if(coin1.equals("MXN")) {
			double MXN = cantidadDinero;
			if(coin2.equals("USD")) {
				rate = 0.058;
			}else if(coin2.equals("EUR")) {
				rate = 0.053;
			}else if(coin2.equals("GBP")) {
				rate = 0.046;
			}else if(coin2.equals("JPY")) {
				rate = 8.43;
			}else if(coin2.equals("KRW")) {
				rate = 76.87;
			}
			result = MXN * rate;
		}else if(coin2.equals("MXN")) {
			double MXN = cantidadDinero;
			if(coin1.equals("USD")) {
				rate = 17.12;
			}else if(coin1.equals("EUR")) {
				rate = 18.69;
			}else if(coin1.equals("GBP")) {
				rate = 21.76;
			}else if(coin1.equals("JPY")) {
				rate = 0.12;
			}else if(coin1.equals("KRW")) {
				rate = 0.013;
			}
			result = MXN * rate;
		}
		return result;
	}
};