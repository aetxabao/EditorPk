package edu.masanz.da.epk.dao;

import edu.masanz.da.epk.dto.MapaDTO;
import edu.masanz.da.epk.dto.MapaDataDTO;

import java.util.List;

public interface EditorDao {
    List<MapaDTO> getAllMapaDTOs();

    MapaDataDTO getMapaDataDTO(long m);

    boolean setMapaDataDTO(MapaDataDTO mdd);
}
