package edu.masanz.da.epk.controller;

import edu.masanz.da.epk.dto.MapaDTO;
import edu.masanz.da.epk.service.EditorService;
import io.javalin.http.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditorController {

    public static void iniciar(Context context) {
        List<MapaDTO> mapas = EditorService.getAllMapaDTOs();
        Map<String, Object> model = new HashMap<>();
        model.put("mapas", mapas);
        // ...
        context.render("/templates/editor.ftl", model);
    }

}
