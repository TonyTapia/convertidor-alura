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

import VentanasPeso.VentanaPeso;

public class VentanaConvertidores extends JFrame implements ActionListener{
	private JPanel panelConvertidores;
	private JComboBox<String> comboBoxConvertidor;
	private JButton btnAceptarConvertidor;
	private JButton btnCancelarConvertidor;
	private int indexCombo;

	public VentanaConvertidores() {
	
		setType(Type.UTILITY);
		setFont(new Font("Arial", Font.PLAIN, 18));
		setForeground(new Color(0, 0, 0));
		setTitle("CONVERTIDOR");
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(453, 144);
		setLocationRelativeTo(null);
		setVisible(true);
		iniciarComponentes();
		
	}
	private void iniciarComponentes() {
		getContentPane().setLayout(null);
		
		panelConvertidores = new JPanel();
		panelConvertidores.setBackground(new Color(230, 230, 230));
		panelConvertidores.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelConvertidores);
		panelConvertidores.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Selecciona un convertidor:");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 22));
		lblTitulo.setBounds(0, 11, 437, 29);
		panelConvertidores.add(lblTitulo);
		
		comboBoxConvertidor = new JComboBox<String>();
		comboBoxConvertidor.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxConvertidor.setBackground(new Color(207, 231, 254));
		comboBoxConvertidor.setBounds(99, 51, 245, 22);
		comboBoxConvertidor.setModel(new DefaultComboBoxModel(new String[] {"Selecciona", "Convertidor de moneda", "Convertidor de medida"}));
		comboBoxConvertidor.setSelectedIndex(0);
		comboBoxConvertidor.addActionListener(this);
		panelConvertidores.add(comboBoxConvertidor);
		
		btnAceptarConvertidor = new JButton("ACEPTAR");
		btnAceptarConvertidor.setForeground(new Color(0, 0, 0));
		btnAceptarConvertidor.setBackground(new Color(191, 255, 194));
		btnAceptarConvertidor.setFont(new Font("Arial", Font.BOLD, 12));
		btnAceptarConvertidor.setBounds(119, 84, 89, 23);
		btnAceptarConvertidor.addActionListener(this);
		panelConvertidores.add(btnAceptarConvertidor);
		
		btnCancelarConvertidor = new JButton("CANCELAR");
		btnCancelarConvertidor.setForeground(Color.BLACK);
		btnCancelarConvertidor.setFont(new Font("Arial", Font.BOLD, 12));
		btnCancelarConvertidor.setBackground(new Color(255, 55, 55));
		btnCancelarConvertidor.setBounds(242, 84, 102, 23);
		btnCancelarConvertidor.addActionListener(this);
		panelConvertidores.add(btnCancelarConvertidor);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==comboBoxConvertidor) {
			indexCombo = comboBoxConvertidor.getSelectedIndex();
		}
		if (e.getSource()== btnAceptarConvertidor) {
			switch(indexCombo) {
				case 0:
					JOptionPane.showMessageDialog(null, "Seleccione un opcion");
					break;					
				case 1:
					this.setVisible(false);
					new VentanaMoneda();
					break;
				case 2:
					this.setVisible(false);
					new VentanaPeso();						
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opcion invalida");			
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
	}
}
