package archivio;

import javax.lang.model.element.Element;
import java.util.*;
import java.util.stream.Collectors;

public class Archivio {
    private List<ElementiCatalogo> elementi = new ArrayList<>();


    //Aggiungi elemento
    public void aggiungi(ElementiCatalogo e) {
        if (elementi.stream().anyMatch(el -> el.getCodiceISBN().equals(e.getCodiceISBN()))) {
            System.out.println("Elemento con ISBN già presente!");
            return;
        }
        elementi.add(e);

    }

    //CERCA ISBN
    public ElementiCatalogo cercaPerISBN(Integer isbn) throws ElementoNonTrovatoException  {
        for (ElementiCatalogo e : elementi) {
            if (e.getCodiceISBN().equals(isbn)) {
                return e;
            }
        }
        throw new ElementoNonTrovatoException(isbn) ;

    }
        //RIMUOVI PER ISBN
    public void rimuovi(Integer isbn) {
        elementi.removeIf(e -> e.getCodiceISBN().equals(isbn));
    }
    //CERCA PER ANNO
    public List<ElementiCatalogo> cercaPerAnno(int anno) {
        List<ElementiCatalogo> l = elementi.stream().filter(e -> e.getAnnoPubblicazione() == anno).toList();
        return l;
    }
    //CERCA PER AUTORE
    public List<Libro> cercaPerAutore(String autore) {
        List<Libro> libro = elementi.stream().filter(e -> e instanceof Libro).map(e -> (Libro) e).filter(l -> l.getAutore().equalsIgnoreCase(autore)).toList();
            return libro;
    }

    //AGGIORNA ELEMENTO
    public void aggiornaElemento(Integer isbn) {
        Scanner scanner = new Scanner(System.in);
        rimuovi(isbn);
        System.out.println("Digita 1 se e' un libro, 2 se e' una rivista");
        int scelta = scanner.nextInt();
        switch (scelta){
            case 1:

                System.out.println("titolo");
                String titolo = scanner.next();
                System.out.println("Anno");
                Integer anno = scanner.nextInt();
                System.out.println("numeroPagine");
                Integer pagine = scanner.nextInt();
                System.out.println("autore");
                String autore = scanner.next();
                System.out.println("genere");
                String genere = scanner.next();
                aggiungi(new Libro(isbn,titolo,anno,pagine,autore,genere));
                break;
            case 2:

                System.out.println("titolo");
                String Titolo = scanner.next();
                System.out.println("Anno");
                Integer Anno = scanner.nextInt();
                System.out.println("numeroPagine");
                Integer Pagine = scanner.nextInt();


                aggiungi(new Rivista(isbn,Titolo,Anno,Pagine, Rivista.Periodicita.MENSILE));
                break;
            default:
                System.out.println("Inserisci 1 o 2 ");


        }

    }

//Statistiche

    public void stampaStatisticheCatalogo() {
        // Statistiche generali
        IntSummaryStatistics statsGenerali = elementi.stream().mapToInt(e -> e.numeroPagine).summaryStatistics();

        // Elemento con più pagine
        ElementiCatalogo maxPagine = elementi.stream().max(Comparator.comparingInt(e -> e.numeroPagine)).orElse(null);

        // Statistiche per tipo (Libro, Rivista)
        Map<String, IntSummaryStatistics> statsPerTipo = elementi.stream()
                .collect(Collectors.groupingBy(
                        e -> e instanceof Libro ? "Libro" : "Rivista",
                        Collectors.summarizingInt(e -> e.numeroPagine)
                ));

        System.out.println(" Statistiche catalogo:");
        System.out.println("Totale elementi: " + statsGenerali.getCount());
        System.out.println("Media pagine (tutti): " + statsGenerali.getAverage());

        statsPerTipo.forEach((tipo, stats) -> {
            System.out.println("Tipo: " + tipo);
            System.out.println("- Numero: " + stats.getCount());
            System.out.println("- Media pagine: " + stats.getAverage());
            System.out.println("- Max pagine: " + stats.getMax());
        });

        if (maxPagine != null) {
            System.out.println("Elemento con più pagine: " + maxPagine );
        }
    }

    @Override
    public String toString() {
        return "Archivio{" +
                "elementi=" + elementi +
                '}';
    }
}
