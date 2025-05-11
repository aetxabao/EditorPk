package edu.masanz.da.epk.dto;

import java.util.Arrays;

public class MapaDataDTO extends MapaDTO {

    private final static int FILAS = 40;
    private final static int COLUMNAS = 30;

    private final static int TIERRA = 0;
    private final static int PARED = 4;

    private String surfaces;
    private String elements;

    public MapaDataDTO() {
        super();
        this.surfaces = initData();
        this.elements = initData();
    }

    public MapaDataDTO(String nombre) {
        this();
        this.nombre = nombre;
    }

    public MapaDataDTO(long id, int orden, String nombre, String surfaces, String elements) {
        super(id, orden, nombre);
        this.surfaces = surfaces;
        this.elements = elements;
    }

    // region getters & setters

    public String getSurfaces() {
        return surfaces;
    }

    public void setSurfaces(String surfaces) {
        this.surfaces = surfaces;
    }

    public String getElements() {
        return elements;
    }

    public void setElements(String elements) {
        this.elements = elements;
    }

    // endregion

    private String initData() {
        // TODO
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (i==0 || i==FILAS-1 || j==0 || j==COLUMNAS-1) {
                    sb.append(PARED).append(" ");
                }else{
                    sb.append(TIERRA).append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String toArray(String txt) {
        // 4 4 4
        // 4 0 4
        // 4 0 4
        // 4 4 4
        StringBuilder sb = new StringBuilder();
        String[] a = txt.split("\\s+");
        //[4, 4, 4, 4, 0, 4, 4, 0, 4, 4, 4, 4]
        for (String s : a) {
            sb.append("'" + s + "', ");
        }
        // '4', '4', '4', '4', '0', '4', '4', '0', '4', '4', '4', '4',_
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        // '4', '4', '4', '4', '0', '4', '4', '0', '4', '4', '4', '4'
        return sb.toString();
    }

    public static void main(String[] args) {
        MapaDataDTO dto = new MapaDataDTO();
        System.out.println(dto.getSurfaces());

        String s = dto.toArray(dto.getSurfaces());
        System.out.println(s);

//        String[] a = dto.getSurfaces().split("\\s+");
//        System.out.println(Arrays.toString(a));
    }

}
