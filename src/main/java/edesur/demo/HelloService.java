package edesur.demo;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class HelloService {
    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);

    public HelloService() {
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Say Hello")
    public String helloYou(@PathParam("name")String nombre) {
        logger.info("GET Hello {}", nombre);
        return "Hello " + nombre;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Say Hello en JSON",
            notes = "Say Hello por medio de un POST que recibe un json con nombre y apellido y retorna un json con dos mensajes",
            response = HelloResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Tudo bom"),
            @ApiResponse(code = 500, message = "Hubo un problema")
    })
    public Response helloPost(@ApiParam(required = true) HelloRequest request) {
        logger.info("POST Hello {} {}", request.getNombre(), request.getApellido());
        HelloResponse response = new HelloResponse();
        response.setMensaje("Hola " + request.getNombre() + " " + request.getApellido());
        response.setInEnglish("Hello Mr. " + request.getNombre() + " " + request.getApellido());
        return Response.ok(response).build();
    }
}
