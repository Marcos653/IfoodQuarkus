package org.example.cadastro.application.mapper;

import org.example.cadastro.application.dto.request.RestauranteRequest;
import org.example.cadastro.application.dto.response.RestauranteResponse;
import org.example.cadastro.domain.model.Restaurante;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestauranteMapper {

    RestauranteMapper RESTAURANTE_MAPPER = Mappers.getMapper(RestauranteMapper.class);

    Restaurante toRestaurante(RestauranteRequest request);

    RestauranteResponse toRestauranteResponse(Restaurante restaurante);
}
