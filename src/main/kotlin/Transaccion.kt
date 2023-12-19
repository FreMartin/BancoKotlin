import java.lang.IllegalArgumentException
import java.time.LocalDate

val transacciones = mutableListOf<Transaccion>()

class Transaccion(val idCount: Int, val fecha: LocalDate, val tipo:String, val monto:Double){
    companion object{
        fun showTrans(){

            println("CUENTA\t FECHA\t\t\t MOVIMIENTO\t MONTO")

            transacciones.forEach {
                println("${it.idCount}\t\t ${it.fecha}\t\t ${it.tipo}\t ${it.monto}")
            }
        }
    }
}


enum class Tipo {
    R,
    D,
    C,
    X
}

fun opcionTrans (): Tipo{
    println(""" Digite la transacción que desea realizar
                        R = RETIRO
                        D = DEPOSITO
                        C = CONSULTA
                        X = SALIR 
                    """.trimIndent())
    val opc = readlnOrNull()?.uppercase()

    val opcion:Tipo = try {
        Tipo.valueOf(opc!!)
    }catch (e: IllegalArgumentException){
        Tipo.X
    }
    return  opcion
}

fun newTrans(opcion:Tipo, idCount: Int){
    when (opcion) {
        Tipo.D ->{
            println("DEPÓSITO")
            Count.deposito(idCount)
        }
        Tipo.R ->{
            println("RETIRO")
            Count.retiro(idCount)
        }
        Tipo.C ->{
            println("CONSULTA")
            Count.consulta(idCount)
        }
        Tipo.X ->{
            println("***Opción no válida, se cancelará la transacción***")
        }
    }
}