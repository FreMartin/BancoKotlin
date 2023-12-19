fun main() {
    usuarios.add(User(1,"PEDRO NAVAJA", "k2", "admin" ))

    do {
        bienvenido()
        when(readln()) {

            "1" -> {
                var idUser = 0
                var rol = ""
                var validar = newValidation()
                if (validar != null) {
                    if (validar.validar) {
                        usuarios.forEach() {
                            if (validar.idUser == it.idUser) {
                                idUser = it.idUser
                                rol = it.rol
                            }
                        }
                        if (rol == "admin") {
                           opcAdmin()
                        } else {
                            val cuenta = selecCount(idUser)
                            if (cuenta != 0) {
                                val trans: Tipo = opcionTrans()
                                newTrans(trans, cuenta)
                            } else {
                                println("La cuenta no existe")
                            }

                        }
                    }
                }
            }

            "2" -> {
                break
            }

            else -> {
                println("Digite una opción válida")
            }
        }
    }while (true)
}