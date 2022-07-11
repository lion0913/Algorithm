class Solution {
    public int solution(String s) {
        int length = s.length();
        int min = length;
        for(int cut = 1; cut <= (length/2); cut++) {
            // System.out.println(cut);
            String[] list = new String[length/cut];
            for(int idx = 0; idx<(length/cut); idx++) {
                // System.out.println((idx+1)*cut);
                if((idx+1)*cut <= length) {
                    list[idx] = s.substring(idx*cut, (idx+1)*cut);
                    // System.out.println(list[idx]);
                }
            }
            int i = 0;
            int dupCnt = 0;
            int l = length;
            while(i+1 < list.length) {
                
                if(list[i].equals(list[i+1])){
                    dupCnt++;
                    i++;
                    // System.out.println("dupCnt "+dupCnt);
                    if(dupCnt == 1) {
                        l = l - cut + 1;
                    } else if(dupCnt > 1) {
                        l = l - cut;
                        if(dupCnt == 9) {
                            l++;
                        } else if(dupCnt == 99){
                            l++;
                        } else if(dupCnt == 999) {
                            l++;
                        }
                        // System.out.println("l : "+l);
                    }
                } else {
                    
                    dupCnt = 0;
                    i++;
                }
            }
            // System.out.println("cut"+cut+", l "+l);
            if(l < min) {
                min = l;
            }
            
        }
        return min;
    }
}