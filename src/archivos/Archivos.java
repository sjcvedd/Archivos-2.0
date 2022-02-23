
package archivos;
import java.io.*;

class nodo{
    String nombre, cedula, materia;
    double nota;
    nodo siguiente;
    nodo(String nom, String Ced, String Mat, double nota){
        this.cedula=Ced;
        this.nombre=nom;
        this.materia=Mat;
        this.nota=nota;
    }
}
class lista{
    nodo L;
    lista(){
        L = null;
    }
    void crear(String Nombre, String Cedula, String Materia, double nota) {
        if (L==null) {
            L=new nodo(Nombre, Cedula, Materia, nota);
        }else{
            nodo aux = L;
            while (aux.siguiente != null)
                aux=aux.siguiente;
            aux.siguiente = new nodo(Nombre, Cedula, Materia, nota);
        }
    }
}

class estudiante
{
    String cedula;
    String nombre;
    String asignatura;
    double nota=0;
    double nota1=0;
    double nota2=0;
    double nota3=0;
    
    void registrar() throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Cedula");
        this.cedula=br.readLine();
        System.out.println("Nombre");
        this.nombre=br.readLine();
        System.out.println("Asignatura");
        this.asignatura=br.readLine();
        try{
            System.out.println("Nota 1.");
            this.nota1=Double.parseDouble(br.readLine());
        }
        catch (Exception e) 
        {
            System.out.println("Valor de entrada incorrecto!!");
        }
        try{
            System.out.println("Nota 2.");
            this.nota2=Double.parseDouble(br.readLine());
        }
        catch (Exception e) 
        {
            System.out.println("Valor de entrada incorrecto!!");
        }
        try{
            System.out.println("Nota 3.");
            this.nota3=Double.parseDouble(br.readLine());
        }
        catch (Exception e) 
        {
            System.out.println("Valor de entrada incorrecto!!");
        }
        nota=((nota1*35/100)+(nota2*0.35)+(nota3*0.30));
        guardar();
        
    }
    
    void guardar() throws IOException
    {
        String datos;
        datos=cedula+"//"+nombre+"//"+asignatura+"//"+nota;
        archivo arch=new archivo();
        arch.crear("estudiante.txt", datos);
    }
    
    
}

class archivo
{
    PrintWriter pf;
    FileReader fr;
    
    void crear(String pNombre,String pDatos) throws IOException
    {
        pf=new PrintWriter(new FileWriter(pNombre, true));
        pf.println(pDatos);
        pf.close();
        System.out.println("Generacion ok");
        
    }
    
    void leer(String pNombre, lista lis) throws IOException
    {
        fr=new FileReader("estudiante.txt");
        BufferedReader br=new BufferedReader(fr);
        String linea;
        while ((linea=br.readLine())!=null)
        {
            String[] datos=new String[4];
            datos=linea.split("//");
            String cedula = datos[0];
            String nombre = datos[1];
            String materia = datos[2];
            double nota = Double.parseDouble(datos[3]);
            lis.crear(nombre, cedula, materia, nota);
        }
    }
}
public class Archivos {

    
    public static void main(String[] args) throws IOException 
    {
        String[][] a= new String[4][3];
        lista lis = new lista();
        a[0]=new String[10];
        a[0][0]="afjdfaspdmsopa";
        a[0][1]="afjdfaspdmsopa";
        a[0][2]="afjdfaspdmsopa";
        //System.out.println("**Bienvenido Introduzca al Estudiante**");
        //estudiante estu=new estudiante();//creacion de objeto de la clase estudiante//
        //estu.registrar(); //abstraccion//
        archivo ar=new archivo();
        ar.leer("estudiante.txt", lis);
        
    }
}
