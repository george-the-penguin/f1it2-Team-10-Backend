package com.api.citasync.dto;
import com.api.citasync.models.Cita;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.util.Date;

public record CitaDto (

        Long id,
        @NotNull String nombre,
        @NotNull @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha,
        @NotNull @DateTimeFormat(pattern = "HH:mm") Time hora,
        @Min(1) Integer duracion,
        @NotBlank String ubicacion,
        @Size(min = 10, max = 1000) String detalles,
        @NotNull String estado

) {
    //contructor con parametros para crear un objeto Cita
    public CitaDto(Cita cita) {
        this(cita.getId(), cita.getNombre(), cita.getFecha(), cita.getHora(), cita.getDuracion(), cita.getUbicacion(), cita.getDetalles(), cita.getEstado());
    }

}
