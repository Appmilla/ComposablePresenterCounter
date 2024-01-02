package counter

import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector

// Copied because it's not available in compose-desktop yet.
@Suppress("MagicNumber")
val Remove: ImageVector
    get() {
        _remove?.let {
            return it
        }
        val remove =
            materialIcon(name = "Filled.Remove") {
                materialPath {
                    moveTo(19.0f, 13.0f)
                    horizontalLineTo(5.0f)
                    verticalLineToRelative(-2.0f)
                    horizontalLineToRelative(14.0f)
                    verticalLineToRelative(2.0f)
                    close()
                }
            }

        _remove = remove
        return remove
    }

private var _remove: ImageVector? = null
