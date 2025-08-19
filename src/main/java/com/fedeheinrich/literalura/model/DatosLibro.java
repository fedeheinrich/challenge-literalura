package com.fedeheinrich.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
    @JsonAlias("tittle") String titulo,
    @JsonAlias("authors") List<DatosAutor> autores,
    @JsonAlias("languages") List<String> idiomas,
    @JsonAlias("dowload_count") Double descargas
){

}
