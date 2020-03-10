package controller;

import ro.tuc.tp.assig1.model.Monom;
import ro.tuc.tp.assig1.model.Polinom;

public class Operation {

	
	public void addMonom(Polinom p, Monom m)
	{
		Polinom rez = new Polinom();
		int i=0, ok=0;
		while(i<p.getSize())
		{
			if((p.getElemPolinom(i).getDegree())==(m.getDegree()))
			{
				p.modifElemPolinom(i, m);
				ok=1;
			}
			
			i++;
		}
		if((i==p.getSize())&&(ok==0))
		{
			p.setElemPolinom(p.getSize()+1, m);
		}
	}
	public void subMonom(Polinom p, Monom m)
	{
		
		int i=0, ok=0;
		while(i<p.getSize())
		{
			if((p.getElemPolinom(i).getDegree())==(m.getDegree()))
			{
				p.modifElemPolinomS(i, m);
				ok=1;
			}
			
			i++;
		}
		if((i==p.getSize())&&(ok==0))
		{
			p.setElemPolinom(p.getSize()+1, m);
		}
	}
	
	public Polinom addPolinoame(Polinom p1, Polinom p2)
	{//StringBuilder s1 = new StringBuilder();
		for(int j=0;j<p2.getSize();j++)
		{
			addMonom(p1, p2.getElemPolinom(j));
		}
		/*for(int k=0; k<p1.getSize(); k++)
		{
			introduceView.setRez(s1.append(toStr(p1.getElemPolinom(k))) .toString());
		}*/
		return p1;
	}
	
	public Polinom subPolinoame(Polinom p1, Polinom p2)
	{//StringBuilder s1 = new StringBuilder();
		for(int i=0; i<p2.getSize();i++)
		{
			subMonom(p1,p2.getElemPolinom(i));
		}
		/*for(int k=0; k<p1.getSize(); k++)
		{
			introduceView.setRez(s1.append(toStr(p1.getElemPolinom(k))) .toString());
		}*/
		return p1;
	}
	
	public Polinom inmPolinoame(Polinom p1, Polinom p2)
	{//StringBuilder s1 = new StringBuilder();
		int k=0;
		Polinom rez = new Polinom();
		for(int i=0;i<p1.getSize();i++)
		{
			for(int j=0; j<p2.getSize();j++)
			{
				Monom r3=new Monom();
				r3.setCoef(p1.getElemPolinom(i).getCoef()*p2.getElemPolinom(j).getCoef());
				r3.setDegree(p1.getElemPolinom(i).getDegree()+p2.getElemPolinom(j).getDegree());
				rez.setElemPolinom(k++, r3);	
			}
		}
		/*for(int i=0; i<rez.getSize();i++)
		{
			introduceView.setRez(s1.append(toStr(rez.getElemPolinom(i))) .toString());
		}*/
		return rez;
	}
	
	public void impPolinoame(Polinom p1, Polinom p2)
	{
		
	}
	
	public Monom derivMonom(Monom m1)
	{
		Monom r4 = new Monom();
		r4.setCoef(m1.getCoef()*m1.getDegree());
		r4.setDegree(m1.getDegree()-1);
		return r4;
	}
	
	public Polinom derivPolinom(Polinom p1)
	{//StringBuilder s1 = new StringBuilder();
		//for each(int i:p1.getPolinom())
		Polinom rez = new Polinom();
		for(int i=0; i<p1.getSize();i++)
		{
			rez.setElemPolinom(i, derivMonom(p1.getElemPolinom(i)));
			//introduceView.setRez(s1.append(toStr(rez.getElemPolinom(i))) .toString());
		}
		return rez;
	}
	
	public Monom integrareMonom(Monom m1)
	{
	  Monom r5 = new Monom();
      r5.setCoef(m1.getCoef()/(m1.getDegree()+1));
      r5.setDegree(m1.getDegree()+1);
      return r5;
	}
	
	public Polinom integrarePolinom(Polinom p1)
	{//StringBuilder s1 = new StringBuilder();
		Polinom rez = new Polinom();
		for(int i=0; i<p1.getSize();i++)
		{
			rez.setElemPolinom(i, integrareMonom(p1.getElemPolinom(i)));
			//introduceView.setRez(s1.append(toStr(rez.getElemPolinom(i))) .toString());
			}
		return rez;
	}
}
