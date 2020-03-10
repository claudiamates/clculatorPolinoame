package controller;

import javax.swing.UIManager;
import controller.Operation;

import ro.tuc.tp.assig1.model.Monom;
import ro.tuc.tp.assig1.model.Polinom;

import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import view.IntroduceView;

public class MainController {

	private IntroduceView introduceView;
	private Polinom polinom1 = new Polinom();
	private Polinom polinom2 = new Polinom();
	private String polinom_1= new String();
	private String polinom_2= new String();
	private Operation op=new Operation();
	
	public void start() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		introduceView = new IntroduceView();
		 
		
		initializeButtonListeners();
		
		introduceView.setVisible(true);	
		 }
	
	private Polinom getValue1(String poly)
	{
		String vect[]=new String[20];
		Polinom rez=new Polinom();
		String regexVar = "([+-]?[^-+]+)";
		Pattern regexPattern = Pattern.compile(regexVar);
		Matcher regexMatcher = regexPattern.matcher(poly);
		int i=0;
		while(regexMatcher.find())
		{
			if(regexMatcher.group().length() != 0)
			{
				vect[i++]=(regexMatcher.group());
			}
		}
		for(int j=0; j<i; j++)
		{
			Monom r1 = new Monom();
			r1.setCoef(0);  r1.setDegree(0);
			if(vect[j].charAt(0) == 'x')
				
			{
				r1.setCoef(1);		
			}
			 if((vect[j].charAt(0)=='-')&&(vect[j].charAt(1)=='x'))
			{
				r1.setCoef(-1);
			}
			if(vect[j].charAt(0)=='-')
			{
				r1.setCoef(-(vect[j].charAt(1)-'0'));
			}
			if(vect[j].charAt(0)=='+')
			{
				r1.setCoef(vect[j].charAt(1)-'0');
			}
			if((vect[j].charAt(0)>'1')&&(vect[j].charAt(0)<='9'))
			{
				r1.setCoef(vect[j].charAt(0)-'0');
			}
			
			if(vect[j].indexOf('^')!= -1)
			{
				if(((vect[j].indexOf('^')+1) != -1)&&(vect[j].charAt(vect[j].indexOf('^')+1)=='-'))
				{
					r1.setDegree(-(vect[j].charAt(vect[j].indexOf('^')+2)-'0'));	
				}
				else r1.setDegree(vect[j].charAt(vect[j].indexOf('^')+1)-'0');
			}
			else if(vect[j].indexOf('x')!=-1)
				r1.setDegree(1);
			rez.setElemPolinom(j, r1);
		}
		for(int j=0;j<i;j++)
		{
			System.out.println("coef:" + rez.getElemPolinom(j).getCoef() + "degree:" + rez.getElemPolinom(j).getDegree());
		}
		return rez;
	}
	
	/*private void getValue2()
	{
		String polinom_2 =introduceView.getPolinom2();
		String vect[]=new String[20];
		
		String regexVar = "([+-]?[^-+]+)";
		Pattern regexPattern = Pattern.compile(regexVar);
		Matcher regexMatcher = regexPattern.matcher(polinom_2);
		int i=0;
		while(regexMatcher.find())
		{
			if(regexMatcher.group().length() != 0)
			{
				vect[i++]=(regexMatcher.group());
			}
		}
		for(int j=0; j<i; j++)
		{
			Monom r2 = new Monom();
			r2.setCoef(0);  r2.setDegree(0);
			if(vect[j].charAt(0) == 'x')
				
			{
				r2.setCoef(1);		
			}
			 if((vect[j].charAt(0)=='-')&&(vect[j].charAt(1)=='x'))
			{
				r2.setCoef(-1);
			}
			if(vect[j].charAt(0)=='-')
			{
				r2.setCoef(-(vect[j].charAt(1)-'0'));
			}
			if(vect[j].charAt(0)=='+')
			{
				r2.setCoef(vect[j].charAt(1)-'0');
			}
			if((vect[j].charAt(0)>'1')&&(vect[j].charAt(0)<='9'))
			{
				r2.setCoef(vect[j].charAt(0)-'0');
			}
			
			if(vect[j].indexOf('^')!= -1)
			{
				if(vect[j].charAt(vect[j].indexOf('^')+1)=='-')
				{
					r2.setDegree(-(vect[j].charAt(vect[j].indexOf('^')+2)-'0'));	
				}
				else r2.setDegree(vect[j].charAt(vect[j].indexOf('^')+1)-'0');
				//System.out.println(vect[j].charAt(vect[j].indexOf('^')+1));
			}
			else if(vect[j].indexOf('x')!=-1)
				r2.setDegree(1);
			polinom2.setElemPolinom(j, r2);
			System.out.println("coef:" + polinom2.getElemPolinom(j).getCoef() + "degree:" + polinom2.getElemPolinom(j).getDegree());
			
		}
	
	}*/
	

		private void initializeButtonListeners() {
			introduceView.addOkButtonActionListener(e->{
				polinom_1 = introduceView.getPolinom1();
				 polinom_2 = introduceView.getPolinom2();
				polinom1= getValue1(polinom_1);
				polinom2 = getValue1(polinom_2);
			});
			introduceView.addAdunareButtonActionListener(e ->{
				Polinom rez = new Polinom(); StringBuilder s1 = new StringBuilder();
				rez=op.addPolinoame(polinom1,polinom2);
				for(int i=0;i<rez.getSize();i++)
				{
					introduceView.setRez(s1.append(toStr(rez.getElemPolinom(i))) .toString());
				}
			});
			introduceView.addScadereeButtonActionListener(e->{
				Polinom rez = new Polinom(); StringBuilder s1 = new StringBuilder();
				rez=op.subPolinoame(polinom1, polinom2);
				for(int i=0;i<rez.getSize();i++)
				{
					introduceView.setRez(s1.append(toStr(rez.getElemPolinom(i))) .toString());
				}
			});
			introduceView.addInmultireButtonActionListener(e->{
				Polinom rez = new Polinom(); StringBuilder s1 = new StringBuilder();
				rez=op.inmPolinoame(polinom1, polinom2);
				for(int i=0;i<rez.getSize();i++)
				{
					introduceView.setRez(s1.append(toStr(rez.getElemPolinom(i))) .toString());
				}
			});
			introduceView.addImpartireButtonActionListener(e->{
				op.impPolinoame(polinom1,polinom2);
			});
			introduceView.addDerivareButtonActionListener(e->{
				Polinom rez = new Polinom(); StringBuilder s1 = new StringBuilder();
				rez=op.derivPolinom(polinom1);
				for(int i=0;i<rez.getSize();i++)
				{
					introduceView.setRez(s1.append(toStr(rez.getElemPolinom(i))) .toString());
				}
			});
			introduceView.addIntegrareButtonActionListener(e->{
				Polinom rez = new Polinom(); StringBuilder s1 = new StringBuilder();
				rez=op.integrarePolinom(polinom1);
				for(int i=0;i<rez.getSize();i++)
				{
					introduceView.setRez(s1.append(toStr(rez.getElemPolinom(i))) .toString());
				}
	
			});
		}

		public String toStr(Monom m)
		{
			StringBuilder s= new StringBuilder();
			if(m.getCoef()==0) {return s.append("") .toString();}
			if(m.getDegree() == 0) {return s.append("+") .append(m.getCoef()) .toString();}
			else if(m.getDegree() == 1) {return s.append("+") .append(m.getCoef())
				.append("x")
				.toString();}
			else {return s.append("+")
					.append(m.getCoef())
			.append("x^")
			.append(m.getDegree())
			.toString();}
		}
			
		
}
