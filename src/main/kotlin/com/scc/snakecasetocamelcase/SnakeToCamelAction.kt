package com.scc.snakecasetocamelcase

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.command.WriteCommandAction

/**
 * Plugin action that converts selected snake_case text to camelCase
 */
class SnakeToCamelAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val editor = e.getRequiredData(CommonDataKeys.EDITOR)
        val project = e.getRequiredData(CommonDataKeys.PROJECT)
        val document = editor.document

        val selectionModel = editor.selectionModel
        if (!selectionModel.hasSelection()) {
            return
        }

        val start = selectionModel.selectionStart
        val end = selectionModel.selectionEnd

        val selectedText = selectionModel.selectedText ?: return

        val lines = selectedText.split("\n")
        val processedLines = lines.map { line ->
            line.split(" ").joinToString(" ") { word ->
                convertSnakeToCamel(word)
            }
        }
        val camelCaseText = processedLines.joinToString("\n")
        if (camelCaseText != selectedText) {
            WriteCommandAction.runWriteCommandAction(project) {
                document.replaceString(start, end, camelCaseText)
            }
        }
    }

    override fun update(e: AnActionEvent) {
        val editor = e.getData(CommonDataKeys.EDITOR)
        e.presentation.isEnabled = editor != null && editor.selectionModel.hasSelection()
    }

    /**
     * Converts snake_case string to camelCase.
     * If the string doesn't contain underscores, returns it unchanged.
     */
    private fun convertSnakeToCamel(snakeCase: String): String {
        if (!snakeCase.contains('_')) {
            return snakeCase
        }

        val parts = snakeCase.split("_")
        val camelCase = StringBuilder()
        if (parts.isNotEmpty()) {
            camelCase.append(parts[0].lowercase())
        }
        for (i in 1 until parts.size) {
            if (parts[i].isNotEmpty()) {
                camelCase.append(parts[i].lowercase().replaceFirstChar { it.uppercase() })
            }
        }

        return camelCase.toString()
    }
}