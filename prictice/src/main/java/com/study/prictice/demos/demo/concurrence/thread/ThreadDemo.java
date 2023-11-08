package com.study.prictice.demos.demo.concurrence.thread;

/**
 * 需求: 两个线程 线程1: 图片的加载 1% ~ 100% (等待图片显示) 图片的下载 1%~100% 线程2: 图片的显示 同时开启线程: 显示之前 需要等待 加载完成 显示后 才能开始下载
 */
public class ThreadDemo {
  public static void main(String[] args) {
    /*
     * 思路：加载；显示；下载
     * 用一个锁来竞争资源
     * */
    Object obj = new Object();
    LoadThread loadThread = new LoadThread(obj);
    ShowThread showThread = new ShowThread(obj);

    Thread t1 = new Thread(loadThread);
    Thread t2 = new Thread(showThread);

    t1.start();
    t2.start();
  }
}

class LoadThread implements Runnable {
  private Object obj;

  public LoadThread(Object obj) {
      this.obj = obj;
  }

  @Override
  public void run() {
    System.out.println("图片开始加载");
    for (int i = 0; i < 100; i++) {
      System.out.println("图片加载了" + i + "%");
    }
    System.out.println("结束加载");
    // 同步代码块
    synchronized (obj) {
      obj.notify();
    }

    synchronized (obj) {
      try {
        obj.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("开始下载");

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    for (int i = 0; i < 100; i++) {
      System.out.println("已下载" + i + "%");
    }
    System.out.println("结束下载");
  }
}

class ShowThread implements Runnable {

  private Object obj;

  public ShowThread(Object obj) {
      this.obj = obj;
  }

  @Override
  public void run() {
    synchronized (obj) {
      try {
        obj.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.println("显示图片");
    synchronized (obj) {
      obj.notify();
    }
  }
}
