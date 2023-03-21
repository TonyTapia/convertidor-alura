package VentanasMoneda;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaMoneda extends JFrame implements ActionListener{
	
	private JPanel panelMonedas;
	private JTextField campoMonedas;
	private JButton btnValidarMonedas;
	
	private double cantidadMonedas = 0;
	
	public VentanaMoneda() {
		
		setType(Type.UTILITY);
		setFont(new Font("Arial", Font.PLAIN, 18));
		setForeground(new Color(0, 0, 0));
		setTitle("Cantidad de Monedas");
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(453, 144);
		setLocationRelativeTo(null);
		setVisible(true);
		iniciarComponentesMonedas();
		
	}
	
	private void iniciarComponentesMonedas() {
		getContentPane().setLayout(null);
		
		panelMonedas = new JPanel();
		panelMonedas = new JPanel();
		panelMonedas.setBackground(new Color(230, 230, 230));
		panelMonedas.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelMonedas);
		panelMonedas.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Ingrese la cantidad de monedas:");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 22));
		lblTitulo.setBounds(0, 11, 437, 29);
		panelMonedas.add(lblTitulo);
		
		campoMonedas = new JTextField("0");
		campoMonedas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				int key = evt.getKeyChar();
				boolean numero = key >=48 && key <=57;
				
				if(!numero) {
					evt.consume();
				}
			}
		});
		campoMonedas.setBounds(99, 51, 245, 22);
		campoMonedas.requestFocus();
		campoMonedas.selectAll();
		panelMonedas.add(campoMonedas);
		
		btnValidarMonedas = new JButton("ACEPTAR");
		btnValidarMonedas.setForeground(Color.BLACK);
		btnValidarMonedas.setFont(new Font("Arial", Font.BOLD, 12));
		btnValidarMonedas.setBackground(new Color(191, 255, 194));
		btnValidarMonedas.setBounds(242, 84, 102, 23);
		btnValidarMonedas.addActionListener(this);
		panelMonedas.add(btnValidarMonedas);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnValidarMonedas) {
			if( campoMonedas.getText().length()<=0) {
				JOptionPane.showMessageDialog(null, "dato invalido ingrese cantidad de moneda mayor a 0","Error, Dato invalido",JOptionPane.ERROR_MESSAGE);
			}
			cantidadMonedas=Double.parseDouble(campoMonedas.getText());
			if(cantidadMonedas <= 0) {
				JOptionPane.showMessageDialog(null, "Ingrese cantidad de monedas mayor a 0","Error, Dato invalido",JOptionPane.ERROR_MESSAGE);
			}else {
				this.setVisible(false);
				new ConvertidorMoneda(cantidadMonedas);
			}
		}
	}
}
