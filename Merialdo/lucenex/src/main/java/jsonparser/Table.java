package jsonparser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"_id", "className", "id", "beginIndex", "endIndex", "referenceContext", "type", "classe", "headersCleaned", "keyColumn"})

public class Table {

	@JsonProperty("cells")
	private Collection<Cell> collectionCells;

	@JsonProperty("maxDimensions")
	private MaxDimension maxDimension;

	private Map<Integer, List<Cell>> mappaColonne;

	public Table() {
		this.mappaColonne = new HashMap<>();
	}

	//input: collezione di celle
	//output: mappa di colonne<int, lista di celle che formano una colonna>
	public void createCells() {
		List<Cell> temp = null;
		for(Cell c : this.collectionCells) {
			if(!(c.isHeader())) {
				temp = this.mappaColonne.get(c.getCoordinates().getColumn());
				if(temp == null) 
					temp = new ArrayList<Cell>();
				temp.add(c);
				this.mappaColonne.put(c.getCoordinates().getColumn(), temp);
			}
		}
	}

	public Collection<Cell> getCollectionCells() {
		return collectionCells;
	}

	public void setCollectionCells(Collection<Cell> collectionCells) {
		this.collectionCells = collectionCells;
	}

	public MaxDimension getMaxDimension() {
		return maxDimension;
	}

	public void setMaxDimension(MaxDimension maxDimension) {
		this.maxDimension = maxDimension;
	}

	public Map<Integer, List<Cell>> getMappaColonne() {
		return mappaColonne;
	}

	public void setMappaColonne(Map<Integer, List<Cell>> mappaColonne) {
		this.mappaColonne = mappaColonne;
	}

	@Override
	public String toString() {
		return "Table [collectionCells=" + collectionCells + ", maxDimension=" + maxDimension + ", mappaColonne="
				+ mappaColonne + "]";
	}

}

