import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Encryption {

	public static void main(String[] args) throws IOException {
		
		Scanner pen=new Scanner(System.in);
		System.out.println("BIENVENIDO AL ENCRIPTADOR Y DESENCRIPTADOR");   //Primer menu para decidir encriptar o desencriptar
		System.out.println("[1]ENCRIPTAR      [2] DESENCRIPTAR");
		int decide = pen.nextInt();
		if(decide==1) {
		System.out.println("Que deseas encriptar archivo o desde consola");     //Menu si eliges encriptar
		System.out.println("[1]consola   [2]archivo");

		int deci1= pen.nextInt();
		
		if(deci1==1) {
			System.out.println("Digita la clave de al menos 3 caracteres");
			String clave = pen.next();					//Lee la clave como string
			if(clave.length()>2) {	
				Listaencrip code=new Listaencrip();		
				for(int i=0;i<clave.length();i++) {			//mete el string en la lista code
					int c = clave.charAt(i);
					code.insertar(c);
				}
				System.out.println("Ingresa el mensaje a encriptar");
				String mensaje = pen.next();				//lee el mensaje a encriptar
				Listaencrip men=new Listaencrip();
				for(int i=0;i<mensaje.length();i++) {
					int m = mensaje.charAt(i);			//lo convierte a lista
					men.insertar(m);
				}
				Listaencrip resultadocon=new Listaencrip();
				resultadocon=resultadocon.encriptar(men,code);		//llama a la funcion encriptar
				System.out.println("El mesaje encriptado es");
				resultadocon.recorrer();
				System.out.println(" ");
				String h =volver(resultadocon);				//llama a la funcion volver para regresarlo a string
				System.out.println(h);
				
			}
		} if(deci1==2) {
			System.out.println("Digita la clave de al menos 3 caracteres");
			String clave = pen.next();
			if(clave.length()>2) {
				Listaencrip code=new Listaencrip();
				for(int i=0;i<clave.length();i++) {
					int c = clave.charAt(i);
					code.insertar(c);
				}
				System.out.println("Ingresa la ruta del archivo a encriptar ejemplo(C:\\Users\\DELL\\Desktop\\)");
				String leer = pen.next();			//primero lee la ruta
				System.out.println("Ingresa el nombre del archivo, ejemplo(input.txt)");
				String nombre = pen.next();			//despues lee el numbre y extencion del archivo
				File file =new File(leer+nombre);		
				FileReader reader = new FileReader (file);  
				BufferedReader li = new BufferedReader(reader);	//abre el archivo para leerlo
				
				String linea1 = li.readLine();			//pasa lo que tiene la primer linea a string
				Listaencrip men=new Listaencrip();
				for(int i = 0; i < linea1.length(); i++){	//convierte el string a lista
		            int num = linea1.charAt(i);
		            men.insertar(num);
		        }
				Listaencrip resultadocon=new Listaencrip();
				resultadocon=resultadocon.encriptar(men,code);   //llama una lista nueva donde deposita lo que da encriptar
				String salida = System.getProperty("user.home")+"\\"+nombre;  //mediante este metodo System.getProperty("user.home") busca la direccion del usuario
				//resultadocon.recorrer();
				System.out.println("Su archivo se guardo en "+salida);	
				String h =volver(resultadocon);			//devuelve string la lista
				FileWriter fw=new FileWriter(salida);		
		        BufferedWriter bw=new BufferedWriter(fw);
		        bw.write(h);						//escribe en el archivo
		        bw.flush();
		        
		        bw.close();
				reader.close();
				
			}
		}
		}
		if(decide==2) {
			System.out.println("Que deseas desencriptar archivo o desde consola");
			System.out.println("[1]consola   [2]archivo");
			int deci2=pen.nextInt();
			if(deci2==1) {
				System.out.println("Digita la clave desencriptadora ");
				String clave = pen.next();
				if(clave.length()>2) {
					Listaencrip codigo=new Listaencrip();
					for(int i=0;i<clave.length();i++) {
						int c = clave.charAt(i);
						codigo.insertar(c);
					}
					System.out.println("Ingresa el mensaje para desencriptar ");
					String mensajeencrip = pen.next();
					Listaencrip men=new Listaencrip();
					for(int i=0;i<mensajeencrip.length();i++) {
						int m = mensajeencrip.charAt(i);
						men.insertar(m);
					}
					Listaencrip resultadocon=new Listaencrip();
					resultadocon=resultadocon.desencriptar(men, codigo);
					System.out.println("El mesaje desencriptado es");
					resultadocon.recorrer();
					System.out.println(" ");
					String h =volver(resultadocon);
					System.out.println(h);
				}
			}
			 if(deci2==2){
				System.out.println("Digita la clave desencriptadora");
				String clave = pen.next();
				if(clave.length()>2) {
					Listaencrip codigo1=new Listaencrip();
					for(int i=0;i<clave.length();i++) {
						int c = clave.charAt(i);
						codigo1.insertar(c);
					}
					System.out.println("Ingresa la ruta del archivo a encriptar ejemplo(C:\\Users\\DELL\\Desktop\\)");
					String leer = pen.next();
					System.out.println("Ingresa el nombre del archivo, ejemplo(input.txt)");
					String nombre = pen.next();
					File file =new File(leer+nombre);
					FileReader reader = new FileReader (file);  
					BufferedReader li = new BufferedReader(reader);
					
					String linea = li.readLine();
					Listaencrip mensaje=new Listaencrip();
					for(int i = 0; i < linea.length(); i++){	
			            int num = linea.charAt(i);
			            mensaje.insertar(num);
			        }
					Listaencrip resultado=new Listaencrip();
					resultado=resultado.desencriptar(mensaje,codigo1);
					String salida = System.getProperty("user.home")+"\\"+nombre;
					resultado.recorrer();
					System.out.println("Su archivo se guardo en "+salida);
					String h =volver(resultado);
					FileWriter fw=new FileWriter(salida);
			        BufferedWriter bw=new BufferedWriter(fw);
			        bw.write(h);
			        bw.flush();
			        
			        bw.close();
					reader.close();
				}
			}
		}
				
		
}
		
	
	public static String volver(Listaencrip x) { //devuelve el ascii a caracter
		StringBuilder regreso = new StringBuilder();
		NodoCircu aux=x.inicio;
		
		int i=0;
		do {
			String temp= Character.toString((char)aux.dato);
			regreso.insert(i, temp);
			i++;
			aux=aux.siguiente;
		}while(aux!=x.inicio);
		return regreso.toString();
	}

}
