/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Modelo.Proyecto;
import java.util.List;

/**
 *
 * @author Verito
 */
public interface CRUDproyecto {
    public List listar();
    public Proyecto list(int id);
    public Proyecto buscarpersona(int id);
    public boolean add(Proyecto pro);
    public boolean edit(Proyecto pro);
    public boolean eliminar(int id);
    
}
