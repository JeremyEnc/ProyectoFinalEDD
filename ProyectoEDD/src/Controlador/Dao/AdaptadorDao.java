/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Dao;

import Controlador.EstructurasDinamicas.Lista;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author jere_
 * @param <T> Es el tipo de objeto que se va a guardar en archivos
 */
public class AdaptadorDao <T> implements InterfazDao<T>
{
    private String CARPETA = "files" + File.separatorChar;//La direccion y el nombre en la que se almacenara el archivo con la informacion guardada
    private final Class clazz;//La clase a la que pertenece el objeto a guardar

    /**
     * Constructor que sirve para recuperar la clase a la que pertence el objeto a guardar
     * @param clazz La clase a la que pertenece el objeto a guardar
     */
    public AdaptadorDao(Class clazz)
    {
        this.clazz = clazz;
        CARPETA+= this.clazz.getSimpleName() + ".obj";
    }

    @Override
    public boolean guardar(T dato)
    {
        try 
        {
            Lista<T> aux = listar();
            aux.add(dato);
            guardarEnFile(aux);
            return true;
        } 
        catch (IOException e)
        {
            System.out.println(e);
            return false;
        }
    }
    
    /**
     * Metodo para remplazar la lista completa que se encuentra en el archivo
     * @param lista la lista que va a remplazar a la anterior
     */
    public void guardarNuevaLista(Lista<T> lista)
    {
        try {
            guardarEnFile(lista);
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public boolean modificar(T dato, int pos)
    {
        try
        {
            Lista<T> aux = listar();
            aux.replace(dato, pos);
            guardarEnFile(aux);
            return true;
        }
        catch (IOException ex)
        {
            return false;
        } 
    }

    @Override
    public Lista<T> listar()
    {
        Lista<T> lista = new Lista();
        
        try 
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CARPETA));
            lista = (Lista<T>)ois.readObject();
            ois.close();
        } 
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println(e);
        }
        
        return lista;
    }
    
    /**
     * Metodo que sirve para guardar en archivos la lista deseada
     * @param aux es la lista que se va a guardar
     * @throws FileNotFoundException Si el programa no encuentra el archivo en el que se va a guardar
     * @throws IOException En caso de que exista cualquier otro error
     */
    private void guardarEnFile(Lista<T> aux) throws FileNotFoundException, IOException
    {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CARPETA, false));
        oos.writeObject(aux);
        oos.close();

    }
    
}
