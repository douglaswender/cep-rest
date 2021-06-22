package br.edu.utfpr.dv.ceprest.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hello")
public class HelloWorld
{
    @GET
    public String getMsg()
    {
         return "Hello World !!";
    }
}
