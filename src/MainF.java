import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import java.awt.GridBagLayout;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.Choice;

import javax.swing.JSpinner;

import java.awt.List;

import javax.swing.JList;
import javax.swing.SpinnerListModel;
import javax.swing.JCheckBox;

import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Font;

import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;

import java.awt.Component;

import javax.swing.Box;

import java.awt.TextField;
import java.awt.Cursor;

import javax.swing.table.DefaultTableModel;

import java.awt.Canvas;

import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.AbstractListModel;
import javax.swing.DebugGraphics;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;


public class MainF extends JFrame {

	private JPanel mainPane;
	private JList cartTable;
	private JList checkOutList;
	private JPasswordField textFieldSearch;
	private JTextField fornamn;
	private JTextField efternamn;
	private JTextField personnummer;
	private JTextField gatuadress;
	private JTextField postnummer;
	private JTextField stad;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	private JPasswordField passwordField;
	private Boolean loggdin = false;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainF frame = new MainF();
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
	public MainF() {
		setType(Type.POPUP);
		setResizable(false);
		setTitle("MainFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1072, 527);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1068, 22);
		mainPane.add(menuBar);
		
		JMenu mnArkiv = new JMenu("Arkiv");
		menuBar.add(mnArkiv);
		
		JMenuItem mntmLoggaUt = new JMenuItem("Logga ut");
		mntmLoggaUt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnArkiv.add(mntmLoggaUt);
		
		JMenuItem mntmSk = new JMenuItem("S\u00F6k");
		mnArkiv.add(mntmSk);
		
		JSeparator arkivSeparator = new JSeparator();
		mnArkiv.add(arkivSeparator);
		
		JMenuItem mntmAvsluta = new JMenuItem("Avsluta");
		mnArkiv.add(mntmAvsluta);
		
		JMenu mnRedigera = new JMenu("Redigera");
		menuBar.add(mnRedigera);
		
		JMenuItem mntmInstllningar = new JMenuItem("Installningar");
		mnRedigera.add(mntmInstllningar);
		
		JMenuItem mntmVisa = new JMenuItem("Visa");
		mnRedigera.add(mntmVisa);
		
		JMenu mnHjlp = new JMenu("Hj\u00E4lp");
		menuBar.add(mnHjlp);
		
		JMenuItem mntmOm = new JMenuItem("Om");
		mnHjlp.add(mntmOm);
		
		JTabbedPane tabPane = new JTabbedPane(JTabbedPane.TOP);
		tabPane.setBorder(null);
		tabPane.setBounds(0, 25, 881, 473);
		mainPane.add(tabPane);
		
		
		JPanel searchTab = new JPanel();
		searchTab.setLocation(0, 25);
		tabPane.addTab("Sök", null, searchTab, null);
		searchTab.setLayout(null);
		
		JLabel lblSkord = new JLabel("S\u00F6kord:");
		lblSkord.setBounds(12, 17, 44, 16);
		searchTab.add(lblSkord);
		
		JLabel lblVisaEndast = new JLabel("Visa endast:");
		lblVisaEndast.setBounds(427, 17, 70, 16);
		searchTab.add(lblVisaEndast);
		
		textFieldSearch = new JPasswordField();
		textFieldSearch.setBounds(58, 15, 200, 20);
		searchTab.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		final JCheckBox chckbxAnaloga = new JCheckBox("Analoga");
		chckbxAnaloga.setSelected(true);
		chckbxAnaloga.setBounds(507, 13, 71, 24);
		searchTab.add(chckbxAnaloga);
		
		final JCheckBox chckbxDigitala = new JCheckBox("Digitala");
		chckbxDigitala.setSelected(true);
		chckbxDigitala.setBounds(585, 13, 67, 24);
		searchTab.add(chckbxDigitala);
		
		final JCheckBox chckbxLjudfiler = new JCheckBox("Ljudfiler");
		chckbxLjudfiler.setSelected(true);
		chckbxLjudfiler.setBounds(663, 13, 71, 24);
		searchTab.add(chckbxLjudfiler);
		
		JButton btnSk = new JButton("S\u00F6k");
		btnSk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String serchString = textFieldSearch.getText();
				boolean booleanChckbxAnaloga = chckbxAnaloga.isSelected();
				boolean booleanChckbxDigitala = chckbxDigitala.isSelected();
				boolean booleanChckbxLjudfiler = chckbxLjudfiler.isSelected();
				
				System.out.println("String från textfält: " + serchString 
									+". Analog:" + booleanChckbxAnaloga
									+". Digital:"+ booleanChckbxDigitala
									+". Ljudfil:" + booleanChckbxLjudfiler);
				
			}
		});
		btnSk.setBounds(367, 12, 56, 26);
		searchTab.add(btnSk);
		

		
		JPanel searchTablePanel = new JPanel();
		searchTablePanel.setBounds(0, 50, 875, 401);
		searchTab.add(searchTablePanel);
		searchTablePanel.setLayout(null);
		
		String[] hej = {"hej"};
		JList searchList = new JList(hej);
		searchList.setBounds(0, 0, 875, 390);
		searchTablePanel.add(searchList);
		
		JButton btnLggTillKundkorg = new JButton("L\u00E4gg till kundkorg");
		btnLggTillKundkorg.setBounds(740, 12, 135, 26);
		searchTab.add(btnLggTillKundkorg);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Fritext", "Titel", "F\u00F6rfattare", "ISBN"}));
		comboBox.setBounds(260, 13, 84, 25);
		searchTab.add(comboBox);
		
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(735, 0, 2, 50);
		searchTab.add(separator);
		
		JPanel checkOutTab = new JPanel();
		tabPane.addTab("Checka ut", null, checkOutTab, null);
		checkOutTab.setLayout(null);
		
		JButton btnBekrftaLn = new JButton("Bekr\u00E4fta l\u00E5n");
		btnBekrftaLn.setBounds(10, 15, 103, 26);
		checkOutTab.add(btnBekrftaLn);
		
		JButton btnAvbrytLn = new JButton("Avbryt l\u00E5n");
		btnAvbrytLn.setBounds(125, 15, 103, 26);
		checkOutTab.add(btnAvbrytLn);
		
		JPanel checkOutTabelPanel = new JPanel();
		checkOutTabelPanel.setBounds(0, 49, 875, 404);
		checkOutTab.add(checkOutTabelPanel);
		checkOutTabelPanel.setLayout(null);
		
		checkOutList = new JList();
		checkOutList.setBounds(0, 0, 875, 378);
		checkOutTabelPanel.add(checkOutList);
		checkOutList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel newUserTab = new JPanel();
		tabPane.addTab("Ny Anv\u00E4ndare", null, newUserTab, null);
		tabPane.setForegroundAt(2, new Color(0, 0, 0));
		newUserTab.setLayout(null);
		
		JSeparator nyAnvändareSeparatorHorisont = new JSeparator();
		nyAnvändareSeparatorHorisont.setBounds(0, 50, 875, 2);
		newUserTab.add(nyAnvändareSeparatorHorisont);
		
		JSeparator nyAnvändareSeparatorVertikal = new JSeparator();
		nyAnvändareSeparatorVertikal.setOrientation(SwingConstants.VERTICAL);
		nyAnvändareSeparatorVertikal.setBounds(163, 52, 6, 393);
		newUserTab.add(nyAnvändareSeparatorVertikal);
		
		JButton btnSkapa = new JButton("Skapa");
		btnSkapa.setBounds(174, 336, 200, 23);
		newUserTab.add(btnSkapa);
		
		JLabel lblFrnamn = new JLabel("F\u00F6rnamn:");
		lblFrnamn.setBounds(107, 73, 53, 16);
		newUserTab.add(lblFrnamn);
		
		JLabel lblEfternamn = new JLabel("Efternamn:");
		lblEfternamn.setBounds(98, 104, 62, 16);
		newUserTab.add(lblEfternamn);
		
		JLabel lblPersonnummer = new JLabel("Personnummer:");
		lblPersonnummer.setBounds(68, 135, 92, 16);
		newUserTab.add(lblPersonnummer);
		
		JLabel lblGatuadress = new JLabel("Gatuadress:");
		lblGatuadress.setBounds(91, 166, 69, 16);
		newUserTab.add(lblGatuadress);
		
		JLabel lblPostnummer = new JLabel("Postnummer:");
		lblPostnummer.setBounds(83, 197, 77, 16);
		newUserTab.add(lblPostnummer);
		
		JLabel lblStad = new JLabel("Stad:");
		lblStad.setBounds(131, 228, 29, 16);
		newUserTab.add(lblStad);
		
		JLabel lblLsenord = new JLabel("L\u00F6senord:");
		lblLsenord.setBounds(103, 259, 57, 16);
		newUserTab.add(lblLsenord);
		
		JLabel lblLsenordIgen = new JLabel("L\u00F6senord igen:");
		lblLsenordIgen.setBounds(76, 290, 84, 16);
		newUserTab.add(lblLsenordIgen);
		
		fornamn = new JTextField();
		fornamn.setBounds(174, 73, 200, 20);
		newUserTab.add(fornamn);
		fornamn.setColumns(10);
		
		efternamn = new JTextField();
		efternamn.setColumns(10);
		efternamn.setBounds(174, 104, 200, 20);
		newUserTab.add(efternamn);
		
		personnummer = new JTextField();
		personnummer.setColumns(10);
		personnummer.setBounds(174, 135, 200, 20);
		newUserTab.add(personnummer);
		
		gatuadress = new JTextField();
		gatuadress.setColumns(10);
		gatuadress.setBounds(174, 166, 200, 20);
		newUserTab.add(gatuadress);
		
		postnummer = new JTextField();
		postnummer.setColumns(10);
		postnummer.setBounds(174, 197, 200, 20);
		newUserTab.add(postnummer);
		
		stad = new JTextField();
		stad.setColumns(10);
		stad.setBounds(174, 228, 200, 20);
		newUserTab.add(stad);
		
		passwordField1 = new JPasswordField();
		passwordField1.setBounds(174, 259, 200, 20);
		newUserTab.add(passwordField1);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(174, 290, 200, 20);
		newUserTab.add(passwordField2);
		
		JPanel MyPageTabPanel = new JPanel();
		MyPageTabPanel.setVisible(false);
		
		tabPane.addTab("Min sida", null, MyPageTabPanel, null);
		tabPane.setEnabledAt(3, true);
		
		JLabel lblTest = new JLabel("Test");
		MyPageTabPanel.add(lblTest);
		
		JPanel cartPane = new JPanel();
		cartPane.setBounds(885, 25, 167, 462);
		cartPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Kundkorg", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mainPane.add(cartPane);
		cartPane.setLayout(null);
		
		final JPanel loginPanel = new JPanel();
			if(loggdin == false){
				loginPanel.setVisible(true);
			}else{
				loginPanel.setVisible(false);
			}
		
		loginPanel.setBounds(0, 0, 179, 421);
		cartPane.add(loginPanel);
		loginPanel.setLayout(null);
		
		JLabel label = new JLabel("Anv\u00E4ndarnamn:");
		label.setBounds(new Rectangle(45, 25, 89, 16));
		loginPanel.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(new Rectangle(33, 41, 112, 20));
		loginPanel.add(textField);
		
		JLabel label_1 = new JLabel("L\u00F6senord:");
		label_1.setBounds(new Rectangle(61, 70, 57, 16));
		loginPanel.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(33, 86, 112, 20);
		loginPanel.add(passwordField);
		
		final JButton btnAvbryt = new JButton("T\u00F6m kundkorg");
		btnAvbryt.setVisible(false);
		btnAvbryt.setBounds(31, 425, 99, 23);
		cartPane.add(btnAvbryt);
		btnAvbryt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton button = new JButton("Logga in");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loggdin = true;
				loginPanel.setVisible(false);
				btnAvbryt.setVisible(true);

				
			}
		});
		button.setBounds(new Rectangle(0, 15, 0, 0));
		button.setBounds(33, 117, 112, 23);
		loginPanel.add(button);
		
		JButton button_1 = new JButton("Gl\u00F6mt L\u00F6sen?");
		button_1.setBounds(new Rectangle(0, 15, 0, 0));
		button_1.setBounds(33, 151, 112, 26);
		loginPanel.add(button_1);
		
		cartTable = new JList();
		cartTable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cartTable.setBounds(10, 16, 147, 398);
		cartPane.add(cartTable);
		

		
		JLabel versionNr = new JLabel("v.0.2");
		versionNr.setFont(new Font("Tahoma", Font.PLAIN, 11));
		versionNr.setForeground(Color.GRAY);
		versionNr.setBounds(1022, 484, 46, 14);
		mainPane.add(versionNr);
		System.out.println(tabPane.getTabCount() + " " + tabPane.getTitleAt(3));
		tabPane.setEnabledAt(3, false);
		
		
	}
	
	public Boolean getLoggdin() {
		return loggdin;
	}

	public void setLoggdin(Boolean loggdin) {
		this.loggdin = loggdin;
	}
}
