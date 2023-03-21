package VentanasPeso;

import javax.swing.JOptionPane;

public class Peso {
	
	public Peso(double cantidadPeso,double valorPeso,String peso){
		String mensaje;
		double total;
		
		
		total=(double)Math.round(cantidadPeso*valorPeso*100d)/100;
		mensaje = "Tienes $"+total+peso;
		String botones[]= {"SALIR","NUEVA CONVERSION"};
		
		int eleccion = JOptionPane.showOptionDialog(null, mensaje, "Cantidad de Peso: "+cantidadPeso, JOptionPane.WARNING_MESSAGE, 0, null, botones, this);
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}else if(eleccion == JOptionPane.NO_OPTION) {
			new VentanaConvertidorPeso();
		}
		
	}
}
