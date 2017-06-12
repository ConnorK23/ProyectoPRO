package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladorClientes;
import controller.ControladorPeliculas;
import controller.ControladorPrestamos;
import dao.ClientesDAO;
import dao.PeliculasDAO;
import dao.PrestamosDAO;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaPrestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblRealizadoPorJess = new JLabel("Realizado por: Jes\u00FAs L\u00F3pez Extremera");
		lblRealizadoPorJess.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblRealizadoPorJess, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaPeliculas frame = new VistaPeliculas();
    			PeliculasDAO peliculasDAO = new PeliculasDAO();
    			new ControladorPeliculas(frame, peliculasDAO);
				frame.setVisible(true);
        		Principal.this.dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon("Images/film-icon_30381-iloveimg-resized.png"));
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaClientes frame = new VistaClientes();
    			ClientesDAO clientesDAO = new ClientesDAO();
    			new ControladorClientes(frame, clientesDAO);
				frame.setVisible(true);
        		Principal.this.dispose();
			}
		});
		button.setIcon(new ImageIcon("Images/folder_customer_256-iloveimg-resized.png"));
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaPrestamos frame = new VistaPrestamos();
    			PrestamosDAO prestamosDAO = new PrestamosDAO();
    			new ControladorPrestamos(frame, prestamosDAO);
				frame.setVisible(true);
        		Principal.this.dispose();
			}
		});
		button_1.setIcon(new ImageIcon("Images/iconos-para-prestamos_Credixpress-05-iloveimg-resized.png"));
		
		JLabel lblPeliculas = new JLabel("Peliculas");
		
		JLabel lblClientes = new JLabel("Clientes");
		
		JLabel lblPrestamos = new JLabel("Prestamos");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(button_1)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(48)
					.addComponent(lblClientes)
					.addGap(101)
					.addComponent(lblPeliculas)
					.addPreferredGap(ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
					.addComponent(lblPrestamos)
					.addGap(46))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblClientes)
						.addComponent(lblPeliculas)
						.addComponent(lblPrestamos))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button_1)
						.addComponent(btnNewButton)
						.addComponent(button))
					.addGap(58))
		);
		panel.setLayout(gl_panel);
		this.setLocationRelativeTo(null);
	}
}
