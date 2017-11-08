package pl.com.knowosad.ticTacToe;


public class Plansza {
    private int[][] plansza = new int[3][3];

    Plansza() {
    }

    public void wyswietlPlansze() {
        System.out.println("     1     2     3  ");
        System.out.println("  -------------------");
        for (int i = 0; i<3 ;i++) {
            if (i==0){
                System.out.print("A ");
            }else if (i==1){
                System.out.print("B ");
            }else {
                System.out.print("C ");
            }
            System.out.print("|  ");
            for (int j = 0; j<3; j++) {
                if (plansza[i][j] == 0) {
                    System.out.print(" ");
                } else if (plansza[i][j] == 1) {
                    System.out.print("X");
                } else System.out.print("O");
                if (j < 2) {
                    System.out.print("  |  ");
                }
            }
            System.out.print("  |");
            System.out.println("\n  -------------------");
        }
    }
    public int[][] getPlansza() {
        return plansza;
    }
    public void setPlansza(int[][] s) {
        this.plansza=s;
    }
}