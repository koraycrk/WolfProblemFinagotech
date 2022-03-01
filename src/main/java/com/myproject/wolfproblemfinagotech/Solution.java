/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myproject.wolfproblemfinagotech;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
/**
 *
 * @author user
 */
class Result {
    public static int uniqueWolfs(List<Integer> arr) {
     // Gelistirmeyi bu alana yapiniz
     HashMap<Integer, Integer> map = new HashMap<>();
     for (int i = 0; i <arr.size(); i++) {
     if(map.containsKey(arr.get(i))){
     map.put(arr.get(i),map.get(arr.get(i))+1);
     }else{
     map.put(arr.get(i), 1);
     }
     }

     Iterator entries = map.entrySet().iterator();
     int maxCount = 0;
     int element =arr.get(0);
     while(entries.hasNext()){
     Map.Entry entry = (Map.Entry) entries.next();
     int count = (Integer)entry.getValue();
     if(maxCount<count || (maxCount == count && element > (Integer)entry.getKey())){
     maxCount = count;
     element = (Integer)entry.getKey();
     }
     }
    //System.out.println("Element repeating maximum no of times: " + element + ", maximum count: " + maxCount);
    return element;
}
}
public class Solution {
public static void main(String[] args) throws IOException {
    System.out.println("Please enter list: ");
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    //int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll(" ", "").replaceAll("\\s+$", "").split("")).map(Integer::parseInt).collect(toList());
    int result = Result.uniqueWolfs(arr);
    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();
    bufferedReader.close();
    bufferedWriter.close();
}
    
}
