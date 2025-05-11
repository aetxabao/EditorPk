package edu.masanz.da.epk.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

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

}
