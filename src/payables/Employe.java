package payables;

/**
 * Classe abstraite représentant la base commune des différentes sortes d'employés.
 */
public abstract class Employe extends Payable {
	private final String nomComplet;
	private final String numeroAssuranceSociale;

	/**
	 * Construit un nouvel Employé.
	 * @param id Numéro d'identification unique du Payable.
	 * @param nom Prénom et nom de l'employé.
	 * @param nas Numéro d'assurance sociale de l'employé.
	 * @param memo Champ texte optionnel pour laisser un mémo.
	 */
	public Employe(int id, String nom, String nas, String memo) {
		super(id, memo);
		this.nomComplet = nom;
		numeroAssuranceSociale = nas;
	}

	/**
	 * @return le nom complet (prénom et nom) de l'employé.
	 */
	public String getNomComplet() {
		return nomComplet;
	}

	/**
	 * @return le numéro d'assurance sociale de l'employé.
	 */
	public String getNumeroAssuranceSociale() {
		return numeroAssuranceSociale;
	}

	@Override
	public String toString() {
		return String.format( "%s \nnuméro d'assurance sociale: %s",
				getNomComplet(), getNumeroAssuranceSociale());
	}

	public String toStringAffichage() {
		String info = super.toStringAffichage();
		info += String.format(" Nom complet [%20s] NAS [%9s]",
				this.getNomComplet(), this.getNumeroAssuranceSociale());
		return info;
	}

	public abstract String toStringSauvegarde();
}
