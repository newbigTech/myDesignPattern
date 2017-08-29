package com.ytc.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class MySingleton implements Serializable {
       
    private static final long serialVersionUID = 1L;  
  
    //�ڲ���  
    private static class MySingletonHandler{  
        private static MySingleton instance = new MySingleton();  
    }   
      
    private MySingleton(){}  
       
    public static MySingleton getInstance() {   
        return MySingletonHandler.instance;  
    }  
      
    //�÷����ڷ����л�ʱ�ᱻ���ã��÷������ǽӿڶ���ķ������е��Լ���׳ɵĸо�  
    protected Object readResolve() throws ObjectStreamException {
        System.out.println("������readResolve������");  
        return MySingletonHandler.instance;   
    }  
}  