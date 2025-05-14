package edu.masanz.da.epk;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinFreemarker;

import edu.masanz.da.epk.controller.EditorController;

public class Main {

    public static void main(String[] args) {
        Javalin app = Javalin.create(
                config -> {
                    config.staticFiles.add("/public");
                    config.fileRenderer(new JavalinFreemarker());
                }).start(4444);

        app.get("/", EditorController::iniciar);
        app.get("/seleccionar", EditorController::seleccionar);

    }
}