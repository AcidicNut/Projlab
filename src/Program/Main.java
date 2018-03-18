package Program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static void elsoTeszt() throws IOException {
        Map m = new Map();
        Tile T1 = new Tile(m);
        Tile T2 = new Tile(m);
        Tile T3 = new Tile(m);
        Player p = new Player();        //Néhány objektum példányosítása a példákhoz.
        Box b = new Box();

        m.tiles.add(T1);
        m.tiles.add(T2);
        m.tiles.add(T3);
        T1.Add(p);
        T2.Add(b);
        //Tile-ok egymás mellé helyezése
        T1.SetNeighbour(Direction.right,T2);
        T2.SetNeighbour(Direction.left,T1);
        T2.SetNeighbour(Direction.right,T3);
        T3.SetNeighbour(Direction.left,T2);

        System.out.println("ITT KEZDŐDIK A TESZT");
        System.out.println("Player tol Box");

        //Egy dobozt megtol egy játékos
        System.out.println("? A doboz mozgatható vagy sem? (true/false)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String d = br.readLine();
        if (d.equalsIgnoreCase("true"))
            b.setMovable(true);
        else
            b.setMovable(false);
        p.Move(Direction.right);

        System.out.println("\n----------------------\n");
    }

    private static void masodikTeszt() throws IOException {
        Map m = new Map();
        Tile T1 = new Tile(m);
        Tile T2 = new Tile(m);
        Tile T3 = new Tile(m);
        Box b = new Box();        //Néhány objektum példányosítása a példákhoz.
        Box b2 = new Box();

        m.tiles.add(T1);
        m.tiles.add(T2);
        m.tiles.add(T3);
        T1.Add(b);
        T2.Add(b2);
        //Tile-ok egymás mellé helyezése
        T1.SetNeighbour(Direction.right,T2);
        T2.SetNeighbour(Direction.left,T1);
        T2.SetNeighbour(Direction.right,T3);
        T3.SetNeighbour(Direction.left,T2);

        System.out.println("ITT KEZDŐDIK A TESZT");
        System.out.println("Box tol Box\nDobozok nem tudnak maguktol mozogni, ezert egy Player tolja az elso dobozt.");

        System.out.println("? A doboz mozgatható vagy sem? (true/false)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String d = br.readLine();
        b.setMovable(true);
        if (d.equalsIgnoreCase("true"))
            b2.setMovable(true);
        else
            b2.setMovable(false);
        b.HitBy(new Player(),Direction.right);

        System.out.println("\n----------------------\n");
    }

    private static void harmadikTeszt() {
        Map m = new Map();
        Tile T1 = new Tile(m);
        Tile T2 = new Tile(m);
        Player p = new Player();       //Néhány objektum példányosítása a példákhoz.
        Wall w = new Wall();

        m.tiles.add(T1);
        m.tiles.add(T2);
        T1.Add(p);
        T2.Add(w);
        //Tile-ok egymás mellé helyezése
        T1.SetNeighbour(Direction.right,T2);
        T2.SetNeighbour(Direction.left,T1);

        System.out.println("ITT KEZDŐDIK A TESZT");
        System.out.println("Falnak megy a Player\n" +
                "Mivel jelenlegi specifikáció szerint a Wall és a Pillar viselkedése megegysezik ezért csak az egyik kerül bemutatásra");

        p.Move(Direction.right);

        System.out.println("\n----------------------\n");
    }

    private static void negyedikTeszt(){
        Map m = new Map();
        Tile T1 = new Tile(m);
        Tile T2 = new Tile(m);
        Box b = new Box();        //Néhány objektum példányosítása a példákhoz.
        Wall w = new Wall();

        m.tiles.add(T1);
        m.tiles.add(T2);
        T1.Add(b);
        T2.Add(w);
        //Tile-ok egymás mellé helyezése
        T1.SetNeighbour(Direction.right,T2);
        T2.SetNeighbour(Direction.left,T1);

        System.out.println("ITT KEZDŐDIK A TESZT");
        System.out.println("(Box) Dobozt neki lok egy jatekos egy falnak. " +
                "\nA jelenlegi specifikacio szerint a fal es az oszlop ugyan ugy viselkedik, " +
                "\ntehat ez a teszteset lefedi azt is amikor a dobozt egy oszlopnak lokjuk.");
        b.HitBy(new Player(), Direction.right);

        System.out.println("\n----------------------\n");
    }

    public  static void otodikTeszt() {
        Map m = new Map();
        Tile T1 = new Tile(m);
        Tile T2 = new Tile(m);
        Box b = new Box();        //Néhány objektum példányosítása a példákhoz.
        Goal g = new Goal();

        m.tiles.add(T1);
        m.tiles.add(T2);
        T1.Add(b);
        T2.Add(g);
        //Tile-ok egymás mellé helyezése
        T1.SetNeighbour(Direction.right, T2);
        T2.SetNeighbour(Direction.left, T1);

        System.out.println("ITT KEZDŐDIK A TESZT");
        System.out.println("(Box) Dobozt neki lok egy jatekos egy celnak. " +
                "\nDobozok nem tudnak maguktol mozogni, ezert egy Player tolja a dobozt," +
                "\nami így a celra er.");
        b.HitBy(new Player(), Direction.right);


        System.out.println("\n----------------------\n");

    }

    private static void hatodikTeszt() throws IOException{
        Map m = new Map();
        Tile T1 = new Tile(m);
        Tile T2 = new Tile(m);
        Player p = new Player();       //Néhány objektum példányosítása a példákhoz.
        // Hole h = new Hole();

        m.tiles.add(T1);
        m.tiles.add(T2);
        T1.Add(p);
        //   T2.Add(h);
        //Tile-ok egymás mellé helyezése
        T1.SetNeighbour(Direction.right,T2);
        T2.SetNeighbour(Direction.left,T1);



        System.out.println("Player lyukba esik");

        System.out.println("? A lyuk aktív-e (true/false)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String d = br.readLine();
        if (d.equalsIgnoreCase("true"))
        {
            Hole h = new Hole(true);
            T2.Add(h);
        }
        else
        {
            Hole h = new Hole(false);
            T2.Add(h);
        }

        System.out.println("ITT KEZDŐDIK A TESZT");



        p.Move(Direction.right);
    }

    private static void hetedikTeszt() throws IOException {
        System.out.println("Box leesik egy lyukba\n" +
                "(Box) Dobozt nem tud magatol mozogni, ezert egy jatekos tolja bele a lyukba. ");
        System.out.println("? A lyuk aktiv? (true/false)");
        Hole h;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String d = br.readLine();
        if (d.equalsIgnoreCase("true")) {
            h = new Hole(true);
        } else {
            h = new Hole(true);
        }

        Map m = new Map();
        Tile T1 = new Tile(m);
        Tile T2 = new Tile(m);
        Box b = new Box();       //Néhány objektum példányosítása a példákhoz.


        m.tiles.add(T1);
        m.tiles.add(T2);
        T1.Add(b);
        T2.Add(h);
        //Tile-ok egymás mellé helyezése
        T1.SetNeighbour(Direction.right,T2);
        T2.SetNeighbour(Direction.left,T1);

        System.out.println("\nITT KEZDŐDIK A TESZT");

        b.HitBy(new Player(),Direction.right);

        System.out.println("\n----------------------\n");
    }


    public static void tizedikTeszt(){

        //Néhány objektum példányosítása a példákhoz.
        Map m = new Map();
        Tile T1 = new Tile(m);
        Tile T2 = new Tile(m);
        Tile T3 = new Tile(m);
        Tile T4 = new Tile(m);
        Hole h = new Hole(true);
        Switch s = new Switch(h);

        Box b = new Box();
        Player p = new Player();

        m.tiles.add(T1);
        m.tiles.add(T2);
        m.tiles.add(T3);
        m.tiles.add(T4);
        T1.Add(s);
        T2.Add(b);
        T3.Add(p);
        T4.Add(h);

        //Tile-ok egymás mellé helyezése
        T1.SetNeighbour(Direction.right,T2);
        T2.SetNeighbour(Direction.left,T1);
        T2.SetNeighbour(Direction.right,T3);
        T3.SetNeighbour(Direction.left,T2);
        T3.SetNeighbour(Direction.right,T4);
        T4.SetNeighbour(Direction.left,T3);



        System.out.println("ITT KEZDŐDIK A TESZT");

        p.Move(Direction.left);
        System.out.println("\n----------------------\n");
    }

    public static void main(String args[]) throws IOException{
        //Itt majd lesz egy menu amiben ki lehet valasztani a tesztesetet.
        System.out.println("Elso teszt: \n");
     /*   elsoTeszt();
        masodikTeszt();
        harmadikTeszt();
        negyedikTeszt();
        otodikTeszt();
        hatodikTeszt();
        hetedikTeszt();*/
        tizedikTeszt();
    }
}