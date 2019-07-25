import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class chemBud extends JFrame {

	private JPanel contentPane;
	private JTextField termEnter;
	private JTextField gibQuestion;
	private JLabel answerLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chemBud frame = new chemBud();
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
	public chemBud() {// make sure to add declaration at top to make sure it can refernce the object

		//////////////////////////////////////////////// BUTTONS///////////////////////////////////////////////////////////////////////////////////////////

		//////////////////////////////////////////////// TextField///////////////////////////////////////////////////////////////////////////////////////////

		//////////////////////////////////////////////// JLABELS///////////////////////////////////////////////////////////////////////////////////////////

		//////////////////////////////////////////////// PANNELS///////////////////////////////////////////////////////////////////////////////////////////
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 975, 588);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSwitch = new JButton("Switch!");
		btnSwitch.setActionCommand("getAnswer");//
		btnSwitch.addActionListener(new getAns());
		btnSwitch.setBounds(619, 257, 89, 23);
		contentPane.add(btnSwitch);

		// btnSwitch.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// }
		// });

		gibQuestion = new JTextField();
		gibQuestion.setBounds(330, 258, 194, 20);
		contentPane.add(gibQuestion);
		gibQuestion.setColumns(10);

		answerLabel = new JLabel("");
		answerLabel.setBounds(330, 367, 194, 14);
		contentPane.add(answerLabel);

	}

	class getAns implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("getAnswer")) {
				findIt(gibQuestion.getText());
			}
		}
	}

	public String findIt(String termEnter) {
		int stop;
		String[] subs;
		// Find type (Formula or Name)
		char whatIs = whatTypeTerm(termEnter);
		// Finds point between substances
		stop = seperateNamesC(termEnter);
		// Separates string into 2 smaller ones
		subs = funcSeperate(termEnter, stop);
		// identifies smaller or bigger form of substance
		subs = getFull(subs, whatIs);

		// Find Valence
		// Name develop
		answerLabel.setText(subs[0] + " " + subs[1]);
		// System.out.println(subs[0] + " " + subs[1]);
		String name = "not";
		return name;

	}

	public String multiValent(String sub) {
        String valence = "";
       int i = 0;
      
		int isMul = sub.indexOf('(');
		int y = isMul;
		 char valenceValue[] = new char[sub.length()-isMul];
		if (isMul >= 0)
		{
			while (y<sub.length())
			{
				valenceValue[i] = sub.charAt(y);
				i++;
				y++;
			}
		}
		valence = new String(valenceValue);
	
		return valence;
	}

	// index 0 will always be first subs and index 2 will alwasy be scond sub
	public String[] getFull(String[] subs, char type) {

		String[][] fullElement = new String[18][7];
		fullElement[0][0] = "Hydrogen";
		fullElement[17][0] = "Helium";

		fullElement[0][1] = "Lithium";
		fullElement[1][1] = "Beryllium";
		fullElement[2][1] = "Boron";
		fullElement[12][1] = "Carbon";
		fullElement[13][1] = "Nitrogen";
		fullElement[14][1] = "Oxygen";
		fullElement[15][1] = "Fluorine";
		fullElement[16][1] = "Neon";

		fullElement[0][2] = "Sodium"; ///
		fullElement[1][2] = "Magnesium";
		fullElement[2][2] = "Aluminum";
		fullElement[12][2] = "Silicon";
		fullElement[13][2] = "Phosphorus";
		fullElement[14][2] = "Sulfur";
		fullElement[15][2] = "Chlorine";
		fullElement[16][2] = "Argon";

		fullElement[0][3] = "Potassium";
		fullElement[1][3] = "Calcium";
		fullElement[2][3] = "Scandium";
		fullElement[3][3] = "Titanium";
		fullElement[4][3] = "Vanadium";
		fullElement[5][3] = "Chromium";
		fullElement[6][3] = "Manganese";
		fullElement[7][3] = "Iron";
		fullElement[8][3] = "Cobalt";
		fullElement[9][3] = "Nickel";
		fullElement[10][3] = "Copper";
		fullElement[11][3] = "Zinc";
		fullElement[12][3] = "Gallium";
		fullElement[13][3] = "Germanium";
		fullElement[14][3] = "Arsenic";
		fullElement[15][3] = "Selenium";
		fullElement[16][3] = "Bromine";
		fullElement[17][3] = "Krypton";

		fullElement[0][4] = "Rubidium";
		fullElement[1][4] = "Strontium";
		fullElement[2][4] = "Yttrium";
		fullElement[3][4] = "Zirconium";
		fullElement[4][4] = "Niobium";
		fullElement[5][4] = "Molybdenum";
		fullElement[6][4] = "Technetium";
		fullElement[7][4] = "Ruthenium";
		fullElement[8][4] = "Rhodium";
		fullElement[9][4] = "Palladium";
		fullElement[10][4] = "Silver";
		fullElement[11][4] = "Cadmium";
		fullElement[12][4] = "Indium";
		fullElement[13][4] = "Tin";
		fullElement[14][4] = "Antimony";
		fullElement[15][4] = "Tellurium";
		fullElement[16][4] = "Iodine";
		fullElement[17][4] = "Xenon";

		fullElement[0][5] = "Cesium";
		fullElement[1][5] = "Barium";
		fullElement[2][5] = "Lanthanum";
		fullElement[3][5] = "Hafnium";
		fullElement[4][5] = "Tantalum";
		fullElement[5][5] = "Tungsten";
		fullElement[6][5] = "Rhenium";
		fullElement[7][5] = "Osmium";
		fullElement[8][5] = "Iridium";
		fullElement[9][5] = "Platinum";
		fullElement[10][5] = "Gold";
		fullElement[11][5] = "Mercury";
		fullElement[12][5] = "Thallium";
		fullElement[13][5] = "Lead";
		fullElement[14][5] = "Bismuth";
		fullElement[15][5] = "Polonium";
		fullElement[16][5] = "Astatine";
		fullElement[17][5] = "Radon";

		fullElement[0][6] = "Francium";
		fullElement[1][6] = "Radium";
		fullElement[2][6] = "Actinium";
		fullElement[3][6] = "Rutherfordium";
		fullElement[4][6] = "Dubnium";
		fullElement[5][6] = "Seaborgium";
		fullElement[6][6] = "Bohrium";
		fullElement[7][6] = "Hassium";
		fullElement[8][6] = "Meitnerium";
		fullElement[9][6] = "Darmstadtium";
		fullElement[10][6] = "Roentgenium";
		fullElement[11][6] = "Copernicium";
		fullElement[12][6] = "Nihonium";
		fullElement[13][6] = "Flerovium";
		fullElement[14][6] = "Moscovium";
		fullElement[15][6] = "Livermorium";
		fullElement[16][6] = "Tennessine";
		fullElement[17][5] = "Oganesson";
		////////////////////////////////
		String[][] shortElement = new String[18][7];
		shortElement[0][0] = "H";
		shortElement[17][0] = "He";

		shortElement[0][1] = "Li";
		shortElement[1][1] = "Be";
		shortElement[2][1] = "B";
		shortElement[12][1] = "C";
		shortElement[13][1] = "N";
		shortElement[14][1] = "O";
		shortElement[15][1] = "F";
		shortElement[16][1] = "Ne";

		shortElement[0][2] = "Na"; ///
		shortElement[1][2] = "Mg";
		shortElement[2][2] = "Al";
		shortElement[12][2] = "Si";
		shortElement[13][2] = "P";
		shortElement[14][2] = "S";
		shortElement[15][2] = "Cl";
		shortElement[16][2] = "Ar";

		shortElement[0][3] = "K";
		shortElement[1][3] = "Ca";
		shortElement[2][3] = "Sc";
		shortElement[3][3] = "Ti";
		shortElement[4][3] = "V";
		shortElement[5][3] = "Cr";
		shortElement[6][3] = "Mn";
		shortElement[7][3] = "Fe";
		shortElement[8][3] = "Co";
		shortElement[9][3] = "Ni";
		shortElement[10][3] = "Cu";
		shortElement[11][3] = "Zn";
		shortElement[12][3] = "Ga";
		shortElement[13][3] = "Ge";
		shortElement[14][3] = "As";
		shortElement[15][3] = "Se";
		shortElement[16][3] = "Br";
		shortElement[17][3] = "Kr";

		shortElement[0][4] = "Rb";
		shortElement[1][4] = "Sr";
		shortElement[2][4] = "Y";
		shortElement[3][4] = "Zr";
		shortElement[4][4] = "Nb";
		shortElement[5][4] = "Mo";
		shortElement[6][4] = "Tc";
		shortElement[7][4] = "Ru";
		shortElement[8][4] = "Rh";
		shortElement[9][4] = "Pd";
		shortElement[10][4] = "Ag";
		shortElement[11][4] = "Cd";
		shortElement[12][4] = "In";
		shortElement[13][4] = "Sn";
		shortElement[14][4] = "Sb";
		shortElement[15][4] = "Te";
		shortElement[16][4] = "I";
		shortElement[17][4] = "Xe";

		shortElement[0][5] = "Cs";
		shortElement[1][5] = "Ba";
		shortElement[2][5] = "La";
		shortElement[3][5] = "Hf";
		shortElement[4][5] = "Ta";
		shortElement[5][5] = "W";
		shortElement[6][5] = "Re";
		shortElement[7][5] = "Os";
		shortElement[8][5] = "Ir";
		shortElement[9][5] = "Pt";
		shortElement[10][5] = "Au";
		shortElement[11][5] = "Hg";
		shortElement[12][5] = "Tl";
		shortElement[13][5] = "Pb";
		shortElement[14][5] = "Bi";
		shortElement[15][5] = "Po";
		shortElement[16][5] = "At";
		shortElement[17][5] = "Rn";

		shortElement[0][6] = "Fr";
		shortElement[1][6] = "Ra";
		shortElement[2][6] = "Ac";
		shortElement[3][6] = "Rf";
		shortElement[4][6] = "Db";
		shortElement[5][6] = "Sg";
		shortElement[6][6] = "Bh";
		shortElement[7][6] = "Hs";
		shortElement[8][6] = "Mt";
		shortElement[9][6] = "Ds";
		shortElement[10][6] = "Rg";
		shortElement[11][6] = "Cn";
		shortElement[12][6] = "Nh";
		shortElement[13][6] = "Fl";
		shortElement[14][6] = "Mc";
		shortElement[15][6] = "Lv";
		shortElement[16][6] = "Ts";
		shortElement[17][5] = "Og";
		////////////////////////////
		int whichSub = 0;
		int bigboy = shortElement.length;
		for (int i = 0; i <= fullElement[0].length; i++) {
			for (int y = 0; y < shortElement.length; y++) {

				if (type == 'c') {
					if (subs[whichSub].equals(shortElement[y][i])) { // will never match need to cross between the
																		// arrays
						subs[whichSub] = fullElement[y][i];
						whichSub++;
						y = 0;
						i = 0;
						break;
					}
				} else {
					if (subs[whichSub].equals(fullElement[y][i])) { // will never match need to cross between the
						// arrays
						subs[whichSub] = shortElement[y][i];
						whichSub++;
						y = 0;
						i = 0;
						break;
					}
				}
			}
			if (whichSub == 2)
				break;
		}

		return subs;
	}

	public char whatTypeTerm(String nameTerm) {
		char name = 'n';
		int indexd = nameTerm.indexOf(' ');
		if (indexd > 0) {
			name = 'n';
		} else {
			name = 'c';
		}

		return name;
	}

	public int seperateNamesC(String term) {
		String ammonium = "NH4";
		int iAm = 0;
		int iTerm = 0;
		char esc = 'n';
		char esc2 = 'n';
		int stop = 0;
		int firstUp = 0;
		while (((ammonium.charAt(iAm) == term.charAt(iTerm)) || term.charAt(iTerm) == '(' || term.charAt(iTerm) == ')')
				&& esc == 'n') {
			if (iAm == 3) {
				esc = 'y';
				stop = iTerm;

			} else {
				if (term.charAt(iTerm) == '(' || term.charAt(iTerm) == ')') {
					iAm++;
				} else {
					iAm++;
					iTerm++;
				}
			}
		}
		iTerm = 0;
		if (esc == 'y') {// make ammonium a sub and send back

		} else {
			while (esc2 == 'n') {
				if (term.charAt(iTerm) == ' ' || term.charAt(iTerm) == ')') {
					esc2 = 'y';
					stop = iTerm;
				} else {
					int checkUp = term.charAt(iTerm);
					if (checkUp < 91) {
						if (firstUp == 0) {
							firstUp++;
							iTerm++;
						} else {
							esc2 = 'y';
							stop = iTerm - 1; // INCLUDE WITH INDEX OF STOP
						}
					} else {
						iTerm++;
					}

				}
			}

		}

		// add a away to return if ammonia or move it
		return stop;
	}

	public String[] funcSeperate(String term, int point) {
		String sub1;
		String sub2;
		char sub1R[] = new char[term.length()]; // make as long as overall string
		char sub2R[] = new char[term.length()];
		int iTerm = 0;
		int iSub = 0;
		String[] subs = new String[2];
		while (iTerm <= point) {
			if (term.charAt(iTerm) == '(' || term.charAt(iTerm) == ')') // be carefull with words
			{
				iTerm++;
			} else {
				if (term.charAt(iTerm) == ' ') { // May have to fix
				} else {
					sub1R[iSub] = term.charAt(iTerm);
				}

				iSub++;
				iTerm++;
			}
		}
		sub1 = new String(sub1R);
		sub1 = sub1.trim();
		subs[0] = sub1;
		iSub = 0;
		while (iTerm <= term.length() - 1) { // Just added the -1
			if (term.charAt(iTerm) == '(' || term.charAt(iTerm) == ')') // be carefull with words
																		// HERE!!!!!!!!!!!!!!!!!!!
			{
				iTerm++;
			} else {
				if (term.charAt(iTerm) == ' ') {
				} else {
					sub2R[iSub] = term.charAt(iTerm);
				}

				iSub++;
				iTerm++;
			}
		}
		sub2 = new String(sub2R);
		sub2 = sub2.trim();
		subs[1] = sub2;
		return subs;
	}
}
