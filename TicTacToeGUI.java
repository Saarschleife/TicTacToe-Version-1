/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
TicTacToe für zwei Spieler

Klasse für Benutzeroberfläche

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

package pd.TicTacToeV1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToeGUI extends JFrame implements ActionListener{
	Random zufall = new Random();//Zufallsgenerator
	boolean spieler1_Zug;

	//Oberfläche
	JPanel titelLeiste = new JPanel();//für das Titelfeld
	JPanel schaltFlFeld = new JPanel();//Spielfeld
	JLabel textFeld = new JLabel();//für den Titel
	JButton[] schaltFl = new JButton[9];//Array mit 9 Schaltflächen für Spielfeld


	//Konstruktor der Benutzeroberfläche
	TicTacToeGUI(){
		
		setLayout(new BorderLayout());
		setSize(800, 800);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);

		textFeld.setBackground(Color.BLACK);
		textFeld.setForeground(Color.ORANGE);
		textFeld.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		textFeld.setHorizontalAlignment(JLabel.CENTER);
		textFeld.setText("TicTacToe Version 1");
		textFeld.setOpaque(true);

		titelLeiste.setLayout(new BorderLayout());
		titelLeiste.setBounds(0, 0, 800, 200);//x,y,Breite,Höhe

		schaltFlFeld.setLayout(new GridLayout(3, 3));
		schaltFlFeld.setBackground(Color.GRAY);

		for (int i = 0; i < 9; i++){
			schaltFl[i] = new JButton();//neue Schaltfläche
			schaltFlFeld.add(schaltFl[i]);//Schaltfläche ins Feld einfügen
			schaltFl[i].setFont(new Font("Arial", Font.BOLD, 70));
			schaltFl[i].setFocusable(false);
			schaltFl[i].addActionListener(this);
		}

		titelLeiste.add(textFeld);//Textfeld in Titelleiste einfügen
		
		//Titelleiste u. Feld für Schaltflächen in Layout einfügen
		add(titelLeiste, BorderLayout.NORTH);
		add(schaltFlFeld, BorderLayout.CENTER);

		ersterZug();//Methode aufrufen
	}


	@Override
	public void actionPerformed(ActionEvent aktion) {
			for (int i = 0; i < 9; i++) {
			if (aktion.getSource() == schaltFl[i]) {//Schaltfläche gedrückt?
				if (spieler1_Zug) {//Spieler 1 am Zug?
					if (schaltFl[i].getText() == ""){//Schaltfläche ohne Symbol?
						schaltFl[i].setForeground(Color.RED);
						schaltFl[i].setText("X");//Symbol auf Schaltfläche setzen
						spieler1_Zug = false;
						textFeld.setText("O ist am Zug");
						werGewinnt();
					}
				}else {//Spieler 2 am Zug?
					if (schaltFl[i].getText() == "") {
						schaltFl[i].setText("O");
						schaltFl[i].setForeground(Color.BLUE);
						spieler1_Zug = true;
						textFeld.setText("X ist am Zug");
						werGewinnt();
					}
				}
			}
		}
	}
	

	public void ersterZug() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (zufall.nextInt(2) == 0) {
			spieler1_Zug = true;
			textFeld.setText("X beginnt");
		} 
		else {
			spieler1_Zug = false;
			textFeld.setText("O beginnt");
		}
	}//
	
	public void werGewinnt() {
		if(
				(schaltFl[0].getText()=="X") &&
				(schaltFl[1].getText()=="X") &&
				(schaltFl[2].getText()=="X")
				){
					xGewinnt(0,1,2);
				}
		if(
				(schaltFl[3].getText()=="X") &&
				(schaltFl[4].getText()=="X") &&
				(schaltFl[5].getText()=="X")
				){
					xGewinnt(3,4,5);
				}
		if(
				(schaltFl[6].getText()=="X") &&
				(schaltFl[7].getText()=="X") &&
				(schaltFl[8].getText()=="X")
				){
					xGewinnt(6,7,8);
				}
		if(
				(schaltFl[0].getText()=="X") &&
				(schaltFl[3].getText()=="X") &&
				(schaltFl[6].getText()=="X")
				){
					xGewinnt(0,3,6);
				}
		if(
				(schaltFl[1].getText()=="X") &&
				(schaltFl[4].getText()=="X") &&
				(schaltFl[7].getText()=="X")
				){
					xGewinnt(1,4,7);
				}
		if(
				(schaltFl[2].getText()=="X") &&
				(schaltFl[5].getText()=="X") &&
				(schaltFl[8].getText()=="X")
				){
					xGewinnt(2,5,8);
				}
		if(
				(schaltFl[0].getText()=="X") &&
				(schaltFl[4].getText()=="X") &&
				(schaltFl[8].getText()=="X")
				){
					xGewinnt(0,4,8);
				}
		if(
				(schaltFl[2].getText()=="X") &&
				(schaltFl[4].getText()=="X") &&
				(schaltFl[6].getText()=="X")
				){
					xGewinnt(2,4,6);
				}
		
		if(
				(schaltFl[0].getText()=="O") &&
				(schaltFl[1].getText()=="O") &&
				(schaltFl[2].getText()=="O")
				){
					oGewinnt(0,1,2);
				}
		if(
				(schaltFl[3].getText()=="O") &&
				(schaltFl[4].getText()=="O") &&
				(schaltFl[5].getText()=="O")
				){
					oGewinnt(3,4,5);
				}
		if(
				(schaltFl[6].getText()=="O") &&
				(schaltFl[7].getText()=="O") &&
				(schaltFl[8].getText()=="O")
				){
					oGewinnt(6,7,8);
				}
		if(
				(schaltFl[0].getText()=="O") &&
				(schaltFl[3].getText()=="O") &&
				(schaltFl[6].getText()=="O")
				){
					oGewinnt(0,3,6);
				}
		if(
				(schaltFl[1].getText()=="O") &&
				(schaltFl[4].getText()=="O") &&
				(schaltFl[7].getText()=="O")
				){
					oGewinnt(1,4,7);
				}
		if(
				(schaltFl[2].getText()=="O") &&
				(schaltFl[5].getText()=="O") &&
				(schaltFl[8].getText()=="O")
				){
					oGewinnt(2,5,8);
				}
		if(
				(schaltFl[0].getText()=="O") &&
				(schaltFl[4].getText()=="O") &&
				(schaltFl[8].getText()=="O")
				){
					oGewinnt(0,4,8);
				}
		if(
				(schaltFl[2].getText()=="O") &&
				(schaltFl[4].getText()=="O") &&
				(schaltFl[6].getText()=="O")
				){
					oGewinnt(2,4,6);
				}
	}//
	
	public void xGewinnt(int a, int b, int c) {
		schaltFl[a].setBackground(Color.GREEN);
		schaltFl[b].setBackground(Color.GREEN);
		schaltFl[c].setBackground(Color.GREEN);
		
		for(int i=0; i<9; i++) {
			schaltFl[i].setEnabled(false);
		}
		textFeld.setText("X Gewinnt");
	}//
	
	public void oGewinnt(int a, int b, int c) {
		schaltFl[a].setBackground(Color.GREEN);
		schaltFl[b].setBackground(Color.GREEN);
		schaltFl[c].setBackground(Color.GREEN);
		
		for(int i=0; i<9; i++) {
			schaltFl[i].setEnabled(false);
		}
		textFeld.setText("O Gewinnt");
	}//
}
