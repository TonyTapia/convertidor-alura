package VentanasPeso;

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

public class ConvertidorPeso extends JFrame implements ActionListener{
	
	
	private JPanel panelConvertidorPeso;
	private JComboBox<String> comboBoxConvertidorPeso;
	private JButton  btnAceptarConvertidor,btnCancelarConvertidor,btnAtras;
	
	private double cantidadPeso;
	private int indexCombo;
	
	private String[] opcionesConvertidor = {"Selecciona","De Gramos a Miligramo","De Gramos a Onzas", 
			"De Gramos a Libras", "De Gramos a Kilos","De Kilos a Toneladas","De Miligramo a Gramos",
			"De Onza a Gramos","De Libas a Gramos","De Kilos a Gramos",
			"De Toneladas a Kilos"};
	
	public ConvertidorPeso(double cantidadPeso){
		this.cantidadPeso = cantidadPeso;
		setType(Type.UTILITY);
		setFont(new Font("Arial", Font.PLAIN, 18));
		setForeground(new Color(0, 0, 0));
		setTitle("Cantidad de Monedas: "+cantidadPeso);
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(453, 144);
		setLocationRelativeTo(null);
		setVisible(true);
		iniciarComponentesConvertidor();
	}

	private void iniciarComponentesConvertidor() {
		getContentPane().setLayout(null);
		
		panelConvertidorPeso = new JPanel();
		panelConvertidorPeso.setBackground(new Color(230, 230, 230));
		panelConvertidorPeso.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelConvertidorPeso);
		panelConvertidorPeso.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Selecciona un convertidor:");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 22));
		lblTitulo.setBounds(0, 11, 437, 29);
		panelConvertidorPeso.add(lblTitulo);
		
		comboBoxConvertidorPeso = new JComboBox();
		comboBoxConvertidorPeso.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxConvertidorPeso.setBackground(new Color(207, 231, 254));
		comboBoxConvertidorPeso.setBounds(99, 51, 245, 22);
		comboBoxConvertidorPeso.setModel(new DefaultComboBoxModel(opcionesConvertidor));
		comboBoxConvertidorPeso.setSelectedIndex(0);
		comboBoxConvertidorPeso.addActionListener(this);
		panelConvertidorPeso.add(comboBoxConvertidorPeso);
		
		btnAceptarConvertidor = new JButton("ACEPTAR");
		btnAceptarConvertidor.setForeground(new Color(0, 0, 0));
		btnAceptarConvertidor.setBackground(new Color(191, 255, 194));
		btnAceptarConvertidor.setFont(new Font("Arial", Font.BOLD, 12));
		btnAceptarConvertidor.setBounds(173, 84, 89, 23);
		btnAceptarConvertidor.addActionListener(this);
		panelConvertidorPeso.add(btnAceptarConvertidor);
		
		btnCancelarConvertidor = new JButton("SALIR");
		btnCancelarConvertidor.setForeground(Color.BLACK);
		btnCancelarConvertidor.setFont(new Font("Arial", Font.BOLD, 12));
		btnCancelarConvertidor.setBackground(new Color(255, 55, 55));
		btnCancelarConvertidor.setBounds(325, 84, 102, 23);
		btnCancelarConvertidor.addActionListener(this);
		panelConvertidorPeso.add(btnCancelarConvertidor);
		
		btnAtras = new JButton("ATRAS...");
		btnAtras.setForeground(Color.BLACK);
		btnAtras.setFont(new Font("Arial", Font.BOLD, 12));
		btnAtras.setBackground(new Color(191, 255, 194));
		btnAtras.setBounds(10, 84, 89, 23);
		btnAtras.addActionListener(this);
		panelConvertidorPeso.add(btnAtras);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==comboBoxConvertidorPeso) {
			indexCombo = comboBoxConvertidorPeso.getSelectedIndex();
		}
		if(e.getSource()==btnAceptarConvertidor) {
			switch(indexCombo) {
				case 0:
					JOptionPane.showMessageDialog(null, "Seleccione un opcion");
					break;
				case 1:
					this.setVisible(false);
					new Peso(cantidadPeso,1000," Miligramos.");
					break;
				case 2:
					this.setVisible(false);
					new Peso(cantidadPeso,0.035," Onzas.");
					break;
				case 3:
					this.setVisible(false);
					new Peso(cantidadPeso,0.0022," Libras.");
					break;
				case 4:
					this.setVisible(false);
					new Peso(cantidadPeso,0.001," Kilos.");
					break;
				case 5:
					this.setVisible(false);
					new Peso(cantidadPeso,0.001," Toneladas.");
					break;
				case 6:
					this.setVisible(false);
					new Peso(cantidadPeso,0.001," Gramos.");
					break;
				case 7:
					this.setVisible(false);
					new Peso(cantidadPeso,28.349," Gramos.");
					break;
				case 8:
					this.setVisible(false);
					new Peso(cantidadPeso,453.592," Gramos.");
					break;
				case 9:
					this.setVisible(false);
					new Peso(cantidadPeso,1000," Gramos.");
					break;
				case 10:
					this.setVisible(false);
					new Peso(cantidadPeso,1000," Kilos.");
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
			new VentanaPeso();
		}
	}
}
