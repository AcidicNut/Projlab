package Program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException{

        Map m = new Map();
        Tile T1 = new Tile();
        Tile T2 = new Tile();
        Tile T3 = new Tile();
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

        //Egy dobozt megtol egy játékos
        System.out.println("A doboz mozgatható vagy sem? (true/false)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String d = br.readLine();
        if (d.equalsIgnoreCase("true"))
            b.setMovable(true);
        else
            b.setMovable(false);
        p.Move(Direction.right);


 
    }
}