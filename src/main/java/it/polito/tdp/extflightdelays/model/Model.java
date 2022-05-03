package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
private Graph<Airport,DefaultWeightedEdge> grafo;
ExtFlightDelaysDAO dao= new ExtFlightDelaysDAO();
List<Airport> aereoporti;


public Graph<Airport,DefaultWeightedEdge> creaGrafo(int distanza) {
	this.grafo=new SimpleWeightedGraph<Airport,DefaultWeightedEdge>(DefaultWeightedEdge.class);
	List<Coppia> result= new ArrayList<Coppia>();
	List<Coppia> aereoportiConnessi=dao.getAirportConnessiDistanza(distanza);
	for(Coppia co:aereoportiConnessi) {
		if(result.size()==0)
			result.add(co);
		else if(!result.contains(co))
			result.add(co);
	}
	
	aereoporti=dao.loadAllAirports();
	Graphs.addAllVertices(grafo, aereoporti);
	
	
	for(Coppia coppia : result) {
		//this.grafo.addEdge(coppia.getId1(), coppia.getId2(), coppia.getDistanza());
		this.grafo.addEdge(this.getAirportById(coppia.getId1()), this.getAirportById(coppia.getId2()));
		this.grafo.setEdgeWeight(this.getAirportById(coppia.getId1()), this.getAirportById(coppia.getId2()), coppia.getDistanza());
	}
	
	return grafo;
	
}
public Airport getAirportById(int id) {
	for(Airport a: aereoporti) {
		if(a.getId()==id)
			return a;
	}
	return null;
	
}
}
