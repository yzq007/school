package com.arcsoft.sdk_demo.NetUtil;

public class BitmapToFile {
    public BitmapToFile(){

    }
    public String getPath(String whole){
        char[] toArray=whole.toCharArray();
        StringBuffer path=new StringBuffer();
        int pos=whole.lastIndexOf("/");
        for (int i = 0; i <pos ; i++) {
            path.append(toArray[i]);
        }
        return path.toString();
    }
    public String getName(String whole){
        char[] toArray=whole.toCharArray();
        StringBuffer name=new StringBuffer();
        int pos=whole.lastIndexOf("/");
        for(int i=pos+1;i<whole.length();i++){
            name.append(toArray[i]);
        }
        return name.toString();
    }
}
