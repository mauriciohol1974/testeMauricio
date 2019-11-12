package br.com.politec.sao.util;

import java.util.LinkedList;

public class ActiveObject extends Thread {
    private boolean alive;

    private final LinkedList tasks;

    public ActiveObject() {
        super("ActiveObject");
        this.alive = true;
        this.tasks = new LinkedList();
    }

    public void run() {
        while (this.alive) {
            Task task = getTask();
            try {
                task.run();
            } catch (Exception exc) {
                task.handleException(exc);
            }
        }
    }

    private synchronized Task getTask() {
        while (this.tasks.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException exc) {
            }
        }
        return (Task) this.tasks.removeFirst();
    }

    public synchronized void addTask(Task task) {
        this.tasks.addLast(task);
        notifyAll();
    }

    public void terminate() {
        this.alive = false;
    }
}
