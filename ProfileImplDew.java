/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author m4rh3
 */
import java.sql.*;
import java.util.*;

public class ProfileImplDew implements ProfileServices {

    @Override
    public Profil insert(Profil profil) throws SQLException {
        PreparedStatement st = KoneksiDb.getConnection().prepareStatement("insert into anggota values(?,?,?,?)");
        st.setInt(1, profil.getNim());
        st.setString(2, profil.getNama());
        st.setString(3, profil.getAlamat());
        st.setString(4, profil.getUmur());
        st.executeUpdate();



        return profil;
    }

    @Override
    public void update(Profil profil) throws SQLException {
        PreparedStatement st = KoneksiDb.getConnection().prepareStatement("update anggota set nama=?,alamat=?,telp=? where id=?");

        st.setString(1, profil.getNama());
        st.setString(2, profil.getAlamat());
        st.setString(3, profil.getUmur());
        st.setInt(4, profil.getNim());
        st.executeUpdate();

    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement st = KoneksiDb.getConnection().prepareStatement("delete from anggota  where id=?");
        st.setInt(1, id);
        st.executeUpdate();
    }

    @Override
    public List getAll() throws SQLException {
        Statement st = KoneksiDb.getConnection().createStatement();
        ResultSet rs = st.executeQuery("select * from anggota");
        List list = new ArrayList();
        while (rs.next()) {
            Profil p = new Profil();
            p.setNim(rs.getInt("nim"));
            p.setNama(rs.getString("nama"));
            p.setAlamat(rs.getString("alamat"));
            p.setUmur(rs.getString("umur"));
            list.add(p);
        }
        return list;
    }
}