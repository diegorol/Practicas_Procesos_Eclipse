import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PingIP {

	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		if(args.length != 1){
			System.out.println("Error en número de parámetros");
		}else{
		String ping = "pimg /c " + args[0];
		Process p = null;
		try {
			p = r.exec(ping);
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String linea;
			while((linea = br.readLine()) != null){
				System.out.println(linea);
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
				
		
		
		}
	}

}
