/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domen.OpstiDomenskiObjekat;
import java.util.LinkedList;
import java.util.List;
import repository.db.DBRepository;
import java.sql.*;
import repository.db.DBConnectionFactory;

/**
 *
 * @author janja
 */
public class DBRepositoryGeneric implements DBRepository<OpstiDomenskiObjekat>{

    @Override
    public List<OpstiDomenskiObjekat> getAll(OpstiDomenskiObjekat param, String cond) throws Exception {
        List<OpstiDomenskiObjekat> list=new LinkedList<>();
        
        String query="SELECT * FROM "+param.vratiNazivTabele()+" "+param.vratiSK();
        if(cond!=null)query+=cond;
        System.out.println(query);
        
        Statement st=DBConnectionFactory.getInstance().getConnection().createStatement();
        ResultSet rs=st.executeQuery(query);
        list=param.vratiListu(rs);
        
        rs.close();
        st.close();        
        
        return list;
    }

    @Override
    public List<OpstiDomenskiObjekat> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(OpstiDomenskiObjekat param) throws Exception {
        String query="INSERT INTO "+param.vratiNazivTabele()+ "( "+param.vratiKoloneZaUbacivanje()+" ) VALUES ( "+param.vratiVrednostiZaUbacivanje()+" )";
        System.out.println(query);
        
        Statement st=DBConnectionFactory.getInstance().getConnection().createStatement();
        st.executeUpdate(query);
        
        st.close();
        
    }

    @Override
    public void update(OpstiDomenskiObjekat param) throws Exception {
        String query="UPDATE "+param.vratiNazivTabele()+" SET "+param.vratiVrednostiZaIzmenu()+" WHERE "+param.vratiprimarniKljuc();
        System.out.println(query);
        
        Statement st=DBConnectionFactory.getInstance().getConnection().createStatement();
        st.executeUpdate(query);
        
        st.close();
    }

    @Override
    public void delete(OpstiDomenskiObjekat param) throws Exception {
        String query="DELETE FROM "+param.vratiNazivTabele()+" WHERE "+param.vratiprimarniKljuc();
        System.out.println(query);
        
        Statement st=DBConnectionFactory.getInstance().getConnection().createStatement();
        st.executeUpdate(query);
        
        st.close();
    }

    
    
}
