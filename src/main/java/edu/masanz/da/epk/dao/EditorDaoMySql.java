package edu.masanz.da.epk.dao;

import edu.masanz.da.epk.db.DbCon;
import edu.masanz.da.epk.dto.MapaDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EditorDaoMySql implements EditorDao {

    public EditorDaoMySql() {
        DbCon.connect(
                "epk_db",
                "proy",
                "password"
        );
    }

    public List<MapaDTO> getAllMapaDTOs() {
        List<MapaDTO> mapas = new ArrayList<>();
        String sql = "SELECT id, orden, nombre " +
                "FROM epk_db.mapa";
        if (DbCon.isConnected()) {
            try (PreparedStatement pst = DbCon.getConnection().prepareStatement(sql)) {
                try (ResultSet rs = pst.executeQuery()) {
                    //int columnCount = rs.getMetaData().getColumnCount();
                    while (rs.next()) {
                        long id = rs.getLong(1);
                        int orden = rs.getInt(2);
                        String nombre = rs.getString(3);
                        MapaDTO mapa = new MapaDTO(id, orden, nombre);
                        mapas.add(mapa);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mapas;
    }


    public static void main(String[] args) {
        EditorDaoMySql dao = new EditorDaoMySql();
        List<MapaDTO> mapas = dao.getAllMapaDTOs();
        for (MapaDTO mapa : mapas) {
            System.out.println(mapa);
        }

    }
}
