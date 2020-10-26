package org.jetbrains.codeviewer.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.jetbrains.codeviewer.platform.HomeFolder
import org.jetbrains.codeviewer.platform.PlatformTheme
import org.jetbrains.codeviewer.platform.WithoutSelection
import org.jetbrains.codeviewer.ui.common.AppTheme
import org.jetbrains.codeviewer.ui.common.Settings
import org.jetbrains.codeviewer.ui.editor.Editors
import org.jetbrains.codeviewer.ui.filetree.FileTree

@Composable
fun MainView() {
    val codeViewer = remember {
        val editors = Editors()

        CodeViewer(
            editors = editors,
            fileTree = FileTree(HomeFolder, editors),
            settings = Settings()
        )
    }

    WithoutSelection {
        MaterialTheme(
            colors = AppTheme.colors.material
        ) {
            PlatformTheme {
                Surface {
                    CodeViewerView(codeViewer)
                }
            }
        }
    }
}