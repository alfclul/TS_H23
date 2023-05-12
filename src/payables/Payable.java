package payables;

import exceptions.ExceptionEcheanceInsuffisante;

/**
 * Classe abstraite représentant tout type de payable (factures, employés, etc.)
 */
public abstract class Payable {
	private final int ID;
	protected Categorie categorie;
	protected int echeanceJours;
	protected String memo;

	/**
	 * Construit un nouveau Payable.
	 * @param id Numéro d'identification unique.
	 * @param memo Champ texte optionnel pour laisser un mémo.
	 */
	public Payable (int id, String memo) {
		this.ID = id;
		this.echeanceJours = 0;
		this.memo = memo;
	}

	/**
	 * Construit un nouveau Payable (sans mémo).
	 * @param id Numéro d'identification unique.
	 */
	public Payable (int id) {
		this.ID = id;
		this.echeanceJours = 0;
		this.memo = "";
	}

	/**
	 * @return L'identifiant unique de ce payable.
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @return Le nombre de jours avant d'atteindre l'échéance de paiement.
	 */
	public int getEcheanceJours() {
		return echeanceJours;
	}

	/**
	 * Défini le nombre de jours avant l'échéance de paiement.
	 * @param echeanceJours Le nombre de jours restants.
	 */
	public void setEcheanceJours(int echeanceJours) {
		this.echeanceJours = echeanceJours;
	}

	/**
	 * Augmente le nombre de jours avant l'échéance de ce payable.
	 * @param jours Nombre de jours à ajouter.
	 */
	public void augmenterEcheance(int jours) {
		echeanceJours += jours;
	}

	/**
	 * Diminue le nombre de jours avant l'échéance de ce payable.
	 * @param jours Nombre de jours à retirer.
	 * @throws ExceptionEcheanceInsuffisante si le nombre de jours restants deviendrait négatif.
	 */
	public void diminuerEcheance(int jours) throws ExceptionEcheanceInsuffisante {
		if (jours > echeanceJours) {
			throw new ExceptionEcheanceInsuffisante(jours);
		}
		this.echeanceJours -= jours;
	}

	/**
	 * @return Le mémo associé à ce payable.
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @param memo Le nouveau mémo pour ce payable (remplacera le précédent s'il existe).
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * Calcule le montant qui devra être payé à la date d'échéance.
	 * @return Le montant net de ce Payable.
	 */
	public abstract double getMontantPaiement();

	/**
	 * @return Le type de Payable, en String.
	 */
	public String getCategorieString() {
		return categorie.toString();
	}

	/**
	 * @return La String représentant ce Payable (version pour affichage).
	 */
	public String toStringAffichage() {
		String info = String.format("ID [%3d] Catégorie [%25s] Mémo [%15s] Échéance [%3d] Paiement [%10.2f]",
				this.ID, this.getCategorieString(), this.getMemo(), this.getEcheanceJours(), this.getMontantPaiement());
		return info;
	}

	/**
	 * @return La String représentant ce Payable (version pour sauvegarde).
	 */
	public abstract String toStringSauvegarde();
}
