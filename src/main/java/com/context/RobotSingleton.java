package com.context;

import javafx.scene.transform.Translate;

/**
 * Created by Admin on 2018/3/25.
 */
public class RobotSingleton {
    private ChartManager chartManager = null;

    private RobotSingleton()  {
        chartManager = ChartManager.getInstance();
    }

    public static RobotSingleton getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private static enum Singleton {
        INSTANCE;
        private RobotSingleton singleton;

        // JVM会保证此方法绝对只调用一次
        private Singleton() {
            singleton = new RobotSingleton();
        }

        public RobotSingleton getInstance() {
            return singleton;
        }
    }

    public String input(String input) {
//        input = Translate.translateString(input);
        System.out.println("您的输入是：" + input);
        return chartManager.response(input);
    }
}
