import java.io.*;
import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int video_len_sec = toSeconds(video_len);
        int pos_sec = toSeconds(pos);
        int op_start_sec = toSeconds(op_start);
        int op_end_sec = toSeconds(op_end);
        
        if(pos_sec >= op_start_sec && pos_sec <= op_end_sec){
            pos_sec = op_end_sec;
        }
        
        for(String command : commands){
                switch(command){
                case "prev":
                    if(pos_sec < 10){
                        pos_sec = 0;
                        break;
                    }
                    pos_sec -= 10;
                    break;
                case "next": 
                    if(video_len_sec - pos_sec < 10){
                        pos_sec = video_len_sec;
                        break;
                    }
                    pos_sec += 10;
                    break;
                }
            if(pos_sec >= op_start_sec && pos_sec <= op_end_sec){
            pos_sec = op_end_sec;
        }
        
        }
        
        if(pos_sec >= op_start_sec && pos_sec <= op_end_sec){
            pos_sec = op_end_sec;
        }
        
        String answer = toString(pos_sec);
        return answer;
    }
    
    public String toString(int seconds){
        int min = seconds / 60;
        int sec = seconds % 60;
        
        String minStr = String.valueOf(min);
        String secStr =  String.valueOf(sec);
        
        if(min<10){
            minStr = "0"+String.valueOf(min);
        }
        
        if(sec<10){
            secStr = "0"+String.valueOf(sec);
        }
        return minStr+":"+secStr;
    }
    
    public int toSeconds(String time){  //  문자열로 주어진 시간을 초 단위로 변환
        String[] separatedTime = new String[2];
        Integer[] separatedTimeInt = new Integer[2];
        separatedTime = time.split(":");    // ":"로 나누어 배열에 넣음

        for(int i = 0;i<separatedTime.length;i++){  
            if(separatedTime[i].startsWith("0")){   //  0으로 시작하면 0을 제거
                separatedTime[i] = separatedTime[i].substring(1);
            }
            separatedTimeInt[i] = Integer.parseInt(separatedTime[i]);
        }
        
        return separatedTimeInt[0] * 60 + separatedTimeInt[1];
    }
}