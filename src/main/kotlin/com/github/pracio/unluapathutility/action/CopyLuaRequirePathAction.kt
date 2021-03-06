package com.github.pracio.unluapathutility.action

import com.github.pracio.unluapathutility.utils.ActionUtils
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent


//Copy Lua Require Path
//Convert file path to lua requrie path
class CopyLuaRequirePathAction: AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        var path = ActionUtils.getCurrentFilePath(e)
        var filePath = ActionUtils.convertPath(path!!)
        var lastPart = filePath!!.substringAfterLast('.')
        filePath = "local $lastPart = require(\"$filePath\")"
        ActionUtils.setClipboard(filePath)
    }
}