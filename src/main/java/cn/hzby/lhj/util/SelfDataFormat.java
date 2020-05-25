package cn.hzby.lhj.util;

import java.text.SimpleDateFormat;

public class SelfDataFormat {

    private volatile static SimpleDateFormat singleton;  
    private SelfDataFormat (){}  
    public static SimpleDateFormat getSingleton() {  
	    if (singleton == null) {  
	        synchronized (SimpleDateFormat.class) {  
		        if (singleton == null) {  
		            singleton = new SimpleDateFormat("yyyy/MM/dd HH:mm");  
		        }  
	        }  
	    }  
	    return singleton;  
    }  
}
