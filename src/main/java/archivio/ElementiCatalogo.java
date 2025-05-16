package archivio;

import java.util.Objects;

public abstract class ElementiCatalogo {
    protected Integer codiceISBN;
    protected String titolo;
    protected Integer annoPubblicazione;
    protected Integer numeroPagine;




    //Costruttore
    public ElementiCatalogo(Integer codiceISBN, String titolo, Integer annoPubblicazione, Integer numeroPagine) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    //get e set

    public Integer getCodiceISBN() {
        return codiceISBN;
    }

    public void setCodiceISBN(Integer codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Integer getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(Integer annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public Integer getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(Integer numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "ElementiCatalogo{" +
                "codiceISBN=" + codiceISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ElementiCatalogo that = (ElementiCatalogo) o;
        return Objects.equals(codiceISBN, that.codiceISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codiceISBN);
    }
}
