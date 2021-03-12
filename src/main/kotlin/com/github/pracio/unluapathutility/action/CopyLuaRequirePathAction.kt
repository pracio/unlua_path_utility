package com.github.pracio.unluapathutility.action

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.fileEditor.FileEditorManager
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection

class CopyLuaRequirePathAction: AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        var project = e.project
        if(project == null) return
        var document = FileEditorManager.getInstance(project).selectedTextEditor?.document
        if (document == null) return
        var currentFile = FileDocumentManager.getInstance().getFile(document)
        var fileName = currentFile?.path
        var filePath = fileName!!
        if (filePath.contains("Content/Script/",true)){
            filePath = filePath.substringAfter("Content/Script/")
        }
        filePath = filePath.replace('/','.')
        if(filePath.endsWith(".lua")){
            filePath = filePath.removeSuffix(".lua")
        }
        var lastPart = filePath.substringAfterLast('.')
        filePath = "local $lastPart = require(\"$filePath\")"
        var clipboard = Toolkit.getDefaultToolkit().systemClipboard
        clipboard.setContents(StringSelection(filePath),null)
    }
}