package classes.LinearRegression;

import jade.core.Agent;
import java.util.Scanner;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;

public class LinearRegression extends Agent {

    private int Size;
    private double[] X;
    private double[] Y;

    private double Ex;
    private double Ey;
    private double Ex2;
    private double Exy;
    private double Pendiente;
    private double Interseccion;

    protected void setup(){
        Object[] args = getArguments();
//        System.out.println(args.length);

//        for(int i=0; i<args.length; i++) {
//            System.out.println("ARG: "+args[i]);
//        }
        int Par = args.length%2;

        if(args != null && args.length >0 && Par == 0 ){

            int Size = (args.length/2);
//            System.out.println(Size);

            X = new double[Size];
            Y = new double[Size];

            for(int i=0; i< Size; i++) {
                X[i] = Double.valueOf((String) args[i]);
//                System.out.println("X: "+X[i]);
                Y[i] = Double.valueOf((String) args[i+Size]);
//                System.out.println("Y: "+Y[i]);
            }

//            for(int i=0; i<Size; i++) {
//                System.out.println("X: "+X[i]);
//                System.out.println("Y: "+Y[i]);
//            }


            Ex = SumatoriaArray(X,Size);
            Ey = SumatoriaArray(Y,Size);
            Ex2 = SumatoriaDeCuadrados(X,Size);
            Exy = SumaDelProducto(X,Y,Size);
            Pendiente = ((Size*Exy) - (Ex*Ey))/((Size*Ex2)-(Ex*Ex));
            Interseccion = ((Ey)-(Pendiente*(Ex)))/(Size);

//            System.out.println("Ex: "+Ex);
//            System.out.println("Ey: "+Ey);
//            System.out.println("Ex2: "+Ex2);
//            System.out.println("Exy: "+Exy);
            System.out.println("Pendiente: "+Pendiente);
            System.out.println("Intersección: "+Interseccion);
            System.out.println("Ecuación resultante de la regresión lineal Y = "+Interseccion+"+"+Pendiente+"(X)");
        }else{
            System.out.println("Faltan argumentos");
            doDelete();
        }
    }

    protected void takeDown(){
        System.out.println("Regression Lineal down");
    }

    public static double SumatoriaArray(double[] X, int Size){
        double sumatoria = 0.0;
        for(int i = 0; i<Size; i++){
            sumatoria = X[i] + sumatoria;
        }
        return sumatoria;
    }

    public static double SumatoriaDeCuadrados(double[] X, int Size){
        double sumatoria = 0.0;
        for(int i = 0; i<Size; i++){
            sumatoria = (X[i]*X[i]) + sumatoria;
        }
        return sumatoria;
    }

    public static double SumaDelProducto(double[] X, double[] Y, int Size){
        double sumatoria = 0.0;
        for(int i = 0; i<Size; i++){
            sumatoria = X[i] * Y[i] + sumatoria;
        }
        return sumatoria;
    }


}
