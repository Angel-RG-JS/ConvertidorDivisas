package coin_Converter_plus;

public class TemperatureConverter {
	
	public static double ConverterDegrees(String degrees1, String degrees2, double grados) {
		double result = 0;
		
		if(degrees1.equals("°C")) {
			double Celsius = grados;
			if(degrees2.equals("°F")) {
				result = (Celsius * 9/5) + 32;
			} else if(degrees2.equals("K")) {
				result = Celsius + 273.15;
			};
		} else if(degrees1.equals("°F")) {
			double Fahrenheit = grados;
			if(degrees2.equals("°C")) {
				result = (Fahrenheit -32) * 5/9;	
			} else if(degrees2.equals("K")) {
				result = (Fahrenheit - 32) * 5/9 + 273.15;
			};
		} else if(degrees1.equals("K")) {
			double Kelvin = grados;
			if(degrees2.equals("°C")) {
				result = Kelvin - 273.15;
			} else if(degrees2.equals("K")) {
				result = (Kelvin - 273.15) * 9/5 + 32;
			};
		};
		return result;
	}
}
