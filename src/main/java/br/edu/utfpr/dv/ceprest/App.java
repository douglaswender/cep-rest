package br.edu.utfpr.dv.ceprest;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import br.edu.utfpr.dv.ceprest.service.CidadeService;
import br.edu.utfpr.dv.ceprest.service.EstadoService;
import br.edu.utfpr.dv.ceprest.service.HelloWorld;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;


public class App 
{
	public static final URI BASE_URI = URI.create("http://localhost:8080");

    public static HttpServer startHttpServer() {
        final ResourceConfig config = new ResourceConfig();
        config.register(HelloWorld.class);
        config.register(EstadoService.class);
        config.register(CidadeService.class);

        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, config);
    }

    public static void main(String[] args) {
        try {

            final HttpServer server = startHttpServer();

            server.start();

            Runtime.getRuntime().addShutdownHook(new Thread(server::shutdownNow));

            System.out.println(String.format("Aplicação iniciada.%nPressione CTRL+C para encerrar."));

            Thread.currentThread().join();
        } catch (InterruptedException | IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
