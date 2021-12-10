/*
11. Se conoce de una  persona el nombre, el día, mes y año de nacimiento, 
escriba un programa en java que creer tres personas  e imprima para cada una su edad.
 */
package persona;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class Persona {
    
    //se declaran las variables
    private String nombre;
    private String dia;
    private String mes;
    private String ano;
    
    public Persona() {
        
        //se inicializan las variables globales
        this.nombre=null;
        this.dia=null;
        this.mes=null;
        this.ano=null;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    
    public static void main(String[] args) {
        //instanciamos la clase
        Persona pers= new Persona();
        //variables numero de personas y datos de la persona
        int n=3, cont=0, edad=0;
        String formFecha=null;
        Scanner teclado = new Scanner(System.in);
        
        for (int i=0; i<n;i++){
            cont=cont+1;
            System.out.println("Ingrese el nombre Persona "+cont+": "); 
            pers.setNombre(teclado.next());
            System.out.print("Día(00) de nacimiento: "); 
            pers.setDia(teclado.next());
            System.out.print("Mes(00) de nacimiento: "); 
            pers.setMes(teclado.next());
            System.out.print("Ano(1999) de nacimiento: "); 
            pers.setAno(teclado.next());
            formFecha = pers.getDia()+"/"+pers.getMes()+"/"+pers.getAno();
            System.out.println("\nFecha de nacimiento completa "+formFecha+": ");
            
            //calculamos la edad
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaNac = LocalDate.parse(formFecha, fmt);
            LocalDate ahora = LocalDate.now();

            Period periodo = Period.between(fechaNac, ahora);
            System.out.printf("Edad : %s años",periodo.getYears());
            System.out.println("\n--------------------------------------------------------");
        }
    }
    
}
