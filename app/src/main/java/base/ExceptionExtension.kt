package base

import ru.alexandrorlov.kinopoisk.ui.model.TypeException
import java.nio.channels.UnresolvedAddressException

internal fun Exception.getTypeException() =
    when (this) {
        is UnresolvedAddressException -> TypeException.NoInternet
        else -> TypeException.AllException
    }
