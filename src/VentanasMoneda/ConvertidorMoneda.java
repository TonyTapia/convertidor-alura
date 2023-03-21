package VentanasMoneda;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ConvertidorMoneda extends JFrame implements ActionListener {
	
	
	private JPanel panelConvertidor;
	private JComboBox<String> comboBoxConvertidor;
	private JButton  btnAceptarConvertidor,btnCancelarConvertidor,btnAtras;
	
	private double cantidadMonedas;
	private int indexCombo;
	
	private String[] opcionesConvertidor = {"Selecciona", "De peso Méxicano a Dólar", 
			"De peso Méxicano a Euros", "De peso Méxicano a Libras Esterlinas", "De peso Méxicano a Yen Japonés",
			"De peso Méxicano a Won sul-coreano","De Dólar a peso México","De Euros a peso México","De Libras Esterlinas a peso México",
			"De Yen Japonés a peso México","De Won sul-coreano a peso México"};
	
	public ConvertidorMoneda(double cantidadMonedas){
		this.cantidadMonedas = cantidadMonedas;
		setType(Type.UTILITY);
		setFont(new Font("Arial", Font.PLAIN, 18));
		setForeground(new Color(0, 0, 0));
		setTitle("Cantidad de Monedas: "+cantidadMonedas);
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(453, 144);
		setLocationRelativeTo(null);
		setVisible(true);
		iniciarComponentesConvertidor();
	}

	private void iniciarComponentesConvertidor() {
		getContentPane().setLayout(null);
		
		panelConvertidor = new JPanel();
		panelConvertidor.setBackground(new Color(230, 230, 230));
		panelConvertidor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelConvertidor);
		panelConvertidor.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Selecciona un convertidor:");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 22));
		lblTitulo.setBounds(0, 11, 437, 29);
		panelConvertidor.add(lblTitulo);
		
		comboBoxConvertidor = new JComboBox<String>();
		comboBoxConvertidor.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxConvertidor.setBackground(new Color(207, 231, 254));
		comboBoxConvertidor.setBounds(99, 51, 245, 22);
		comboBoxConvertidor.setModel(new DefaultComboBoxModel(opcionesConvertidor));
		comboBoxConvertidor.setSelectedIndex(0);
		comboBoxConvertidor.addActionListener(this);
		panelConvertidor.add(comboBoxConvertidor);
		
		btnAceptarConvertidor = new JButton("ACEPTAR");
		btnAceptarConvertidor.setForeground(new Color(0, 0, 0));
		btnAceptarConvertidor.setBackground(new Color(191, 255, 194));
		btnAceptarConvertidor.setFont(new Font("Arial", Font.BOLD, 12));
		btnAceptarConvertidor.setBounds(173, 84, 89, 23);
		btnAceptarConvertidor.addActionListener(this);
		panelConvertidor.add(btnAceptarConvertidor);
		
		btnCancelarConvertidor = new JButton("SALIR");
		btnCancelarConvertidor.setForeground(Color.BLACK);
		btnCancelarConvertidor.setFont(new Font("Arial", Font.BOLD, 12));
		btnCancelarConvertidor.setBackground(new Color(255, 55, 55));
		btnCancelarConvertidor.setBounds(325, 84, 102, 23);
		btnCancelarConvertidor.addActionListener(this);
		panelConvertidor.add(btnCancelarConvertidor);
		
		btnAtras = new JButton("ATRAS...");
		btnAtras.setForeground(Color.BLACK);
		btnAtras.setFont(new Font("Arial", Font.BOLD, 12));
		btnAtras.setBackground(new Color(191, 255, 194));
		btnAtras.setBounds(10, 84, 89, 23);
		btnAtras.addActionListener(this);
		panelConvertidor.add(btnAtras);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==comboBoxConvertidor) {
			indexCombo = comboBoxConvertidor.getSelectedIndex();
		}
		if(e.getSource()==btnAceptarConvertidor) {
			switch(indexCombo) {
				case 0:
					JOptionPane.showMessageDialog(null, "Seleccione un opcion");
					break;
				case 1:
					this.setVisible(false);
					new Moneda(cantidadMonedas,0.053," Dolares.");
					break;
				case 2:
					this.setVisible(false);
					new Moneda(cantidadMonedas,0.050," Euros.");
					break;
				case 3:
					this.setVisible(false);
					new Moneda(cantidadMonedas,0.043," Libras Esterlimnas.");
					break;
				case 4:
					this.setVisible(false);
					new Moneda(cantidadMonedas,6.99," Yenes Japoneses.");
					break;
				case 5:
					this.setVisible(false);
					new Moneda(cantidadMonedas,64.54," Won´s Surcoreanos.");
					break;
				case 6:
					this.setVisible(false);
					new Moneda(cantidadMonedas,18.80," Pesos Méxicanos.");
					break;
				case 7:
					this.setVisible(false);
					new Moneda(cantidadMonedas,20.16," pesos Méxicanos.");
					break;
				case 8:
					this.setVisible(false);
					new Moneda(cantidadMonedas,23.08," Pesos Méxicanos.");
					break;
				case 9:
					this.setVisible(false);
					new Moneda(cantidadMonedas,0.14," Pesos Méxicanos.");
					break;
				case 10:
					this.setVisible(false);
					new Moneda(cantidadMonedas,0.014," Pesos Méxicanos.");
					break;
			}
		}
		if (e.getSource()==btnCancelarConvertidor) {
			String botones[]= {"Cerrar","Cancelar"};
			int eleccion = JOptionPane.showOptionDialog(this, "¿Desea cerrar la aplicacion?", "Cerrar App", JOptionPane.WARNING_MESSAGE, 0, null, botones, this);
			if (eleccion == JOptionPane.YES_OPTION) {
				System.exit(0);
			}else if(eleccion == JOptionPane.NO_OPTION) {
				
			}
		}
		if (e.getSource()==btnAtras) {
			this.setVisible(false);
			new VentanaMoneda();
		}
	}
}
