import java.lang.NumberFormatException

class Validacion(var validar:Boolean, val idUser: Int, val rol: String)

fun newValidation(): Validacion? {
    println("+++Ingrese el numero de usuario+++")
    val entrada = readlnOrNull()
    var user = 0
    try{
        if (entrada != null) {
            user = entrada.toInt()
        }
    }catch (e: NumberFormatException){
        println("***Ingresar el usuario es obligatorio y debe ser numérico***")
    }
    println("+++Ingrese la clave+++")
    var clave = readlnOrNull().toString()
    var acceso = false
    var rol = ""
    usuarios.forEach(){
        if (it.idUser == user && it.clave == clave){
            acceso = true
            rol = it.rol
            println("***Acceso permitido***")
        }
    }
    if (!acceso) {
        println("***Credenciales incorrectas***")
    }
    return Validacion(acceso, user, rol)
}