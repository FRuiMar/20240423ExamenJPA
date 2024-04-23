package examen.vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;

import examen.controladores.ControladorContrato;
import examen.controladores.ControladorUsuario;
import examen.entidades.Contrato;
import examen.entidades.Usuario;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelGestionContratos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfDescripcion;
	private JTextField jtfId;
	private JTextField jtfSaldo;
	private JTextField jtfLimite;
	private JTextField jtfFechaFirma;
	JComboBox jcbUsuario; 
	private ButtonGroup jBGroup;
	JRadioButton rbtPrestamo;
	JRadioButton rbtCredito;
	JRadioButton rbtCuenta;
	JRadioButton rbtDebito;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	
	
	
	/**
	 * Create the panel.
	 */
	public PanelGestionContratos() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 96, 118, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblGestinDeContratos = new JLabel("Gestión de contratos");
		lblGestinDeContratos.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblGestinDeContratos = new GridBagConstraints();
		gbc_lblGestinDeContratos.gridwidth = 4;
		gbc_lblGestinDeContratos.insets = new Insets(0, 0, 5, 0);
		gbc_lblGestinDeContratos.gridx = 0;
		gbc_lblGestinDeContratos.gridy = 0;
		add(lblGestinDeContratos, gbc_lblGestinDeContratos);
		
		JLabel lblNewLabel = new JLabel("Id: ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(5, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 3;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo de contrato: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridheight = 2;
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		rbtCuenta = new JRadioButton("Cuenta Bancaria");
		GridBagConstraints gbc_rbtCuenta = new GridBagConstraints();
		gbc_rbtCuenta.fill = GridBagConstraints.HORIZONTAL;
		gbc_rbtCuenta.insets = new Insets(0, 0, 5, 5);
		gbc_rbtCuenta.gridx = 1;
		gbc_rbtCuenta.gridy = 2;
		add(rbtCuenta, gbc_rbtCuenta);
		
		rbtCredito = new JRadioButton("Tarjeta Crédito");
		GridBagConstraints gbc_rbtCredito = new GridBagConstraints();
		gbc_rbtCredito.insets = new Insets(0, 0, 5, 5);
		gbc_rbtCredito.gridx = 2;
		gbc_rbtCredito.gridy = 2;
		add(rbtCredito, gbc_rbtCredito);
		
		rbtDebito = new JRadioButton("Tarjeta débito");
		GridBagConstraints gbc_rbtDebito = new GridBagConstraints();
		gbc_rbtDebito.fill = GridBagConstraints.HORIZONTAL;
		gbc_rbtDebito.insets = new Insets(0, 0, 5, 5);
		gbc_rbtDebito.gridx = 1;
		gbc_rbtDebito.gridy = 3;
		add(rbtDebito, gbc_rbtDebito);
		
		rbtPrestamo = new JRadioButton("Préstamo");
		GridBagConstraints gbc_rbtPrestamo = new GridBagConstraints();
		gbc_rbtPrestamo.insets = new Insets(0, 0, 5, 5);
		gbc_rbtPrestamo.gridx = 2;
		gbc_rbtPrestamo.gridy = 3;
		add(rbtPrestamo, gbc_rbtPrestamo);
		
		
		jBGroup = new ButtonGroup();
		jBGroup.add(rbtCuenta);
		jBGroup.add(rbtCredito);
		jBGroup.add(rbtDebito);
		jBGroup.add(rbtPrestamo);
		
		
		JLabel lblDescripcion = new JLabel("Descripcion: ");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcion.insets = new Insets(20, 0, 5, 5);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 4;
		add(lblDescripcion, gbc_lblDescripcion);
		
		jtfDescripcion = new JTextField();
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.gridwidth = 3;
		gbc_jtfDescripcion.insets = new Insets(20, 0, 5, 0);
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 4;
		add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario: ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 5;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbUsuario = new JComboBox<Usuario>();
		GridBagConstraints gbc_jcbUsuario = new GridBagConstraints();
		gbc_jcbUsuario.gridwidth = 2;
		gbc_jcbUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_jcbUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbUsuario.gridx = 1;
		gbc_jcbUsuario.gridy = 5;
		add(jcbUsuario, gbc_jcbUsuario);
		
		JButton jbrtGestionarUsu = new JButton("Gestionar usuario");
		GridBagConstraints gbc_jbrtGestionarUsu = new GridBagConstraints();
		gbc_jbrtGestionarUsu.insets = new Insets(0, 0, 5, 0);
		gbc_jbrtGestionarUsu.gridx = 3;
		gbc_jbrtGestionarUsu.gridy = 5;
		add(jbrtGestionarUsu, gbc_jbrtGestionarUsu);
		
		JLabel lblSaldo = new JLabel("Saldo (€): ");
		GridBagConstraints gbc_lblSaldo = new GridBagConstraints();
		gbc_lblSaldo.anchor = GridBagConstraints.EAST;
		gbc_lblSaldo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaldo.gridx = 0;
		gbc_lblSaldo.gridy = 6;
		add(lblSaldo, gbc_lblSaldo);
		
		jtfSaldo = new JTextField();
		GridBagConstraints gbc_jtfSaldo = new GridBagConstraints();
		gbc_jtfSaldo.gridwidth = 3;
		gbc_jtfSaldo.insets = new Insets(0, 0, 5, 5);
		gbc_jtfSaldo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSaldo.gridx = 1;
		gbc_jtfSaldo.gridy = 6;
		add(jtfSaldo, gbc_jtfSaldo);
		jtfSaldo.setColumns(10);
		
		JLabel lblLimite = new JLabel("Limite (€): ");
		GridBagConstraints gbc_lblLimite = new GridBagConstraints();
		gbc_lblLimite.anchor = GridBagConstraints.EAST;
		gbc_lblLimite.insets = new Insets(0, 0, 5, 5);
		gbc_lblLimite.gridx = 0;
		gbc_lblLimite.gridy = 7;
		add(lblLimite, gbc_lblLimite);
		
		jtfLimite = new JTextField();
		GridBagConstraints gbc_jtfLimite = new GridBagConstraints();
		gbc_jtfLimite.gridwidth = 3;
		gbc_jtfLimite.insets = new Insets(0, 0, 5, 5);
		gbc_jtfLimite.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLimite.gridx = 1;
		gbc_jtfLimite.gridy = 7;
		add(jtfLimite, gbc_jtfLimite);
		jtfLimite.setColumns(10);
		
		JLabel lblFechaDeFirma = new JLabel("Fecha de firma: ");
		GridBagConstraints gbc_lblFechaDeFirma = new GridBagConstraints();
		gbc_lblFechaDeFirma.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeFirma.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeFirma.gridx = 0;
		gbc_lblFechaDeFirma.gridy = 8;
		add(lblFechaDeFirma, gbc_lblFechaDeFirma);
		
		jtfFechaFirma = new JTextField();
		GridBagConstraints gbc_jtfFechaFirma = new GridBagConstraints();
		gbc_jtfFechaFirma.gridwidth = 3;
		gbc_jtfFechaFirma.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFechaFirma.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFechaFirma.gridx = 1;
		gbc_jtfFechaFirma.gridy = 8;
		add(jtfFechaFirma, gbc_jtfFechaFirma);
		jtfFechaFirma.setColumns(10);
		
		JButton jbtGuardar = new JButton("Guardar");
		jbtGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarContrato();
			}
		});
		GridBagConstraints gbc_jbtGuardar = new GridBagConstraints();
		gbc_jbtGuardar.gridwidth = 4;
		gbc_jbtGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_jbtGuardar.gridx = 0;
		gbc_jbtGuardar.gridy = 9;
		add(jbtGuardar, gbc_jbtGuardar);

		
		loadAllUsuarios();
		
	}

	
	/**
	 * 
	 * @param panel
	 */
	private void showJDialogUsuario() {
		
		JDialog dialogo = new JDialog();
		dialogo.setResizable(true);
		
		dialogo.setTitle("Gestión de Usuarios");
		
//		dialogo.setContentPane(new PanelGestionContratos(this, dialogo));
		
		dialogo.pack();
		// El usuario no puede hacer clic sobre la ventana padre, si el Di�logo es modal
		dialogo.setModal(true);
		// Centro el di�logo en pantalla
		dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - dialogo.getWidth()/2, 
				(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - dialogo.getHeight()/2);
		// Muestro el di�logo en pantalla
		dialogo.setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private void loadAllUsuarios() {
		
		
		
		List<Usuario> lista = (List<Usuario>) ControladorUsuario
				.getInstance().findAll();
		for (Usuario ts : lista) {
			this.jcbUsuario.addItem(ts);
		}
	}
	
	
	
	private void guardarContrato() {
		
		if (!isDescripcionValida()) {
			JOptionPane.showMessageDialog(null,
					"Error. La descripción debe tener una longitud mínima "
					+ "de 6 caracteres cualesquiera");
			return;
		}
		
		
		
		
		Contrato c = new Contrato();
		
		c.setId(Integer.parseInt(this.jtfId.getText()));
		
		if (this.rbtCuenta.isSelected()) {
			c.setIdTipoContrato(1);
		} else if (this.rbtDebito.isSelected()) {
			c.setIdTipoContrato(2);
		} else if (this.rbtCredito.isSelected()) {
			c.setIdTipoContrato(3);
		} else {
			c.setIdTipoContrato(4);
		}
		
		
		
		
		c.setDescripcion(this.jtfDescripcion.getText());
		
		//c.setUsuario jcombo;
		
		
		
		c.setSaldo(Float.parseFloat(this.jtfSaldo.getText()));
		
		c.setLimite(Float.parseFloat(this.jtfLimite.getText()));
		
		
		String str = this.jtfFechaFirma.getText();
		if (!str.trim().equals("")) {
			try {
				c.setFechaFirma(sdf.parse(this.jtfFechaFirma.getText()));
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null,
						"Error. La fecha de alta debe tener el siguiente formato: dd/MM/yyyy");
				return;
			}
		} else {
			c.setFechaFirma(null);
		}
		
		ControladorContrato.getInstance().updateContrato(c);
		
	
	}
	
	
	
	
	private boolean isDescripcionValida() {
		String strDescrip = this.jtfDescripcion.getText();
		
		if (strDescrip.matches("[a-zA-Z0-9]{4,}")) {
			return true;
		}
		return false;
	}
	
	
	
	
}
