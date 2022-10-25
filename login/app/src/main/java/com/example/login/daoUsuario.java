package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoUsuario {
    Context c;
    usuario u;
    ArrayList<usuario> lista;
    SQLiteDatabase sql;
    String bd="BDUsuarios";
    String tabla="create table if not exists usuario(id integer primary key autoincrement, usuario text, pass text, nombre text, ap text)";
    public daoUsuario(Context c ){
        this. c=c;
        sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE,null);
        sql.execSQL(tabla);
        u=new usuario();
    }
    public boolean insertUsuario(usuario u){
    if (buscar(u.getUsuario())==0){
        ContentValues cv=new ContentValues();
        cv.put("usuario", u.getUsuario());
        cv.put("pass", u.getPassword());
        cv.put("nombre", u.getNombre());
        cv.put("ap", u.getApellido());
        return  (sql.insert("usuario",null,cv)>0);
    }else{
        return false;
    }
    }
        public int buscar(String u){
    int x=0;
    lista = selectusuario();
    for (usuario us:lista){
        if (us.getUsuario().equals(u)){
            x++;
    }
    }
        return x;
}
    public ArrayList<usuario> selectusuario() {
      ArrayList<usuario> lista =new ArrayList<usuario>();
        lista.clear();
        Cursor cr=sql.rawQuery("select * from usuario",null);
        if (cr!=null&&cr.moveToFirst()){
            do {
            usuario u=new usuario();
            u.setId(cr.getInt(0));
                u.setUsuario(cr.getString(1));
                u.setPassword(cr.getString(2));
                u.setNombre(cr.getString(3));
                u.setApellido(cr.getString(4));
                lista.add(u);
            } while (cr.moveToNext());


        }
        return lista;
        }
    public int login(String u, String p){
        int a=0;
        Cursor cr=sql.rawQuery("select * from usuario",null);
        if (cr!=null&&cr.moveToFirst()){
            do {
                if (cr.getString(1).equals(u)&&cr.getString(2).equals(p)){
                    a++;
                }
            }while (cr.moveToNext());


        } return a;
    }
    public usuario getusuariobyid(int id){
        lista=selectusuario();
        for ( usuario us:lista){
            if(us.getId()==id){
                return us;
            }
        }
        return null;
    }
    public usuario getUsuario(String u, String p){
        lista=selectusuario();
        for ( usuario us:lista){
            if (us.getUsuario().equals(u)&&us.getPassword().equals(p)){
                return us;

            }
        }
        return null;
    }

    public boolean updateUsuario(usuario u){
        ContentValues cv=new ContentValues();
            cv.put("usuario", u.getUsuario());
            cv.put("pass", u.getPassword());
            cv.put("nombre", u.getNombre());
            cv.put("ap", u.getApellido());
            return  (sql.update("usuario",cv,"id="+u.getId(),null)>0);
    }
    public boolean deleteUsuario (int id){
        return (sql.delete("usuario", "id="+id,null)>0);
    }
}


