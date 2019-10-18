package lab.pkg2_gabriel.vasquez;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Gabriel Vasquez
 */
public class Lab2_GabrielVasquez {
    
    static Scanner input = new Scanner(System.in);
    static Random r = new Random();

    public static void main(String[] args) {
        
        ArrayList lista = new ArrayList();
        
        System.out.printf("%s\n%s" ,"1 - Crear Universidad\n2 - Eliminar Universidad\n3 - Log In\n4 - Ascender Universidad\n"
                + "5 - Listar Universidades y su Sucursal\n6 - Modificar Universidad\n7 - Descender Universidad\n8 - RANDOM",
                "Ingrese la opción que desea: ");
        int option = input.nextInt();
        
        while(option != 3){
            System.out.println("Debe seleccionar la opción 3 - Log In para poder iniciar.");
            System.out.printf("\n%s\n%s" ,"1 - Crear Universidad\n2 - Eliminar Universidad\n3 - Log In\n4 - Ascender Universidad\n"
                + "5 - Listar Universidades y su Sucursal\n6 - Modificar Universidad\n7 - Descender Universidad\n8 - RANDOM",
                "Ingrese la opción que desea: ");
        option = input.nextInt();
        }
        
        while(option != 0){
        
            switch(option){

                case 1:
                    System.out.println();
                    
                    String nombre;
                    System.out.print("Nombre de la Universidad: ");
                    input.nextLine();
                    nombre = input.nextLine();

                    String rector;
                    System.out.print("Nombre del Rector: ");
                    input.next();
                    rector = input.nextLine();

                    System.out.print("Sucursal: ");
                    String sucursal = input.next();

                    System.out.print("Año de Creación: ");
                    int año = input.nextInt();

                    System.out.print("Cantidad de Maestros: ");
                    int maestros = input.nextInt();

                    System.out.print("Cantidad de Estudiantes: ");
                    int estudiantes = input.nextInt();

                    System.out.print("Nivel [1 - Privada | 2 - Pública]: ");
                    int niv = input.nextInt();
                    String nivel;
                    int costo;
                    if(niv == 1){
                        nivel = "Privada";
                        costo = 6000;
                        
                    }
                    else{
                        nivel = "Pública";
                        costo = 0;
                    }

                    Universidad u = new Universidad(nombre, rector, sucursal, año, maestros, estudiantes, costo, nivel);
                    lista.add(u);
                    break;

                case 2:
                    System.out.println();
                    
                    System.out.println("Posición de la Universidad a Eliminar: ");
                    int pos = input.nextInt();
                    if (pos > lista.size()) {
                        System.out.println("Posición Incorrecta");
                    }
                    else{
                        lista.remove(pos);
                    }
                    break;

                case 3:
                    System.out.println();
                    
                    System.out.print("Ingrese su usuario: ");
                    String usuario = input.next();
                    while(!"leobanegas".equals(usuario)){
                        System.out.println("Ha ingresado un usuario y/o contraseña incorrecto");
                        System.out.print("Ingrese su usuario: ");
                        usuario = input.next();
                    }
                    System.out.print("Ingrese contraseña: ");
                    String contraseña = input.next();
                    while(!"99".equals(contraseña)){
                        System.out.println("Ha ingresado un usuario y/o contraseña incorrecto");
                        System.out.print("Ingrese contraseña: ");
                        contraseña = input.next();
                    }
                    break;

                case 4:
                    System.out.println();
                    
                    System.out.println("Posición de la Universidad a Ascender: ");
                    pos = input.nextInt();
                    if (pos > lista.size()) {
                        System.out.println("Posición Incorrecta");
                    }
                    else{
                        if( ((Universidad)lista.get(pos)).getNivel().equals("Pública") ){
                            ((Universidad)lista.get(pos)).setNivel("Pública Prestigiosa");
                            ((Universidad)lista.get(pos)).setCosto(200);
                        }
                        else if( ((Universidad)lista.get(pos)).getNivel().equals("Privada") ){
                            ((Universidad)lista.get(pos)).setNivel("Privada Prestigiosa");
                            ((Universidad)lista.get(pos)).setCosto(12000);
                        }
                        else if( ((Universidad)lista.get(pos)).getNivel().equals("Pública Prestigiosa") ){
                            int cont = 0;
                            for (Object t : lista) {
                                if(((Universidad)t).getNivel().equals("Nacional")){
                                    cont++;
                                }
                            }
                            if(cont >= 1){
                                System.out.println("Ya existe una Universidad Nacional");
                            }
                            else{
                                ((Universidad)lista.get(pos)).setNivel("Nacional");
                                ((Universidad)lista.get(pos)).setCosto(500);
                            }
                        }
                        else if( ((Universidad)lista.get(pos)).getNivel().equals("Privada Prestigiosa") ){
                            System.out.println("La Universidad es Privada Prestigiosa y no puede tener un nivel más alto");
                        }
                    }
                    break;

                case 5:
                    System.out.println();
                    
                    String salida = "";
                    for (Object t : lista) {
                            salida += lista.indexOf(t) + " - " + t + "\n";
                    }
                    System.out.println(salida);
                    break;

                case 6:
                    System.out.println();
                    
                    System.out.println("Posición de la Universidad a Modificar: ");
                    int post = input.nextInt();
                    if (post > lista.size()) {
                        System.out.println("Posición Incorrecta");
                    }
                    else{
                        System.out.print("1- Nombre, 2- Rector, 3- Sucursal, 4- Año, 5- N. Maestros"
                                + ", 6- N. Estudiantes, 7- Nivel\n¿Qúe desea Modificar?");
                        int mod = input.nextInt();
                        switch(mod){
                            case 1:
                            System.out.print("Nombre de la Universidad: ");
                            input.nextLine();
                            nombre = input.nextLine();
                            ( (Universidad)lista.get(post) ).setNombre(nombre);
                            break;

                            case 2:
                            System.out.print("Nombre del Rector: ");
                            input.nextLine();
                            rector = input.nextLine();
                            ( (Universidad)lista.get(post) ).setRector(rector);
                            break;
                            
                            case 3:
                            System.out.print("Sucursal: ");
                            sucursal = input.next();
                            ( (Universidad)lista.get(post) ).setSucursal(sucursal);
                            break;

                            case 4:
                            System.out.print("Año de Creación: ");
                            año = input.nextInt();
                            ( (Universidad)lista.get(post) ).setAño(año);
                            break;

                            case 5:
                            System.out.print("Cantidad de Maestros: ");
                            maestros = input.nextInt();
                            ( (Universidad)lista.get(post) ).setMaestros(maestros);
                            break;

                            case 6:
                            System.out.print("Cantidad de Estudiantes: ");
                            estudiantes = input.nextInt();
                            ( (Universidad)lista.get(post) ).setEstudiantes(estudiantes);
                            break;

                            case 7:
                            System.out.print("Nivel [1 - Privada | 2 - Pública]: ");
                            niv = input.nextInt();
                            if(niv == 1){
                                nivel = "Privada";
                            }
                            else{
                                nivel = "Pública";
                            }
                            ( (Universidad)lista.get(post) ).setNivel(nivel);
                            break;
                        }
                    }
                    break;

                case 7:
                    System.out.println();
                    
                    System.out.println("Posición de la Universidad a Descender: ");
                    pos = input.nextInt();
                    if (pos > lista.size()) {
                        System.out.println("Posición Incorrecta");
                    }
                    else{
                        if( ((Universidad)lista.get(pos)).getNivel().equals("Pública") ){
                            lista.remove(((Universidad)lista.get(pos)));
                        }
                        else if( ((Universidad)lista.get(pos)).getNivel().equals("Privada") ){
                            lista.remove(((Universidad)lista.get(pos)));
                        }
                        else if( ((Universidad)lista.get(pos)).getNivel().equals("Pública Prestigiosa") ){
                            ((Universidad)lista.get(pos)).setNivel("Pública");
                            ((Universidad)lista.get(pos)).setCosto(0);
                        }
                        else if( ((Universidad)lista.get(pos)).getNivel().equals("Privada Prestigiosa") ){
                            ((Universidad)lista.get(pos)).setNivel("Privada");
                            ((Universidad)lista.get(pos)).setCosto(6000);
                        }
                        else if( ((Universidad)lista.get(pos)).getNivel().equals("Nacional") ){
                            ((Universidad)lista.get(pos)).setNivel("Pública Prestigiosa");
                            ((Universidad)lista.get(pos)).setCosto(200);
                        }
                    }
                    break;

                case 8:
                    System.out.println();
                    
                    int rand = 0 + r.nextInt(lista.size()-1);
                    int cont = 0;
                    int old = 0;
                    for (Object t : lista) {
                        if(((Universidad)t).getNivel().equals("Nacional")){
                            cont++;
                            old = lista.indexOf(t);
                        }
                    }
                    if(cont >= 1){
                        ((Universidad)lista.get(old)).setNivel("Pública Prestigiosa");
                        ((Universidad)lista.get(old)).setCosto(200);
                        ((Universidad)lista.get(rand)).setNivel("Nacional");
                        ((Universidad)lista.get(rand)).setCosto(500);
                    }
                    else if( ((Universidad)lista.get(rand)).getNivel().equals("Pública Prestigiosa") ){
                        ((Universidad)lista.get(rand)).setNivel("Nacional");
                        ((Universidad)lista.get(rand)).setCosto(500);
                    }
                    break;

                default:
                    System.exit(0);
                
            }
            
            System.out.printf("\n%s\n%s" ,"1 - Crear Universidad\n2 - Eliminar Universidad\n3 - Log In\n4 - Acender Universidad\n"
                + "5 - Listar Universidades y su Sucursal\n6 - Modificar Universidad\n7 - Descender Universidad\n8 - RANDOM",
                "Ingrese la opción que desea: ");
                option = input.nextInt();
            
        }
        
    }
    
}