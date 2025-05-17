package archivio;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EsecuzioneArchivio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Archivio a1 = new Archivio();
        a1.aggiungi( new Libro(12,"Arsene Lupin" ,1907,1765,"Maurice Leblanc","Giallo"));
        a1.aggiungi(new Libro(124,"Il muro",1939,456,"Sartre","Racconti"));
        a1.aggiungi(new Libro(125,"Le notti bianche",1848,1569,"Dostoevsky","Racconto"));
        a1.aggiungi(new Rivista(234,"Airone",1988,184, Rivista.Periodicita.MENSILE));
        a1.aggiungi(new Rivista(235,"Art e Dossier",2020, 231 , Rivista.Periodicita.SEMESTRALE));
        a1.aggiungi(new Rivista(236,"Shonen Jump",2025,260, Rivista.Periodicita.SETTIMANALE));

       boolean esecuzione = true;
       while (esecuzione){
           System.out.println("Scegli cosa vuoi fare :");
           System.out.println("1 - Aggiungi un elemento");
           System.out.println("2 - Ricerca per ISBN");
           System.out.println("3 - Elimina con ISBN");
           System.out.println("4- Ricerca per anno ");
           System.out.println("5 - Ricerca per autore");
           System.out.println("6 - Aggiorna con ISBN ");
           System.out.println("7 - Statistiche del catalogo");
           System.out.println("0 - Esci dal programma");
           int scelta = scanner.nextInt();
           switch (scelta){
               case 0 : esecuzione= false;
               break;
               case 1 :
                   
                   System.out.println("Digita :");
                   System.out.println("1 - Libro");
                   System.out.println("2- Rivista");
                   int tipo = scanner.nextInt();
                   switch (tipo){
                       case 1:
                           System.out.println("Isbn");
                           Integer isbn = scanner.nextInt();
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
                           a1.aggiungi(new Libro(isbn,titolo,anno,pagine,autore,genere));

                           break;
                       case 2:
                           System.out.println("Isbn");
                           Integer Isbn = scanner.nextInt();
                           System.out.println("titolo");
                           String Titolo = scanner.next();
                           System.out.println("Anno");
                           Integer Anno = scanner.nextInt();
                           System.out.println("numeroPagine");
                           Integer Pagine = scanner.nextInt();


                           a1.aggiungi(new Rivista(Isbn,Titolo,Anno,Pagine, Rivista.Periodicita.MENSILE));
                           break;
                       default:
                           System.out.println("Inserisci 1 o 2 ");


                   }
                   break;
               case 2 :
                   System.out.print("Inserisci ISBN da cercare: ");
                   try {
                       Integer isbn = scanner.nextInt();
                       ElementiCatalogo trovato = a1.cercaPerISBN(isbn);
                       System.out.println("Elemento trovato: " + trovato);
                   }catch (InputMismatchException i){
                       System.out.println("Inserire solo numeri interi" );
                       scanner.nextLine();
                   }catch (ElementoNonTrovatoException e) {
                       System.out.println("Errore: " + e.getMessage());
                   }
                   break;


               case 3 :
                   try {
                       System.out.println("Inserisci ISBN per eliminare: ");
                       Integer z = scanner.nextInt();
                       a1.rimuovi(z);
                       System.out.println( z + "Rimosso con successo");
                   }catch (InputMismatchException d){
                       System.out.println("Inserire solo numeri interi" );
                       scanner.nextLine();
                   }

                   break;
               case 4 :
                   try {
                       System.out.println("Inserisci l'anno: ");
                       int y = scanner.nextInt();
                       System.out.println(a1.cercaPerAnno(y));
                   }catch (InputMismatchException z){
                       System.out.println("Inserire solo numeri interi" );
                       scanner.nextLine();
                   }

                   break;
               case 5:
                   System.out.println("Inserisci autore: ");
                   String a = scanner.next();
                   System.out.println(a1.cercaPerAutore(a));
                   break;
               case 6:
                   try {
                       System.out.println("Aggiorna con ISBN: ");
                       int f = scanner.nextInt();
                       a1.aggiornaElemento(f);
                   }catch (InputMismatchException e){
                       System.out.println("Inserire solo numeri interi" );
                       scanner.nextLine();
                   }

                   break;
               case 7:
                   a1.stampaStatisticheCatalogo();



           }

       }












    }
}
