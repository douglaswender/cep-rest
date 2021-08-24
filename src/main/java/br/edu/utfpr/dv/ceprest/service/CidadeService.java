package br.edu.utfpr.dv.ceprest.service;

import java.sql.SQLException;
import java.util.List;

import br.edu.utfpr.dv.ceprest.dao.CidadeDAO;
import br.edu.utfpr.dv.ceprest.model.Cidade;
import br.edu.utfpr.dv.ceprest.model.Estado;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/cidades")
public class CidadeService {

	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cidade> listar() {
		try {
			return new CidadeDAO().listar();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar/{param}")
	public List<Cidade> listarPorEstado(@PathParam("param") String sigla) {
		try {
			return new CidadeDAO().listarPorEstado(sigla);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@POST
	@Path("/listar/porestado")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Cidade> listarPorEstadoPost(Estado estado) {
		try {
			return new CidadeDAO().listarPorEstado(estado.getSigla());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Path("/listar/Rondonia")
	@Produces(MediaType.APPLICATION_JSON)
	public Cidade[] getCidadesDeRondonia() {
		try {
			return new CidadeDAO().cidadesDeRondonia().toArray(new Cidade[] {});
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
