package examen.vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import examen.controladores.ControladorContrato;
import examen.entidades.Contrato;
import tablaEstudiante.controladores.ControladorEstudianteJPA;
import tablaEstudiante.entities.Estudiante;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class PanelTabla extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel dtm = null;
	private Object datosTabla[][] = DatosDeTabla.getDatosDeTabla();
	private String titulosTabla[] = DatosDeTabla.getTitulosColumnas();
	
	// Referencia al PanelEstudiante actual.
	private PanelGestionContratos panelContratos;

	/**
	 * Create the panel.
	 * Le pasamos como parámetro el PanelEstudiante que usaremos
	 * junto al JSplitPane.
	 */
	public PanelTabla(PanelGestionContratos panelContratos) {
		
		this.panelContratos = panelContratos;
		
		setLayout(new BorderLayout(0, 0));

		
		
		// Inicializamos el DefaultTableModel.
		this.dtm = getDefaultTableModel();
		// Creo la tabla utilizando el DefaultTableModel.
		this.table = new JTable(dtm);
		// Limitamos el modo selección de filas a una única selección.
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Agregamos la JTable al JScrollPane.
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
		
		// Mostramos el posible primer registro.
		showFirstRow();
		
		// Utilizo un MouseListener para conseguir que al seleccionar una fila
		// se muestre en el Panel Estudiante.
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				// Mostramos los datos del registro.
				showSelectedRow();
			}
		});

	}
	
	
	
	
	
	
	/**
	 * Selecciona y muestra el posible primer registro.
	 */
	public void showFirstRow() {
		if (this.dtm.getRowCount() > 0) {
			this.table.setRowSelectionInterval(0, 0);
			// Mostramos los datos del registro.
			showSelectedRow();
		}
	}
	
	/**
	 * Método que consigue actualizar los valores de la tabla.
	 */
	public void updateTable() {
		// Obtenemos los datos actualizados de la BBDD.
		this.datosTabla = DatosDeTabla.getDatosDeTabla();
		this.dtm.setDataVector(datosTabla, titulosTabla);
		// Se notifican los posibles cambios de las celdas de la tabla.
		this.dtm.fireTableDataChanged();
	}
	
	/**
	 * Mostramos en el panel Estudiante el registro seleccionado 
	 * en la tabla. Para ello, hacemos uso de la variable referencia 
	 * panelEstudiante.
	 */
	public void showSelectedRow() {
		try {
			int indexRow = table.getSelectedRow();
			Integer idCelda = (Integer) dtm.getValueAt(indexRow, 0);
			Contrato cont = (Contrato) ControladorContrato
					.getInstance().findById(idCelda);
			this.panelContratos.muestraEnPantalla(cont);
		} catch (Exception e) {
			this.panelContratos.muestraEnPantalla(null);
		}
	}
	
	/**
	 * Selecciona y muestra un registro en la tabla según el id del mismo.
	 * @param e
	 */
	public void selectRowById(Estudiante e) {
		for (int i = 0; i < this.dtm.getRowCount(); i++) {
			Integer idCell = (Integer) this.dtm.getValueAt(i, 0);
			if (idCell == e.getId()) {
				this.table.setRowSelectionInterval(i, i);
				showSelectedRow();
			}
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private DefaultTableModel getDefaultTableModel() {
		DefaultTableModel dtm = 
				new DefaultTableModel(datosTabla, titulosTabla) {
			
			/**
			 * La sobreescritura de este método nos permite controlar 
			 * qué celdas queremos que sean editables
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
			
			
		};
		return dtm;
	}

}
