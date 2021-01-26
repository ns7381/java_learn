package com.nathan.learn.design.behavioral.command;

/**
 * @author nathan
 */
public class Example {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.add("Command pattern in text editor.\n");
// 执行一个CopyCommand:
        Command copy = new CopyCommand(editor);
        copy.execute();
        editor.add("----\n");
// 执行一个PasteCommand:
        Command paste = new PasteCommand(editor);
        paste.execute();
        System.out.println(editor.getState());
    }
}


class CopyCommand implements Command {
    // 持有执行者对象:
    private TextEditor receiver;

    public CopyCommand(TextEditor receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.copy();
    }
}

class PasteCommand implements Command {
    private TextEditor receiver;

    public PasteCommand(TextEditor receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.paste();
    }
}

class TextEditor {
    private StringBuilder buffer = new StringBuilder();

    public void copy() {
    }

    public void paste() {
        add("");
    }

    public void add(String s) {
        buffer.append(s);
    }

    public void delete() {
        if (buffer.length() > 0) {
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }

    public String getState() {
        return buffer.toString();
    }
}