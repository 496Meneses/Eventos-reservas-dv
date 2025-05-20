package com.gestion.personal.domain.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MensajeDTO {
    Boolean error;
    String respuesta;
}
