import java.lang.NumberFormatException
import java.time.LocalDate

val cuentas = mutableListOf<Count>()
class Count(val idCount:Int, var saldo:Double, idUser: Int, nombre: String, clave: String, rol: String ) : User(idUser, nombre, clave, rol){
    fun regCount(count: Count){
        cuentas.add(count)
        println("***Cuenta ${count.idCount} registrada con éxito***")
    }
    companion object{
        fun consulta(idCount: Int){

            println("CUENTA\t SALDO")

            cuentas.forEach {
                if (idCount == it.idCount) {
                    println("${it.idCount}\t\t $${it.saldo}")
                }
            }
        }
        fun deposito(idCount: Int) {
            var deposito = 0.0
            val tipo = "Depósito"
            println("+++Ingrese el monto a depositar+++")
            deposito = readlnOrNull()?.toDouble()!!
            cuentas.forEach(){

                if (idCount == it.idCount) {
                    it.saldo = it.saldo + deposito!!
                    println("***Se depositó con éxito la cantidad de $$deposito en la cuenta $idCount***")
                }
            }
            val transaccion:Transaccion = Transaccion(idCount, LocalDate.now() , tipo, deposito)
            transacciones.add(transaccion)
        }

        fun retiro(idCount: Int) {
            var retiro = 0.0
            var tipo = "Retiro"
            println("---Ingrese el monto a retirar---")
            retiro = readlnOrNull()?.toDouble()!!
            cuentas.forEach(){

                if (idCount == it.idCount) {
                    if (it.saldo > retiro!!) {
                        it.saldo = it.saldo - retiro
                        println("***Se retiró con éxito la cantidad de $$retiro de la cuenta $idCount***")
                        val transaccion:Transaccion = Transaccion(idCount, LocalDate.now() , tipo, retiro)
                        transacciones.add(transaccion)
                    }else{
                        println("***Lo sentimos, fondos insuficientes***")
                    }
                }
            }
        }


        fun verCuentas(){
            println("USUARIO\t CUENTA\t NOMBRE\t\t\t\t SALDO")
            cuentas.forEach(){
                println("${it.idUser}\t\t ${it.idCount}\t\t ${it.nombre}\t\t ${it.saldo}")
            }
        }
    }
}

fun newCount(): Count {
    var found = false
    var idUser = 0
    var nombre = ""
    var clave = ""

    do {
        println("+++Ingrese el id del usuario EXISTENTE al que desea asociar la cuenta+++")
        val entrada = readlnOrNull()
        try{
            if (entrada != null) {
                idUser = entrada.toInt()
            }
        }catch (e: NumberFormatException){
            println("***Digitar el Id Usuario es obligatorio y debe ser numérico***")
        }
        usuarios.forEach() {
            if (it.idUser == idUser) {
                found = true
                nombre = it.nombre
                clave = it.clave
            }
        }
    } while (!found)
    val saldo = 0.0
    val rol = "user"
    return Count(cuentas.size + 1, saldo, idUser, nombre, clave, rol)
}

fun selecCount(idUser: Int):Int{
    var encontrado = false
    cuentas.forEach(){
        if (it.idUser == idUser){
            println("***Cuentas a su nombre***")
            println("${it.idCount}\t\t ${it.saldo}")
        }
    }
    println("+++Digite su cuenta a la que desa acceder+++")
    val entrada = readlnOrNull()
    var idCount = 0
    try{
        if (entrada != null) {
            idCount = entrada.toInt()
        }
    }catch (e: NumberFormatException){
        println("***Ingresar la cuenta es obligatorio y debe ser numérica***")
    }
    cuentas.forEach(){
        if (idCount==it.idCount){
            encontrado = true
        }
    }
    return idCount
}