package pl.com.knowosad.ticTacToe;


import java.util.Scanner;

public class Gra {
    private final Plansza p = new Plansza();
    private int[][] s = p.getPlansza();
    public Gra() {
        String nazwa[]=new String[2];
        for (int i = 0; i<=1; i++) {
            System.out.println((i%2==0) ? "Podaj nazwę pierwszego gracza, będzie grał 'X':": "Podaj nazwę drugiego gracza, będzie grał 'O':");
            nazwa[i] = wczytajStringa();
        }
        p.wyswietlPlansze();
        p.setPlansza(s);
        int licz = 0;
        while (true) {
            System.out.println((licz % 2 == 0) ? nazwa[0] + " podaj swój ruch:" : nazwa[1] + " podaj swój ruch:");
            if (wczytajRuch((licz % 2 == 0) ? 'X' : 'O')) licz++;
            sparawdzWynik();
            if (licz == 9) {
                System.out.println("Remis!");
                System.exit(0);
            }
        }
    }
    private void sparawdzWynik() {
        int sumaK1 = 0;
        int sumaK2 = 0;
        int sumaK3 = 0;
        int sumaD1 = 0;
        int sumaD2 = 0;
        for (int i = 0; i < 3; i++) {
            int sumaWiersz = 0;
            for (int j = 0; j < 3; j++) {
                sumaWiersz += s[i][j];
                if (j == 0) sumaK1 += s[i][j];
                if (j == 1) sumaK2 += s[i][j];
                if (j == 2) sumaK3 += s[i][j];
                if (i == j) sumaD1 += s[i][j];
                if (i + j == 2) sumaD2 += s[i][j];
                if (sumaWiersz == 3 || sumaK1 == 3 || sumaK2 == 3 || sumaK3 == 3 || sumaD1 == 3 || sumaD2 == 3) {
                    System.out.println("wygrał gracz 1");
                    System.exit(0);
                }
                if (sumaWiersz == 12 || sumaK1 == 12 || sumaK2 == 12 || sumaK3 == 12 || sumaD1 == 12 || sumaD2 == 12) {
                    System.out.println("wygrał gracz 2");
                    System.exit(0);
                }
            }
        }
    }
    public void zrobRuch(int x, int y, char z) {
        if (z == 'X') {
            s[x][y] = 1;
        } else s[x][y] = 4;
        p.setPlansza(s);
        p.wyswietlPlansze();
    }
    public boolean wczytajRuch(char znak) {    // v2 mrrrr
        Scanner s = new Scanner(System.in);
        String ruch = s.nextLine().toUpperCase();
        String wzorzec = "[A-C][1-3]"; // wyrażenie regularne (regex)
        if ( ruch.matches(wzorzec)){
            int x = ruch.charAt(0)-65;
            int y = ruch.charAt(1)-49;
            if(sprawdzDostepnoscPola(x, y)) {
                zrobRuch(x, y, znak);
                return true;
            }
            System.out.println("Pole jest zajęte!");
            return false;
        }
        System.out.println("You Fucked Up!");
        return false;
    }
    public boolean sprawdzDostepnoscPola(int x, int y) {
            if (s[x][y]>0) return false;
            return true;
    }
    public String wczytajStringa() {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }
}

