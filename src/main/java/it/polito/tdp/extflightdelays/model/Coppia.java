package it.polito.tdp.extflightdelays.model;

public class Coppia {
private 	int id1;
private 	int id2;
private double distanza;
public Coppia(int id1, int id2,double distanza) {
	super();
	this.id1 = id1;
	this.id2 = id2;
	this.distanza=distanza;
	
}
public int getId1() {
	return id1;
}
public int getId2() {
	return id2;
}
public double getDistanza() {
	return distanza;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id1;
	result = prime * result + id2;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Coppia other = (Coppia) obj;
	if (id1 == other.id2 && id2 == other.id1)
		return true;
	return false;
}
@Override
public String toString() {
	return "Coppia [id1=" + id1 + ", id2=" + id2 + ", distanza=" + distanza + "]";
}



	
	

}
