package examen.vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import examen.controladores.ControladorContrato;
import examen.controladores.ControladorUsuario;
import examen.entidades.Contrato;
import examen.entidades.Usuario;


import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class PanelGestionUsuarios extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfIdUsu;
	private JTextField jtfUsuario;

	private JTextField jtfEmail;
	private JPasswordField jpassword;

	private PanelGestionContratos panelGestionContratos;
	private JDialog jd;

	private JComboBox jcbColorPreferido;
	
	
	
	/**
	 * Create the panel.
	 */
	public PanelGestionUsuarios(PanelGestionContratos panelGestionContratos, JDialog jd) {

		this.panelGestionContratos = panelGestionContratos;
		this.jd = jd;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Id: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfIdUsu = new JTextField();
		GridBagConstraints gbc_jtfIdUsu = new GridBagConstraints();
		gbc_jtfIdUsu.insets = new Insets(0, 0, 5, 0);
		gbc_jtfIdUsu.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfIdUsu.gridx = 1;
		gbc_jtfIdUsu.gridy = 1;
		add(jtfIdUsu, gbc_jtfIdUsu);
		jtfIdUsu.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Usuario: ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfUsuario = new JTextField();
		GridBagConstraints gbc_jtfUsuario = new GridBagConstraints();
		gbc_jtfUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_jtfUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUsuario.gridx = 1;
		gbc_jtfUsuario.gridy = 2;
		add(jtfUsuario, gbc_jtfUsuario);
		jtfUsuario.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Contraseña: ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		jpassword = new JPasswordField();
		GridBagConstraints gbc_jpassword = new GridBagConstraints();
		gbc_jpassword.insets = new Insets(0, 0, 5, 0);
		gbc_jpassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_jpassword.gridx = 1;
		gbc_jpassword.gridy = 3;
		add(jpassword, gbc_jpassword);

		JLabel lblNewLabel_4 = new JLabel("Email: ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);

		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 4;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);

		JLabel lblColorPreferido = new JLabel("Color preferido:");
		GridBagConstraints gbc_lblColorPreferido = new GridBagConstraints();
		gbc_lblColorPreferido.anchor = GridBagConstraints.EAST;
		gbc_lblColorPreferido.insets = new Insets(0, 0, 5, 5);
		gbc_lblColorPreferido.gridx = 0;
		gbc_lblColorPreferido.gridy = 5;
		add(lblColorPreferido, gbc_lblColorPreferido);

		jcbColorPreferido = new JComboBox<String>();
		jcbColorPreferido.addItem("#FF00FF");
		jcbColorPreferido.addItem("#9890A5"); 
		jcbColorPreferido.addItem("#765456");
		jcbColorPreferido.addItem("#879876");
		GridBagConstraints gbc_jcbColorPreferido = new GridBagConstraints();
		gbc_jcbColorPreferido.insets = new Insets(0, 0, 5, 0);
		gbc_jcbColorPreferido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbColorPreferido.gridx = 1;
		gbc_jcbColorPreferido.gridy = 5;
		add(jcbColorPreferido, gbc_jcbColorPreferido);

		JButton jbtGuardarUsuarios = new JButton("Guardar");
		jbtGuardarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		GridBagConstraints gbc_jbtGuardarUsuarios = new GridBagConstraints();
		gbc_jbtGuardarUsuarios.gridwidth = 2;
		gbc_jbtGuardarUsuarios.gridx = 0;
		gbc_jbtGuardarUsuarios.gridy = 6;
		add(jbtGuardarUsuarios, gbc_jbtGuardarUsuarios);

		 showUsuario();

	}

	private void showUsuario() {

		Usuario u = (Usuario) this.panelGestionContratos.jcbUsuario.getSelectedItem();

		if (u != null) {
			this.jtfIdUsu.setText("" + u.getId());
			this.jtfUsuario.setText(u.getNombreUsuario());
			this.jpassword.setText(u.getPassword());
			this.jtfEmail.setText(u.getEmail());
			
			for (int i = 0; i < this.jcbColorPreferido.getItemCount(); i++) {
				if (this.jcbColorPreferido.getItemAt(i).equals(u.getColorPreferido())) {
					this.jcbColorPreferido.setSelectedIndex(i);
				}
			}

		}
	}

	
	
	
	private void guardar() {
		
		Usuario u = new Usuario();

		u.setId(Integer.parseInt(this.jtfIdUsu.getText()));
		u.setNombreUsuario(this.jtfUsuario.getText());
		u.setPassword(this.jpassword.getText());
		u.setEmail(this.jtfEmail.getText());
		
		/// tengo qu ehacer la lista de colores primero
		String color = this.jcbColorPreferido.getSelectedItem()).getName();
		u.setColorPreferido(color);


		ControladorUsuario.getInstance().updateUsuario(u);

		
		
		this.jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.jd.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				panelGestionContratos.loadAllContratos();
				
				int idArticuloActual = Integer.parseInt(panelGestionContratos.get().getText());
				Contrato a = (Contrato) ControladorContrato
						.getInstance().findById(idArticuloActual);
				panelGestionContratos.showContrato(a);
			}
		});
	}
		
		
		
		
		
}

	
	
	
	
	

