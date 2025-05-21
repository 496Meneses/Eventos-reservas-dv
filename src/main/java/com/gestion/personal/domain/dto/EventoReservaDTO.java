package com.gestion.personal.domain.dto;


import com.gestion.personal.domain.dto.response.ResponseEventoDTO;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventoReservaDTO {

    Long idReserva;
    Long idPersona;
    ResponseEventoDTO evento;
}
