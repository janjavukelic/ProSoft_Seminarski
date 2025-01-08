/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

import repository.Repository;
import repository.db.DBRepository;
import repository.db.impl.DBRepositoryGeneric;

/**
 *
 * @author janja
 */
public abstract class ApstraktnaGenerickaOperacija {
    protected final Repository broker;

    public ApstraktnaGenerickaOperacija() {
        this.broker=new DBRepositoryGeneric();
    }
    
    public final void izvrsi(Object obj, String key) throws Exception{
        try{
            preduslovi(obj);
            zapocniTransakciju();
            izvrsiOperaciju(obj, key);
            potvrdiTransakciju();
        }catch(Exception e){
            ponistiTransakciju();
        }finally{
            ugasiKonekciju();
        }
    }
    
    
    protected abstract void preduslovi(Object obj) throws Exception;
    
    protected abstract void izvrsiOperaciju(Object obj,String key) throws Exception;
    
    private void zapocniTransakciju()throws Exception{
        ((DBRepository)broker).connect();
    }
    
    private void potvrdiTransakciju()throws Exception{
        ((DBRepository)broker).commit();
    }
    
    private void ponistiTransakciju()throws Exception{
        ((DBRepository)broker).rollback();
    }
    
    private void ugasiKonekciju()throws Exception{
        ((DBRepository)broker).disconnect();
    }
}
