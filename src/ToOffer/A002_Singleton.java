package ToOffer;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-09-02 18:00
 * 单例模式分为懒汉式（需要才去创建对象）和饿汉式（创建类的实例时就去创建对象）
 */

public class A002_Singleton {

    /**
     * 饿汉模式：线程安全，耗费资源。
     */
    //属性实例化对象
    /*public class HugerSingletonTest {
        //该对象的引用不可修改
        private static final HugerSingletonTest ourInstance = new HugerSingletonTest();

        public static HugerSingletonTest getInstance() {
            return ourInstance;
        }

        private HugerSingletonTest() {

        }
    }*/
    //在静态代码块实例对象//但内部类不能拥有static所以注释掉
    /*public class Singleton {
        private static Singleton ourInstance;

        static {
            ourInstance = new Singleton();
        }

        public static Singleton getInstance() {
            return ourInstance;
        }

        private Singleton() {
        }
    }*/

    /**
     * 懒汉式 非线程安全(需要处理)
     */
    //普通懒汉单例
    /*public class Singleton {
        private static Singleton ourInstance;

        public static Singleton getInstance() {
            if (null == ourInstance) {
                ourInstance = new Singleton();
            }
            return ourInstance;
        }

        private Singleton() {
        }
    }*/
    //加锁应对并发 给方法加锁
    /*public class Singleton {
        private static Singleton ourInstance;

        public synchronized static Singleton getInstance() {
            if (null == ourInstance) {
                ourInstance = new Singleton();
            }
            return ourInstance;
        }

        private Singleton() {
        }
    }*/
    //双重检查锁（同步代码块）但会存在dcl(指令重排序问题)
    /*public class Singleton {
        private static Singleton ourInstance;

        public static Singleton getInstance() {
            if (null == ourInstance) {
                synchronized (Singleton.class) {
                    if (null == ourInstance) {
                        ourInstance = new Singleton();
                    }
                }
            }
            return ourInstance;
        }

        private Singleton() {
        }
    }*/
    //双重检查锁（同步代码块）使用volatile禁止指令重排序
    /*public class Singleton {
        //volatile的作用是：保证可见性、禁止指令重排序，但不能保证原子性
        private volatile static Singleton ourInstance;

        public static Singleton getInstance() {
            if (null == ourInstance) {
                synchronized (Singleton.class) {
                    if (null == ourInstance) {
                        ourInstance = new Singleton();
                    }
                }
            }
            return ourInstance;
        }

        private Singleton() {
        }
    }*/
    //静态内部类
    /*public class Singleton {
        private static class SingletonHodler {
            private static Singleton ourInstance = new Singleton();
        }

        public synchronized static Singleton getInstance() {
            return SingletonHodler.ourInstance;
        }

        private Singleton() {
        }
    }*/
}
