package VentanasMoneda;

import javax.swing.JOptionPane;

public class Moneda {
	
	public Moneda(double cantidadMonedas,double valorMoneda,String moneda){
		String mensaje;
		double total;
		
		
		total=(double)Math.round(cantidadMonedas*valorMoneda*100d)/100;
		mensaje = "Tienes $"+total+moneda;
		String botones[]= {"SALIR","NUEVA CONVERSION"};
		
		int eleccion = JOptionPane.showOptionDialog(null, mensaje, "Cantidad de monedas: "+cantidadMonedas, JOptionPane.WARNING_MESSAGE, 0, null, botones, this);
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}else if(eleccion == JOptionPane.NO_OPTION) {
			new VentanaConvertidores();
		}
		
	}
}
