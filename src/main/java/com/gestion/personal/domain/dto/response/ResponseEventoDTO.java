package com.gestion.personal.domain.dto.response;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseEventoDTO {
    private Long id;
    private String title;
    private Date date;
    private Integer limite;
    private ExtendedProps extendedProps;
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ExtendedProps {
        private String descripcion;
    }
}
