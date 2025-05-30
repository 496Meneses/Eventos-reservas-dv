package com.gestion.personal.domain.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestEventoDTO {
    private Long id;
    private String title;
    private String date;
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
