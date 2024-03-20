package org.example.cadastro.application.resources.contract;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.example.cadastro.application.dto.request.PratoRequest;
import org.example.cadastro.application.dto.response.PratoResponse;

import java.util.List;

@Tag(name = "Prato")
@Path("/restaurantes")
@RolesAllowed("proprietario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IPratoResource {

    @GET
    @Path("/{idRestaurante}/pratos")
    List<PratoResponse> buscarPratosPeloIdRestaurante(@PathParam("idRestaurante") Long idRestaurante);

    @POST
    @Path("/{idRestaurante}/pratos")
    void adicionar(@PathParam("idRestaurante") Long idRestaurante, @Valid PratoRequest request);

    @PUT
    @Path("{idRestaurante}/pratos/{idPrato}")
    void atualizar(@PathParam("idRestaurante") Long idRestaurante,
                   @PathParam("idPrato") Long idPrato, @Valid PratoRequest request);

    @DELETE
    @Path("{idRestaurante}/pratos/{idPrato}")
    void delete(@PathParam("idRestaurante") Long idRestaurante,
                @PathParam("idPrato") Long idPrato);
}
