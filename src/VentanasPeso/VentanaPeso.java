package VentanasPeso;

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

public class VentanaPeso extends JFrame implements ActionListener{
	
	private JPanel panelPeso;
	private JTextField campoPeso;
	private JButton btnValidarPeso;
	
	
	private double cantidadPeso = 0;
	
	public VentanaPeso() {
		
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
		
		panelPeso = new JPanel();
		panelPeso = new JPanel();
		panelPeso.setBackground(new Color(230, 230, 230));
		panelPeso.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPeso);
		panelPeso.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Ingrese la cantidad de monedas:");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 22));
		lblTitulo.setBounds(0, 11, 437, 29);
		panelPeso.add(lblTitulo);
		
		campoPeso = new JTextField("0");
		campoPeso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				int key = evt.getKeyChar();
				boolean numero = key >=48 && key <=57;
				
				if(!numero) {
					evt.consume();
				}
			}
		});
		campoPeso.setBounds(99, 51, 245, 22);
		campoPeso.requestFocus();
		campoPeso.selectAll();
		panelPeso.add(campoPeso);
		
		btnValidarPeso = new JButton("ACEPTAR");
		btnValidarPeso.setForeground(Color.BLACK);
		btnValidarPeso.setFont(new Font("Arial", Font.BOLD, 12));
		btnValidarPeso.setBackground(new Color(191, 255, 194));
		btnValidarPeso.setBounds(242, 84, 102, 23);
		btnValidarPeso.addActionListener(this);
		panelPeso.add(btnValidarPeso);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnValidarPeso) {
			if( campoPeso.getText().length()<=0) {
				JOptionPane.showMessageDialog(null, "dato invalido ingrese cantidad de moneda mayor a 0","Error, Dato invalido",JOptionPane.ERROR_MESSAGE);
			}
			cantidadPeso=Double.parseDouble(campoPeso.getText());
			if(cantidadPeso <= 0) {
				JOptionPane.showMessageDialog(null, "Ingrese cantidad de monedas mayor a 0","Error, Dato invalido",JOptionPane.ERROR_MESSAGE);
			}else {
				this.setVisible(false);
				new ConvertidorPeso(cantidadPeso);
			}
		}
	}
}
