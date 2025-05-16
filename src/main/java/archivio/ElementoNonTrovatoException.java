package archivio;

public class ElementoNonTrovatoException extends Exception{
    public ElementoNonTrovatoException(Integer isbn) {
        super("Elemento con ISBN " + isbn + " non trovato.");
}}
