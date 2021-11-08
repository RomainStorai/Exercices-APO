package fr.rstr.apo.seance11.exo1;

/**
 * <strong> Arithmétique de Peano.  </strong>
 * <p>
 * Algèbre.
 * <p>
 * $$\langle Nat, \Sigma, eqs \rangle$$
 *
 *
 *
 * <p>
 * Description de l'ensemble des entiers naturels par l'<b><i>axiomatique de
 * Peano </i></b> : 0 et l'ensemble de ses successeurs. Ce sont les entiers
 * positifs ou nuls. On ne fixe pas de borne supérieure (nombre infini <i> a
 * priori</i>, ou plutôt limité par la mémoire de la machine).
 * </p>
 *
 * <p>
 * Ici la description du type est récursive : un entier naturel est défini par
 * son prédécesseur s'il est strictement positif. L'entier 0 (constructeur du
 * type en algèbre universelle) a comme prédécesseur un objet non défini null.
 * </p>
 *
 * <p>
 * Aucune description décimale n'est donnée dans les attributs. Sa valeur
 * décimale peut seulement être calculée par une méthode. Stocker la valeur
 * décimale dans un int, long ou Integer ou LongInteger reviendrait à utiliser
 * une solution déjà implémentée des entiers.
 * </p>
 *
 * <i> Le but est de mettre en oeuvre la stricte définition de l'ensemble de
 * Peano dans le but de voir comment on pourrait coder les axiomes de façon
 * aussi fidèle que possible, et de voir (par l'exemple seulement), si cette
 * définition est correcte. Le but n'est évidemment pas d'avoir une
 * implémentation efficace des entiers. </i>
 *
 * <p>
 * <p>
 * Cette définition fait appel aux booléens, mais pas aux entiers. </p>
 *
 * <div>
 *
 * <b> Operations : </b>
 *
 *
 *
 * <ul>
 * <li>
 * <pre> zero:              &rarr; Nat                <i>     zero est un constructeur </i>  </pre> </li>
 * <li>
 * <pre> succ:          Nat &rarr; Nat                <i>     succ est un constructeur, algébriquement. C'est une fonction de Nat dans Nat. </i> </pre>
 * </li>
 * <li>
 * <pre> add:      Nat, Nat &rarr; Nat                <i>      add est une fonction de Nat, Nat dans Nat. </i>
 * </pre>
 * </li>
 * <li>
 * <pre> mult:     Nat, Nat &rarr; Nat                 <i>     mult est une fonction de Nat, Nat dans Nat. </i>
 * </pre>
 * </li>
 * <li>
 * <pre> leq:      Nat, Nat &rarr; boolean             <i>     leq est une fonction de Nat, Nat dans boolean. </i>
 * </pre>
 * </li>
 * <li>
 * <pre> equals: Nat, Nat &rarr; boolean              <i>    equalsTo est une fonction de Nat, Nat dans boolean. </i>
 * </pre>
 * </li>
 *
 * </ul>
 * </div>
 *
 * <p>
 * <p>
 * Par soucis de clareté, ci-dessous, on renomme les operations zero, succ, add,
 * mult respectivement : \(0, s, +, \times \); et on utilise une notation infixée
 * habituelle pour \(+, \times\), leq et equalsTo.
 *
 * </p>
 *
 *
 * <b> Equations: </b>
 *
 *
 *
 * <pre>
 * &forall; x, y: Nat :
 *        x + 0 = x
 *     x + s(y) = s(x + y)
 *
 *       x &times; 0  = 0
 *     x &times; s(y) = x &times; y + x
 *
 *      s(x) leq 0 = false
 *      0 leq s(x) = true
 *   s(x) leq s(y) = x leq y
 *
 *
 *     s(x) equals 0 = false             <i> tout entier de type s(x) est non nul. </i>
 *        0 equals 0 = true
 *  s(x) equals s(y) = x equals y
 *
 * </pre>
 * <p>
 * D'autres descriptions du codage interne (chaînes de caractères, ArrayList,
 * ...) sont évidemment possibles.
 * <p>
 * Le but est de mettre en pratique les axiomes de Peano, et non d'avoir une
 * nouvelle implémentation des entiers naturels.
 * <p>
 * <p>
 * Cela permet d'illustrer comment un TAD (Type abstrait de Données) peut s'implémenter en Java.
 * <p>
 * https://fr.wikipedia.org/wiki/Axiomes_de_Peano
 * <p>
 * <p>
 * Type abstrait de données (ou ADT : langages Act-One, Larch, ... Ehrig)
 *
 * @author lambolai
 */
public interface NatInterface {

    /**
     * Operation "producteur" zero. Algébriquement c'est un constructeur.
     *
     * @return Entier 0 de Peano. C'est le seul qui n'a pas de prédécesseur.
     */
    public NatInterface zero();

    /**
     * Operation succ.
     * succ : Nat &rarr; Nat.   C'est un constructeur, d'un point de vue algébrique. Entier strictement positif.
     * \(\forall x, s(x) \not= 0 \)
     *
     * @return Nat immediatly following natural number.
     */
    public NatInterface succ();

    /**
     * Conversion de l'objet de type Nat en entier décimal classique (int).
     *
     * @return valeur entière (int) décimale de l'objet de type Nat.
     */
    public int intValue();


    /**
     * Affiche les entiers de la forme 0, s(0), s(s(0)), etc.
     *
     * @return chaîne de caractères sous la forme "s(s(s(...)...))".
     */
    @Override
    public String toString();

    /**
     * @return true if zero, else false.
     */
    public boolean isZero();

    /**
     * Opération pred. Permet de retrouver l'entier immédiatement précédent, s'il existe.
     *
     * @return preceding Nat, if it exists, else returns null.
     */
    public NatInterface pred();

    /**
     * Addition par les axiomes de Peano uniquement.
     *
     * <div> Axiomes de Peano pour l'addition : </div>
     * <div> \(\forall x, y : \mathrm{Nat} \) </div>
     * <div> \(x + 0 = x \)  </div>
     * <div> \(x + s(y) = s(x+y) \) </div>
     *
     * @param y param to add this with
     * @return this + y
     */
    public NatInterface add(NatInterface y);


    /**
     * Multiplication par les axiomes de Peano uniquement.
     * <p>
     * Axiomes de Peano pour la multiplication.
     * <div> \( \forall x, y : \mathrm{Nat} \) </div>
     * <div> \( x \times  0 = 0 \)  </div>
     * <div> \( x \times  s(y) = x \times y + x \) </div>
     *
     * @param y param to add this with
     * @return this + y
     */
    public NatInterface mult(NatInterface y);

    /**
     * subtract.
     * <div> \( \forall x, y : \mathrm{Nat} \) </div>
     * <div> \(y \ \mathrm{leq}\  x \Rightarrow s(x - s(y)) = x - y \)</div>
     * <div> \(x - 0 = x \)</div>
     *
     * @param y y Nat y leq this.
     * @return this - y
     */
    public NatInterface subtract(NatInterface y) throws Exception;

    /**
     * Lower or equals than.
     * <div> \( \forall x, y : \mathrm{Nat} \) </div>
     * <div>\( 0 \ \mathit{leq}\ 0 = \mathbf{true} \) </div>
     * <div>\( 0 \ \mathit{leq}\ s(x) \) = \mathbf{true}</div>
     * <div>\( s(x) \ \mathit{leq}\ 0) = \mathbf{false}\)</div>
     * <div>\( s(x) \ \mathit{leq}\ s(y) = x \ leq \ y \)</div>
     *
     * @param y param
     * @return this leq y
     */
    public boolean leq(NatInterface y);

    /**
     * Affichage pratique pour voir les deux formes.
     * Nat().succ().succ().succ().afficher donne "3 = s(s(s(0)))"
     */
    public void afficher();

    /**
     * Equals.
     * <div> \( \forall x, y : \mathit{Nat} \) </div>
     * <div> \( 0 \ \mathit{equals} \ 0 = \mathbf{true} \) </div>
     * <div> \( s(x) \ \mathit{equals} \ 0 = \mathbf{false} \)</div>
     * <div> \( 0 \ \mathit{equals} \ s(y) = \mathbf{false} \) </div>
     * <div> \( s(x) \ \mathit{equals} \ s(y) = x \ \mathit{equals}\  y \) </div>
     *
     * @param y param
     * @return this == y
     */
    public boolean equals(NatInterface y);

}
