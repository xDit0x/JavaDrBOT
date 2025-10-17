package main;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Usuario {
        private static final String ARCHIVO_JSON = "usuarios.json";
        private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        private static final String LOCALUSUARIOSJSON =  "src/main/usuarios.json";
        private static int ultimoId = 0;

        private final int id;
        private String usuario;
        private String password;
        private String permisos;


         public Usuario(String nombreUsuario, String password, String permisos){
            this.usuario = nombreUsuario;
            this.password = password;
            this.permisos = permisos;
            this.id = generarNuevoId();
        }

    private static synchronized int generarNuevoId(){
            if (ultimoId==0){
                getStaticId();
            }
            ultimoId++;
            return ultimoId;
        }

    private static void revisarNombreUsuario(String nombreUsuario){
        actualizarListaUsuarios();
        for(Usuario usuario : listaUsuarios){
            if(usuario.getNombreUsuario()==nombreUsuario){
                
            }
        }
    }
    
    public static int getStaticId(){
        actualizarListaUsuarios();
        if(listaUsuarios==null|| listaUsuarios.isEmpty())
            {return 0;}
        for(Usuario usuario : listaUsuarios){
            if( usuario.getId()>ultimoId){
                ultimoId = usuario.getId();
            }
        }
        return ultimoId;
    }
    
    protected String getPassword(){
        return this.password;
    }
    public String getNombreUsuario(){
        return this.usuario;
    }
    protected void setpassword(String password){
        this.password = password;
    }
    public void setNombreUsuario(String nombreUsuario){
        this.usuario = nombreUsuario;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    public int getId() {
        return id;
    }



    public static void actualizarListaUsuarios() {
        try(Reader fr = new FileReader(LOCALUSUARIOSJSON)){
            Type tipoListaUsuarios = new TypeToken<ArrayList<Usuario>>(){}.getType();
           listaUsuarios = gson.fromJson(fr, tipoListaUsuarios);

           if(listaUsuarios==null){
            listaUsuarios = new ArrayList<>();
           }
        }
        catch(FileNotFoundException e){
            listaUsuarios = new ArrayList<>();
        }
        catch(IOException e){   
            System.err.println("Error leyendo archivo, debe a "+ e.getMessage());         
            listaUsuarios = new ArrayList<>();
        }
    }
    public static void guardarListaUsuariosAJson(){
        try(
            Writer fw = new FileWriter(LOCALUSUARIOSJSON)) { 
            gson.toJson(listaUsuarios, fw );
            } 
         catch (Exception e) {
            System.err.println("Error al cargar nuevos usuarios, debe a "+e.getMessage());
            }
        
    }

    public static void registrarNuevoUsuario(Usuario usuario){
        try {
            listaUsuarios.add(usuario);
            guardarListaUsuariosAJson();
        } catch (Exception
             e) {
        }
    }
     public static void main(String[] args) {
        Usuario newUser = new Usuario("pp", "password123", "usuario");
        Usuario newUser2 = new Usuario("mria", "password456", "admin");
        Usuario newUser3 = new Usuario("p1312p", "password123", "usuario");
        Usuario newUser4 = new Usuario("mr231312ia", "password456", "admin");

        Usuario.registrarNuevoUsuario(newUser);
        Usuario.registrarNuevoUsuario(newUser2);
        Usuario.registrarNuevoUsuario(newUser4);
        Usuario.registrarNuevoUsuario(newUser3);

        newUser.getId();

       
        Usuario.actualizarListaUsuarios();
       
        for(Usuario usuario : listaUsuarios){
            System.out.println(usuario.getId());
        }

     }
}
