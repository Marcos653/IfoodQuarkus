package org.example.cadastro.application.resources.contract;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.example.cadastro.application.dto.request.RestauranteRequest;
import org.example.cadastro.application.dto.response.RestauranteResponse;

import java.util.List;

@Tag(name = "Restaurante")
@Path("/restaurantes")
@RolesAllowed("proprietario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IRestauranteResource {

    @GET
    List<RestauranteResponse> buscar();

    @POST
    void adicionar(@Valid RestauranteRequest request);

    @PUT
    @Path("{id}")
    void atualizar(@PathParam("id") Long id, @Valid RestauranteRequest request);

    @DELETE
    @Path("{id}")
    void delete(@PathParam("id")  Long id);
}
