package com.github.nicolasholanda.designpatterns.creational.prototype;

class Document implements Cloneable {
    private String title;
    private String content;
    private String author;

    Document(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    @Override
    public Document clone() {
        try {
            return (Document) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Document{title='%s', content='%s', author='%s'}".formatted(title, content, author);
    }
}
