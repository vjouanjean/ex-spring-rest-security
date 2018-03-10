package io.vn.bean;

/**
 * Object de test
 * 
 * @author vn
 */
public class ObjetBean {

	private long id;
	private String contenu;

	/**
	 * Constructeur avec paramètre
	 * 
	 * @param id
	 * @param contenu
	 */
	public ObjetBean(long id, String contenu) {
		this.id = id;
		this.contenu = contenu;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

}
