package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class IntroduceView extends JFrame {
	 private JTextField polinom1TextField;
	 private JTextField polinom2TextField;
	 private JTextField rezultatTextField;
	 private JButton adunareButton;
	 private JButton scadereButton;
	 private JButton inmultireButton;
	 private JButton impartireButton;
	 private JButton derivareButton;
	 private JButton integrareButton;
	 private JButton okButton;
	 
	 public IntroduceView()
	 {
		 this.setBounds(100,100,820,400);
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  getContentPane().setLayout(null);
		  
		  JLabel polinom1Label = new JLabel("Polinom1");
		  polinom1Label.setBounds(320, 32, 84, 14);
		  getContentPane().add(polinom1Label);
		  
		  JLabel polinom2Label = new JLabel("Polinom2");
		  polinom2Label.setBounds(320, 67, 84, 14);
		  getContentPane().add(polinom2Label);
		  
		  JLabel rezultatLabel = new JLabel("Rezultat");
		  rezultatLabel.setBounds(320, 250, 84, 14);
		  getContentPane().add(rezultatLabel);
		  
		  polinom1TextField = new JTextField();
		  polinom1TextField.setBounds(430, 32, 162, 20);
		  getContentPane().add(polinom1TextField);
		  
		  polinom2TextField = new JTextField();
		  polinom2TextField.setBounds(430, 67, 162, 20);
		  getContentPane().add(polinom2TextField);
		  
		  rezultatTextField = new JTextField();
		  rezultatTextField.setBounds(430, 250, 162, 20);
		  getContentPane().add(rezultatTextField);
		  
		  okButton = new JButton("ok");
		  okButton.setBounds(630, 45, 70, 23);
		  getContentPane().add(okButton);
		  
		  adunareButton = new JButton("+");
		  adunareButton.setBounds(114, 157, 70, 40);
		  getContentPane().add(adunareButton);
		  
		  scadereButton = new JButton("-");
		  scadereButton.setBounds(202, 157, 70, 40);
		  getContentPane().add(scadereButton);
		  
		  inmultireButton = new JButton("*");
		  inmultireButton.setBounds(280, 157, 70, 40);
		  getContentPane().add(inmultireButton);
		  
		  impartireButton = new JButton("/");
		  impartireButton.setBounds(362, 157, 70, 40);
		  getContentPane().add(impartireButton);
		  
		  derivareButton = new JButton("'");
		  derivareButton.setBounds(436, 157, 70, 40);
		  getContentPane().add(derivareButton);
		  
		  integrareButton = new JButton("I");
		  integrareButton.setBounds(512, 157, 70, 40);
		  getContentPane().add(integrareButton);
		  
		  }

	 public void addOkButtonActionListener(final ActionListener actionListener) {
		  okButton.addActionListener(actionListener);
		}
	 public void addAdunareButtonActionListener(final ActionListener actionListener) {
		  adunareButton.addActionListener(actionListener);
		}
	 public void addScadereeButtonActionListener(final ActionListener actionListener) {
		  scadereButton.addActionListener(actionListener);
		}
	 public void addInmultireButtonActionListener(final ActionListener actionListener) {
		  inmultireButton.addActionListener(actionListener);
		}
	 public void addImpartireButtonActionListener(final ActionListener actionListener) {
		  impartireButton.addActionListener(actionListener);
		}
	 public void addDerivareButtonActionListener(final ActionListener actionListener) {
		  derivareButton.addActionListener(actionListener);
		}
	 public void addIntegrareButtonActionListener(final ActionListener actionListener) {
		  integrareButton.addActionListener(actionListener);
		}
	 public String getPolinom1()
	 {
		 return polinom1TextField.getText();
	 }
	 
	 public String getPolinom2()
	 {
		 return polinom2TextField.getText();
	 }
	 
	 public void setRez(String s1)
	 {
		 rezultatTextField.setText(s1);
	 }
	 
	
}

