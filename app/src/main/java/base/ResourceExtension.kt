package base

import android.content.res.Resources
import android.util.TypedValue
import androidx.annotation.AnyRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
internal fun weightResource(@AnyRes id: Int): Float {
    val context = LocalContext.current
    return context.resources.getFloatValue(id)
}

private fun Resources.getFloatValue(@AnyRes id: Int): Float {
    val out = TypedValue()
    getValue(id, out, true)
    return out.float
}
