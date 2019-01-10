package com.example.threadpool.container;

public class BeanDefiniation {

    private boolean isSingleton;

    private String beanName;

    private Class beanClass;

    private Object data;

    public boolean isSingleton() {
        return isSingleton;
    }

    public void setSingleton(boolean singleton) {
        isSingleton = singleton;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BeanDefiniationBuilder build(){
        return new BeanDefiniationBuilder();
    }

    class BeanDefiniationBuilder{
        private boolean isSingleton;

        private String beanName;

        private Class beanClass;

        public BeanDefiniationBuilder isSingleton(boolean isSingleton){
            BeanDefiniation.this.isSingleton=isSingleton;
            return this;
        }
        public BeanDefiniationBuilder beanName(String beanName){
            BeanDefiniation.this.beanName=beanName;
            return this;
        }
        public BeanDefiniationBuilder beanClass(Class beanClass){
            BeanDefiniation.this.beanClass=beanClass;
            return this;
        }
        public BeanDefiniationBuilder data(Object data){
            BeanDefiniation.this.data=data;
            return this;
        }

    }
}
