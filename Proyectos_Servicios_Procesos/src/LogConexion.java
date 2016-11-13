
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;

public class LogConexion {

	public static void main(String[] args) {

		Runtime r = Runtime.getRuntime();
		// File f = new File("./log_conexion.log");

		PrintWriter file = null;
		try {
			file = new PrintWriter("./Conexion.log");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String comando = "cmd /c ping -t 8.8.8.8";
		Process p = null;
		try {
			p = r.exec(comando);

			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String linea;

			while ((linea = br.readLine()) != null) {
				if (linea.length() > 5) {
					if (linea.substring(0, 6) == "Tiempo") {
						Date fecha = new Date();
						System.out.println(fecha.toString() + "sssssssss");

						// TODO: Crear el log
						file.println("Error en la trans");
					}
				}
				System.out.println(linea);

			}
			br.close();
		} catch (Exception e) {
			System.out.println("Error en : " + comando);
			e.printStackTrace();
		}

		int salida;
		try {
			// Valor de salida del proceso p, waitFor nos espera
			salida = p.waitFor();
			System.out.println("Valor devuelto: " + salida);
		} catch (InterruptedException e) {
			System.out.println("El comando terminó bruscamente");
			e.printStackTrace();

		}

		try {
			// Controlamos la salida que sale por consola
			InputStream er = p.getErrorStream();
			BufferedReader errorBufferR = new BufferedReader(new InputStreamReader(er));
			String lineaError;
			while ((lineaError = errorBufferR.readLine()) != null) {
				System.out.println("Error: " + lineaError);
			}
		} catch (IOException ioe) {
			ioe.getStackTrace();
		}
	}

}
