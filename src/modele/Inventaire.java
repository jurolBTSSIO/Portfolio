package modele;

public class Inventaire {
	
	int idItem, quantite;
	String nomItem, imageItem;
	
	public Inventaire(int id, int qtte, String nom, String img) {
		
		this.idItem = id;
		this.quantite = qtte;
		this.nomItem = nom;
		this.imageItem = img;
		
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getNomItem() {
		return nomItem;
	}

	public void setNomItem(String nomItem) {
		this.nomItem = nomItem;
	}

	public String getImageItem() {
		return imageItem;
	}

	public void setImageItem(String imageItem) {
		this.imageItem = imageItem;
	}

	@Override
	public String toString() {
		return "Inventaire [idItem=" + idItem + ", quantite=" + quantite + ", nomItem=" + nomItem + ", imageItem="
				+ imageItem + "]";
	}

	
}
