package ro.tuc.tp.assig1.model;

public class Monom {

	private float coef_m;
	private int degree_m;
	
	Monom m3;
	public int getDegree()
	{
		return degree_m;
	}
	
	public float getCoef()
	{
		return coef_m;
	}
	
	public void setDegree(int m)
	{
		this.degree_m=m;
	}
	
	public void setCoef(float c)
	{
		this.coef_m=c;
	}
	
	/*public Monom addmonoms(Monom m1, Monom m2)
	{
		if(m1.degree_m==m2.degree_m)
		{
			m3.degree_m = m1.degree_m;
			m3.coef_m =m1.coef_m+m2.coef_m;
		}
		else
		return m3;
	}*/
	
}
