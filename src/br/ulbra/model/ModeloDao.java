package br.ulbra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Jeferson
 */
public class ModeloDao {
    Connection con;
    
    public ModeloDao() throws SQLException{
        con = ConnectionFactory.getConnection();
    }
    
    public boolean  checkLogin(String email, String senha){
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tbusuario"
                    + " where email = ? AND senha = ?");
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                check = true;
            }
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
        }
        return check;
    }
    // SALVA O USUARIO NO BANCO DE DADOS   ---- C
    public void create(Modelo m){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbmodelo (modelo,marca,ano) VALUE (?,?,?)");
            stmt.setString(1, m.getModelo());
            stmt.setString(2, m.getMarca());
            stmt.setInt(3, m.getAno());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modelo "+m.getModelo()+" salvo com sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     //listagem de usuarios na tabela do formulario   ---   R
    
    public ArrayList<Modelo> read(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Modelo> modelos = new ArrayList<Modelo>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbmodelo");
            rs = stmt.executeQuery();
            while(rs.next()){
                Modelo modelo = new Modelo();
                modelo.setId(rs.getInt("id"));
                modelo.setModelo(rs.getString("modelo"));
                modelo.setMarca(rs.getString("marca"));
                modelo.setAno(rs.getInt("ano"));
                modelos.add(modelo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Modelo>) modelos;
    }
    
    public ArrayList<Modelo> readPesq(String model){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Modelo> modelos = new ArrayList<Modelo>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbmodelo WHERE modelo LIKE ?");
            stmt.setString(1, "%"+model+"%");
            rs = stmt.executeQuery();
            while(rs.next()){
                Modelo modelo = new Modelo();
                modelo.setId(rs.getInt("id"));
                modelo.setModelo(rs.getString("modelo"));
                modelo.setMarca(rs.getString("marca"));
                modelo.setAno(rs.getInt("ano"));
                modelos.add(modelo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Modelo>) modelos;
    }
    
    //ALTERAR O USUARIO NO BANCO DE DADOS   -- U 
    public void update(Modelo m){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbmodelo SET modelo = ?, marca = ?, ano = ? WHERE id = ?");
            stmt.setString(1, m.getModelo());
            stmt.setString(2, m.getMarca());
            stmt.setInt(3, m.getAno());
            stmt.setInt(4, m.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modelo "+m.getModelo()+" Modificado com Sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    //excluir do banco de dados   --- D
    public void delete(Modelo m){
            PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tbmodelo WHERE id = ?");
           
            stmt.setInt   (1, m.getId());
            
            if (JOptionPane.showConfirmDialog(null,"Exclusão", "Tem certeza que deseja excluir o Usuario(a)"+m.getModelo(), JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Modelo "+m.getModelo()+" excluído com Sucesso!!");
                stmt.executeUpdate();
            }else{
                JOptionPane.showMessageDialog(null, "A exclusão do Modelo "+m.getModelo()+" Cancelado com Sucesso!!");
            }
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
   
}
