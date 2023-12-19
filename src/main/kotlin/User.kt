
val usuarios = mutableListOf<User>()
open class User(val idUser:Int, val nombre:String, val clave:String, val rol: String ){

    fun regUser(user: User){
        usuarios.add(user)
        println("***Usuario ${user.idUser} registrado con éxito***")
    }

    companion object{
        fun verUser(){
            println("ID\t NOMBRE")
            usuarios.forEach(){
                println("${it.idUser}\t ${it.nombre}")
            }
        }
    }
}

fun newUser(): User {
    val id: Int = usuarios.size + 1
    println("+++Ingrese el nombre del usuario+++")
    val nombre = readln().uppercase()
    println("+++Registre la contrasenia+++")
    val pass = readln()
    val rol = "user"
    return User(id, nombre, pass, rol)
}

fun menuAdmin(): String? {
    println(
        """ Digite la operación que desea realizar
                        NU = REGISTRAR NUEVO USUARIO
                        NC = REGISTRAR NUEVA CUENTA
                        VU = VER USUARIOS
                        VC = VER CUENTAS
                        VT = VER TRANSACCIONES
                        X = SALIR
                    """.trimIndent()
    )
    return readlnOrNull()?.uppercase()
}

fun bienvenido(){
    println("***BIENVENIDO, ¿Qué desa hacer?***")
    println("""
            1: Iniciar sesión
            2: Salir
        """.trimIndent())
}

fun opcAdmin(){
    do {
        when (menuAdmin()) {
            "NU" -> {
                val user: User = newUser()
                user.regUser(user)
            }

            "VU" -> {
                User.verUser()
            }

            "NC" -> {
                val cuenta: Count = newCount()
                cuenta.regCount(cuenta)
            }

            "VC" -> {
                Count.verCuentas()
            }

            "VT" -> {
                Transaccion.showTrans()
            }

            "X" -> {
                println("Nos vemos")
                break
            }

            else -> {
                println("Opción de operación no válida")
            }
        }
    }while (true)
}