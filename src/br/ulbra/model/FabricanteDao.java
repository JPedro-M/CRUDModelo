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
public class FabricanteDao {
    Connection con;
    
    public FabricanteDao() throws SQLException{
        con = ConnectionFactory.getConnection();
    }
    
    public void create(Fabricante f){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbfabricante (marca,telefone,site,email) VALUE (?,?,?,?)");
            stmt.setString(1, f.getMarca());
            stmt.setString(2, f.getFone());
            stmt.setString(3, f.getSite());
            stmt.setString(4, f.getEmail());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Fabricante "+f.getMarca()+" salvo com sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     //listagem de usuarios na tabela do formulario   ---   R
    
    public ArrayList<Fabricante> read(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Fabricante> fabricantes = new ArrayList<Fabricante>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbfabricante");
            rs = stmt.executeQuery();
            while(rs.next()){
                Fabricante fabricante = new Fabricante();
                fabricante.setId(rs.getInt("id"));
                fabricante.setMarca(rs.getString("marca"));
                fabricante.setFone(rs.getString("telefone"));
                fabricante.setSite(rs.getString("site"));
                fabricante.setEmail(rs.getString("email"));
                fabricantes.add(fabricante);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Fabricante>) fabricantes;
    }
    
    public ArrayList<Fabricante> readPesq(String marca){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Fabricante> fabricantes = new ArrayList<Fabricante>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbfabricante WHERE marca LIKE ?");
            stmt.setString(1, "%"+marca+"%");
            rs = stmt.executeQuery();
            while(rs.next()){
                Fabricante fabricante = new Fabricante();
                fabricante.setId(rs.getInt("id"));
                fabricante.setMarca(rs.getString("marca"));
                fabricante.setFone(rs.getString("telefone"));
                fabricante.setSite(rs.getString("site"));
                fabricante.setEmail(rs.getString("email"));
                fabricantes.add(fabricante);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Fabricante>) fabricantes;
    }
    
    //ALTERAR O USUARIO NO BANCO DE DADOS   -- U 
    public void update(Fabricante f){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbfabricante SET marca = ?,telefone = ?, site = ? ,email = ? WHERE id = ?");
            stmt.setString(1, f.getMarca());
            stmt.setString(2, f.getFone());
            stmt.setString(3, f.getSite());
            stmt.setString(4, f.getEmail());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Fabricante "+f.getMarca()+" modificado com sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    //excluir do banco de dados   --- D
    public void delete(Fabricante f){
            PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tbfabricante WHERE id = ?");
           
            stmt.setInt   (1, f.getId());
            
            if (JOptionPane.showConfirmDialog(null,"Exclusão", "Tem certeza que deseja excluir a empresa"+f.getMarca()+"?", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Empresa "+f.getMarca()+" excluída com Sucesso!!");
                stmt.executeUpdate();
            }else{
                JOptionPane.showMessageDialog(null, "Exclusão da empresa "+f.getMarca()+" cancelada com Sucesso!!");
            }
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
   
}
