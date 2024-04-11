package com.github.pracio.unluapathutility.utils

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.editor.Document
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.Project
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection

class ActionUtils {

    companion object {

        fun getCurrentFilePath(e: AnActionEvent): @NotNull String? {
            var file = e.getData(PlatformDataKeys.VIRTUAL_FILE)
            return file?.path;
        }

        fun convertPath(path: String): @NotNull String? {
            var filePath = path
            if (filePath.contains("Content/Script/",true)){
                filePath = filePath.substringAfter("Content/Script/")
            }
            filePath = filePath.replace('/','.')
            if(filePath.endsWith(".lua")){
                filePath = filePath.removeSuffix(".lua")
            }
            return filePath
        }

        fun setClipboard(content: String){
            var clipboard = Toolkit.getDefaultToolkit().systemClipboard
            clipboard.setContents(StringSelection(content),null)
        }

        fun isLuaFile(e: AnActionEvent): Boolean {
            var filePath = getCurrentFilePath(e)
            if (filePath == null) return false
            return filePath.endsWith(".lua")
        }
    }
}