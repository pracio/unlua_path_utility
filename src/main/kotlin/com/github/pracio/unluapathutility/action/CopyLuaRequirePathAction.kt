package com.github.pracio.unluapathutility.action

import com.github.pracio.unluapathutility.utils.ActionUtils
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent


//Copy Lua Require Path
//Convert file path to lua require path
class CopyLuaRequirePathAction: AnAction() {

    override fun update(e: AnActionEvent) {
        var isLua = ActionUtils.isLuaFile(e);
        e.presentation.isVisible = isLua
        e.presentation.isEnabled = isLua
    }

    override fun actionPerformed(e: AnActionEvent) {
        var path = ActionUtils.getCurrentFilePath(e)
        var filePath = ActionUtils.convertPath(path!!)
        var lastPart = filePath!!.substringAfterLast('.')
        filePath = "local $lastPart = require(\"$filePath\")"
        ActionUtils.setClipboard(filePath)
    }

}