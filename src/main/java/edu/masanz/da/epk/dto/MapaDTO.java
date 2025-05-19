package edu.masanz.da.epk.dto;

import edu.masanz.da.epk.Main;

import java.io.Serializable;
import java.util.*;

public class MapaDTO implements Comparable<MapaDTO>, Serializable {

    protected long id;
    protected int orden;
    protected String nombre;

    public MapaDTO() {
        this(0,0,"");
    }

    public MapaDTO(long id, int orden, String nombre) {
        this.id = id;
        this.orden = orden;
        this.nombre = nombre;
    }

    // region getter & setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // endregion


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MapaDTO other = (MapaDTO) o;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(MapaDTO other) {
        if (other == null) { return -1; }
        return this.orden - other.orden;
    }

    public String toJson() {
        return "{\"id\":" + id + ",\"orden\":" + orden + ",\"nombre\":\"" + nombre + "\"}";
    }

    @Override
    public String toString() {
        return toJson();
    }
//
//    public static void main(String[] args) {
//        MapaDTO dto1 = new MapaDTO(5,5,"Aqua");
//        MapaDTO dto2 = new MapaDTO(2,2,"Land");
//
//        Set<MapaDTO> dtos = new TreeSet<MapaDTO>();
//        dtos.add(dto2);
//        dtos.add(dto1);
//
//        for (MapaDTO dto : dtos) {
//            System.out.println(dto);
//        }
//
//    }
//
//    public static void main(String[] args) {
//        List<MapaDTO> lista = new ArrayList<MapaDTO>();
//
//        lista.add(new MapaDTO(1, 2, "Uno"));
//        lista.add(new MapaDTO(2, 4, "Dos"));
//        lista.add(new MapaDTO(3, 5, "Tres"));
//
//
//        long idMapaOrdenarAntes = 3;
//
//        for (int i = 0; i < lista.size(); i++) {
//            MapaDTO actual = lista.get(i);
//            if (actual.getId() == idMapaOrdenarAntes) {
//                if (i > 0) {
//                    MapaDTO temp = lista.get(i);
//                    MapaDTO anterior = lista.get(i - 1);
//                    lista.set(i, anterior);
//                    lista.set(i-1, temp);
//                }
//                break;
//            }
//        }
//
//        for (MapaDTO mapaDTO : lista) {
//            System.out.println(mapaDTO.nombre);
//        }
//
//    }


//    public static void main(String[] args) {
//        List<MapaDTO> lista = new ArrayList<MapaDTO>();
//
//        lista.add(new MapaDTO(1, 1, "Uno"));
//        lista.add(new MapaDTO(2, 2, "Dos"));
//        lista.add(new MapaDTO(3, 3, "Tres"));
//        lista.add(new MapaDTO(4, 4, "Cuatro"));
//
//        lista.add(new MapaDTO(6, 6, "Seis"));
//
//
//        long idMapaOrdenarAntes = 4;
//
//        // reordenar la lista
//        for (int i = 0; i < lista.size(); i++) {
//            MapaDTO actual = lista.get(i);
//            if (actual.getId() == idMapaOrdenarAntes) {
//                if (i > 0) {
//                    MapaDTO temp = lista.get(i);
//                    MapaDTO anterior = lista.get(i - 1);
//                    lista.set(i, anterior);
//                    lista.set(i-1, temp);
//                }
//                break;
//            }
//        }
//
//        //actualizar campo orden de los elementos
//        for (int i = 0; i < lista.size(); i++) {
//            lista.get(i).orden = i+1;
//        }
//
//        for (MapaDTO mapaDTO : lista) {
//            System.out.println(mapaDTO);
//        }
//
//    }

    public static void main(String[] args) {
        List<MapaDTO> lista = new ArrayList<MapaDTO>();

        lista.add(new MapaDTO(1, 1, "Uno"));
        lista.add(new MapaDTO(2, 2, "Dos"));
        lista.add(new MapaDTO(3, 3, "Tres"));
        lista.add(new MapaDTO(4, 4, "Cuatro"));

        lista.add(new MapaDTO(6, 6, "Seis"));


        long idMapaOrdenarAntes = 4;

        // reordenar la lista
        for (int i = 0; i < lista.size(); i++) {
            MapaDTO actual = lista.get(i);
            if (actual.getId() == idMapaOrdenarAntes) {
                if (i > 0) {
                    int ordenTemp = lista.get(i).getOrden();
                    MapaDTO anterior = lista.get(i - 1);
                    lista.get(i).setOrden(anterior.getOrden());
                    lista.get(i-1).setOrden(ordenTemp);
                }
                break;
            }
        }

        for (MapaDTO mapaDTO : lista) {
            System.out.println(mapaDTO);
        }

    }
}
