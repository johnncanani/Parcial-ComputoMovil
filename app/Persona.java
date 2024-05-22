public class Persona {

    private String usu;
    private String cont;
    private String sex;
    private String color;

    public Persona(String usuario, String contrasenia, String sexo, String color){

        this.usu = usuario;
        this.cont = contrasenia;
        this.sex = sexo;
        this.color = color;

    }

    public String mostrar_datos(){
        return "usuario: " + usu + "\n"
                + "contraseña: " + cont + "\n"
                + "sexo: " + sex + "\n"
                + "color: " + color;
    }



}
