package com.StringProblems;

/**
 * Created by Alvin on 15/11/16.
 */
public class Exe {
    //变形数
    public boolean isChange(String str1,String str2){
        //若有一个字符串为null或者两个字符串的长度不相等,那么必不为变形
        if(str1 == null || str1 == null || str1.length() != str2.length())
            return false;
        //转换为char类型的数组
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        //设置一个容器,存放每个字母在字符串中出现的数量
        int[] contrainer = new int[26];
        for(int i = 0;i < c1.length;i++)
            contrainer[c1[i]-'a']++;
        //若c2的字母数量c1的字母数量不想等,则相互不为变形字符串
        for(int j = 0;j <c2.length; j++)
            if(contrainer[c2[j]-'a']--==0)
                return false;
        return true;
    }

    //移除字符串中的数字
    public String deleteNumFromString(String str){
        if(str == null)
            return null;
        char[] c = str.toCharArray();
        int len = c.length;
        //j用于指向非数字数,i用于指向整个字符串
        int i = 0,j = 0;
        for(;i < len && j < len;i++,j++)
        {
            //移动i若遇到数字,则直接后移
            //此时j不移动指向数字前的一个字母
            while(c[i] >= '0' && c[i] <='9')
                i++;
            //交换将i赋值给j,就是将数字后的第一个字母
            //覆盖掉数字
            c[j] = c[i];
        }
        //这里只截取0-j的字符串,因为j一直指向的是字母
        String result = String.valueOf(c,0,j);
        return result;
    }

    //判断是否为回文
    public boolean isPlalindrome(String str){
        if(str == null)
            return false;
        int len = str.length();
        //比较左右两个偏移相同的字符是否一致
        for(int i = 0; i < len/2;i++)
            if(str.charAt(i) != str.charAt(len-1-i))
                return false;
        return true;
    }
}
