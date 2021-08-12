package br.edu.utfpr.dv.ceprest.service;

import java.sql.SQLException;
import java.util.List;

import br.edu.utfpr.dv.ceprest.dao.EstadoDAO;
import br.edu.utfpr.dv.ceprest.model.Estado;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/estados")
public class EstadoService {

	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estado> listar() {
		try {
			return new EstadoDAO().listar();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
