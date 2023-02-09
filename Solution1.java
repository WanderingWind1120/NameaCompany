package org.example;

import java.awt.image.BandedSampleModel;
import java.util.HashSet;

public class Solution1 {

    // Nguyên tắc giải của câu hỏi này rất đơn giản
    // group lại các phần đuôi của String có chung kí tự đầu tiên
    // Muốn tráo đổi kí tự đầu tiên mà tạo ra các phần tử khong thuộc String ban đầu
    // thì nó không được hcung một group kí tự đầu tiên và 2 từ thuộc 2 group tráo đổi kí tự đầu tiên cho nhau không
    // được có chung phần đuôi
    public int nameaCompany (String [] ideas) {
        HashSet<String>[] initials = new HashSet[26];
        // Tạo array bao gồm các Hashset tượng trưng cho các group chứa các phần đuôi có chung kí tự đâu tiên

        for (int i = 0; i <= 25; ++i) {
            initials[i] = new HashSet<>();
        }
        for (String idea: ideas){
            initials[idea.charAt(0) - 'a'].add(idea.substring(1));
            // Lấy index cho array bằng cách lấy hiệu của thứ của của các chữ trong bảng chữ cái với chữ đầu tiên có
            // số thứ tự = 0 
        }
        long answer = 0;
        for (int i =0; i <= 24; i++){
            long numofMutual = 0;
            for (int j = i+1; j <= 25; j++){
                
                for (String ideaA: initials[i]){
                    if (initials[j].contains(ideaA)){
                        numofMutual++;
                    }
                }

                answer += 2*(initials[i].size()-numofMutual) * (initials[j].size()-numofMutual);
            }
        }
        return (int) answer;
    }
}
