package com.lql;

import org.junit.jupiter.api.Test;

import java.util.*;


public class Solution {
    @Test
    public void test() {
        System.out.println(-3>>1);
    }

    List<List<String>> res=new LinkedList<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, LinkedList<String>> map=new HashMap<>();
        for(String str: strs){
            String code=encode(str);
            map.putIfAbsent(code, new LinkedList<>());
            map.get(code).add(str);
        }
        for(Map.Entry<String, LinkedList<String>> entry: map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

    public String encode(String str){
        char[] count=new char[26];
        for(char c: str.toCharArray()){
            count[c-'a']++;
        }
        return String.valueOf(count);
    }
}