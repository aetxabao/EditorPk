package edu.masanz.da.epk.service;

import edu.masanz.da.epk.dao.EditorDao;
import edu.masanz.da.epk.dao.EditorDaoMySql;
import edu.masanz.da.epk.dto.MapaDTO;

import java.util.List;

public class EditorService {

    private static EditorDao dao = new EditorDaoMySql();

    public static List<MapaDTO> getAllMapaDTOs() {
        return dao.getAllMapaDTOs();
    }

}
