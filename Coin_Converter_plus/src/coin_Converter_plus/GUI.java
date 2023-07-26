package coin_Converter_plus;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class GUI implements ItemListener, ActionListener {
	JFrame ventana;
	JPanel titlePanel, mainPanel, buttonPanel;
	JLabel miJLabel;
	JComboBox<String> selector, selectorCoin, selectorTemperature;
	JButton buttonOk, buttonOkCurrency, buttonOkTemperature;
	JButton buttonClose, buttonCancel;
	String cantidadDinero, cantidadGrados;
	double rate, scale, cantidadDineroDouble, cantidadGradosDouble;
	String coin1 = "MXN";
	String coin2 = "USD";
	String degrees1 = "°C";
	String degrees2 = "°F";
	int type;

	public GUI() {
		ventana = new JFrame("Menu");
		ventana.setSize(300,150);
		ventana.setLayout(new GridLayout(3, 0));
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		((JComponent) ventana.getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		ventana.setLocationRelativeTo(null);

		titlePanel = new JPanel();
		titlePanel.setSize(300, 300);

	    //miJPanel.setLayout(new GridBagLayout());
		titlePanel.setLayout(new GridLayout(0, 1));

		miJLabel = new JLabel();
		miJLabel.setText("Seleccione una opción de conversión: ");
		miJLabel.setVerticalAlignment(SwingConstants.TOP);
		miJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlePanel.add(miJLabel);
		
		
		mainPanel = new JPanel();
		mainPanel.setSize(300, 300);
		mainPanel.setLayout(new GridLayout(0, 1));
		
		String[] optionsMain = {"Conversor de Moneda", "Conversor de Temperatura"};
		selector = new JComboBox<String>(optionsMain);
		selector.setBounds(100,100,10,20);
		selector.addItemListener(this);
		selector.setSelectedIndex(0);
		mainPanel.add(selector);
        
		buttonPanel = new JPanel();
		buttonPanel.setSize(300, 300);
		buttonPanel.setLayout(new GridLayout(0, 2));
		
        buttonOk = new JButton("OK");  
        buttonPanel.add(buttonOk);
		buttonOk.addActionListener(this);
		
		buttonClose = new JButton("Close");
		buttonClose.addActionListener(this);
		buttonPanel.add(buttonClose);
        
		ventana.add(titlePanel);
		ventana.add(mainPanel);
		ventana.add(buttonPanel);
		ventana.setVisible(true);
	};

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == selector) {
			type = selector.getSelectedIndex();
			
		}else if (e.getSource() == selectorCoin) {
			int itemSelected = selectorCoin.getSelectedIndex();
			switch(itemSelected) {
				case (0):
					coin1 = "MXN";
					coin2 = "USD";
					break;
				case (1):
					coin1 = "MXN";
					coin2 = "EUR";
					break;
				case (2):
					coin1 = "MXN";
					coin2 = "GBP";
					break;
				case (3):
					coin1 = "MXN";
					coin2 = "JPY";
					break;
				case (4):
					coin1 = "MXN";
					coin2 = "KRW";
					break;
				case (5):
					coin1 = "USD";
					coin2 = "MXN";
					break;
				case (6):
					coin1 = "EUR";
					coin2 = "MXN";
					break;
				case (7):
					coin1 = "GBP";
					coin2 = "MXN";
					break;
				case (8):
					coin1 = "JPY";
					coin2 = "MXN";
					break;
				case (9):
					coin1 = "KRW";
					coin2 = "MXN";
					break;
			}
		} else if (e.getSource() == selectorTemperature) {
			int itemSelected = selectorTemperature.getSelectedIndex();
			switch(itemSelected) {
				case (0):
					degrees1 = "°C";
					degrees2 = "°F";
					break;
				case (1):
					degrees1 = "°C";
					degrees2 = "K";
					break;
				case (2):
					degrees1 = "°F";
					degrees2 = "°C";
					break;
				case (3):
					degrees1 = "°F";
					degrees2 = "K";
					break;
				case (4):
					degrees1 = "K";
					degrees2 = "°C";
					break;
				case (5):
					degrees1 = "K";
					degrees2 = "°F";
					break;
			}
		}
	};
	
	public void actionPerformed(ActionEvent buttonClick) {
		if (buttonClick.getSource() == buttonOk) {
			if (type == 0) {
				ventana.setVisible(false);
				converterCurrencyOk();
			} else if (type == 1) {
				ventana.setVisible(false);
				converterTemperatureOk();
			};
		} else if (buttonClick.getSource() == buttonOkCurrency) {
			System.out.println("coin1 = " + coin1);
			System.out.println("coin2 = " + coin2);
			System.out.println("rate = " + rate);

			rate = CoinConverter.ConverterMXN(coin1, coin2, cantidadDineroDouble);
			ventana.dispose();
			JOptionPane.showMessageDialog(ventana, "Tienes " + rate + " " + coin2);
			showConfirmDialogCurrency();
		} else if (buttonClick.getSource() == buttonOkTemperature) {
			scale = TemperatureConverter.ConverterDegrees(degrees1, degrees2, cantidadGradosDouble);
			ventana.dispose();
			JOptionPane.showMessageDialog(ventana, "Son " + scale + " " + degrees2);
			showConfirmDialogTemperature();
		} else if (buttonClick.getSource() == buttonClose) {
			ventana.dispose();
		} else if (buttonClick.getSource() == buttonCancel) {
			ventana.dispose();
			new GUI();
		}
	};
	
	public void converterCurrencyOk() {
		cantidadDinero = JOptionPane.showInputDialog("Ingrese la cantidad de dinero que quiere convertir");
		if (cantidadDinero == null) {
			ventana.dispose();
			new GUI();
		}else {
			boolean valido = ValidaInput.validaInput(cantidadDinero);
			if(valido == true) {
				cantidadDineroDouble = Double.parseDouble(cantidadDinero);
				System.out.println("cantidadDineroDouble = " + cantidadDineroDouble);
				ventana = new JFrame("Monedas");
				ventana.setSize(400,150);
				ventana.setLayout(new GridLayout(3, 0));
				ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				((JComponent) ventana.getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
				ventana.setLocationRelativeTo(null);
				
				titlePanel = new JPanel();
				titlePanel.setSize(300, 300);
	
				titlePanel.setLayout(new GridLayout(0, 1));
	
				miJLabel = new JLabel();
				miJLabel.setText("Elija la moneda a la que quiere convertir su dinero: ");
				miJLabel.setVerticalAlignment(SwingConstants.TOP);
				miJLabel.setHorizontalAlignment(SwingConstants.CENTER);
				titlePanel.add(miJLabel);
				
				mainPanel = new JPanel();
				mainPanel.setSize(300, 300);
				mainPanel.setLayout(new GridLayout(0, 1));
	
				String[] optionsCoin = {"Pesos mexicanos (MXN) a dólares ($/USD)",
										"Pesos mexicanos (MXN) a euros (€/EUR)",
										"Pesos mexicanos (MXN) a libras esterlinas (£/GBP)",
										"Pesos mexicanos (MXN) a yenes japoneses (¥/JPY)",
										"Pesos mexicanos (MXN) a Won surcoreano (₩/KRW)",
										"Dólares ($/USD) a pesos mexicanos (MXN)",
										"Euros (€/EUR) a pesos mexicanos (MXN)",
										"Libras esterlinas (£/GBP) a pesos mexicanos (MXN)",
										"Yenes japoneses (¥/JPY) a pesos mexicanos (MXN)",
										"Won surcoreano (₩/KRW) a pesos mexicanos (MXN)"
				};
				selectorCoin = new JComboBox<String>(optionsCoin);
				selectorCoin.setBounds(100,100,10,20);
				selectorCoin.addItemListener(this);
				selectorCoin.setSelectedIndex(0);
				
				mainPanel.add(selectorCoin);
				
				buttonPanel = new JPanel();
				buttonPanel.setSize(300, 300);
				buttonPanel.setLayout(new GridLayout(0, 2));
			    
			    buttonOkCurrency = new JButton("OK");  
		        buttonOkCurrency.addActionListener(this);
				
				buttonCancel = new JButton("Cancel");
				buttonCancel.addActionListener(this);
				
				buttonPanel.add(buttonOkCurrency);
				buttonPanel.add(buttonCancel);
		        
				ventana.add(titlePanel);
				ventana.add(mainPanel);
				ventana.add(buttonPanel);
				ventana.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(ventana, "Ingrese dato numérico válido",
			               "Advertencia", JOptionPane.WARNING_MESSAGE);
				converterCurrencyOk();
			}
		}
	};
	
	public void converterTemperatureOk() {
		cantidadGrados = JOptionPane.showInputDialog("Ingrese los grados que quiere convertir");
		if (cantidadGrados == null) {
			ventana.dispose();
			new GUI();
		}else {
			boolean valido = ValidaInput.validaInput(cantidadGrados);
			if(valido == true) {
				cantidadGradosDouble = Double.parseDouble(cantidadGrados);
				
				ventana = new JFrame("Escalas de temperatura");
				ventana.setSize(300,150);
				ventana.setLayout(new GridLayout(3, 0));
				ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				((JComponent) ventana.getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
				ventana.setLocationRelativeTo(null);
				
				titlePanel = new JPanel();
				titlePanel.setSize(300, 300);
	
				titlePanel.setLayout(new GridLayout(0, 1));
	
				miJLabel = new JLabel();
				miJLabel.setText("Elija la escala de temperatura a la que quiere convertir: ");
				miJLabel.setVerticalAlignment(SwingConstants.TOP);
				miJLabel.setHorizontalAlignment(SwingConstants.CENTER);
				titlePanel.add(miJLabel);
	
				mainPanel = new JPanel();
				mainPanel.setSize(300, 300);
				mainPanel.setLayout(new GridLayout(0, 1));
				
				String[] optionsTemperature = { "Grados Celsius (°C) a Fahrenheit (°F)",
										 		"Grados Celsius (°C) a Kelvin (K)",
										 		"Grados Fahrenheit (°F) a Celsius (°C)",
										 		"Grados Fahrenheit (°F) a Kelvin (K)",
										 		"Kelvin (K) a Celsius (°C)",
										 		"Kelvin (K) a Fahrenheit (°F)"
				};
				selectorTemperature = new JComboBox<String>(optionsTemperature);
				selectorTemperature.setBounds(100,100,10,20);
				selectorTemperature.addItemListener(this);
				selectorTemperature.setSelectedIndex(0);
				
				mainPanel.add(selectorTemperature);
				
				buttonPanel = new JPanel();
				buttonPanel.setSize(300, 300);
				buttonPanel.setLayout(new GridLayout(0, 2));
				
			    buttonOkTemperature = new JButton("OK");  
		        buttonOkTemperature.addActionListener(this);
				
				buttonCancel = new JButton("Cancel");
				buttonCancel.addActionListener(this);
				
				buttonPanel.add(buttonOkTemperature);
				buttonPanel.add(buttonCancel);
		        
				ventana.add(titlePanel);
				ventana.add(mainPanel);
				ventana.add(buttonPanel);
				ventana.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(ventana, "Ingrese dato numérico válido",
			               "Advertencia", JOptionPane.WARNING_MESSAGE);
				converterTemperatureOk();
			}
		}
	};
	
	public void showConfirmDialogCurrency() { 
		int result = JOptionPane.showConfirmDialog(ventana, "¿Desea continuar?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			new GUI();
		} else if (result == JOptionPane.NO_OPTION) {
		    System.exit(0);
		} else if (result == JOptionPane.CANCEL_OPTION) {
			converterCurrencyOk();
		}
	};
	
	public void showConfirmDialogTemperature() { 
		int result = JOptionPane.showConfirmDialog(ventana, "¿Desea continuar?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			new GUI();
		} else if (result == JOptionPane.NO_OPTION) {
		    System.exit(0);
		} else if (result == JOptionPane.CANCEL_OPTION) {
			converterTemperatureOk();
		}
	};
}
