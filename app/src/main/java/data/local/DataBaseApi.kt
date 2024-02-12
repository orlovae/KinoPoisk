package data.local

import android.content.Context
import androidx.room.Room

interface DataBaseApi {

    companion object {
        fun create(context: Context): LocalDataBase {
            return Room.databaseBuilder(
                context = context,
                klass = LocalDataBase::class.java,
                name = LocalConstant.DATABASE_NAME,
            )
                .build()
        }
    }
}
