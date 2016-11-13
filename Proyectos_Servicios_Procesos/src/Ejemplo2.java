import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo2 {

	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		String comando = "cmd /c pin 8.8.8.8";
		Process p = null;
		try {
			p = r.exec( comando );
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String linea;
			while((linea = br.readLine()) != null){
				System.out.println(linea);
			}
			br.close();
		}catch (Exception e){
			System.out.println("Error en : " + comando);
			e.printStackTrace();
		}

		int salida ;
		try {
			//Valor de salida del proceso p, waitFor nos espera
			salida = p.waitFor();
			System.out.println("Valor devuelto: " + salida);
		} catch (InterruptedException e) {
			System.out.println("El comando terminó bruscamente");
			e.printStackTrace();
			
		}
		
		try {
			//Controlamos la salida que sale por consola
			InputStream er = p.getErrorStream();
			BufferedReader errorBufferR = new BufferedReader(new InputStreamReader(er));
			String lineaError ;
			while((lineaError = errorBufferR.readLine()) != null){
				System.out.println("Error: " + lineaError);
			}
		} catch (IOException ioe) {
			ioe.getStackTrace();
		}
	}

}
