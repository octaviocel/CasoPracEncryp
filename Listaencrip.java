
public class Listaencrip {

	  NodoCircu inicio = null;
	  NodoCircu pivote = null;
	    
	    public void insertar(int dato){   		//inserta un nodo circular
	    	NodoCircu nuevo =new NodoCircu();
	    	nuevo.dato=dato;
	    	nuevo.siguiente=nuevo;
	        if(inicio==null){
	        	inicio = nuevo;
	            pivote = nuevo;
	        }
	        else{
	        	
	            NodoCircu aux = inicio;
	            while(aux.siguiente != inicio){
	                aux = aux.siguiente;
	            }
	            
	            aux.siguiente = nuevo;
	            nuevo.siguiente = inicio;
	        }
	        
	    }
	    
	    public void recorrer(){			//imprime el nodo
	        
	        if(inicio != null){
	            
	        	NodoCircu aux = inicio;
	            do{
	                System.out.print(aux.dato+" ");
	                aux = aux.siguiente;
	                        
	            }while(aux != inicio);
	        }        
	    }
	    public Listaencrip encriptar(Listaencrip mensaje,Listaencrip codigo) {  //encripta mediante un mensaje y una clave(codigo)
	    	NodoCircu a = mensaje.inicio.siguiente;
	    	NodoCircu b = codigo.inicio.siguiente;
	    	//a.siguiente=a;
	    	Listaencrip res=new Listaencrip();
	    	int x =mensaje.inicio.dato+codigo.inicio.dato;			//primero suma lo que tiene primero las listas
	    	if(x>255) {							//si es mayor a255 le quita 255 y lo inserta
	    		x-=255;
	    	}res.insertar(x);
	    	while(a!=mensaje.inicio) {					// y mientras no vuelva al inicio va a hacerlo n veces
	    		
	    		int temp= a.dato+b.dato;
	    		if(temp>255) {
	    			temp=temp-255;
	    			res.insertar(temp);
	    		}else {
	    			res.insertar(temp);
	    		}
	    		b=b.siguiente;
	    		a=a.siguiente;
	    	}
	    	
	    	return res;					//regresa una lista
	    	
	    }
	    public Listaencrip desencriptar(Listaencrip mensaje,Listaencrip codigo) { // desepcripta, hace el proceso inverso a encriptar
	    	NodoCircu z = mensaje.inicio.siguiente;
	    	NodoCircu v = codigo.inicio.siguiente;
	    	//a.siguiente=a;
	    	Listaencrip resen=new Listaencrip();
	    	int w =mensaje.inicio.dato-codigo.inicio.dato;
	    	if(w<0) {
	    		w= w + 255;
	    	}resen.insertar(w);
	    	while(z!=mensaje.inicio) {
	    		
	    		int tempo= z.dato-v.dato;
	    		if(tempo<0) {
	    			tempo=tempo+255;
	    			resen.insertar(tempo);
	    		}else {
	    			resen.insertar(tempo);
	    		}
	    		z=z.siguiente;
	    		v=v.siguiente;
	    	}
	    	
	    	return resen;
	    	
	    }
	   
}
