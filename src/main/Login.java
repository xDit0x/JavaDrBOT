package main;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
//import java.io.Reader;
//import com.google.gson.Gson;

public class Login {

    public static int verificarLoggeo(String usuarioBuscar, String passwordBuscar) {
          boolean userFound = false;
          if(usuarioBuscar.equals("") || passwordBuscar.equals("")){
            return -1;
          }
          else
            try(
                BufferedReader br = new BufferedReader(new FileReader("/Users/peterpunk/JavaDrBOT/javaDrBot/src/usuarios.json"))){
                    StringBuilder usuariosContent = new StringBuilder();
                    String lineaUsuarios ="";

                    while((lineaUsuarios = br.readLine()) != null){
                        usuariosContent.append(lineaUsuarios);
                    }
                    String strUsuariosContent = usuariosContent.toString();
          
                    JsonObject jsonObject = JsonParser.parseString(strUsuariosContent).getAsJsonObject();
                    JsonArray usuarios = jsonObject.getAsJsonArray("usuarios");

                    for (int i = 0; i < usuarios.size(); i++) {
                        JsonObject user = usuarios.get(i).getAsJsonObject();
                        String usuario = user.get("usuario").getAsString();
                        String password = user.get("password").getAsString();
                        String permisos = user.get("permisos").getAsString();
        
                        if (usuario.equals(usuarioBuscar) && password.equals(passwordBuscar) && "admin".equals(permisos)) {
                            return 5;
                    }
                        if (usuario.equals(usuarioBuscar) && password.equals(passwordBuscar) && "usuario".equals(permisos)) {
                            return 2;
                }
                         else if (usuario.equals(usuarioBuscar)){
                            return 1;
                    }
        }



            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 0;
    }
    //testeo
    private void main(String[] args) {
        int resultado = verificarLoggeo("Admin", "admin");
        System.out.println("Resultado: " + resultado);
    }
}