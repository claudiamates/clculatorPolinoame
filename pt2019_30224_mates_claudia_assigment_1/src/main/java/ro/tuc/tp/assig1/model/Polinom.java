package ro.tuc.tp.assig1.model;

import java.util.ArrayList;
import java.util.List;

public class Polinom {

	List<Monom> polinom = new ArrayList<Monom>();
	
	
	
	public Monom getElemPolinom(int i)
	{
		return polinom.get(i);
	}
	
	public void setElemPolinom(int i,Monom m)
	{
		polinom.add(i, m);
	}
	public void modifElemPolinom(int i, Monom m)
	{
		Monom m1 = new Monom();
		m1.setCoef(m.getCoef()+polinom.get(i).getCoef());
		m1.setDegree(m.getDegree());
		polinom.set(i,m1);
	}
	
	public void modifElemPolinomS(int i, Monom m)
	{
		Monom m2 = new Monom();
		m2.setCoef(polinom.get(i).getCoef()-m.getCoef());
		m2.setDegree(m.getDegree());
		polinom.set(i,m2);
	}
	
	public int getSize()
	{
		return polinom.size();
	}
	 
	public List<Monom> getPolinom()
	{
		return polinom;
	}
}
