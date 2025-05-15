package edu.masanz.da.epk.dao;

import edu.masanz.da.epk.db.DbCon;
import edu.masanz.da.epk.dto.MapaDTO;
import edu.masanz.da.epk.dto.MapaDataDTO;

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
                "FROM epk_db.mapa ORDER BY orden";
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

    @Override
    public MapaDataDTO getMapaDataDTO(long m) {
        MapaDataDTO mapaDataDTO = new MapaDataDTO();
        String sql = "SELECT id, orden, nombre, surfaces, elements " +
                "FROM epk_db.mapa WHERE id = ?";
        if (DbCon.isConnected()) {
            try (PreparedStatement pst = DbCon.getConnection().prepareStatement(sql)) {
                pst.setLong(1, m);
                try (ResultSet rs = pst.executeQuery()) {
                    //int columnCount = rs.getMetaData().getColumnCount();
                    if (rs.next()) {
                        long id = rs.getLong(1);
                        int orden = rs.getInt(2);
                        String nombre = rs.getString(3);
                        String surfaces = rs.getString(4);
                        String elements = rs.getString(5);
                        mapaDataDTO = new MapaDataDTO(id, orden, nombre, surfaces, elements);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mapaDataDTO;
    }

    @Override
    public boolean setMapaDataDTO(MapaDataDTO mdd) {
        String sql = "UPDATE epk_db.mapa " +
                "SET surfaces = ?, elements = ? " +
                "WHERE id = ?";
        if (DbCon.isConnected()) {
            try (PreparedStatement pst = DbCon.getConnection().prepareStatement(sql)) {
                pst.setString(1, mdd.getSurfaces());
                pst.setString(2, mdd.getElements());
                pst.setLong(3, mdd.getId());
                int affectedRows = pst.executeUpdate();
                return affectedRows > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    public static void main(String[] args) {
        EditorDaoMySql dao = new EditorDaoMySql();
//        List<MapaDTO> mapas = dao.getAllMapaDTOs();
//        for (MapaDTO mapa : mapas) {
//            System.out.println(mapa);
//        }
        MapaDataDTO mapaDataDTO = dao.getMapaDataDTO(1);
        System.out.println(mapaDataDTO);

    }
}
