package org.example.cadastro.application.mapper;

import org.example.cadastro.application.dto.request.PratoRequest;
import org.example.cadastro.application.dto.response.PratoResponse;
import org.example.cadastro.domain.model.Prato;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PratoMapper {

    PratoMapper PRATO_MAPPER = Mappers.getMapper(PratoMapper.class);

    @Mapping(target = "nome", source = "request.nome")
    @Mapping(target = "descricao", source = "request.descricao")
    @Mapping(target = "preco", source = "request.preco")
    Prato toPrato(PratoRequest request);

    @Mapping(target = "id", source = "prato.id")
    @Mapping(target = "nome", source = "prato.nome")
    @Mapping(target = "descricao", source = "prato.descricao")
    @Mapping(target = "restaurante", source = "prato.restaurante")
    @Mapping(target = "preco", source = "prato.preco")
    PratoResponse toPratoResponse(Prato prato);
}
