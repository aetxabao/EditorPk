package edu.masanz.da.epk.controller;

import edu.masanz.da.epk.dto.MapaDTO;
import edu.masanz.da.epk.dto.MapaDataDTO;
import edu.masanz.da.epk.service.EditorService;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditorController {

    public static void iniciar(Context context) {
        List<MapaDTO> mapas = EditorService.getAllMapaDTOs();
        long m = 0;//TODO: Cuidado INSERT / UPDATE
        if (mapas.size() > 0) {
            m = mapas.get(0).getId();
        }
        MapaDataDTO mapa = EditorService.getMapaDataDTO(m);
        Map<String, Object> model = new HashMap<>();
        model.put("mapas", mapas);
        model.put("mapa", mapa);
        context.render("/templates/editor.ftl", model);
    }

    public static void seleccionar(@NotNull Context context) {
        long m = Long.parseLong(context.queryParam("nivel"));
        System.out.println("Nivel: " + m);
        MapaDataDTO mapa = EditorService.getMapaDataDTO(m);
        List<MapaDTO> mapas = EditorService.getAllMapaDTOs();
        Map<String, Object> model = new HashMap<>();
        model.put("mapas", mapas);
        model.put("mapa", mapa);
        context.render("/templates/editor.ftl", model);
    }
}
