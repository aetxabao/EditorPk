package edu.masanz.da.epk.service;

import edu.masanz.da.epk.dao.EditorDao;
import edu.masanz.da.epk.dao.EditorDaoMySql;
import edu.masanz.da.epk.dto.MapaDTO;
import edu.masanz.da.epk.dto.MapaDataDTO;

import java.util.List;

public class EditorService {

    private static EditorDao dao = new EditorDaoMySql();

    public static List<MapaDTO> getAllMapaDTOs() {
        return dao.getAllMapaDTOs();
    }

    public static MapaDataDTO getMapaDataDTO(long m) {
        return dao.getMapaDataDTO(m);
    }

    public static boolean setMapaDataDTO(MapaDataDTO mdd) {
        return dao.setMapaDataDTO(mdd);
    }
}
