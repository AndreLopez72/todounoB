package com.todouno.hulkstore.infraestructure.entrypoint.controller;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.validation.constraints.Min;

import com.todouno.hulkstore.domain.modelo.Producto;
import com.todouno.hulkstore.infraestructure.repository.ProductoRepository; 


import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import java.net.URI;
import java.util.List;




@Path("/producto")
@RequestScoped
public class ProductoController {
	
	@Inject
    private ProductoRepository productoRepository;
	
	
	@POST
	@Path("/crear")
	@Consumes(APPLICATION_JSON)
	public Response crearProducto( Producto producto, @Context UriInfo uriInfo) {
		producto = productoRepository.create(producto);
		URI createdURI = uriInfo.getAbsolutePathBuilder().path(producto.getId().toString()).build();
		return Response.created(createdURI).build();
	}
	
	@GET
	@Path("/{id : \\d+}")
	@Consumes(APPLICATION_JSON)
	public Response getProductoById(@PathParam("id") @Min(1) Long id) {
        Producto producto = productoRepository.find(id);

        if (producto == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(producto).build();
	}
	
	@DELETE
	@Path("/{id : \\d+}")
	public Response deleteProducto(@PathParam("id") @Min(1) long id) {
		productoRepository.delete(id);
		return Response.noContent().build();
	}
	
	@GET
    @Produces(APPLICATION_JSON)
    public Response getAllProductos() {
        List<Producto> producto = productoRepository.findAll();

        if (producto.size() == 0)
            return Response.status(Response.Status.NO_CONTENT).build();

        return Response.ok(producto).build();
    }
	
	@GET
    @Path("/count")
    @Produces(TEXT_PLAIN)
    public Response countProductos() {
      Long nbOfProducto = productoRepository.countAll();

        if (nbOfProducto == 0)
            return Response.status(Response.Status.NO_CONTENT).build();

        return Response.ok(nbOfProducto).build();
    }
	

}
