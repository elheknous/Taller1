import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        double [][] estudiantes = new double[50][5];
        menu(estudiantes);
    }

    private static void menu(double[][] estudiantes) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1- Agregar estudinates: ");
        System.out.println("2- Mostrar cantidad de estudiantes que aprueban la asignatura");
        System.out.println("3- Mostrar cantidad de estudiantes que reprueban la asignatura");
        System.out.println("4- Mostrar la cantidad de estudiantes que van a examen");
        System.out.println("5- Mostrar el estado de todos los estudiantes de la asignatura (notas y promedio)");
        System.out.println("6- Salir");
        int opcion = sc.nextInt();
        switch (opcion){
            case 1:
                estudiantes = agregarEstudiante(estudiantes);
                imprimirMatriz(estudiantes);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:

                break;
            case 5:
                break;
            case 6:
                System.out.println("Hasta la proxima");
                break;

        }
    }

    private static double[][] agregarEstudiante(double[][] estudiantes) {
        for (int i = 0; i < 50; i++) {
            if (estudiantes[i][0] == 0){
                estudiantes = agregarNotas(estudiantes,i);
                break;
            }

        }
        return estudiantes;
    }

    private static double[][] agregarNotas(double[][] estudiantes, int i) {
        double nota = Math.random()*(7-1+1)+1;
        for (int j = 0; j < 5; j++) {
            estudiantes[i][j] = Math.random()*(7-1+1)+1;

        }
        return estudiantes;
    }


    private static void imprimirMatriz(double[][] matriz) {
        String[] notas = {"Nota 1","Nota 2","Nota 3","Nota 4","Nota 5"};

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("["+matriz[i][j]+"]");
            }
            System.out.println();
        }
    }

}
