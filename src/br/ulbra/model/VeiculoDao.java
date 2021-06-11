package br.ulbra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author João
 */
public class VeiculoDao {
    Connection con;
    
    public VeiculoDao() throws SQLException{
        con = ConnectionFactory.getConnection();
    }
    
    public void create(Veiculo v){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbveiculo (marca,modelo,ano,cor,placa,motor,km,valor) VALUE (?,?,?,?,?,?,?,?)");
            stmt.setString(1, v.getMarca());
            stmt.setString(2, v.getModelo());
            stmt.setInt(3, v.getAno());
            stmt.setString(4, v.getCor());
            stmt.setString(5, v.getPlaca());
            stmt.setString(6, v.getMotor());
            stmt.setString(7, v.getKm());
            stmt.setDouble(8, v.getValor());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Carro salvo com sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     //listagem de usuarios na tabela do formulario   ---   R
    
    public ArrayList<Veiculo> read(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Veiculo> veiculos = new ArrayList<Veiculo>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbveiculo");
            rs = stmt.executeQuery();
            while(rs.next()){
                Veiculo veiculo = new Veiculo();
                veiculo.setId(rs.getInt("id"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setAno(rs.getInt("ano"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setMotor(rs.getString("motor"));
                veiculo.setKm(rs.getString("km"));
                veiculo.setValor(rs.getDouble("valor"));
                veiculos.add(veiculo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Veiculo>) veiculos;
    }
    
    public ArrayList<Veiculo> readPesq(String modelo){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Veiculo> veiculos = new ArrayList<Veiculo>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbveiculo WHERE modelo LIKE ?");
            stmt.setString(1, "%"+modelo+"%");
            rs = stmt.executeQuery();
            while(rs.next()){
                Veiculo veiculo = new Veiculo();
                veiculo.setId(rs.getInt("id"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setAno(rs.getInt("ano"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setMotor(rs.getString("motor"));
                veiculo.setKm(rs.getString("km"));
                veiculo.setValor(rs.getDouble("valor"));
                veiculos.add(veiculo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Veiculo>) veiculos;
    }
    
    public void update(Veiculo u){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbveiculo SET marca = ?, modelo = ?, ano = ?, cor = ?, placa = ?, motor = ?, km = ?, valor = ? WHERE id = ?");
            stmt.setString(1, u.getMarca());
            stmt.setString(2, u.getModelo());
            stmt.setInt(3, u.getAno());
            stmt.setString(4, u.getCor());
            stmt.setString(5, u.getPlaca());
            stmt.setString(6, u.getMotor());
            stmt.setString(7, u.getKm());
            stmt.setDouble(8, u.getValor());
            stmt.setInt(9, u.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Carro modificado com sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public void delete(Veiculo u){
            PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tbveiculo WHERE id = ?");
           
            stmt.setInt   (1, u.getId());
            
            if (JOptionPane.showConfirmDialog(null,"Exclusão", "Tem certeza que deseja excluir o carro", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Carro excluído(a)com Sucesso!!");
                stmt.executeUpdate();
            }else{
                JOptionPane.showMessageDialog(null, "Exclusão do carro cancelada com sucesso!!");
            }
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
   
}
