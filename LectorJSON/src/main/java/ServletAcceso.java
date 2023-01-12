

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

/**
 * Servlet implementation class ServletAcceso
 */
public class ServletAcceso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAcceso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void anadirMonumentoJSON(Monumento monu) {

		JSONObject identificador = new JSONObject();
		identificador.put("identificador", monu.getIdentificador());

		JSONObject nombre = new JSONObject();
		nombre.put("nombre", monu.getNombre());

		JSONObject tipoMonumento = new JSONObject();
		tipoMonumento.put("tipoMonumento", monu.getTipoMonumento());

		JSONObject identificadorBienCultural = new JSONObject();
		identificadorBienCultural.put("identificadorBienInteresCultural", monu.getIdentificadorBienCultural());

		JSONObject calle = new JSONObject();
		calle.put("calle", monu.getCalle());

		JSONObject yacimiento = new JSONObject();
		yacimiento.put("clasificacion", monu.getYacimiento());

		JSONObject tipoConstruccion = new JSONObject();
		tipoConstruccion.put("tipoConstruccion", monu.getTipoConstruccion());

		JSONObject codigoPostal = new JSONObject();
		codigoPostal.put("codigoPostal", monu.getCodigoPostal());

		JSONObject descripcion = new JSONObject();
		descripcion.put("descripcion", monu.getDescripcion());

		JSONObject periodoHistorico = new JSONObject();
		periodoHistorico.put("periodoHistorico", monu.getPeriodoHistorico());

		JSONObject provincia = new JSONObject();
		provincia.put("provincia", monu.getProvincia());

		JSONObject municipio = new JSONObject();
		municipio.put("municipio", monu.getMunicipio());

		JSONObject localidad = new JSONObject();
		localidad.put("localidad", monu.getLocalidad());

		JSONArray poblacionArray = new JSONArray();
		poblacionArray.add(provincia);
		poblacionArray.add(municipio);
		poblacionArray.add(localidad);

		JSONObject poblacion = new JSONObject();
		poblacion.put("poblacion", poblacionArray);

		JSONObject coordenadasX = new JSONObject();
		coordenadasX.put("latitud", monu.getCoordenadasX());

		JSONObject coordenadasY = new JSONObject();
		coordenadasY.put("longitud", monu.getCoordenadasY());

		JSONArray coordenadasArray = new JSONArray();
		coordenadasArray.add(coordenadasX);
		coordenadasArray.add(coordenadasY);

		JSONObject coordenadas = new JSONObject();
		coordenadas.put("coordenadas", coordenadasArray);

		JSONArray monumentoArray = new JSONArray();
		monumentoArray.add(identificador);
		monumentoArray.add(nombre);
		monumentoArray.add(tipoMonumento);
		monumentoArray.add(identificadorBienCultural);
		monumentoArray.add(calle);
		monumentoArray.add(yacimiento);
		monumentoArray.add(tipoConstruccion);
		monumentoArray.add(codigoPostal);
		monumentoArray.add(descripcion);
		monumentoArray.add(periodoHistorico);
		monumentoArray.add(poblacion);
		monumentoArray.add(coordenadas);
		JSONObject monumento = new JSONObject();
		monumento.put("monumentos", monumentoArray);

		JSONArray monumentosArray = new JSONArray();
		monumentosArray.add(monumento);

		JSONObject monumentos = new JSONObject();
		monumentos.put("monumentos", monumentosArray);
		File file = new File("D:\\Acceso_a_datos\\EjerManejoFicherosJSON\\monumento.json");
		try (FileWriter filewriter = new FileWriter(file, true)) {

			filewriter.write(monumentosArray.toJSONString() + "\r\n");

		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}

	}

	public void leerListaJSON() {
		File file = new File("D:\\Acceso_a_datos\\EjerManejoFicherosJSON\\monumento.json");
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);

			String linea;

			while ((linea = br.readLine()) != null) {
				org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
				JSONArray array = (JSONArray) parser.parse(linea);
				System.out.println(array.toJSONString());
			}

			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
