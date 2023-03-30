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
                if (estudiantes[49][0] == 0) {
                    estudiantes = agregarEstudiante(estudiantes);
                    imprimirMatriz(estudiantes);
                    menu(estudiantes);
                }else {
                    System.out.println("Cantidad de alumnos maxima, no se puede añadir mas");
                    menu(estudiantes);
                }
                break;
            case 2:
                if (estudiantes[0][0] != 0) {
                    quienAprobo(estudiantes);
                    menu(estudiantes);
                }else {
                    System.out.println("Lo sentimos, no hay estudiantes para realizar la operacion");
                    menu(estudiantes);
                }
                break;
            case 3:
                if (estudiantes[0][0] != 0) {
                    reprobaron(estudiantes);
                    menu(estudiantes);
                }else {
                    System.out.println("Lo sentimos, no hay estudiantes para realizar la operacion");
                    menu(estudiantes);
                }
                break;
            case 4:
                if (estudiantes[0][0] != 0) {
                    examen(estudiantes);
                    menu(estudiantes);
                }else {
                    System.out.println("Lo sentimos, no hay estudiantes para realizar la operacion");
                    menu(estudiantes);
                }
                break;
            case 5:
                if (estudiantes[0][0] != 0) {

                    mostrarTodo(estudiantes);
                    menu(estudiantes);
                }else {
                    System.out.println("Lo sentimos, no hay estudiantes para realizar la operacion");
                    menu(estudiantes);
                }
                break;
            case 6:
                System.out.println("Hasta la proxima");
                break;

        }
    }

    private static void examen(double[][] estudiantes) {
        int examen = 0;
        double promedio = 0.0;

        for (int i = 0; i < 50; i++) {
            if (estudiantes[i][0] != 0){
                promedio = promedioPonderado(estudiantes,i);
                if (promedio >= 3.6 && promedio <4) {
                    examen++;
                }
            }

        }
        System.out.println("Examen: "+ examen);
    }

    private static void reprobaron(double[][] estudiantes) {
        int reprobaron = 0;
        double promedio = 0.0;

        for (int i = 0; i < 50; i++) {
            if (estudiantes[i][0] != 0){
                promedio = promedioPonderado(estudiantes,i);
                if (promedio < 3.6) {
                    reprobaron++;
                }
            }

        }
        System.out.println("Reprobaron: "+ reprobaron);
    }


    private static void mostrarTodo(double[][] estudiantes) {
        double prom = 0.0;
        for (int i = 0; i < 50; i++) {
            if (estudiantes[i][0] != 0){
                System.out.print("Notas: ");
                System.out.println(" "+estudiantes[i][0]+" "+estudiantes[i][1]+" "+estudiantes[i][2]+" "+estudiantes[i][3]+" "+estudiantes[i][4]);
                System.out.println("Promedio: "+promedioPonderado(estudiantes,i));
            }


        }
    }



    private static void quienAprobo(double[][] estudiantes) {
        int aprobaron = 0;
        double promedio = 0.0;

        for (int i = 0; i < 50; i++) {
            if (estudiantes[i][0] != 0){
                promedio = promedioPonderado(estudiantes,i);
                if (promedio >= 4.0) {
                    aprobaron++;
                }
            }

        }
        System.out.println("Aprobados: "+ aprobaron);
    }

    private static double promedioPonderado(double[][] estudiantes, int i){
        double ponderacion1 = estudiantes[i][0] * 0.25;
        double ponderacion2 = estudiantes[i][1] * 0.25;
        double ponderacion3 = estudiantes[i][2] * 0.25;
        double ponderacion4 = estudiantes[i][3] * 0.15;
        double ponderacion5 = estudiantes[i][4] * 0.10;

        double promedio = ponderacion1 + ponderacion2 +ponderacion3 + ponderacion4 + ponderacion5;

        return promedio;



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
        double nota = 0;
        for (int j = 0; j < 5; j++) {
            do {
                nota = Math.random()*(7-1+1)+1;
            }while (nota > 7);
            estudiantes[i][j] = nota;

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
