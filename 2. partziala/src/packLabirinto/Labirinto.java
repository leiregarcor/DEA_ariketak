package packLabirinto;

public class Labirinto {

    public class Lauki{
        int x;
        int y;
        int Z;
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
        boolean ema= false;

        return ema;
    }
}
