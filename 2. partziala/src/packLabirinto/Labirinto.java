package packLabirinto;

import java.util.Stack;

public class Labirinto {

    public class Lauki{
        int x;
        int y;
        int z;


        public Lauki(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
        public int getX(){
            return this.x;
        }
        public int getY(){
            return this.y;
        }
        public int getZ(){
            return this.z;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Lauki other = (Lauki) obj;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            if (z != other.z)
                return false;
            return true;
        }
    }

    private char [][][] labirinto = {
            {   {'_','X','_'},
                {'X','X','X'},
                {'_','X','_'}
            },
            {   {'_','_','X'},
                {'X','_','X'},
                {'_','X','_'}
            },
            {   {'_','X','_'},
                {'_','_','_'},
                {'_','X','_'}
            }
    };

        //labirinto [x][y][z]== '_' , lauki hori pasiloa da.
        //labirinto [x][y][z]== 'X' , lauki hori horma da.

    public boolean bideaDago(){
        //post: emaitza true da bide bat baldin badadgo hasierako laukitik ([0,0,0]laukia) eskuineko
        //        beheko laukira, false bestela.
        //Lauki bat emanda, 6 mugimendu egin daitezke: aurrera, atzera, gora, behera, ezkerrera edo eskuinera.
        boolean aurk= false;
        Lauki hasiera= new Lauki(0,0,0);
        Lauki helburua= new Lauki(labirinto.length-1, labirinto[0].length-1,labirinto[0][0].length-1);
        Stack<Lauki> aztGabeak = new Stack<>();
        aztGabeak.push(hasiera);
        boolean [][][] aztertuak = new boolean[labirinto.length][labirinto[0].length][labirinto[0][0].length];
        for (int k = 0; k < aztertuak.length-1; k++) {
            for (int l=0; l<aztertuak[0].length-1; l++){
                for (int n=0; n<aztertuak[0][0].length-1; n++){
                    aztertuak[k][l][n]=false;
                }
            }
        }
        aztertuak[0][0][0]= true;

        while (!aztGabeak.isEmpty() && !aurk){
            Lauki unekoa = aztGabeak.pop();
            if (unekoa.equals(helburua)){
                aurk = true;
            }
            else{
                //kasu 1
                int x = unekoa.getX()-1;
                int y = unekoa.getY();
                int z = unekoa.getZ();
                if(this.barruan(x, y , z) && labirinto[x][y][z]!='X' && !aztertuak[x][y][z] ){
                    aztGabeak.push(new Lauki(x, y , z));
                    aztertuak[x][y][z]=true;
                }
                //kasu 2
                x = unekoa.getX()+1;
                y = unekoa.getY();
                z = unekoa.getZ();
                if(this.barruan(x, y , z) && labirinto[x][y][z]!='X' && !aztertuak[x][y][z] ){
                    aztGabeak.push(new Lauki(x, y , z));
                    aztertuak[x][y][z]=true;
                }
                //kasu 3
                x = unekoa.getX();
                y = unekoa.getY()-1;
                z = unekoa.getZ();
                if(this.barruan(x, y , z) && labirinto[x][y][z]!='X' && !aztertuak[x][y][z] ){
                    aztGabeak.push(new Lauki(x, y , z));
                    aztertuak[x][y][z]=true;
                }
                //kasu 4
                x = unekoa.getX();
                y = unekoa.getY()+1;
                z = unekoa.getZ();
                if(this.barruan(x, y , z) && labirinto[x][y][z]!='X' && !aztertuak[x][y][z] ){
                    aztGabeak.push(new Lauki(x, y , z));
                    aztertuak[x][y][z]=true;
                }
                //kasu 5
                x = unekoa.getX();
                y = unekoa.getY();
                z = unekoa.getZ()-1;
                if(this.barruan(x, y , z) && labirinto[x][y][z]!='X' && !aztertuak[x][y][z] ){
                    aztGabeak.push(new Lauki(x, y , z));
                    aztertuak[x][y][z]=true;
                }
                //kasu 6
                x = unekoa.getX();
                y = unekoa.getY();
                z = unekoa.getZ()+1;
                if(this.barruan(x, y , z) && labirinto[x][y][z]!='X' && !aztertuak[x][y][z] ){
                    aztGabeak.push(new Lauki(x, y , z));
                    aztertuak[x][y][z]=true;
                }
            }
        }

        return aurk;
    }

    public boolean barruan(int x, int y, int z){
        boolean ema= true;
        if (x<0 || y<0 || z<0){
            ema=false;
        }
        if(labirinto.length-1<x || labirinto[0].length-1<y || labirinto[0][0].length-1<z ){
            ema=false;
        }
        return ema;
    }

    public static void main(String[] args) {
        Labirinto l = new Labirinto();
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" main");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(l.bideaDago());
    }
}
