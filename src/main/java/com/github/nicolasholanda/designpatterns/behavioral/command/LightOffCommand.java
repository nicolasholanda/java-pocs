package com.github.nicolasholanda.designpatterns.behavioral.command;

class LightOffCommand implements Command {
    private Light light;

    LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
